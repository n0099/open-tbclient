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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.c.c;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.worldcup.talkball.a.b;
import com.baidu.tieba.frs.worldcup.talkball.b.e;
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
/* loaded from: classes2.dex */
public class TalkBallFragment extends BaseFragment implements NavigationBar.a, VoiceManager.c, ak, com.baidu.tieba.frs.worldcup.talkball.activity.a {
    private AppBarLayout NY;
    private ImageView bNv;
    private PbListView buU;
    private BdTypeRecyclerView bxH;
    private NoNetworkView cPM;
    private View dIC;
    private BdSwipeRefreshLayout dID;
    private b dIE;
    private ViewGroup dIF;
    private com.baidu.tieba.frs.worldcup.talkball.view.a dIG;
    private AutoBannerView dIH;
    private AdidasBanner dII;
    private com.baidu.tieba.frs.worldcup.talkball.c.a dIJ;
    private boolean dIK;
    private VoiceManager djz;
    private ObservedChangeLinearLayout dlH;
    private com.baidu.tieba.c.b dlg;
    private c dlo;
    private ImageView dzk;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private Pair<Integer, Integer> djF = null;
    private g.b bBV = new g.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.g.b
        public void aU(boolean z) {
            TalkBallFragment.this.fm(true);
        }
    };
    private BdListView.e dIL = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.Tf();
        }
    };
    private NoNetworkView.a cAL = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            if (z) {
                TalkBallFragment.this.Tn();
                TalkBallFragment.this.fm(true);
            }
        }
    };
    private CustomMessageListener dkG = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dlg != null) {
                    TalkBallFragment.this.dlg.f(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bwS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    int g = com.baidu.adp.lib.g.b.g(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == g) {
                        TalkBallFragment.this.Tn();
                        TalkBallFragment.this.fm(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> dIM = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void f(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a lX;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.dIH != null && (lX = TalkBallFragment.this.dIH.lX(i - 1)) != null) {
                TiebaStatic.log(new an("c13085").ah(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).r("obj_locate", i).ah("obj_param1", lX.uh()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new an("c13084").ah(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).r("obj_locate", i).ah("obj_param1", aVar.uh()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.djz = getVoiceManager();
        this.djz.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.talk_ball_layout, viewGroup, false);
        aC(inflate);
        an(inflate);
        aD(inflate);
        aAM();
        aAK();
        aE(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.dIK = true;
        this.dIJ = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dkG);
        registerListener(2001446, this.bwS, getUniqueId());
        aAJ();
    }

    private void aAJ() {
        aAO();
        if (aAL()) {
            showLoadingView(this.dIF, true);
            fm(false);
            return;
        }
        Uf();
        d((d.a) null);
    }

    private void aC(View view) {
        this.dIC = view.findViewById(d.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.dIC.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dIC.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dIC.setLayoutParams(layoutParams);
        }
    }

    private void an(View view) {
        this.dlH = (ObservedChangeLinearLayout) view.findViewById(d.g.navigationbar_wrapper);
        this.NY = (AppBarLayout) view.findViewById(d.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.bNv = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
        this.dzk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
        this.dzk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dIJ != null) {
                    TalkBallFragment.this.dIJ.aBm();
                }
            }
        });
        this.dlg = new com.baidu.tieba.c.b(getActivity());
        this.dlg.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dIJ != null) {
                    TalkBallFragment.this.dIJ.aBn();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dlg.getView(), (View.OnClickListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements RecyclerView.RecyclerListener {
        private a() {
        }

        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    private void aD(View view) {
        this.dIF = (ViewGroup) view.findViewById(d.g.content_container);
        this.mPullView = new h(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bBV);
        this.dID = (BdSwipeRefreshLayout) view.findViewById(d.g.pull_refresh_layout);
        this.dID.setProgressView(this.mPullView);
        this.bxH = (BdTypeRecyclerView) view.findViewById(d.g.recycler_view);
        ((DefaultItemAnimator) this.bxH.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bxH.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bxH.setScrollable(this);
        this.bxH.setFadingEdgeLength(0);
        this.bxH.setOverScrollMode(2);
        this.bxH.setOnSrollToBottomListener(this.dIL);
        this.bxH.setRecyclerListener(new a());
        this.dIE = new b(this, this.bxH);
    }

    private void aE(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(d.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dlo = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aAK() {
        this.cPM = new NoNetworkView(getActivity());
        this.cPM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cPM.a(this.cAL);
        this.dlH.addView(this.cPM);
        aAL();
    }

    private boolean aAL() {
        if (j.jr()) {
            this.cPM.setVisibility(8);
            return true;
        }
        this.cPM.setVisibility(0);
        return false;
    }

    private void aAM() {
        this.buU = new PbListView(getActivity());
        this.buU.getView();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.setHeight(l.e(getActivity(), d.e.tbds182));
        this.buU.AE();
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
        this.buU.dx(d.C0142d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (aAL() && this.dIJ != null) {
            gx(z);
            this.bxH.setSelection(0);
            this.dIJ.onRefresh();
            return;
        }
        gx(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        if (aAL() && this.dIJ != null) {
            aAP();
            this.bxH.stopScroll();
            this.dIJ.aBl();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void W(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.dIE != null) {
            this.dIE.setData(arrayList);
            this.dIE.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(e eVar) {
        if (eVar == null || w.z(eVar.aAW()) == 0) {
            if (this.dIG != null) {
                this.bxH.removeHeaderView(this.dIG.getView());
                this.dIG = null;
                return;
            }
            return;
        }
        if (this.dIG == null) {
            this.dIG = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bxH);
            this.bxH.addHeaderView(this.dIG.getView(), this.bxH.getHeaderViewsCount());
        }
        this.dIG.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bxH != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.dII != null) {
                    this.bxH.removeHeaderView(this.dII);
                    this.dII = null;
                    return;
                }
                return;
            }
            if (this.dII == null) {
                this.dII = new AdidasBanner(getContext());
                this.bxH.addHeaderView(this.dII, this.bxH.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.dII.setForumId(getForumId());
            this.dII.ap(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bE(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bxH != null) {
            if (w.A(list)) {
                if (this.dIH != null) {
                    this.bxH.removeHeaderView(this.dIH);
                    this.dIH = null;
                    return;
                }
                return;
            }
            if (this.dIH == null) {
                this.dIH = new AutoBannerView(getContext());
                this.dIH.setOutOnCoverViewCallback(this.dIM);
                this.bxH.addHeaderView(this.dIH, 0);
            }
            this.dIH.bF(list);
            this.dIH.Bk();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dlo != null) {
            this.dlo.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dIG != null) {
                this.dIG.fy(isPrimary());
            }
            if (isPrimary()) {
                if (!this.dIK) {
                    init();
                }
                if (this.dlo != null) {
                    this.dlo.aki();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.dIF);
            aAN();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gJF) {
                string = TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aAO();
        showNetRefreshView(this.dIF, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        Tn();
        aAJ();
    }

    private void aAN() {
        this.dID.setVisibility(0);
    }

    private void aAO() {
        this.dID.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void Tn() {
        gx(false);
        hideLoadingView(this.dIF);
        hideNetRefreshView(this.dIF);
        aAN();
    }

    private void gx(boolean z) {
        if (this.dID != null) {
            this.dID.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            Tn();
            fm(true);
        }
    }

    private void aAP() {
        if (this.dIJ == null || !l.jU()) {
            Uf();
        } else if (this.dIJ.hasMore()) {
            if (this.bxH.getCount() > 3) {
                Ud();
            } else {
                auT();
            }
        } else if (this.bxH.getCount() == 0) {
            Uf();
        } else {
            Ue();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.djz != null) {
            this.djz.onDestory(getPageContext());
        }
        if (this.dIE != null) {
            this.dIE.onDestory();
        }
        if (this.bxH != null) {
            this.bxH.setOnSrollToBottomListener(null);
            this.bxH.setScrollable(null);
        }
        if (this.dIJ != null) {
            this.dIJ.onDestroy();
        }
        if (this.dIG != null) {
            this.dIG.onDestroy();
        }
        if (this.dIH != null) {
            this.dIH.Bl();
        }
        if (this.dlo != null) {
            this.dlo.onDestroy();
        }
    }

    public void Ud() {
        this.bxH.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.setOnClickListener(null);
        this.buU.AH();
    }

    public void Ue() {
        this.bxH.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.setOnClickListener(null);
        this.buU.AI();
        this.buU.setText(getResources().getString(d.k.list_no_more));
    }

    public void auT() {
        this.bxH.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.Tf();
            }
        });
        this.buU.AI();
        this.buU.setText(getResources().getString(d.k.list_click_load_more));
    }

    public void Uf() {
        this.bxH.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        kl(i);
        if (this.cPM != null) {
            this.cPM.onChangeSkinType(getPageContext(), i);
        }
        if (this.buU != null) {
            this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
            this.buU.dz(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.dIG != null) {
            this.dIG.onChangeSkinType(i);
        }
        if (this.dIH != null) {
            this.dIH.onChangeSkinType(i);
        }
        if (this.dII != null) {
            this.dII.onChangeSkinType(i);
        }
        if (this.dIE != null) {
            this.dIE.notifyDataSetChanged();
        }
        am.j(this.NY, d.C0142d.cp_bg_line_d);
        am.j(this.dID, d.C0142d.cp_bg_line_e);
    }

    private void kl(int i) {
        if (this.djF != null) {
            lU(i);
        } else {
            km(i);
        }
    }

    private void km(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(am.cS(d.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            am.j(this.mNavigationBar.getBottomLine(), d.C0142d.cp_bg_line_b);
        }
        int i2 = d.C0142d.select_topbar_icon_color_tint;
        aq.zE().c(this.bNv, d.f.icon_topbar_return_n_svg, i2);
        aq.zE().c(this.dzk, d.f.icon_topbar_search_n_svg, i2);
        if (this.dlg != null) {
            this.dlg.ja(i2);
            this.dlg.onChangeSkinType(i);
        }
        if (this.dIC != null) {
            this.dIC.setBackgroundDrawable(new BitmapDrawable(am.cS(d.f.s_navbar_bg)).mutate());
        }
    }

    private void lU(int i) {
        if (this.djF != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                am.c(this.mNavigationBar.mCenterText, d.C0142d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.djF);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.djF);
            com.baidu.tieba.frs.worldcup.b.a(this.dIC, this.djF);
            int i2 = d.C0142d.select_topbar_icon_white_color_tint;
            aq.zE().c(this.bNv, d.f.icon_topbar_return_n_svg, i2);
            aq.zE().c(this.dzk, d.f.icon_topbar_search_n_svg, i2);
            if (this.dlg != null) {
                this.dlg.ja(i2);
                this.dlg.onChangeSkinType(i);
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
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar UW() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.djF = pair;
    }

    public String getForumId() {
        return this.dIJ != null ? this.dIJ.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.djz == null) {
            this.djz = VoiceManager.instance();
        }
        return this.djz;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        kl(TbadkCoreApplication.getInst().getSkinType());
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onStop(getPageContext());
        }
    }
}
