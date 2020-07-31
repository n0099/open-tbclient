package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaFrsStoryLiveGatherActivity extends BaseActivity<AlaFrsStoryLiveGatherActivity> {
    private TextView fLR;
    private b fLS;
    private AlaFrsStoryLiveGatherModel fLT;
    private String forumId;
    private String forumName;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private AlaFrsStoryLiveGatherModel.a fLU = new AlaFrsStoryLiveGatherModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.3
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void kq(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.getPageContext() != null && AlaFrsStoryLiveGatherActivity.this.fLS != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.fLS.getRootView());
                AlaFrsStoryLiveGatherActivity.this.fLS.completePullRefresh();
                AlaFrsStoryLiveGatherActivity.this.fLS.c(AlaFrsStoryLiveGatherActivity.this.fLT.getDatas(), AlaFrsStoryLiveGatherActivity.this.fLT.bAt(), z);
                AlaFrsStoryLiveGatherActivity.this.fLS.qB(AlaFrsStoryLiveGatherActivity.this.fLT.getLiveCount());
                if (x.getCount(AlaFrsStoryLiveGatherActivity.this.fLT.getDatas()) != 0) {
                    AlaFrsStoryLiveGatherActivity.this.hideNetRefreshView(AlaFrsStoryLiveGatherActivity.this.fLS.getRootView());
                    return;
                }
                AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.fLS.getRootView(), AlaFrsStoryLiveGatherActivity.this.getPageContext().getString(R.string.no_data_text), false);
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void ao(int i, String str) {
            if (AlaFrsStoryLiveGatherActivity.this.fLS != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.fLS.getRootView());
                AlaFrsStoryLiveGatherActivity.this.fLS.completePullRefresh();
            }
            if (x.getCount(AlaFrsStoryLiveGatherActivity.this.fLT.getDatas()) > 0 && AlaFrsStoryLiveGatherActivity.this.fLS != null) {
                AlaFrsStoryLiveGatherActivity.this.showToast(str);
                return;
            }
            AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
            AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.fLS.getRootView(), str, false);
        }
    };
    private e fLu = new e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.4
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.ala.e
        public void O(bv bvVar) {
            AlaFrsStoryLiveGatherActivity.this.a(AlaFrsStoryLiveGatherActivity.this.getPageContext(), bvVar);
        }
    };
    private f.c fBc = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.fLT != null) {
                AlaFrsStoryLiveGatherActivity.this.fLT.refreshData();
            }
        }
    };
    private BdListView.e fLV = new BdListView.e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsStoryLiveGatherActivity.this.fLT != null) {
                z = AlaFrsStoryLiveGatherActivity.this.fLT.bxZ();
            }
            if (AlaFrsStoryLiveGatherActivity.this.fLS != null) {
                if (z) {
                    AlaFrsStoryLiveGatherActivity.this.fLS.bwT();
                } else {
                    AlaFrsStoryLiveGatherActivity.this.fLS.bwS();
                }
            }
        }
    };
    private d fLw = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.7
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void qX(int i) {
            if (AlaFrsStoryLiveGatherActivity.this.fLT != null && AlaFrsStoryLiveGatherActivity.this.fLT.getSortType() != i) {
                AlaFrsStoryLiveGatherActivity.this.fLT.setSortType(i);
                if (AlaFrsStoryLiveGatherActivity.this.fLS != null) {
                    AlaFrsStoryLiveGatherActivity.this.fLS.getListView().startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.forumId = bundle.getString("forum_id");
            this.forumName = bundle.getString("forum_name");
        } else if (getIntent() != null) {
            this.forumId = getIntent().getStringExtra("forum_id");
            this.forumName = getIntent().getStringExtra("forum_name");
        } else {
            finish();
            return;
        }
        if (StringUtils.isNull(this.forumId)) {
            finish();
        }
        setContentView(bAi());
        BE();
    }

    private View bAi() {
        String string;
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        this.mStatusBarView = new View(getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = UtilHelper.getStatusBarHeight();
        }
        linearLayout.addView(this.mStatusBarView, layoutParams);
        this.mNavigationBar = new NavigationBar(getPageContext().getPageActivity());
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaFrsStoryLiveGatherActivity.this.finish();
            }
        });
        new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, l.getDimens(getPageContext().getPageActivity(), R.dimen.ds24), 0);
        this.fLR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.all), new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12551"));
                AlaFrsStoryLiveGatherActivity.this.sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(AlaFrsStoryLiveGatherActivity.this.getPageContext().getPageActivity())));
            }
        });
        if (!StringUtils.isNull(this.forumName)) {
            string = this.forumName + " - 直播";
        } else {
            string = getResources().getString(R.string.frs_game_gather_title);
        }
        this.mNavigationBar.setCenterTextTitle(string);
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        this.fLS = new b(getPageContext(), false, false, getUniqueId());
        this.fLS.initView();
        this.fLS.qY(1);
        this.fLS.b(this.fLu);
        this.fLS.setListPullRefreshListener(this.fBc);
        this.fLS.setOnSrollToBottomListener(this.fLV);
        this.fLS.a(this.fLw);
        linearLayout.addView(this.fLS.getRootView(), new LinearLayout.LayoutParams(-1, -1));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return linearLayout;
    }

    private void BE() {
        this.fLT = new AlaFrsStoryLiveGatherModel(getPageContext());
        this.fLT.a(this.fLU);
        this.fLT.setForumId(this.forumId);
        this.fLT.refreshData();
    }

    private AlaLiveInfoCoreData S(bv bvVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
        alaLiveInfoCoreData.userName = bvVar.aWl().getUserName();
        return alaLiveInfoCoreData;
    }

    public void a(TbPageContext<?> tbPageContext, bv bvVar) {
        if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bvVar.aWl().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            TiebaStatic.log(new ap("c12550").dn("obj_param1", bvVar.aWl().getUserId()));
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bv bvVar2 : this.fLT.bxQ()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bvVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mStatusBarView != null) {
            ao.setBackgroundColor(this.mStatusBarView, R.color.common_color_10274);
        }
        if (this.fLR != null) {
            ao.setViewTextColor(this.fLR, R.color.cp_cont_f);
        }
        if (this.fLS != null) {
            this.fLS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
