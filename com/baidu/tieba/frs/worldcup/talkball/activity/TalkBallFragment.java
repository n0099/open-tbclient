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
    private PbListView bPm;
    private BdTypeRecyclerView bRY;
    private ImageView chC;
    private VoiceManager dLz;
    private ObservedChangeLinearLayout dNI;
    private b dNh;
    private c dNp;
    private NoNetworkView drO;
    private ImageView ebJ;
    private View elT;
    private BdSwipeRefreshLayout elU;
    private com.baidu.tieba.frs.worldcup.talkball.a.b elV;
    private ViewGroup elW;
    private com.baidu.tieba.frs.worldcup.talkball.view.a elX;
    private AutoBannerView elY;
    private AdidasBanner elZ;
    private com.baidu.tieba.frs.worldcup.talkball.c.a ema;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private Pair<Integer, Integer> dLE = null;
    private j.b bWm = new j.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.j.b
        public void bI(boolean z) {
            TalkBallFragment.this.gm(true);
        }
    };
    private BdListView.e emb = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.aaA();
        }
    };
    private NoNetworkView.a dcP = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z) {
                TalkBallFragment.this.aaI();
                TalkBallFragment.this.gm(true);
            }
        }
    };
    private CustomMessageListener dMG = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dNh != null) {
                    TalkBallFragment.this.dNh.h(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bRi = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
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
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> emc = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void i(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a oh;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.elY != null && (oh = TalkBallFragment.this.elY.oh(i - 1)) != null) {
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
        this.dLz = getVoiceManager();
        this.dLz.onCreate(getPageContext());
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
        this.ema = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dMG);
        registerListener(2001446, this.bRi, getUniqueId());
        aJs();
    }

    private void aJs() {
        aJw();
        if (checkNetwork()) {
            showLoadingView(this.elW, true);
            gm(false);
            return;
        }
        abA();
        d((d.a) null);
    }

    private void aY(View view) {
        this.elT = view.findViewById(e.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.elT.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.elT.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.elT.setLayoutParams(layoutParams);
        }
    }

    private void aJ(View view) {
        this.dNI = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.QZ = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.chC = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.ebJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        this.ebJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.ema != null) {
                    TalkBallFragment.this.ema.aJU();
                }
            }
        });
        this.dNh = new b(getActivity());
        this.dNh.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.ema != null) {
                    TalkBallFragment.this.ema.aJV();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dNh.getView(), (View.OnClickListener) null);
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
        this.elW = (ViewGroup) view.findViewById(e.g.content_container);
        this.mPullView = new k(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bWm);
        this.elU = (BdSwipeRefreshLayout) view.findViewById(e.g.pull_refresh_layout);
        this.elU.setProgressView(this.mPullView);
        this.bRY = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bRY.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRY.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bRY.setScrollable(this);
        this.bRY.setFadingEdgeLength(0);
        this.bRY.setOverScrollMode(2);
        this.bRY.setOnSrollToBottomListener(this.emb);
        this.bRY.setRecyclerListener(new a());
        this.elV = new com.baidu.tieba.frs.worldcup.talkball.a.b(this, this.bRY);
    }

    private void ba(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(e.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dNp = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aJt() {
        this.drO = new NoNetworkView(getActivity());
        this.drO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.drO.a(this.dcP);
        this.dNI.addView(this.drO);
        checkNetwork();
    }

    private boolean checkNetwork() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.drO.setVisibility(8);
            return true;
        }
        this.drO.setVisibility(0);
        return false;
    }

    private void aJu() {
        this.bPm = new PbListView(getActivity());
        this.bPm.getView();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bPm.Fm();
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPm.ew(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(boolean z) {
        if (checkNetwork() && this.ema != null) {
            hE(z);
            this.bRY.setSelection(0);
            this.ema.onRefresh();
            return;
        }
        hE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (checkNetwork() && this.ema != null) {
            aJx();
            this.bRY.stopScroll();
            this.ema.aJT();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void V(ArrayList<h> arrayList) {
        if (this.elV != null) {
            this.elV.setData(arrayList);
            this.elV.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar == null || v.H(eVar.aJE()) == 0) {
            if (this.elX != null) {
                this.bRY.removeHeaderView(this.elX.getView());
                this.elX = null;
                return;
            }
            return;
        }
        if (this.elX == null) {
            this.elX = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bRY);
            this.bRY.addHeaderView(this.elX.getView(), this.bRY.getHeaderViewsCount());
        }
        this.elX.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bRY != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.elZ != null) {
                    this.bRY.removeHeaderView(this.elZ);
                    this.elZ = null;
                    return;
                }
                return;
            }
            if (this.elZ == null) {
                this.elZ = new AdidasBanner(getContext());
                this.bRY.addHeaderView(this.elZ, this.bRY.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.elZ.setForumId(getForumId());
            this.elZ.aJ(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bW(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bRY != null) {
            if (v.I(list)) {
                if (this.elY != null) {
                    this.bRY.removeHeaderView(this.elY);
                    this.elY = null;
                    return;
                }
                return;
            }
            if (this.elY == null) {
                this.elY = new AutoBannerView(getContext());
                this.elY.setOutOnCoverViewCallback(this.emc);
                this.bRY.addHeaderView(this.elY, 0);
            }
            this.elY.bX(list);
            this.elY.FR();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dNp != null) {
            this.dNp.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.elX != null) {
                this.elX.gA(isPrimary());
            }
            if (isPrimary()) {
                if (!this.ZR) {
                    init();
                }
                if (this.dNp != null) {
                    this.dNp.asu();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.elW);
            aJv();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.hmg) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aJw();
        showNetRefreshView(this.elW, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        aaI();
        aJs();
    }

    private void aJv() {
        this.elU.setVisibility(0);
    }

    private void aJw() {
        this.elU.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void aaI() {
        hE(false);
        hideLoadingView(this.elW);
        hideNetRefreshView(this.elW);
        aJv();
    }

    private void hE(boolean z) {
        if (this.elU != null) {
            this.elU.setRefreshing(z);
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
        if (this.ema == null || !l.ll()) {
            abA();
        } else if (this.ema.hasMore()) {
            if (this.bRY.getCount() > 3) {
                aby();
            } else {
                aDf();
            }
        } else if (this.bRY.getCount() == 0) {
            abA();
        } else {
            abz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLz != null) {
            this.dLz.onDestory(getPageContext());
        }
        if (this.elV != null) {
            this.elV.onDestory();
        }
        if (this.bRY != null) {
            this.bRY.setOnSrollToBottomListener(null);
            this.bRY.setScrollable(null);
        }
        if (this.ema != null) {
            this.ema.onDestroy();
        }
        if (this.elX != null) {
            this.elX.onDestroy();
        }
        if (this.elY != null) {
            this.elY.FS();
        }
        if (this.dNp != null) {
            this.dNp.onDestroy();
        }
    }

    public void aby() {
        this.bRY.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.setOnClickListener(null);
        this.bPm.Fp();
    }

    public void abz() {
        this.bRY.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.setOnClickListener(null);
        this.bPm.Fq();
        this.bPm.setText(getResources().getString(e.j.list_no_more));
    }

    public void aDf() {
        this.bRY.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.aaA();
            }
        });
        this.bPm.Fq();
        this.bPm.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void abA() {
        this.bRY.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        mo(i);
        if (this.drO != null) {
            this.drO.onChangeSkinType(getPageContext(), i);
        }
        if (this.bPm != null) {
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPm.ey(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.elX != null) {
            this.elX.onChangeSkinType(i);
        }
        if (this.elY != null) {
            this.elY.onChangeSkinType(i);
        }
        if (this.elZ != null) {
            this.elZ.onChangeSkinType(i);
        }
        if (this.elV != null) {
            this.elV.notifyDataSetChanged();
        }
        al.j(this.QZ, e.d.cp_bg_line_d);
        al.j(this.elU, e.d.cp_bg_line_e);
    }

    private void mo(int i) {
        if (this.dLE != null) {
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
        ap.Ed().c(this.chC, e.f.icon_topbar_return_n_svg, i2);
        ap.Ed().c(this.ebJ, e.f.icon_topbar_search_n_svg, i2);
        if (this.dNh != null) {
            this.dNh.lf(i2);
            this.dNh.onChangeSkinType(i);
        }
        if (this.elT != null) {
            this.elT.setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
        }
    }

    private void oe(int i) {
        if (this.dLE != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dLE);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dLE);
            com.baidu.tieba.frs.worldcup.b.a(this.elT, this.dLE);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            ap.Ed().c(this.chC, e.f.icon_topbar_return_n_svg, i2);
            ap.Ed().c(this.ebJ, e.f.icon_topbar_search_n_svg, i2);
            if (this.dNh != null) {
                this.dNh.lf(i2);
                this.dNh.onChangeSkinType(i);
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
        this.dLE = pair;
    }

    public String getForumId() {
        return this.ema != null ? this.ema.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dLz == null) {
            this.dLz = VoiceManager.instance();
        }
        return this.dLz;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        mo(TbadkCoreApplication.getInst().getSkinType());
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dLz = getVoiceManager();
        if (this.dLz != null) {
            this.dLz.onStop(getPageContext());
        }
    }
}
