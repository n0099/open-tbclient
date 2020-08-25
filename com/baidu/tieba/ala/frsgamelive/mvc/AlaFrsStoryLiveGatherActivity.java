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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaFrsStoryLiveGatherActivity extends BaseActivity<AlaFrsStoryLiveGatherActivity> {
    private TextView fXP;
    private b fXQ;
    private AlaFrsStoryLiveGatherModel fXR;
    private String forumId;
    private String forumName;
    private NavigationBar mNavigationBar;
    private View mStatusBarView;
    private AlaFrsStoryLiveGatherModel.a fXS = new AlaFrsStoryLiveGatherModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.3
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void kO(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.getPageContext() != null && AlaFrsStoryLiveGatherActivity.this.fXQ != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.fXQ.getRootView());
                AlaFrsStoryLiveGatherActivity.this.fXQ.completePullRefresh();
                AlaFrsStoryLiveGatherActivity.this.fXQ.c(AlaFrsStoryLiveGatherActivity.this.fXR.getDatas(), AlaFrsStoryLiveGatherActivity.this.fXR.bJO(), z);
                AlaFrsStoryLiveGatherActivity.this.fXQ.sN(AlaFrsStoryLiveGatherActivity.this.fXR.getLiveCount());
                if (y.getCount(AlaFrsStoryLiveGatherActivity.this.fXR.getDatas()) != 0) {
                    AlaFrsStoryLiveGatherActivity.this.hideNetRefreshView(AlaFrsStoryLiveGatherActivity.this.fXQ.getRootView());
                    return;
                }
                AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.fXQ.getRootView(), AlaFrsStoryLiveGatherActivity.this.getPageContext().getString(R.string.no_data_text), false);
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.a
        public void am(int i, String str) {
            if (AlaFrsStoryLiveGatherActivity.this.fXQ != null) {
                AlaFrsStoryLiveGatherActivity.this.hideLoadingView(AlaFrsStoryLiveGatherActivity.this.fXQ.getRootView());
                AlaFrsStoryLiveGatherActivity.this.fXQ.completePullRefresh();
            }
            if (y.getCount(AlaFrsStoryLiveGatherActivity.this.fXR.getDatas()) > 0 && AlaFrsStoryLiveGatherActivity.this.fXQ != null) {
                AlaFrsStoryLiveGatherActivity.this.showToast(str);
                return;
            }
            AlaFrsStoryLiveGatherActivity.this.setNetRefreshViewTopMargin(AlaFrsStoryLiveGatherActivity.this.getResources().getDimensionPixelSize(R.dimen.ds160));
            AlaFrsStoryLiveGatherActivity.this.showNetRefreshView(AlaFrsStoryLiveGatherActivity.this.fXQ.getRootView(), str, false);
        }
    };
    private e fXs = new e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.4
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.ala.e
        public void O(bw bwVar) {
            AlaFrsStoryLiveGatherActivity.this.a(AlaFrsStoryLiveGatherActivity.this.getPageContext(), bwVar);
        }
    };
    private f.c fMu = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.fXR != null) {
                AlaFrsStoryLiveGatherActivity.this.fXR.refreshData();
            }
        }
    };
    private BdListView.e fXT = new BdListView.e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsStoryLiveGatherActivity.this.fXR != null) {
                z = AlaFrsStoryLiveGatherActivity.this.fXR.bGY();
            }
            if (AlaFrsStoryLiveGatherActivity.this.fXQ != null) {
                if (z) {
                    AlaFrsStoryLiveGatherActivity.this.fXQ.bFS();
                } else {
                    AlaFrsStoryLiveGatherActivity.this.fXQ.bFR();
                }
            }
        }
    };
    private d fXu = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.7
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void tj(int i) {
            if (AlaFrsStoryLiveGatherActivity.this.fXR != null && AlaFrsStoryLiveGatherActivity.this.fXR.getSortType() != i) {
                AlaFrsStoryLiveGatherActivity.this.fXR.setSortType(i);
                if (AlaFrsStoryLiveGatherActivity.this.fXQ != null) {
                    AlaFrsStoryLiveGatherActivity.this.fXQ.getListView().startPullRefresh();
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
        setContentView(bJD());
        Hh();
    }

    private View bJD() {
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
        this.fXP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.all), new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity.2
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
        ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        this.fXQ = new b(getPageContext(), false, false, getUniqueId());
        this.fXQ.initView();
        this.fXQ.tk(1);
        this.fXQ.b(this.fXs);
        this.fXQ.setListPullRefreshListener(this.fMu);
        this.fXQ.setOnSrollToBottomListener(this.fXT);
        this.fXQ.a(this.fXu);
        linearLayout.addView(this.fXQ.getRootView(), new LinearLayout.LayoutParams(-1, -1));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return linearLayout;
    }

    private void Hh() {
        this.fXR = new AlaFrsStoryLiveGatherModel(getPageContext());
        this.fXR.a(this.fXS);
        this.fXR.setForumId(this.forumId);
        this.fXR.refreshData();
    }

    private AlaLiveInfoCoreData S(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
        alaLiveInfoCoreData.userName = bwVar.beE().getUserName();
        return alaLiveInfoCoreData;
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            TiebaStatic.log(new aq("c12550").dD("obj_param1", bwVar.beE().getUserId()));
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bw bwVar2 : this.fXR.bGP()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bwVar2));
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
            ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mStatusBarView != null) {
            ap.setBackgroundColor(this.mStatusBarView, R.color.common_color_10274);
        }
        if (this.fXP != null) {
            ap.setViewTextColor(this.fXP, (int) R.color.cp_cont_f);
        }
        if (this.fXQ != null) {
            this.fXQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
