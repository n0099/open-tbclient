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
    private PbListView bOB;
    private BdTypeRecyclerView bRn;
    private ImageView cgR;
    private VoiceManager dKQ;
    private c dMG;
    private ObservedChangeLinearLayout dMZ;
    private b dMy;
    private NoNetworkView drf;
    private ImageView ebd;
    private View eln;
    private BdSwipeRefreshLayout elo;
    private com.baidu.tieba.frs.worldcup.talkball.a.b elp;
    private ViewGroup elq;
    private com.baidu.tieba.frs.worldcup.talkball.view.a elr;
    private AutoBannerView els;
    private AdidasBanner elt;
    private com.baidu.tieba.frs.worldcup.talkball.c.a elu;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private Pair<Integer, Integer> dKV = null;
    private j.b bVB = new j.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            TalkBallFragment.this.gj(true);
        }
    };
    private BdListView.e elv = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.aad();
        }
    };
    private NoNetworkView.a dcc = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                TalkBallFragment.this.aal();
                TalkBallFragment.this.gj(true);
            }
        }
    };
    private CustomMessageListener dLX = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dMy != null) {
                    TalkBallFragment.this.dMy.h(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bQx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    int l = com.baidu.adp.lib.g.b.l(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == l) {
                        TalkBallFragment.this.aal();
                        TalkBallFragment.this.gj(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> elw = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void g(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a og;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.els != null && (og = TalkBallFragment.this.els.og(i - 1)) != null) {
                TiebaStatic.log(new am("c13085").aA(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).x("obj_locate", i).aA("obj_param1", og.ys()));
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
        this.dKQ = getVoiceManager();
        this.dKQ.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.talk_ball_layout, viewGroup, false);
        aY(inflate);
        aJ(inflate);
        aZ(inflate);
        aIW();
        aIV();
        ba(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.ZI = true;
        this.elu = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dLX);
        registerListener(2001446, this.bQx, getUniqueId());
        aIU();
    }

    private void aIU() {
        aIY();
        if (checkNetwork()) {
            showLoadingView(this.elq, true);
            gj(false);
            return;
        }
        abd();
        d((d.a) null);
    }

    private void aY(View view) {
        this.eln = view.findViewById(e.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.eln.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eln.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.eln.setLayoutParams(layoutParams);
        }
    }

    private void aJ(View view) {
        this.dMZ = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QP = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.cgR = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.ebd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        this.ebd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.elu != null) {
                    TalkBallFragment.this.elu.aJw();
                }
            }
        });
        this.dMy = new b(getActivity());
        this.dMy.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.elu != null) {
                    TalkBallFragment.this.elu.aJx();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dMy.getView(), (View.OnClickListener) null);
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

    private void aZ(View view) {
        this.elq = (ViewGroup) view.findViewById(e.g.content_container);
        this.mPullView = new k(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bVB);
        this.elo = (BdSwipeRefreshLayout) view.findViewById(e.g.pull_refresh_layout);
        this.elo.setProgressView(this.mPullView);
        this.bRn = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bRn.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRn.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bRn.setScrollable(this);
        this.bRn.setFadingEdgeLength(0);
        this.bRn.setOverScrollMode(2);
        this.bRn.setOnSrollToBottomListener(this.elv);
        this.bRn.setRecyclerListener(new a());
        this.elp = new com.baidu.tieba.frs.worldcup.talkball.a.b(this, this.bRn);
    }

    private void ba(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(e.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dMG = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aIV() {
        this.drf = new NoNetworkView(getActivity());
        this.drf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.drf.a(this.dcc);
        this.dMZ.addView(this.drf);
        checkNetwork();
    }

    private boolean checkNetwork() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.drf.setVisibility(8);
            return true;
        }
        this.drf.setVisibility(0);
        return false;
    }

    private void aIW() {
        this.bOB = new PbListView(getActivity());
        this.bOB.getView();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bOB.EZ();
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOB.ew(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(boolean z) {
        if (checkNetwork() && this.elu != null) {
            hE(z);
            this.bRn.setSelection(0);
            this.elu.onRefresh();
            return;
        }
        hE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aad() {
        if (checkNetwork() && this.elu != null) {
            aIZ();
            this.bRn.stopScroll();
            this.elu.aJv();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void V(ArrayList<h> arrayList) {
        if (this.elp != null) {
            this.elp.setData(arrayList);
            this.elp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar == null || v.H(eVar.aJg()) == 0) {
            if (this.elr != null) {
                this.bRn.removeHeaderView(this.elr.getView());
                this.elr = null;
                return;
            }
            return;
        }
        if (this.elr == null) {
            this.elr = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bRn);
            this.bRn.addHeaderView(this.elr.getView(), this.bRn.getHeaderViewsCount());
        }
        this.elr.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bRn != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.elt != null) {
                    this.bRn.removeHeaderView(this.elt);
                    this.elt = null;
                    return;
                }
                return;
            }
            if (this.elt == null) {
                this.elt = new AdidasBanner(getContext());
                this.bRn.addHeaderView(this.elt, this.bRn.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.elt.setForumId(getForumId());
            this.elt.aI(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bV(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bRn != null) {
            if (v.I(list)) {
                if (this.els != null) {
                    this.bRn.removeHeaderView(this.els);
                    this.els = null;
                    return;
                }
                return;
            }
            if (this.els == null) {
                this.els = new AutoBannerView(getContext());
                this.els.setOutOnCoverViewCallback(this.elw);
                this.bRn.addHeaderView(this.els, 0);
            }
            this.els.bW(list);
            this.els.FE();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dMG != null) {
            this.dMG.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.elr != null) {
                this.elr.gx(isPrimary());
            }
            if (isPrimary()) {
                if (!this.ZI) {
                    init();
                }
                if (this.dMG != null) {
                    this.dMG.arW();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.elq);
            aIX();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.hlc) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aIY();
        showNetRefreshView(this.elq, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        aal();
        aIU();
    }

    private void aIX() {
        this.elo.setVisibility(0);
    }

    private void aIY() {
        this.elo.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void aal() {
        hE(false);
        hideLoadingView(this.elq);
        hideNetRefreshView(this.elq);
        aIX();
    }

    private void hE(boolean z) {
        if (this.elo != null) {
            this.elo.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            aal();
            gj(true);
        }
    }

    private void aIZ() {
        if (this.elu == null || !l.ll()) {
            abd();
        } else if (this.elu.hasMore()) {
            if (this.bRn.getCount() > 3) {
                abb();
            } else {
                aCI();
            }
        } else if (this.bRn.getCount() == 0) {
            abd();
        } else {
            abc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dKQ != null) {
            this.dKQ.onDestory(getPageContext());
        }
        if (this.elp != null) {
            this.elp.onDestory();
        }
        if (this.bRn != null) {
            this.bRn.setOnSrollToBottomListener(null);
            this.bRn.setScrollable(null);
        }
        if (this.elu != null) {
            this.elu.onDestroy();
        }
        if (this.elr != null) {
            this.elr.onDestroy();
        }
        if (this.els != null) {
            this.els.FF();
        }
        if (this.dMG != null) {
            this.dMG.onDestroy();
        }
    }

    public void abb() {
        this.bRn.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.setOnClickListener(null);
        this.bOB.Fc();
    }

    public void abc() {
        this.bRn.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.setOnClickListener(null);
        this.bOB.Fd();
        this.bOB.setText(getResources().getString(e.j.list_no_more));
    }

    public void aCI() {
        this.bRn.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.aad();
            }
        });
        this.bOB.Fd();
        this.bOB.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void abd() {
        this.bRn.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        mn(i);
        if (this.drf != null) {
            this.drf.onChangeSkinType(getPageContext(), i);
        }
        if (this.bOB != null) {
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOB.ey(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.elr != null) {
            this.elr.onChangeSkinType(i);
        }
        if (this.els != null) {
            this.els.onChangeSkinType(i);
        }
        if (this.elt != null) {
            this.elt.onChangeSkinType(i);
        }
        if (this.elp != null) {
            this.elp.notifyDataSetChanged();
        }
        al.j(this.QP, e.d.cp_bg_line_d);
        al.j(this.elo, e.d.cp_bg_line_e);
    }

    private void mn(int i) {
        if (this.dKV != null) {
            od(i);
        } else {
            mo(i);
        }
    }

    private void mo(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dP(e.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        int i2 = e.d.select_topbar_icon_color_tint;
        ap.DQ().c(this.cgR, e.f.icon_topbar_return_n_svg, i2);
        ap.DQ().c(this.ebd, e.f.icon_topbar_search_n_svg, i2);
        if (this.dMy != null) {
            this.dMy.le(i2);
            this.dMy.onChangeSkinType(i);
        }
        if (this.eln != null) {
            this.eln.setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
        }
    }

    private void od(int i) {
        if (this.dKV != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dKV);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dKV);
            com.baidu.tieba.frs.worldcup.b.a(this.eln, this.dKV);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            ap.DQ().c(this.cgR, e.f.icon_topbar_return_n_svg, i2);
            ap.DQ().c(this.ebd, e.f.icon_topbar_search_n_svg, i2);
            if (this.dMy != null) {
                this.dMy.le(i2);
                this.dMy.onChangeSkinType(i);
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
    public NavigationBar abW() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dKV = pair;
    }

    public String getForumId() {
        return this.elu != null ? this.elu.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dKQ == null) {
            this.dKQ = VoiceManager.instance();
        }
        return this.dKQ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        mn(TbadkCoreApplication.getInst().getSkinType());
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dKQ = getVoiceManager();
        if (this.dKQ != null) {
            this.dKQ.onStop(getPageContext());
        }
    }
}
