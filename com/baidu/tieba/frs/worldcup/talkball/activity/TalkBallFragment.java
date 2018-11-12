package com.baidu.tieba.frs.worldcup.talkball.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.c.b;
import com.baidu.tieba.c.c;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.worldcup.talkball.view.AdidasBanner;
import com.baidu.tieba.frs.worldcup.talkball.view.AutoBannerView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.view.FloatingAnimationView;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.AdidasAdvert;
/* loaded from: classes3.dex */
public class TalkBallFragment extends BaseFragment implements NavigationBar.a, VoiceManager.c, ak, com.baidu.tieba.frs.worldcup.talkball.activity.a {
    private AppBarLayout QP;
    private boolean ZI;
    private PbListView bKJ;
    private BdTypeRecyclerView bNt;
    private ImageView ccT;
    private VoiceManager dBD;
    private ObservedChangeLinearLayout dDM;
    private b dDl;
    private c dDt;
    private ImageView dRK;
    private NoNetworkView dhH;
    private View ebU;
    private BdSwipeRefreshLayout ebV;
    private com.baidu.tieba.frs.worldcup.talkball.a.b ebW;
    private ViewGroup ebX;
    private com.baidu.tieba.frs.worldcup.talkball.view.a ebY;
    private AutoBannerView ebZ;
    private AdidasBanner eca;
    private com.baidu.tieba.frs.worldcup.talkball.c.a ecb;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private Pair<Integer, Integer> dBI = null;
    private j.b bRH = new j.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.j.b
        public void bG(boolean z) {
            TalkBallFragment.this.gg(true);
        }
    };
    private BdListView.e ecc = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.YV();
        }
    };
    private NoNetworkView.a cSD = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            if (z) {
                TalkBallFragment.this.Zd();
                TalkBallFragment.this.gg(true);
            }
        }
    };
    private CustomMessageListener dCK = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dDl != null) {
                    TalkBallFragment.this.dDl.g(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bME = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    int l = com.baidu.adp.lib.g.b.l(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == l) {
                        TalkBallFragment.this.Zd();
                        TalkBallFragment.this.gg(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> ecd = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void g(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a nD;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.ebZ != null && (nD = TalkBallFragment.this.ebZ.nD(i - 1)) != null) {
                TiebaStatic.log(new am("c13085").ax(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).x("obj_locate", i).ax("obj_param1", nD.xn()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new am("c13084").ax(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).x("obj_locate", i).ax("obj_param1", aVar.xn()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dBD = getVoiceManager();
        this.dBD.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.talk_ball_layout, viewGroup, false);
        aV(inflate);
        aG(inflate);
        aW(inflate);
        aGv();
        aGu();
        aX(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.ZI = true;
        this.ecb = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dCK);
        registerListener(2001446, this.bME, getUniqueId());
        aGt();
    }

    private void aGt() {
        aGx();
        if (checkNetwork()) {
            showLoadingView(this.ebX, true);
            gg(false);
            return;
        }
        ZV();
        d((d.a) null);
    }

    private void aV(View view) {
        this.ebU = view.findViewById(e.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.ebU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ebU.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.ebU.setLayoutParams(layoutParams);
        }
    }

    private void aG(View view) {
        this.dDM = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QP = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.ccT = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.dRK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        this.dRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.ecb != null) {
                    TalkBallFragment.this.ecb.aGV();
                }
            }
        });
        this.dDl = new b(getActivity());
        this.dDl.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.ecb != null) {
                    TalkBallFragment.this.ecb.aGW();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dDl.getView(), (View.OnClickListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements RecyclerView.RecyclerListener {
        private a() {
        }

        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(e.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(e.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    private void aW(View view) {
        this.ebX = (ViewGroup) view.findViewById(e.g.content_container);
        this.mPullView = new k(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bRH);
        this.ebV = (BdSwipeRefreshLayout) view.findViewById(e.g.pull_refresh_layout);
        this.ebV.setProgressView(this.mPullView);
        this.bNt = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bNt.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bNt.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bNt.setScrollable(this);
        this.bNt.setFadingEdgeLength(0);
        this.bNt.setOverScrollMode(2);
        this.bNt.setOnSrollToBottomListener(this.ecc);
        this.bNt.setRecyclerListener(new a());
        this.ebW = new com.baidu.tieba.frs.worldcup.talkball.a.b(this, this.bNt);
    }

    private void aX(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(e.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dDt = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aGu() {
        this.dhH = new NoNetworkView(getActivity());
        this.dhH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.dhH.a(this.cSD);
        this.dDM.addView(this.dhH);
        checkNetwork();
    }

    private boolean checkNetwork() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.dhH.setVisibility(8);
            return true;
        }
        this.dhH.setVisibility(0);
        return false;
    }

    private void aGv() {
        this.bKJ = new PbListView(getActivity());
        this.bKJ.getView();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.setHeight(l.h(getActivity(), e.C0200e.tbds182));
        this.bKJ.DV();
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bKJ.ei(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(boolean z) {
        if (checkNetwork() && this.ecb != null) {
            hz(z);
            this.bNt.setSelection(0);
            this.ecb.onRefresh();
            return;
        }
        hz(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YV() {
        if (checkNetwork() && this.ecb != null) {
            aGy();
            this.bNt.stopScroll();
            this.ecb.aGU();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void V(ArrayList<h> arrayList) {
        if (this.ebW != null) {
            this.ebW.setData(arrayList);
            this.ebW.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar == null || v.H(eVar.aGF()) == 0) {
            if (this.ebY != null) {
                this.bNt.removeHeaderView(this.ebY.getView());
                this.ebY = null;
                return;
            }
            return;
        }
        if (this.ebY == null) {
            this.ebY = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bNt);
            this.bNt.addHeaderView(this.ebY.getView(), this.bNt.getHeaderViewsCount());
        }
        this.ebY.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bNt != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.eca != null) {
                    this.bNt.removeHeaderView(this.eca);
                    this.eca = null;
                    return;
                }
                return;
            }
            if (this.eca == null) {
                this.eca = new AdidasBanner(getContext());
                this.bNt.addHeaderView(this.eca, this.bNt.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.eca.setForumId(getForumId());
            this.eca.aF(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bS(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bNt != null) {
            if (v.I(list)) {
                if (this.ebZ != null) {
                    this.bNt.removeHeaderView(this.ebZ);
                    this.ebZ = null;
                    return;
                }
                return;
            }
            if (this.ebZ == null) {
                this.ebZ = new AutoBannerView(getContext());
                this.ebZ.setOutOnCoverViewCallback(this.ecd);
                this.bNt.addHeaderView(this.ebZ, 0);
            }
            this.ebZ.bT(list);
            this.ebZ.Ez();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dDt != null) {
            this.dDt.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.ebY != null) {
                this.ebY.gt(isPrimary());
            }
            if (isPrimary()) {
                if (!this.ZI) {
                    init();
                }
                if (this.dDt != null) {
                    this.dDt.apv();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.ebX);
            aGw();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.haY) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aGx();
        showNetRefreshView(this.ebX, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        Zd();
        aGt();
    }

    private void aGw() {
        this.ebV.setVisibility(0);
    }

    private void aGx() {
        this.ebV.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void Zd() {
        hz(false);
        hideLoadingView(this.ebX);
        hideNetRefreshView(this.ebX);
        aGw();
    }

    private void hz(boolean z) {
        if (this.ebV != null) {
            this.ebV.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            Zd();
            gg(true);
        }
    }

    private void aGy() {
        if (this.ecb == null || !l.lm()) {
            ZV();
        } else if (this.ecb.hasMore()) {
            if (this.bNt.getCount() > 3) {
                ZT();
            } else {
                aAj();
            }
        } else if (this.bNt.getCount() == 0) {
            ZV();
        } else {
            ZU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
        if (this.ebW != null) {
            this.ebW.onDestory();
        }
        if (this.bNt != null) {
            this.bNt.setOnSrollToBottomListener(null);
            this.bNt.setScrollable(null);
        }
        if (this.ecb != null) {
            this.ecb.onDestroy();
        }
        if (this.ebY != null) {
            this.ebY.onDestroy();
        }
        if (this.ebZ != null) {
            this.ebZ.EA();
        }
        if (this.dDt != null) {
            this.dDt.onDestroy();
        }
    }

    public void ZT() {
        this.bNt.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.setOnClickListener(null);
        this.bKJ.DY();
    }

    public void ZU() {
        this.bNt.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.setOnClickListener(null);
        this.bKJ.DZ();
        this.bKJ.setText(getResources().getString(e.j.list_no_more));
    }

    public void aAj() {
        this.bNt.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.YV();
            }
        });
        this.bKJ.DZ();
        this.bKJ.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void ZV() {
        this.bNt.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        lK(i);
        if (this.dhH != null) {
            this.dhH.onChangeSkinType(getPageContext(), i);
        }
        if (this.bKJ != null) {
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bKJ.ek(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.ebY != null) {
            this.ebY.onChangeSkinType(i);
        }
        if (this.ebZ != null) {
            this.ebZ.onChangeSkinType(i);
        }
        if (this.eca != null) {
            this.eca.onChangeSkinType(i);
        }
        if (this.ebW != null) {
            this.ebW.notifyDataSetChanged();
        }
        al.j(this.QP, e.d.cp_bg_line_d);
        al.j(this.ebV, e.d.cp_bg_line_e);
    }

    private void lK(int i) {
        if (this.dBI != null) {
            nA(i);
        } else {
            lL(i);
        }
    }

    private void lL(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dB(e.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        int i2 = e.d.select_topbar_icon_color_tint;
        ap.CM().c(this.ccT, e.f.icon_topbar_return_n_svg, i2);
        ap.CM().c(this.dRK, e.f.icon_topbar_search_n_svg, i2);
        if (this.dDl != null) {
            this.dDl.kB(i2);
            this.dDl.onChangeSkinType(i);
        }
        if (this.ebU != null) {
            this.ebU.setBackgroundDrawable(new BitmapDrawable(al.dB(e.f.s_navbar_bg)).mutate());
        }
    }

    private void nA(int i) {
        if (this.dBI != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dBI);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dBI);
            com.baidu.tieba.frs.worldcup.b.a(this.ebU, this.dBI);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            ap.CM().c(this.ccT, e.f.icon_topbar_return_n_svg, i2);
            ap.CM().c(this.dRK, e.f.icon_topbar_search_n_svg, i2);
            if (this.dDl != null) {
                this.dDl.kB(i2);
                this.dDl.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a054";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TextUtils.isEmpty(getForumId())) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar aaO() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dBI = pair;
    }

    public String getForumId() {
        return this.ecb != null ? this.ecb.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        lK(TbadkCoreApplication.getInst().getSkinType());
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
    }
}
