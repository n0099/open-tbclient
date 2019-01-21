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
    private AppBarLayout QZ;
    private boolean ZR;
    private PbListView bPn;
    private BdTypeRecyclerView bRZ;
    private ImageView chD;
    private VoiceManager dLA;
    private ObservedChangeLinearLayout dNJ;
    private b dNi;
    private c dNq;
    private NoNetworkView drP;
    private ImageView ebK;
    private View elU;
    private BdSwipeRefreshLayout elV;
    private com.baidu.tieba.frs.worldcup.talkball.a.b elW;
    private ViewGroup elX;
    private com.baidu.tieba.frs.worldcup.talkball.view.a elY;
    private AutoBannerView elZ;
    private AdidasBanner ema;
    private com.baidu.tieba.frs.worldcup.talkball.c.a emb;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private Pair<Integer, Integer> dLF = null;
    private j.b bWn = new j.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.j.b
        public void bI(boolean z) {
            TalkBallFragment.this.gm(true);
        }
    };
    private BdListView.e emc = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.aaA();
        }
    };
    private NoNetworkView.a dcQ = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z) {
                TalkBallFragment.this.aaI();
                TalkBallFragment.this.gm(true);
            }
        }
    };
    private CustomMessageListener dMH = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dNi != null) {
                    TalkBallFragment.this.dNi.h(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bRj = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    int l = com.baidu.adp.lib.g.b.l(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == l) {
                        TalkBallFragment.this.aaI();
                        TalkBallFragment.this.gm(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> emd = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void i(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a oh;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.elZ != null && (oh = TalkBallFragment.this.elZ.oh(i - 1)) != null) {
                TiebaStatic.log(new am("c13085").aB(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).y("obj_locate", i).aB("obj_param1", oh.yF()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new am("c13084").aB(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).y("obj_locate", i).aB("obj_param1", aVar.yF()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dLA = getVoiceManager();
        this.dLA.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.talk_ball_layout, viewGroup, false);
        aY(inflate);
        aJ(inflate);
        aZ(inflate);
        aJu();
        aJt();
        ba(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.ZR = true;
        this.emb = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dMH);
        registerListener(2001446, this.bRj, getUniqueId());
        aJs();
    }

    private void aJs() {
        aJw();
        if (checkNetwork()) {
            showLoadingView(this.elX, true);
            gm(false);
            return;
        }
        abA();
        d((d.a) null);
    }

    private void aY(View view) {
        this.elU = view.findViewById(e.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.elU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.elU.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.elU.setLayoutParams(layoutParams);
        }
    }

    private void aJ(View view) {
        this.dNJ = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QZ = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.chD = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.ebK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        this.ebK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.emb != null) {
                    TalkBallFragment.this.emb.aJU();
                }
            }
        });
        this.dNi = new b(getActivity());
        this.dNi.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.emb != null) {
                    TalkBallFragment.this.emb.aJV();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dNi.getView(), (View.OnClickListener) null);
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
        this.elX = (ViewGroup) view.findViewById(e.g.content_container);
        this.mPullView = new k(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bWn);
        this.elV = (BdSwipeRefreshLayout) view.findViewById(e.g.pull_refresh_layout);
        this.elV.setProgressView(this.mPullView);
        this.bRZ = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bRZ.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRZ.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bRZ.setScrollable(this);
        this.bRZ.setFadingEdgeLength(0);
        this.bRZ.setOverScrollMode(2);
        this.bRZ.setOnSrollToBottomListener(this.emc);
        this.bRZ.setRecyclerListener(new a());
        this.elW = new com.baidu.tieba.frs.worldcup.talkball.a.b(this, this.bRZ);
    }

    private void ba(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(e.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dNq = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aJt() {
        this.drP = new NoNetworkView(getActivity());
        this.drP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.drP.a(this.dcQ);
        this.dNJ.addView(this.drP);
        checkNetwork();
    }

    private boolean checkNetwork() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.drP.setVisibility(8);
            return true;
        }
        this.drP.setVisibility(0);
        return false;
    }

    private void aJu() {
        this.bPn = new PbListView(getActivity());
        this.bPn.getView();
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bPn.Fm();
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPn.ew(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(boolean z) {
        if (checkNetwork() && this.emb != null) {
            hE(z);
            this.bRZ.setSelection(0);
            this.emb.onRefresh();
            return;
        }
        hE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (checkNetwork() && this.emb != null) {
            aJx();
            this.bRZ.stopScroll();
            this.emb.aJT();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void V(ArrayList<h> arrayList) {
        if (this.elW != null) {
            this.elW.setData(arrayList);
            this.elW.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar == null || v.H(eVar.aJE()) == 0) {
            if (this.elY != null) {
                this.bRZ.removeHeaderView(this.elY.getView());
                this.elY = null;
                return;
            }
            return;
        }
        if (this.elY == null) {
            this.elY = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bRZ);
            this.bRZ.addHeaderView(this.elY.getView(), this.bRZ.getHeaderViewsCount());
        }
        this.elY.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bRZ != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.ema != null) {
                    this.bRZ.removeHeaderView(this.ema);
                    this.ema = null;
                    return;
                }
                return;
            }
            if (this.ema == null) {
                this.ema = new AdidasBanner(getContext());
                this.bRZ.addHeaderView(this.ema, this.bRZ.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.ema.setForumId(getForumId());
            this.ema.aJ(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bW(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bRZ != null) {
            if (v.I(list)) {
                if (this.elZ != null) {
                    this.bRZ.removeHeaderView(this.elZ);
                    this.elZ = null;
                    return;
                }
                return;
            }
            if (this.elZ == null) {
                this.elZ = new AutoBannerView(getContext());
                this.elZ.setOutOnCoverViewCallback(this.emd);
                this.bRZ.addHeaderView(this.elZ, 0);
            }
            this.elZ.bX(list);
            this.elZ.FR();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dNq != null) {
            this.dNq.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.elY != null) {
                this.elY.gA(isPrimary());
            }
            if (isPrimary()) {
                if (!this.ZR) {
                    init();
                }
                if (this.dNq != null) {
                    this.dNq.asu();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.elX);
            aJv();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.hmh) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aJw();
        showNetRefreshView(this.elX, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        aaI();
        aJs();
    }

    private void aJv() {
        this.elV.setVisibility(0);
    }

    private void aJw() {
        this.elV.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void aaI() {
        hE(false);
        hideLoadingView(this.elX);
        hideNetRefreshView(this.elX);
        aJv();
    }

    private void hE(boolean z) {
        if (this.elV != null) {
            this.elV.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            aaI();
            gm(true);
        }
    }

    private void aJx() {
        if (this.emb == null || !l.ll()) {
            abA();
        } else if (this.emb.hasMore()) {
            if (this.bRZ.getCount() > 3) {
                aby();
            } else {
                aDf();
            }
        } else if (this.bRZ.getCount() == 0) {
            abA();
        } else {
            abz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLA != null) {
            this.dLA.onDestory(getPageContext());
        }
        if (this.elW != null) {
            this.elW.onDestory();
        }
        if (this.bRZ != null) {
            this.bRZ.setOnSrollToBottomListener(null);
            this.bRZ.setScrollable(null);
        }
        if (this.emb != null) {
            this.emb.onDestroy();
        }
        if (this.elY != null) {
            this.elY.onDestroy();
        }
        if (this.elZ != null) {
            this.elZ.FS();
        }
        if (this.dNq != null) {
            this.dNq.onDestroy();
        }
    }

    public void aby() {
        this.bRZ.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.setOnClickListener(null);
        this.bPn.Fp();
    }

    public void abz() {
        this.bRZ.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.setOnClickListener(null);
        this.bPn.Fq();
        this.bPn.setText(getResources().getString(e.j.list_no_more));
    }

    public void aDf() {
        this.bRZ.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.aaA();
            }
        });
        this.bPn.Fq();
        this.bPn.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void abA() {
        this.bRZ.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        mo(i);
        if (this.drP != null) {
            this.drP.onChangeSkinType(getPageContext(), i);
        }
        if (this.bPn != null) {
            this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPn.ey(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.elY != null) {
            this.elY.onChangeSkinType(i);
        }
        if (this.elZ != null) {
            this.elZ.onChangeSkinType(i);
        }
        if (this.ema != null) {
            this.ema.onChangeSkinType(i);
        }
        if (this.elW != null) {
            this.elW.notifyDataSetChanged();
        }
        al.j(this.QZ, e.d.cp_bg_line_d);
        al.j(this.elV, e.d.cp_bg_line_e);
    }

    private void mo(int i) {
        if (this.dLF != null) {
            oe(i);
        } else {
            mp(i);
        }
    }

    private void mp(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dP(e.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        int i2 = e.d.select_topbar_icon_color_tint;
        ap.Ed().c(this.chD, e.f.icon_topbar_return_n_svg, i2);
        ap.Ed().c(this.ebK, e.f.icon_topbar_search_n_svg, i2);
        if (this.dNi != null) {
            this.dNi.lf(i2);
            this.dNi.onChangeSkinType(i);
        }
        if (this.elU != null) {
            this.elU.setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
        }
    }

    private void oe(int i) {
        if (this.dLF != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dLF);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dLF);
            com.baidu.tieba.frs.worldcup.b.a(this.elU, this.dLF);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            ap.Ed().c(this.chD, e.f.icon_topbar_return_n_svg, i2);
            ap.Ed().c(this.ebK, e.f.icon_topbar_search_n_svg, i2);
            if (this.dNi != null) {
                this.dNi.lf(i2);
                this.dNi.onChangeSkinType(i);
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
    public NavigationBar act() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dLF = pair;
    }

    public String getForumId() {
        return this.emb != null ? this.emb.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dLA == null) {
            this.dLA = VoiceManager.instance();
        }
        return this.dLA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        mo(TbadkCoreApplication.getInst().getSkinType());
        this.dLA = getVoiceManager();
        if (this.dLA != null) {
            this.dLA.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dLA = getVoiceManager();
        if (this.dLA != null) {
            this.dLA.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dLA = getVoiceManager();
        if (this.dLA != null) {
            this.dLA.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dLA = getVoiceManager();
        if (this.dLA != null) {
            this.dLA.onStop(getPageContext());
        }
    }
}
