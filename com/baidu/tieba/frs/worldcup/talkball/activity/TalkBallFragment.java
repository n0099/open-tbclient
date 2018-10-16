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
    private AppBarLayout QN;
    private boolean ZI;
    private PbListView bJY;
    private BdTypeRecyclerView bMI;
    private ImageView ccE;
    private VoiceManager dAm;
    private b dBU;
    private c dCc;
    private ObservedChangeLinearLayout dCv;
    private ImageView dQG;
    private NoNetworkView dgC;
    private BdSwipeRefreshLayout eaA;
    private com.baidu.tieba.frs.worldcup.talkball.a.b eaB;
    private ViewGroup eaC;
    private com.baidu.tieba.frs.worldcup.talkball.view.a eaD;
    private AutoBannerView eaE;
    private AdidasBanner eaF;
    private com.baidu.tieba.frs.worldcup.talkball.c.a eaG;
    private View eaz;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private Pair<Integer, Integer> dAr = null;
    private j.b bQW = new j.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.j.b
        public void bp(boolean z) {
            TalkBallFragment.this.fW(true);
        }
    };
    private BdListView.e eaH = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.YK();
        }
    };
    private NoNetworkView.a cRx = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (z) {
                TalkBallFragment.this.YS();
                TalkBallFragment.this.fW(true);
            }
        }
    };
    private CustomMessageListener dBt = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dBU != null) {
                    TalkBallFragment.this.dBU.g(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bLT = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    int l = com.baidu.adp.lib.g.b.l(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == l) {
                        TalkBallFragment.this.YS();
                        TalkBallFragment.this.fW(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> eaI = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void h(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a nl;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.eaE != null && (nl = TalkBallFragment.this.eaE.nl(i - 1)) != null) {
                TiebaStatic.log(new am("c13085").ax(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).x("obj_locate", i).ax("obj_param1", nl.xf()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new am("c13084").ax(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).x("obj_locate", i).ax("obj_param1", aVar.xf()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dAm = getVoiceManager();
        this.dAm.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.talk_ball_layout, viewGroup, false);
        aT(inflate);
        aE(inflate);
        aU(inflate);
        aGX();
        aGV();
        aV(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.ZI = true;
        this.eaG = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dBt);
        registerListener(2001446, this.bLT, getUniqueId());
        aGU();
    }

    private void aGU() {
        aGZ();
        if (aGW()) {
            showLoadingView(this.eaC, true);
            fW(false);
            return;
        }
        ZK();
        d((d.a) null);
    }

    private void aT(View view) {
        this.eaz = view.findViewById(e.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.eaz.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eaz.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.eaz.setLayoutParams(layoutParams);
        }
    }

    private void aE(View view) {
        this.dCv = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QN = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.ccE = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.dQG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        this.dQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.eaG != null) {
                    TalkBallFragment.this.eaG.aHx();
                }
            }
        });
        this.dBU = new b(getActivity());
        this.dBU.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.eaG != null) {
                    TalkBallFragment.this.eaG.aHy();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dBU.getView(), (View.OnClickListener) null);
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

    private void aU(View view) {
        this.eaC = (ViewGroup) view.findViewById(e.g.content_container);
        this.mPullView = new k(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bQW);
        this.eaA = (BdSwipeRefreshLayout) view.findViewById(e.g.pull_refresh_layout);
        this.eaA.setProgressView(this.mPullView);
        this.bMI = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bMI.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bMI.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bMI.setScrollable(this);
        this.bMI.setFadingEdgeLength(0);
        this.bMI.setOverScrollMode(2);
        this.bMI.setOnSrollToBottomListener(this.eaH);
        this.bMI.setRecyclerListener(new a());
        this.eaB = new com.baidu.tieba.frs.worldcup.talkball.a.b(this, this.bMI);
    }

    private void aV(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(e.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dCc = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aGV() {
        this.dgC = new NoNetworkView(getActivity());
        this.dgC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.dgC.a(this.cRx);
        this.dCv.addView(this.dgC);
        aGW();
    }

    private boolean aGW() {
        if (com.baidu.adp.lib.util.j.kM()) {
            this.dgC.setVisibility(8);
            return true;
        }
        this.dgC.setVisibility(0);
        return false;
    }

    private void aGX() {
        this.bJY = new PbListView(getActivity());
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(l.h(getActivity(), e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bJY.dU(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(boolean z) {
        if (aGW() && this.eaG != null) {
            hp(z);
            this.bMI.setSelection(0);
            this.eaG.onRefresh();
            return;
        }
        hp(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YK() {
        if (aGW() && this.eaG != null) {
            aHa();
            this.bMI.stopScroll();
            this.eaG.aHw();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void W(ArrayList<h> arrayList) {
        if (this.eaB != null) {
            this.eaB.setData(arrayList);
            this.eaB.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar == null || v.I(eVar.aHh()) == 0) {
            if (this.eaD != null) {
                this.bMI.removeHeaderView(this.eaD.getView());
                this.eaD = null;
                return;
            }
            return;
        }
        if (this.eaD == null) {
            this.eaD = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bMI);
            this.bMI.addHeaderView(this.eaD.getView(), this.bMI.getHeaderViewsCount());
        }
        this.eaD.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bMI != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.eaF != null) {
                    this.bMI.removeHeaderView(this.eaF);
                    this.eaF = null;
                    return;
                }
                return;
            }
            if (this.eaF == null) {
                this.eaF = new AdidasBanner(getContext());
                this.bMI.addHeaderView(this.eaF, this.bMI.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.eaF.setForumId(getForumId());
            this.eaF.aF(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bU(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bMI != null) {
            if (v.J(list)) {
                if (this.eaE != null) {
                    this.bMI.removeHeaderView(this.eaE);
                    this.eaE = null;
                    return;
                }
                return;
            }
            if (this.eaE == null) {
                this.eaE = new AutoBannerView(getContext());
                this.eaE.setOutOnCoverViewCallback(this.eaI);
                this.bMI.addHeaderView(this.eaE, 0);
            }
            this.eaE.bV(list);
            this.eaE.Ep();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dCc != null) {
            this.dCc.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.eaD != null) {
                this.eaD.gj(isPrimary());
            }
            if (isPrimary()) {
                if (!this.ZI) {
                    init();
                }
                if (this.dCc != null) {
                    this.dCc.apT();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.eaC);
            aGY();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gZz) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aGZ();
        showNetRefreshView(this.eaC, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        YS();
        aGU();
    }

    private void aGY() {
        this.eaA.setVisibility(0);
    }

    private void aGZ() {
        this.eaA.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void YS() {
        hp(false);
        hideLoadingView(this.eaC);
        hideNetRefreshView(this.eaC);
        aGY();
    }

    private void hp(boolean z) {
        if (this.eaA != null) {
            this.eaA.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            YS();
            fW(true);
        }
    }

    private void aHa() {
        if (this.eaG == null || !l.lo()) {
            ZK();
        } else if (this.eaG.hasMore()) {
            if (this.bMI.getCount() > 3) {
                ZI();
            } else {
                aAL();
            }
        } else if (this.bMI.getCount() == 0) {
            ZK();
        } else {
            ZJ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dAm != null) {
            this.dAm.onDestory(getPageContext());
        }
        if (this.eaB != null) {
            this.eaB.onDestory();
        }
        if (this.bMI != null) {
            this.bMI.setOnSrollToBottomListener(null);
            this.bMI.setScrollable(null);
        }
        if (this.eaG != null) {
            this.eaG.onDestroy();
        }
        if (this.eaD != null) {
            this.eaD.onDestroy();
        }
        if (this.eaE != null) {
            this.eaE.Eq();
        }
        if (this.dCc != null) {
            this.dCc.onDestroy();
        }
    }

    public void ZI() {
        this.bMI.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.setOnClickListener(null);
        this.bJY.DO();
    }

    public void ZJ() {
        this.bMI.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.setOnClickListener(null);
        this.bJY.DP();
        this.bJY.setText(getResources().getString(e.j.list_no_more));
    }

    public void aAL() {
        this.bMI.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.YK();
            }
        });
        this.bJY.DP();
        this.bJY.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void ZK() {
        this.bMI.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        ls(i);
        if (this.dgC != null) {
            this.dgC.onChangeSkinType(getPageContext(), i);
        }
        if (this.bJY != null) {
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bJY.dW(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.eaD != null) {
            this.eaD.onChangeSkinType(i);
        }
        if (this.eaE != null) {
            this.eaE.onChangeSkinType(i);
        }
        if (this.eaF != null) {
            this.eaF.onChangeSkinType(i);
        }
        if (this.eaB != null) {
            this.eaB.notifyDataSetChanged();
        }
        al.j(this.QN, e.d.cp_bg_line_d);
        al.j(this.eaA, e.d.cp_bg_line_e);
    }

    private void ls(int i) {
        if (this.dAr != null) {
            ni(i);
        } else {
            lt(i);
        }
    }

    private void lt(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dn(e.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        int i2 = e.d.select_topbar_icon_color_tint;
        ap.CF().c(this.ccE, e.f.icon_topbar_return_n_svg, i2);
        ap.CF().c(this.dQG, e.f.icon_topbar_search_n_svg, i2);
        if (this.dBU != null) {
            this.dBU.ki(i2);
            this.dBU.onChangeSkinType(i);
        }
        if (this.eaz != null) {
            this.eaz.setBackgroundDrawable(new BitmapDrawable(al.dn(e.f.s_navbar_bg)).mutate());
        }
    }

    private void ni(int i) {
        if (this.dAr != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dAr);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dAr);
            com.baidu.tieba.frs.worldcup.b.a(this.eaz, this.dAr);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            ap.CF().c(this.ccE, e.f.icon_topbar_return_n_svg, i2);
            ap.CF().c(this.dQG, e.f.icon_topbar_search_n_svg, i2);
            if (this.dBU != null) {
                this.dBU.ki(i2);
                this.dBU.onChangeSkinType(i);
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
    public NavigationBar aaD() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dAr = pair;
    }

    public String getForumId() {
        return this.eaG != null ? this.eaG.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ls(TbadkCoreApplication.getInst().getSkinType());
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
    }
}
