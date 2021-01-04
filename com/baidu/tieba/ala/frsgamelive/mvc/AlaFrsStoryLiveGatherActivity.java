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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel;
import com.baidu.tieba.ala.g;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaFrsStoryLiveGatherActivity extends BaseActivity<AlaFrsStoryLiveGatherActivity> {
    private String forumId;
    private String forumName;
    private TextView gXJ;
    private b gXK;
    private AlaFrsStoryLiveGatherModel gXL;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private AlaFrsStoryLiveGatherModel.a gXM = new AlaFrsStoryLiveGatherModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.3
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void mK(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.getPageContext() != null && AlaFrsStoryLiveGatherActivity.this.gXK != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.gXK.getRootView());
                AlaFrsStoryLiveGatherActivity.this.gXK.completePullRefresh();
                AlaFrsStoryLiveGatherActivity.this.gXK.c(AlaFrsStoryLiveGatherActivity.this.gXL.getDatas(), AlaFrsStoryLiveGatherActivity.this.gXL.bYx(), z);
                AlaFrsStoryLiveGatherActivity.this.gXK.vt(AlaFrsStoryLiveGatherActivity.this.gXL.getLiveCount());
                if (x.getCount(AlaFrsStoryLiveGatherActivity.this.gXL.getDatas()) != 0) {
                    AlaFrsStoryLiveGatherActivity.this.hideNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gXK.getRootView());
                    return;
                }
                AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gXK.getRootView(), AlaFrsStoryLiveGatherActivity.this.getPageContext().getString(R.string.no_data_text), false);
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void aE(int i, String str) {
            if (AlaFrsStoryLiveGatherActivity.this.gXK != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.gXK.getRootView());
                AlaFrsStoryLiveGatherActivity.this.gXK.completePullRefresh();
            }
            if (x.getCount(AlaFrsStoryLiveGatherActivity.this.gXL.getDatas()) > 0 && AlaFrsStoryLiveGatherActivity.this.gXK != null) {
                AlaFrsStoryLiveGatherActivity.this.showToast(str);
                return;
            }
            AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
            AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gXK.getRootView(), str, false);
        }
    };
    private g gXm = new g() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.4
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.ala.g
        public void R(bz bzVar) {
            AlaFrsStoryLiveGatherActivity.this.a(AlaFrsStoryLiveGatherActivity.this.getPageContext(), bzVar);
        }
    };
    private f.c gKQ = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.gXL != null) {
                AlaFrsStoryLiveGatherActivity.this.gXL.refreshData();
            }
        }
    };
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsStoryLiveGatherActivity.this.gXL != null) {
                z = AlaFrsStoryLiveGatherActivity.this.gXL.bVK();
            }
            if (AlaFrsStoryLiveGatherActivity.this.gXK != null) {
                if (z) {
                    AlaFrsStoryLiveGatherActivity.this.gXK.bUE();
                } else {
                    AlaFrsStoryLiveGatherActivity.this.gXK.bUD();
                }
            }
        }
    };
    private d gXo = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.7
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void vS(int i) {
            if (AlaFrsStoryLiveGatherActivity.this.gXL != null && AlaFrsStoryLiveGatherActivity.this.gXL.getSortType() != i) {
                AlaFrsStoryLiveGatherActivity.this.gXL.setSortType(i);
                if (AlaFrsStoryLiveGatherActivity.this.gXK != null) {
                    AlaFrsStoryLiveGatherActivity.this.gXK.getListView().startPullRefresh();
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
        setContentView(bYm());
        initModel();
    }

    private View bYm() {
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
        this.gXJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.all), new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12551"));
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
        ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        this.gXK = new b(getPageContext(), false, false, getUniqueId());
        this.gXK.initView();
        this.gXK.vT(1);
        this.gXK.b(this.gXm);
        this.gXK.setListPullRefreshListener(this.gKQ);
        this.gXK.setOnSrollToBottomListener(this.gXN);
        this.gXK.a(this.gXo);
        linearLayout.addView(this.gXK.getRootView(), new LinearLayout.LayoutParams(-1, -1));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return linearLayout;
    }

    private void initModel() {
        this.gXL = new AlaFrsStoryLiveGatherModel(getPageContext());
        this.gXL.a(this.gXM);
        this.gXL.setForumId(this.forumId);
        this.gXL.refreshData();
    }

    private AlaLiveInfoCoreData V(bz bzVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
        alaLiveInfoCoreData.userName = bzVar.brq().getUserName();
        return alaLiveInfoCoreData;
    }

    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        if (tbPageContext != null && bzVar != null && bzVar.brq() != null && bzVar.brJ() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.brq().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            TiebaStatic.log(new aq("c12550").dX("obj_param1", bzVar.brq().getUserId()));
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bz bzVar2 : this.gXL.bVD()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
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
            ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.mStatusBarView != null) {
            ao.setBackgroundColor(this.mStatusBarView, R.color.common_color_10274);
        }
        if (this.gXJ != null) {
            ao.setViewTextColor(this.gXJ, R.color.CAM_X0106);
        }
        if (this.gXK != null) {
            this.gXK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
