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
    private TextView gLX;
    private b gLY;
    private AlaFrsStoryLiveGatherModel gLZ;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private AlaFrsStoryLiveGatherModel.a gMa = new AlaFrsStoryLiveGatherModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.3
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void mn(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.getPageContext() != null && AlaFrsStoryLiveGatherActivity.this.gLY != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.gLY.getRootView());
                AlaFrsStoryLiveGatherActivity.this.gLY.completePullRefresh();
                AlaFrsStoryLiveGatherActivity.this.gLY.c(AlaFrsStoryLiveGatherActivity.this.gLZ.getDatas(), AlaFrsStoryLiveGatherActivity.this.gLZ.bVS(), z);
                AlaFrsStoryLiveGatherActivity.this.gLY.vi(AlaFrsStoryLiveGatherActivity.this.gLZ.getLiveCount());
                if (y.getCount(AlaFrsStoryLiveGatherActivity.this.gLZ.getDatas()) != 0) {
                    AlaFrsStoryLiveGatherActivity.this.hideNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gLY.getRootView());
                    return;
                }
                AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gLY.getRootView(), AlaFrsStoryLiveGatherActivity.this.getPageContext().getString(R.string.no_data_text), false);
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void aC(int i, String str) {
            if (AlaFrsStoryLiveGatherActivity.this.gLY != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.gLY.getRootView());
                AlaFrsStoryLiveGatherActivity.this.gLY.completePullRefresh();
            }
            if (y.getCount(AlaFrsStoryLiveGatherActivity.this.gLZ.getDatas()) > 0 && AlaFrsStoryLiveGatherActivity.this.gLY != null) {
                AlaFrsStoryLiveGatherActivity.this.showToast(str);
                return;
            }
            AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
            AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.gLY.getRootView(), str, false);
        }
    };
    private f gLA = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.4
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.ala.f
        public void R(by byVar) {
            AlaFrsStoryLiveGatherActivity.this.a(AlaFrsStoryLiveGatherActivity.this.getPageContext(), byVar);
        }
    };
    private f.c gzN = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.gLZ != null) {
                AlaFrsStoryLiveGatherActivity.this.gLZ.refreshData();
            }
        }
    };
    private BdListView.e gMb = new BdListView.e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsStoryLiveGatherActivity.this.gLZ != null) {
                z = AlaFrsStoryLiveGatherActivity.this.gLZ.bTg();
            }
            if (AlaFrsStoryLiveGatherActivity.this.gLY != null) {
                if (z) {
                    AlaFrsStoryLiveGatherActivity.this.gLY.bSc();
                } else {
                    AlaFrsStoryLiveGatherActivity.this.gLY.bSb();
                }
            }
        }
    };
    private d gLC = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.7
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void vH(int i) {
            if (AlaFrsStoryLiveGatherActivity.this.gLZ != null && AlaFrsStoryLiveGatherActivity.this.gLZ.getSortType() != i) {
                AlaFrsStoryLiveGatherActivity.this.gLZ.setSortType(i);
                if (AlaFrsStoryLiveGatherActivity.this.gLY != null) {
                    AlaFrsStoryLiveGatherActivity.this.gLY.getListView().startPullRefresh();
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
        setContentView(bVH());
        KR();
    }

    private View bVH() {
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
        this.gLX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.all), new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.2
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
        this.gLY = new b(getPageContext(), false, false, getUniqueId());
        this.gLY.initView();
        this.gLY.vI(1);
        this.gLY.b(this.gLA);
        this.gLY.setListPullRefreshListener(this.gzN);
        this.gLY.setOnSrollToBottomListener(this.gMb);
        this.gLY.a(this.gLC);
        linearLayout.addView(this.gLY.getRootView(), new LinearLayout.LayoutParams(-1, -1));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return linearLayout;
    }

    private void KR() {
        this.gLZ = new AlaFrsStoryLiveGatherModel(getPageContext());
        this.gLZ.a(this.gMa);
        this.gLZ.setForumId(this.forumId);
        this.gLZ.refreshData();
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
            for (by byVar2 : this.gLZ.bSZ()) {
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
        if (this.gLX != null) {
            ap.setViewTextColor(this.gLX, (int) R.color.CAM_X0106);
        }
        if (this.gLY != null) {
            this.gLY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
