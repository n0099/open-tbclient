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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.f;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AlaFrsStoryLiveGatherActivity extends BaseActivity<AlaFrsStoryLiveGatherActivity> {
    private String forumId;
    private String forumName;
    private TextView gLV;
    private b gLW;
    private AlaFrsStoryLiveGatherModel gLX;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private AlaFrsStoryLiveGatherModel.a gLY = new AlaFrsStoryLiveGatherModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.3
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void mn(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.getPageContext() != null && AlaFrsStoryLiveGatherActivity.this.gLW != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.gLW.getRootView());
                AlaFrsStoryLiveGatherActivity.this.gLW.completePullRefresh();
                AlaFrsStoryLiveGatherActivity.this.gLW.c(AlaFrsStoryLiveGatherActivity.this.gLX.getDatas(), AlaFrsStoryLiveGatherActivity.this.gLX.bVR(), z);
                AlaFrsStoryLiveGatherActivity.this.gLW.vi(AlaFrsStoryLiveGatherActivity.this.gLX.getLiveCount());
                if (y.getCount(AlaFrsStoryLiveGatherActivity.this.gLX.getDatas()) != 0) {
                    AlaFrsStoryLiveGatherActivity.this.hideNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gLW.getRootView());
                    return;
                }
                AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gLW.getRootView(), AlaFrsStoryLiveGatherActivity.this.getPageContext().getString(R.string.no_data_text), false);
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void aC(int i, String str) {
            if (AlaFrsStoryLiveGatherActivity.this.gLW != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.gLW.getRootView());
                AlaFrsStoryLiveGatherActivity.this.gLW.completePullRefresh();
            }
            if (y.getCount(AlaFrsStoryLiveGatherActivity.this.gLX.getDatas()) > 0 && AlaFrsStoryLiveGatherActivity.this.gLW != null) {
                AlaFrsStoryLiveGatherActivity.this.showToast(str);
                return;
            }
            AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
            AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gLW.getRootView(), str, false);
        }
    };
    private f gLy = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.4
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.ala.f
        public void R(by byVar) {
            AlaFrsStoryLiveGatherActivity.this.a(AlaFrsStoryLiveGatherActivity.this.getPageContext(), byVar);
        }
    };
    private f.c gzL = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.gLX != null) {
                AlaFrsStoryLiveGatherActivity.this.gLX.refreshData();
            }
        }
    };
    private BdListView.e gLZ = new BdListView.e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsStoryLiveGatherActivity.this.gLX != null) {
                z = AlaFrsStoryLiveGatherActivity.this.gLX.bTf();
            }
            if (AlaFrsStoryLiveGatherActivity.this.gLW != null) {
                if (z) {
                    AlaFrsStoryLiveGatherActivity.this.gLW.bSb();
                } else {
                    AlaFrsStoryLiveGatherActivity.this.gLW.bSa();
                }
            }
        }
    };
    private d gLA = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.7
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void vH(int i) {
            if (AlaFrsStoryLiveGatherActivity.this.gLX != null && AlaFrsStoryLiveGatherActivity.this.gLX.getSortType() != i) {
                AlaFrsStoryLiveGatherActivity.this.gLX.setSortType(i);
                if (AlaFrsStoryLiveGatherActivity.this.gLW != null) {
                    AlaFrsStoryLiveGatherActivity.this.gLW.getListView().startPullRefresh();
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
        setContentView(bVG());
        KR();
    }

    private View bVG() {
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
        this.gLV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.all), new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12551"));
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
        ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        this.gLW = new b(getPageContext(), false, false, getUniqueId());
        this.gLW.initView();
        this.gLW.vI(1);
        this.gLW.b(this.gLy);
        this.gLW.setListPullRefreshListener(this.gzL);
        this.gLW.setOnSrollToBottomListener(this.gLZ);
        this.gLW.a(this.gLA);
        linearLayout.addView(this.gLW.getRootView(), new LinearLayout.LayoutParams(-1, -1));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return linearLayout;
    }

    private void KR() {
        this.gLX = new AlaFrsStoryLiveGatherModel(getPageContext());
        this.gLX.a(this.gLY);
        this.gLX.setForumId(this.forumId);
        this.gLX.refreshData();
    }

    private AlaLiveInfoCoreData V(by byVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
        alaLiveInfoCoreData.userName = byVar.boP().getUserName();
        return alaLiveInfoCoreData;
    }

    public void a(TbPageContext<?> tbPageContext, by byVar) {
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            TiebaStatic.log(new ar("c12550").dY("obj_param1", byVar.boP().getUserId()));
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (by byVar2 : this.gLX.bSY()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(byVar2));
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
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.mStatusBarView != null) {
            ap.setBackgroundColor(this.mStatusBarView, R.color.common_color_10274);
        }
        if (this.gLV != null) {
            ap.setViewTextColor(this.gLV, (int) R.color.CAM_X0106);
        }
        if (this.gLW != null) {
            this.gLW.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
