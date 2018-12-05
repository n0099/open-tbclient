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
    private PbListView bOy;
    private BdTypeRecyclerView bRk;
    private ImageView cgK;
    private VoiceManager dIc;
    private b dJK;
    private c dJS;
    private ObservedChangeLinearLayout dKl;
    private ImageView dYm;
    private NoNetworkView dop;
    private ViewGroup eiA;
    private com.baidu.tieba.frs.worldcup.talkball.view.a eiB;
    private AutoBannerView eiC;
    private AdidasBanner eiD;
    private com.baidu.tieba.frs.worldcup.talkball.c.a eiE;
    private View eix;
    private BdSwipeRefreshLayout eiy;
    private com.baidu.tieba.frs.worldcup.talkball.a.b eiz;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private Pair<Integer, Integer> dIh = null;
    private j.b bVy = new j.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            TalkBallFragment.this.gh(true);
        }
    };
    private BdListView.e eiF = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.aab();
        }
    };
    private NoNetworkView.a cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                TalkBallFragment.this.aaj();
                TalkBallFragment.this.gh(true);
            }
        }
    };
    private CustomMessageListener dJj = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dJK != null) {
                    TalkBallFragment.this.dJK.h(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bQu = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    int l = com.baidu.adp.lib.g.b.l(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == l) {
                        TalkBallFragment.this.aaj();
                        TalkBallFragment.this.gh(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> eiG = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void g(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a nT;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.eiC != null && (nT = TalkBallFragment.this.eiC.nT(i - 1)) != null) {
                TiebaStatic.log(new am("c13085").aA(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).x("obj_locate", i).aA("obj_param1", nT.ys()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new am("c13084").aA(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).x("obj_locate", i).aA("obj_param1", aVar.ys()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dIc = getVoiceManager();
        this.dIc.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.talk_ball_layout, viewGroup, false);
        aV(inflate);
        aG(inflate);
        aW(inflate);
        aIh();
        aIg();
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
        this.eiE = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dJj);
        registerListener(2001446, this.bQu, getUniqueId());
        aIf();
    }

    private void aIf() {
        aIj();
        if (checkNetwork()) {
            showLoadingView(this.eiA, true);
            gh(false);
            return;
        }
        abb();
        d((d.a) null);
    }

    private void aV(View view) {
        this.eix = view.findViewById(e.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.eix.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eix.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.eix.setLayoutParams(layoutParams);
        }
    }

    private void aG(View view) {
        this.dKl = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QP = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.cgK = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.dYm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        this.dYm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.eiE != null) {
                    TalkBallFragment.this.eiE.aIH();
                }
            }
        });
        this.dJK = new b(getActivity());
        this.dJK.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.eiE != null) {
                    TalkBallFragment.this.eiE.aII();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dJK.getView(), (View.OnClickListener) null);
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
        this.eiA = (ViewGroup) view.findViewById(e.g.content_container);
        this.mPullView = new k(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bVy);
        this.eiy = (BdSwipeRefreshLayout) view.findViewById(e.g.pull_refresh_layout);
        this.eiy.setProgressView(this.mPullView);
        this.bRk = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bRk.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRk.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bRk.setScrollable(this);
        this.bRk.setFadingEdgeLength(0);
        this.bRk.setOverScrollMode(2);
        this.bRk.setOnSrollToBottomListener(this.eiF);
        this.bRk.setRecyclerListener(new a());
        this.eiz = new com.baidu.tieba.frs.worldcup.talkball.a.b(this, this.bRk);
    }

    private void aX(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(e.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dJS = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aIg() {
        this.dop = new NoNetworkView(getActivity());
        this.dop.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.dop.a(this.cZk);
        this.dKl.addView(this.dop);
        checkNetwork();
    }

    private boolean checkNetwork() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.dop.setVisibility(8);
            return true;
        }
        this.dop.setVisibility(0);
        return false;
    }

    private void aIh() {
        this.bOy = new PbListView(getActivity());
        this.bOy.getView();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bOy.EZ();
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOy.ew(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(boolean z) {
        if (checkNetwork() && this.eiE != null) {
            hB(z);
            this.bRk.setSelection(0);
            this.eiE.onRefresh();
            return;
        }
        hB(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        if (checkNetwork() && this.eiE != null) {
            aIk();
            this.bRk.stopScroll();
            this.eiE.aIG();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void V(ArrayList<h> arrayList) {
        if (this.eiz != null) {
            this.eiz.setData(arrayList);
            this.eiz.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar == null || v.H(eVar.aIr()) == 0) {
            if (this.eiB != null) {
                this.bRk.removeHeaderView(this.eiB.getView());
                this.eiB = null;
                return;
            }
            return;
        }
        if (this.eiB == null) {
            this.eiB = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bRk);
            this.bRk.addHeaderView(this.eiB.getView(), this.bRk.getHeaderViewsCount());
        }
        this.eiB.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bRk != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.eiD != null) {
                    this.bRk.removeHeaderView(this.eiD);
                    this.eiD = null;
                    return;
                }
                return;
            }
            if (this.eiD == null) {
                this.eiD = new AdidasBanner(getContext());
                this.bRk.addHeaderView(this.eiD, this.bRk.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.eiD.setForumId(getForumId());
            this.eiD.aI(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bU(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bRk != null) {
            if (v.I(list)) {
                if (this.eiC != null) {
                    this.bRk.removeHeaderView(this.eiC);
                    this.eiC = null;
                    return;
                }
                return;
            }
            if (this.eiC == null) {
                this.eiC = new AutoBannerView(getContext());
                this.eiC.setOutOnCoverViewCallback(this.eiG);
                this.bRk.addHeaderView(this.eiC, 0);
            }
            this.eiC.bV(list);
            this.eiC.FD();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dJS != null) {
            this.dJS.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.eiB != null) {
                this.eiB.gu(isPrimary());
            }
            if (isPrimary()) {
                if (!this.ZI) {
                    init();
                }
                if (this.dJS != null) {
                    this.dJS.arh();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.eiA);
            aIi();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.hhQ) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aIj();
        showNetRefreshView(this.eiA, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        aaj();
        aIf();
    }

    private void aIi() {
        this.eiy.setVisibility(0);
    }

    private void aIj() {
        this.eiy.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void aaj() {
        hB(false);
        hideLoadingView(this.eiA);
        hideNetRefreshView(this.eiA);
        aIi();
    }

    private void hB(boolean z) {
        if (this.eiy != null) {
            this.eiy.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            aaj();
            gh(true);
        }
    }

    private void aIk() {
        if (this.eiE == null || !l.ll()) {
            abb();
        } else if (this.eiE.hasMore()) {
            if (this.bRk.getCount() > 3) {
                aaZ();
            } else {
                aBT();
            }
        } else if (this.bRk.getCount() == 0) {
            abb();
        } else {
            aba();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dIc != null) {
            this.dIc.onDestory(getPageContext());
        }
        if (this.eiz != null) {
            this.eiz.onDestory();
        }
        if (this.bRk != null) {
            this.bRk.setOnSrollToBottomListener(null);
            this.bRk.setScrollable(null);
        }
        if (this.eiE != null) {
            this.eiE.onDestroy();
        }
        if (this.eiB != null) {
            this.eiB.onDestroy();
        }
        if (this.eiC != null) {
            this.eiC.FE();
        }
        if (this.dJS != null) {
            this.dJS.onDestroy();
        }
    }

    public void aaZ() {
        this.bRk.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.setOnClickListener(null);
        this.bOy.Fc();
    }

    public void aba() {
        this.bRk.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.setOnClickListener(null);
        this.bOy.Fd();
        this.bOy.setText(getResources().getString(e.j.list_no_more));
    }

    public void aBT() {
        this.bRk.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.aab();
            }
        });
        this.bOy.Fd();
        this.bOy.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void abb() {
        this.bRk.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        ma(i);
        if (this.dop != null) {
            this.dop.onChangeSkinType(getPageContext(), i);
        }
        if (this.bOy != null) {
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOy.ey(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.eiB != null) {
            this.eiB.onChangeSkinType(i);
        }
        if (this.eiC != null) {
            this.eiC.onChangeSkinType(i);
        }
        if (this.eiD != null) {
            this.eiD.onChangeSkinType(i);
        }
        if (this.eiz != null) {
            this.eiz.notifyDataSetChanged();
        }
        al.j(this.QP, e.d.cp_bg_line_d);
        al.j(this.eiy, e.d.cp_bg_line_e);
    }

    private void ma(int i) {
        if (this.dIh != null) {
            nQ(i);
        } else {
            mb(i);
        }
    }

    private void mb(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dP(e.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        int i2 = e.d.select_topbar_icon_color_tint;
        ap.DQ().c(this.cgK, e.f.icon_topbar_return_n_svg, i2);
        ap.DQ().c(this.dYm, e.f.icon_topbar_search_n_svg, i2);
        if (this.dJK != null) {
            this.dJK.kR(i2);
            this.dJK.onChangeSkinType(i);
        }
        if (this.eix != null) {
            this.eix.setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
        }
    }

    private void nQ(int i) {
        if (this.dIh != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dIh);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dIh);
            com.baidu.tieba.frs.worldcup.b.a(this.eix, this.dIh);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            ap.DQ().c(this.cgK, e.f.icon_topbar_return_n_svg, i2);
            ap.DQ().c(this.dYm, e.f.icon_topbar_search_n_svg, i2);
            if (this.dJK != null) {
                this.dJK.kR(i2);
                this.dJK.onChangeSkinType(i);
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
    public NavigationBar abU() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dIh = pair;
    }

    public String getForumId() {
        return this.eiE != null ? this.eiE.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dIc == null) {
            this.dIc = VoiceManager.instance();
        }
        return this.dIc;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ma(TbadkCoreApplication.getInst().getSkinType());
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onStop(getPageContext());
        }
    }
}
