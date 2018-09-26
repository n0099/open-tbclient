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
import com.baidu.tieba.c.c;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.worldcup.talkball.a.b;
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
    private AppBarLayout Qy;
    private PbListView bBr;
    private BdTypeRecyclerView bEd;
    private ImageView bUe;
    private NoNetworkView cYm;
    private ImageView dIJ;
    private View dSF;
    private BdSwipeRefreshLayout dSG;
    private b dSH;
    private ViewGroup dSI;
    private com.baidu.tieba.frs.worldcup.talkball.view.a dSJ;
    private AutoBannerView dSK;
    private AdidasBanner dSL;
    private com.baidu.tieba.frs.worldcup.talkball.c.a dSM;
    private boolean dSN;
    private VoiceManager dsk;
    private com.baidu.tieba.c.b dtT;
    private c dub;
    private ObservedChangeLinearLayout duu;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private Pair<Integer, Integer> dsq = null;
    private j.b bIt = new j.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.j.b
        public void bf(boolean z) {
            TalkBallFragment.this.fE(true);
        }
    };
    private BdListView.e dSO = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.Vd();
        }
    };
    private NoNetworkView.a cJe = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            if (z) {
                TalkBallFragment.this.Vl();
                TalkBallFragment.this.fE(true);
            }
        }
    };
    private CustomMessageListener dts = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dtT != null) {
                    TalkBallFragment.this.dtT.f(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bDo = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    int l = com.baidu.adp.lib.g.b.l(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == l) {
                        TalkBallFragment.this.Vl();
                        TalkBallFragment.this.fE(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> dSP = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void h(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a mN;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.dSK != null && (mN = TalkBallFragment.this.dSK.mN(i - 1)) != null) {
                TiebaStatic.log(new am("c13085").al(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).w("obj_locate", i).al("obj_param1", mN.uW()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new am("c13084").al(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).w("obj_locate", i).al("obj_param1", aVar.uW()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dsk = getVoiceManager();
        this.dsk.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.talk_ball_layout, viewGroup, false);
        aT(inflate);
        aE(inflate);
        aU(inflate);
        aDF();
        aDD();
        aV(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.dSN = true;
        this.dSM = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dts);
        registerListener(2001446, this.bDo, getUniqueId());
        aDC();
    }

    private void aDC() {
        aDH();
        if (aDE()) {
            showLoadingView(this.dSI, true);
            fE(false);
            return;
        }
        Wd();
        d((d.a) null);
    }

    private void aT(View view) {
        this.dSF = view.findViewById(e.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.dSF.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dSF.setLayoutParams(layoutParams);
        }
    }

    private void aE(View view) {
        this.duu = (ObservedChangeLinearLayout) view.findViewById(e.g.navigationbar_wrapper);
        this.Qy = (AppBarLayout) view.findViewById(e.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.bUe = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(e.g.widget_navi_back_button);
        this.dIJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
        this.dIJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dSM != null) {
                    TalkBallFragment.this.dSM.aEf();
                }
            }
        });
        this.dtT = new com.baidu.tieba.c.b(getActivity());
        this.dtT.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dSM != null) {
                    TalkBallFragment.this.dSM.aEg();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dtT.getView(), (View.OnClickListener) null);
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
        this.dSI = (ViewGroup) view.findViewById(e.g.content_container);
        this.mPullView = new k(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bIt);
        this.dSG = (BdSwipeRefreshLayout) view.findViewById(e.g.pull_refresh_layout);
        this.dSG.setProgressView(this.mPullView);
        this.bEd = (BdTypeRecyclerView) view.findViewById(e.g.recycler_view);
        ((DefaultItemAnimator) this.bEd.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bEd.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bEd.setScrollable(this);
        this.bEd.setFadingEdgeLength(0);
        this.bEd.setOverScrollMode(2);
        this.bEd.setOnSrollToBottomListener(this.dSO);
        this.bEd.setRecyclerListener(new a());
        this.dSH = new b(this, this.bEd);
    }

    private void aV(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(e.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dub = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aDD() {
        this.cYm = new NoNetworkView(getActivity());
        this.cYm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cYm.a(this.cJe);
        this.duu.addView(this.cYm);
        aDE();
    }

    private boolean aDE() {
        if (com.baidu.adp.lib.util.j.ky()) {
            this.cYm.setVisibility(8);
            return true;
        }
        this.cYm.setVisibility(0);
        return false;
    }

    private void aDF() {
        this.bBr = new PbListView(getActivity());
        this.bBr.getView();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.setHeight(l.h(getActivity(), e.C0141e.tbds182));
        this.bBr.BF();
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bBr.dK(e.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(boolean z) {
        if (aDE() && this.dSM != null) {
            gX(z);
            this.bEd.setSelection(0);
            this.dSM.onRefresh();
            return;
        }
        gX(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vd() {
        if (aDE() && this.dSM != null) {
            aDI();
            this.bEd.stopScroll();
            this.dSM.aEe();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void W(ArrayList<h> arrayList) {
        if (this.dSH != null) {
            this.dSH.setData(arrayList);
            this.dSH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(com.baidu.tieba.frs.worldcup.talkball.b.e eVar) {
        if (eVar == null || v.y(eVar.aDP()) == 0) {
            if (this.dSJ != null) {
                this.bEd.removeHeaderView(this.dSJ.getView());
                this.dSJ = null;
                return;
            }
            return;
        }
        if (this.dSJ == null) {
            this.dSJ = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bEd);
            this.bEd.addHeaderView(this.dSJ.getView(), this.bEd.getHeaderViewsCount());
        }
        this.dSJ.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bEd != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.dSL != null) {
                    this.bEd.removeHeaderView(this.dSL);
                    this.dSL = null;
                    return;
                }
                return;
            }
            if (this.dSL == null) {
                this.dSL = new AdidasBanner(getContext());
                this.bEd.addHeaderView(this.dSL, this.bEd.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.dSL.setForumId(getForumId());
            this.dSL.au(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bE(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bEd != null) {
            if (v.z(list)) {
                if (this.dSK != null) {
                    this.bEd.removeHeaderView(this.dSK);
                    this.dSK = null;
                    return;
                }
                return;
            }
            if (this.dSK == null) {
                this.dSK = new AutoBannerView(getContext());
                this.dSK.setOutOnCoverViewCallback(this.dSP);
                this.bEd.addHeaderView(this.dSK, 0);
            }
            this.dSK.bF(list);
            this.dSK.Ck();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dub != null) {
            this.dub.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dSJ != null) {
                this.dSJ.fR(isPrimary());
            }
            if (isPrimary()) {
                if (!this.dSN) {
                    init();
                }
                if (this.dub != null) {
                    this.dub.amu();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.dSI);
            aDG();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(e.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gSe) {
                string = TbadkCoreApplication.getInst().getString(e.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aDH();
        showNetRefreshView(this.dSI, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        Vl();
        aDC();
    }

    private void aDG() {
        this.dSG.setVisibility(0);
    }

    private void aDH() {
        this.dSG.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void Vl() {
        gX(false);
        hideLoadingView(this.dSI);
        hideNetRefreshView(this.dSI);
        aDG();
    }

    private void gX(boolean z) {
        if (this.dSG != null) {
            this.dSG.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            Vl();
            fE(true);
        }
    }

    private void aDI() {
        if (this.dSM == null || !l.lb()) {
            Wd();
        } else if (this.dSM.hasMore()) {
            if (this.bEd.getCount() > 3) {
                Wb();
            } else {
                axq();
            }
        } else if (this.bEd.getCount() == 0) {
            Wd();
        } else {
            Wc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dsk != null) {
            this.dsk.onDestory(getPageContext());
        }
        if (this.dSH != null) {
            this.dSH.onDestory();
        }
        if (this.bEd != null) {
            this.bEd.setOnSrollToBottomListener(null);
            this.bEd.setScrollable(null);
        }
        if (this.dSM != null) {
            this.dSM.onDestroy();
        }
        if (this.dSJ != null) {
            this.dSJ.onDestroy();
        }
        if (this.dSK != null) {
            this.dSK.Cl();
        }
        if (this.dub != null) {
            this.dub.onDestroy();
        }
    }

    public void Wb() {
        this.bEd.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.setOnClickListener(null);
        this.bBr.BI();
    }

    public void Wc() {
        this.bEd.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.setOnClickListener(null);
        this.bBr.BJ();
        this.bBr.setText(getResources().getString(e.j.list_no_more));
    }

    public void axq() {
        this.bEd.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.Vd();
            }
        });
        this.bBr.BJ();
        this.bBr.setText(getResources().getString(e.j.list_click_load_more));
    }

    public void Wd() {
        this.bEd.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        kU(i);
        if (this.cYm != null) {
            this.cYm.onChangeSkinType(getPageContext(), i);
        }
        if (this.bBr != null) {
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bBr.dM(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.dSJ != null) {
            this.dSJ.onChangeSkinType(i);
        }
        if (this.dSK != null) {
            this.dSK.onChangeSkinType(i);
        }
        if (this.dSL != null) {
            this.dSL.onChangeSkinType(i);
        }
        if (this.dSH != null) {
            this.dSH.notifyDataSetChanged();
        }
        al.j(this.Qy, e.d.cp_bg_line_d);
        al.j(this.dSG, e.d.cp_bg_line_e);
    }

    private void kU(int i) {
        if (this.dsq != null) {
            mK(i);
        } else {
            kV(i);
        }
    }

    private void kV(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(al.dd(e.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        int i2 = e.d.select_topbar_icon_color_tint;
        ap.Ay().c(this.bUe, e.f.icon_topbar_return_n_svg, i2);
        ap.Ay().c(this.dIJ, e.f.icon_topbar_search_n_svg, i2);
        if (this.dtT != null) {
            this.dtT.jK(i2);
            this.dtT.onChangeSkinType(i);
        }
        if (this.dSF != null) {
            this.dSF.setBackgroundDrawable(new BitmapDrawable(al.dd(e.f.s_navbar_bg)).mutate());
        }
    }

    private void mK(int i) {
        if (this.dsq != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dsq);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dsq);
            com.baidu.tieba.frs.worldcup.b.a(this.dSF, this.dsq);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            ap.Ay().c(this.bUe, e.f.icon_topbar_return_n_svg, i2);
            ap.Ay().c(this.dIJ, e.f.icon_topbar_search_n_svg, i2);
            if (this.dtT != null) {
                this.dtT.jK(i2);
                this.dtT.onChangeSkinType(i);
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
    public NavigationBar WW() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dsq = pair;
    }

    public String getForumId() {
        return this.dSM != null ? this.dSM.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dsk == null) {
            this.dsk = VoiceManager.instance();
        }
        return this.dsk;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        kU(TbadkCoreApplication.getInst().getSkinType());
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onStop(getPageContext());
        }
    }
}
