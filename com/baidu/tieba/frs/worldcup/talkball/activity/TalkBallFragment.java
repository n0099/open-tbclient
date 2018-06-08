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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.c.c;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
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
public class TalkBallFragment extends BaseFragment implements NavigationBar.a, VoiceManager.c, ai, a {
    private AppBarLayout NW;
    private ImageView bLm;
    private PbListView btv;
    private BdTypeRecyclerView bwl;
    private NoNetworkView cRO;
    private View dFi;
    private BdSwipeRefreshLayout dFj;
    private b dFk;
    private ViewGroup dFl;
    private com.baidu.tieba.frs.worldcup.talkball.view.a dFm;
    private AutoBannerView dFn;
    private AdidasBanner dFo;
    private FloatingAnimationView dFp;
    private com.baidu.tieba.frs.worldcup.talkball.c.a dFq;
    private boolean dFr;
    private VoiceManager dhB;
    private ObservedChangeLinearLayout djE;
    private com.baidu.tieba.c.b djf;
    private c djn;
    private ImageView dwa;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private Pair<Integer, Integer> dhH = null;
    private int mSkinType = 3;
    private f.b bzV = new f.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.f.b
        public void aS(boolean z) {
            TalkBallFragment.this.fm(true);
        }
    };
    private BdListView.e dFs = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.SJ();
        }
    };
    private NoNetworkView.a cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                TalkBallFragment.this.SR();
                TalkBallFragment.this.fm(true);
            }
        }
    };
    private CustomMessageListener diF = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626 && (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) != null) {
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.djf != null) {
                    TalkBallFragment.this.djf.f(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bvx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    int g = com.baidu.adp.lib.g.b.g(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == g) {
                        TalkBallFragment.this.SR();
                        TalkBallFragment.this.fm(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> dFt = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.10
        @Override // com.baidu.tbadk.core.flow.a.d
        public void f(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a lQ;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.dFn != null && (lQ = TalkBallFragment.this.dFn.lQ(i - 1)) != null) {
                TiebaStatic.log(new am("c13085").ah(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).r("obj_locate", i).ah("obj_param1", lQ.ub()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new am("c13084").ah(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).r("obj_locate", i).ah("obj_param1", aVar.ub()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dhB = getVoiceManager();
        this.dhB.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.talk_ball_layout, viewGroup, false);
        aA(inflate);
        al(inflate);
        aB(inflate);
        aAf();
        aAd();
        aC(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.dFr = true;
        this.dFq = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.diF);
        registerListener(2001446, this.bvx, getUniqueId());
        aAc();
    }

    private void aAc() {
        aAh();
        if (aAe()) {
            showLoadingView(this.dFl, true);
            fm(false);
            return;
        }
        TL();
        d((d.a) null);
    }

    private void aA(View view) {
        this.dFi = view.findViewById(d.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.dFi.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dFi.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dFi.setLayoutParams(layoutParams);
        }
    }

    private void al(View view) {
        this.djE = (ObservedChangeLinearLayout) view.findViewById(d.g.navigationbar_wrapper);
        this.NW = (AppBarLayout) view.findViewById(d.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.bLm = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
        this.dwa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
        this.dwa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dFq != null) {
                    TalkBallFragment.this.dFq.aAF();
                }
            }
        });
        this.djf = new com.baidu.tieba.c.b(getActivity());
        this.djf.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dFq != null) {
                    TalkBallFragment.this.dFq.aAG();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.djf.getView(), (View.OnClickListener) null);
    }

    private void aB(View view) {
        this.dFl = (ViewGroup) view.findViewById(d.g.content_container);
        this.mPullView = new g(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bzV);
        this.dFj = (BdSwipeRefreshLayout) view.findViewById(d.g.pull_refresh_layout);
        this.dFj.setProgressView(this.mPullView);
        this.bwl = (BdTypeRecyclerView) view.findViewById(d.g.recycler_view);
        ((DefaultItemAnimator) this.bwl.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bwl.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bwl.setScrollable(this);
        this.bwl.setFadingEdgeLength(0);
        this.bwl.setOverScrollMode(2);
        this.bwl.setOnSrollToBottomListener(this.dFs);
        this.bwl.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
            }
        });
        this.dFk = new b(this, this.bwl);
    }

    private void aC(View view) {
        if (view != null) {
            this.dFp = (FloatingAnimationView) view.findViewById(d.g.redpacket_view);
            this.dFp.setPageId(getUniqueId());
            this.djn = new c(getPageContext(), this.dFp, 2);
        }
    }

    private void aAd() {
        this.cRO = new NoNetworkView(getActivity());
        this.cRO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cRO.a(this.cCR);
        this.djE.addView(this.cRO);
        aAe();
    }

    private boolean aAe() {
        if (j.jr()) {
            this.cRO.setVisibility(8);
            return true;
        }
        this.cRO.setVisibility(0);
        return false;
    }

    private void aAf() {
        this.btv = new PbListView(getActivity());
        this.btv.getView();
        this.btv.dx(d.C0141d.cp_bg_line_e);
        this.btv.setHeight(l.e(getActivity(), d.e.tbds182));
        this.btv.Ao();
        this.btv.setTextSize(d.e.tbfontsize33);
        this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
        this.btv.dw(d.C0141d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (aAe() && this.dFq != null) {
            gn(z);
            this.bwl.setSelection(0);
            this.dFq.onRefresh();
            return;
        }
        gn(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        if (aAe() && this.dFq != null) {
            aAi();
            this.bwl.stopScroll();
            this.dFq.aAE();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void Q(ArrayList<h> arrayList) {
        if (this.dFk != null) {
            this.dFk.setData(arrayList);
            this.dFk.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(e eVar) {
        if (eVar == null || w.y(eVar.aAp()) == 0) {
            if (this.dFm != null) {
                this.bwl.removeHeaderView(this.dFm.getView());
                this.dFm = null;
                return;
            }
            return;
        }
        if (this.dFm == null) {
            this.dFm = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bwl);
            this.bwl.addHeaderView(this.dFm.getView(), this.bwl.getHeaderViewsCount());
        }
        this.dFm.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bwl != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.dFo != null) {
                    this.bwl.removeHeaderView(this.dFo);
                    this.dFo = null;
                    return;
                }
                return;
            }
            if (this.dFo == null) {
                this.dFo = new AdidasBanner(getContext());
                this.bwl.addHeaderView(this.dFo, this.bwl.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.dFo.setForumId(getForumId());
            this.dFo.ap(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bA(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bwl != null) {
            if (w.z(list)) {
                if (this.dFn != null) {
                    this.bwl.removeHeaderView(this.dFn);
                    this.dFn = null;
                    return;
                }
                return;
            }
            if (this.dFn == null) {
                this.dFn = new AutoBannerView(getContext());
                this.dFn.setOutOnCoverViewCallback(this.dFt);
                this.bwl.addHeaderView(this.dFn, 0);
            }
            this.dFn.bB(list);
            this.dFn.AS();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.djn != null) {
            this.djn.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dFm != null) {
                this.dFm.fw(isPrimary());
            }
            if (isPrimary()) {
                if (!this.dFr) {
                    init();
                }
                if (this.djn != null) {
                    this.djn.akO();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.dFl);
            aAg();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(d.k.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gFM) {
                string = TbadkCoreApplication.getInst().getString(d.k.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aAh();
        showNetRefreshView(this.dFl, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        SR();
        aAc();
    }

    private void aAg() {
        this.dFj.setVisibility(0);
    }

    private void aAh() {
        this.dFj.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void SR() {
        gn(false);
        hideLoadingView(this.dFl);
        hideNetRefreshView(this.dFl);
        aAg();
    }

    private void gn(boolean z) {
        if (this.dFj != null) {
            this.dFj.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            SR();
            fm(true);
        }
    }

    private void aAi() {
        if (this.dFq == null || !l.jU()) {
            TL();
        } else if (this.dFq.hasMore()) {
            if (this.bwl.getCount() > 3) {
                TJ();
            } else {
                auA();
            }
        } else if (this.bwl.getCount() == 0) {
            TL();
        } else {
            TK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
        if (this.dFk != null) {
            this.dFk.onDestory();
        }
        if (this.bwl != null) {
            this.bwl.setOnSrollToBottomListener(null);
            this.bwl.setScrollable(null);
        }
        if (this.dFq != null) {
            this.dFq.onDestroy();
        }
        if (this.dFm != null) {
            this.dFm.onDestroy();
        }
        if (this.dFn != null) {
            this.dFn.AT();
        }
        if (this.djn != null) {
            this.djn.onDestroy();
        }
    }

    public void TJ() {
        this.bwl.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.setOnClickListener(null);
        this.btv.Ar();
    }

    public void TK() {
        this.bwl.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.setOnClickListener(null);
        this.btv.As();
        this.btv.setText(getResources().getString(d.k.list_no_more));
    }

    public void auA() {
        this.bwl.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.SJ();
            }
        });
        this.btv.As();
        this.btv.setText(getResources().getString(d.k.list_click_load_more));
    }

    public void TL() {
        this.bwl.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        kh(i);
        if (this.cRO != null) {
            this.cRO.onChangeSkinType(getPageContext(), i);
        }
        if (this.btv != null) {
            this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
            this.btv.dy(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.dFm != null) {
            this.dFm.onChangeSkinType(i);
        }
        if (this.dFn != null) {
            this.dFn.onChangeSkinType(i);
        }
        if (this.dFo != null) {
            this.dFo.onChangeSkinType(i);
        }
        if (this.dFk != null) {
            this.dFk.notifyDataSetChanged();
        }
        al.j(this.NW, d.C0141d.cp_bg_line_d);
        al.j(this.dFj, d.C0141d.cp_bg_line_c);
        al.j(this.bwl, d.C0141d.cp_bg_line_e);
    }

    private void kh(int i) {
        if (this.dhH != null) {
            lN(i);
        } else {
            ki(i);
        }
    }

    private void ki(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(al.cR(d.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            al.j(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
        }
        int i2 = d.C0141d.select_topbar_icon_color_tint;
        ap.zp().c(this.bLm, d.f.icon_topbar_return_n_svg, i2);
        ap.zp().c(this.dwa, d.f.icon_topbar_search_n_svg, i2);
        if (this.djf != null) {
            this.djf.jc(i2);
            this.djf.onChangeSkinType(i);
        }
        if (this.dFi != null) {
            this.dFi.setBackgroundDrawable(new BitmapDrawable(al.cR(d.f.s_navbar_bg)).mutate());
        }
    }

    private boolean lN(int i) {
        if (this.dhH != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                al.c(this.mNavigationBar.mCenterText, d.C0141d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dhH);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dhH);
            com.baidu.tieba.frs.worldcup.b.a(this.dFi, this.dhH);
            int i2 = d.C0141d.select_topbar_icon_white_color_tint;
            ap.zp().c(this.bLm, d.f.icon_topbar_return_n_svg, i2);
            ap.zp().c(this.dwa, d.f.icon_topbar_search_n_svg, i2);
            if (this.djf != null) {
                this.djf.jc(i2);
                this.djf.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a054";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        return super.getCurrentPageSourceKeyList();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && TextUtils.isEmpty(getForumId())) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar UB() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dhH = pair;
    }

    public String getForumId() {
        return this.dFq != null ? this.dFq.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        kh(TbadkCoreApplication.getInst().getSkinType());
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
    }
}
