package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaFrsStoryLiveGatherActivity extends BaseActivity<AlaFrsStoryLiveGatherActivity> {
    public String forumId;
    public String forumName;
    public AlaFrsStoryLiveGatherModel liveModel;
    public TextView mAllBtn;
    public d.a.n0.v.e.c.b mLiveView;
    public NavigationBar mNavigationBar;
    public View mStatusBarView;
    public AlaFrsStoryLiveGatherModel.b modelCallback = new c();
    public d.a.n0.v.c subCardClickListener = new d();
    public f.g listPullRefreshListener = new e();
    public BdListView.p scrollToBottomListener = new f();
    public d.a.n0.v.e.c.d frsLiveViewEvent = new g();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaFrsStoryLiveGatherActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12551"));
            AlaFrsStoryLiveGatherActivity.this.sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(AlaFrsStoryLiveGatherActivity.this.getPageContext().getPageActivity())));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AlaFrsStoryLiveGatherModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.b
        public void a(int i2, String str) {
            if (AlaFrsStoryLiveGatherActivity.this.mLiveView != null) {
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = AlaFrsStoryLiveGatherActivity.this;
                alaFrsStoryLiveGatherActivity.hideLoadingView(alaFrsStoryLiveGatherActivity.mLiveView.g());
                AlaFrsStoryLiveGatherActivity.this.mLiveView.e();
            }
            if (ListUtils.getCount(AlaFrsStoryLiveGatherActivity.this.liveModel.G()) > 0 && AlaFrsStoryLiveGatherActivity.this.mLiveView != null) {
                AlaFrsStoryLiveGatherActivity.this.showToast(str);
                return;
            }
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity2 = AlaFrsStoryLiveGatherActivity.this;
            alaFrsStoryLiveGatherActivity2.setNetRefreshViewTopMargin(alaFrsStoryLiveGatherActivity2.getResources().getDimensionPixelSize(R.dimen.ds160));
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity3 = AlaFrsStoryLiveGatherActivity.this;
            alaFrsStoryLiveGatherActivity3.showNetRefreshView(alaFrsStoryLiveGatherActivity3.mLiveView.g(), str, false);
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherModel.b
        public void b(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.getPageContext() == null || AlaFrsStoryLiveGatherActivity.this.mLiveView == null) {
                return;
            }
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = AlaFrsStoryLiveGatherActivity.this;
            alaFrsStoryLiveGatherActivity.hideLoadingView(alaFrsStoryLiveGatherActivity.mLiveView.g());
            AlaFrsStoryLiveGatherActivity.this.mLiveView.e();
            AlaFrsStoryLiveGatherActivity.this.mLiveView.t(AlaFrsStoryLiveGatherActivity.this.liveModel.G(), AlaFrsStoryLiveGatherActivity.this.liveModel.M(), z);
            AlaFrsStoryLiveGatherActivity.this.mLiveView.o(AlaFrsStoryLiveGatherActivity.this.liveModel.H());
            if (ListUtils.getCount(AlaFrsStoryLiveGatherActivity.this.liveModel.G()) == 0) {
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity2 = AlaFrsStoryLiveGatherActivity.this;
                alaFrsStoryLiveGatherActivity2.setNetRefreshViewTopMargin(alaFrsStoryLiveGatherActivity2.getResources().getDimensionPixelSize(R.dimen.ds160));
                AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity3 = AlaFrsStoryLiveGatherActivity.this;
                alaFrsStoryLiveGatherActivity3.showNetRefreshView(alaFrsStoryLiveGatherActivity3.mLiveView.g(), AlaFrsStoryLiveGatherActivity.this.getPageContext().getString(R.string.no_data_text), false);
                return;
            }
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity4 = AlaFrsStoryLiveGatherActivity.this;
            alaFrsStoryLiveGatherActivity4.hideNetRefreshView(alaFrsStoryLiveGatherActivity4.mLiveView.g());
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.n0.v.c {
        public d() {
        }

        @Override // d.a.n0.v.c
        public void a(a2 a2Var) {
            AlaFrsStoryLiveGatherActivity alaFrsStoryLiveGatherActivity = AlaFrsStoryLiveGatherActivity.this;
            alaFrsStoryLiveGatherActivity.jumpToLiveRoom(alaFrsStoryLiveGatherActivity.getPageContext(), a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (AlaFrsStoryLiveGatherActivity.this.liveModel != null) {
                AlaFrsStoryLiveGatherActivity.this.liveModel.O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BdListView.p {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            boolean N = AlaFrsStoryLiveGatherActivity.this.liveModel != null ? AlaFrsStoryLiveGatherActivity.this.liveModel.N() : false;
            if (AlaFrsStoryLiveGatherActivity.this.mLiveView != null) {
                if (N) {
                    AlaFrsStoryLiveGatherActivity.this.mLiveView.w();
                } else {
                    AlaFrsStoryLiveGatherActivity.this.mLiveView.x();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.n0.v.e.c.d {
        public g() {
        }

        @Override // d.a.n0.v.e.c.d
        public void a(int i2) {
            if (AlaFrsStoryLiveGatherActivity.this.liveModel == null || AlaFrsStoryLiveGatherActivity.this.liveModel.J() == i2) {
                return;
            }
            AlaFrsStoryLiveGatherActivity.this.liveModel.setSortType(i2);
            if (AlaFrsStoryLiveGatherActivity.this.mLiveView != null) {
                AlaFrsStoryLiveGatherActivity.this.mLiveView.f().F();
            }
        }
    }

    private void initModel() {
        AlaFrsStoryLiveGatherModel alaFrsStoryLiveGatherModel = new AlaFrsStoryLiveGatherModel(getPageContext());
        this.liveModel = alaFrsStoryLiveGatherModel;
        alaFrsStoryLiveGatherModel.P(this.modelCallback);
        this.liveModel.setForumId(this.forumId);
        this.liveModel.O();
    }

    private View onCreateView() {
        String string;
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        this.mStatusBarView = new View(getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = UtilHelper.getStatusBarHeight();
        }
        linearLayout.addView(this.mStatusBarView, layoutParams);
        NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        navigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a());
        new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds24), 0);
        this.mAllBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.all), new b());
        if (!StringUtils.isNull(this.forumName)) {
            string = this.forumName + " - 直播";
        } else {
            string = getResources().getString(R.string.frs_game_gather_title);
        }
        this.mNavigationBar.setCenterTextTitle(string);
        linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
        SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        d.a.n0.v.e.c.b bVar = new d.a.n0.v.e.c.b(getPageContext(), false, false, getUniqueId());
        this.mLiveView = bVar;
        bVar.j();
        this.mLiveView.p(1);
        this.mLiveView.q(this.subCardClickListener);
        this.mLiveView.s(this.listPullRefreshListener);
        this.mLiveView.u(this.scrollToBottomListener);
        this.mLiveView.r(this.frsLiveViewEvent);
        linearLayout.addView(this.mLiveView.g(), new LinearLayout.LayoutParams(-1, -1));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return linearLayout;
    }

    private AlaLiveInfoCoreData parseThreadToLiveCoreData(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void jumpToLiveRoom(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.r1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = a2Var.T().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        TiebaStatic.log(new StatisticItem("c12550").param("obj_param1", a2Var.T().getUserId()));
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (a2 a2Var2 : this.liveModel.I()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(parseThreadToLiveCoreData(a2Var2));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        View view = this.mStatusBarView;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.common_color_10274);
        }
        TextView textView = this.mAllBtn;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        }
        d.a.n0.v.e.c.b bVar = this.mLiveView;
        if (bVar != null) {
            bVar.l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

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
        setContentView(onCreateView());
        initModel();
    }
}
