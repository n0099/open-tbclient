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
/* loaded from: classes3.dex */
public class TalkBallFragment extends BaseFragment implements NavigationBar.a, VoiceManager.c, ak, com.baidu.tieba.frs.worldcup.talkball.activity.a {
    private AppBarLayout NV;
    private ImageView bOq;
    private PbListView bvA;
    private BdTypeRecyclerView bym;
    private NoNetworkView cSy;
    private ImageView dBW;
    private View dLr;
    private BdSwipeRefreshLayout dLs;
    private b dLt;
    private ViewGroup dLu;
    private com.baidu.tieba.frs.worldcup.talkball.view.a dLv;
    private AutoBannerView dLw;
    private AdidasBanner dLx;
    private com.baidu.tieba.frs.worldcup.talkball.c.a dLy;
    private boolean dLz;
    private VoiceManager dmp;
    private com.baidu.tieba.c.b dnX;
    private c dog;
    private ObservedChangeLinearLayout doz;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private Pair<Integer, Integer> dmv = null;
    private g.b bCC = new g.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.g.b
        public void aS(boolean z) {
            TalkBallFragment.this.fn(true);
        }
    };
    private BdListView.e dLA = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.Tn();
        }
    };
    private NoNetworkView.a cDq = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                TalkBallFragment.this.Tv();
                TalkBallFragment.this.fn(true);
            }
        }
    };
    private CustomMessageListener dnw = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dnX != null) {
                    TalkBallFragment.this.dnX.f(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bxx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    int g = com.baidu.adp.lib.g.b.g(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == g) {
                        TalkBallFragment.this.Tv();
                        TalkBallFragment.this.fn(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> dLB = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void h(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a mj;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.dLw != null && (mj = TalkBallFragment.this.dLw.mj(i - 1)) != null) {
                TiebaStatic.log(new an("c13085").af(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).r("obj_locate", i).af("obj_param1", mj.tU()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new an("c13084").af(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).r("obj_locate", i).af("obj_param1", aVar.tU()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dmp = getVoiceManager();
        this.dmp.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.talk_ball_layout, viewGroup, false);
        aF(inflate);
        aq(inflate);
        aG(inflate);
        aBv();
        aBt();
        aH(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.dLz = true;
        this.dLy = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dnw);
        registerListener(2001446, this.bxx, getUniqueId());
        aBs();
    }

    private void aBs() {
        aBx();
        if (aBu()) {
            showLoadingView(this.dLu, true);
            fn(false);
            return;
        }
        Un();
        d((d.a) null);
    }

    private void aF(View view) {
        this.dLr = view.findViewById(d.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.dLr.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLr.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dLr.setLayoutParams(layoutParams);
        }
    }

    private void aq(View view) {
        this.doz = (ObservedChangeLinearLayout) view.findViewById(d.g.navigationbar_wrapper);
        this.NV = (AppBarLayout) view.findViewById(d.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.bOq = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(d.g.widget_navi_back_button);
        this.dBW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
        this.dBW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dLy != null) {
                    TalkBallFragment.this.dLy.aBV();
                }
            }
        });
        this.dnX = new com.baidu.tieba.c.b(getActivity());
        this.dnX.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dLy != null) {
                    TalkBallFragment.this.dLy.aBW();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dnX.getView(), (View.OnClickListener) null);
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

    private void aG(View view) {
        this.dLu = (ViewGroup) view.findViewById(d.g.content_container);
        this.mPullView = new h(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bCC);
        this.dLs = (BdSwipeRefreshLayout) view.findViewById(d.g.pull_refresh_layout);
        this.dLs.setProgressView(this.mPullView);
        this.bym = (BdTypeRecyclerView) view.findViewById(d.g.recycler_view);
        ((DefaultItemAnimator) this.bym.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bym.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.bym.setScrollable(this);
        this.bym.setFadingEdgeLength(0);
        this.bym.setOverScrollMode(2);
        this.bym.setOnSrollToBottomListener(this.dLA);
        this.bym.setRecyclerListener(new a());
        this.dLt = new b(this, this.bym);
    }

    private void aH(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(d.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.dog = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aBt() {
        this.cSy = new NoNetworkView(getActivity());
        this.cSy.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cSy.a(this.cDq);
        this.doz.addView(this.cSy);
        aBu();
    }

    private boolean aBu() {
        if (j.js()) {
            this.cSy.setVisibility(8);
            return true;
        }
        this.cSy.setVisibility(0);
        return false;
    }

    private void aBv() {
        this.bvA = new PbListView(getActivity());
        this.bvA.getView();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.setHeight(l.f(getActivity(), d.e.tbds182));
        this.bvA.Au();
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
        this.bvA.dA(d.C0140d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        if (aBu() && this.dLy != null) {
            gz(z);
            this.bym.setSelection(0);
            this.dLy.onRefresh();
            return;
        }
        gz(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn() {
        if (aBu() && this.dLy != null) {
            aBy();
            this.bym.stopScroll();
            this.dLy.aBU();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void W(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.dLt != null) {
            this.dLt.setData(arrayList);
            this.dLt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(e eVar) {
        if (eVar == null || w.y(eVar.aBF()) == 0) {
            if (this.dLv != null) {
                this.bym.removeHeaderView(this.dLv.getView());
                this.dLv = null;
                return;
            }
            return;
        }
        if (this.dLv == null) {
            this.dLv = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.bym);
            this.bym.addHeaderView(this.dLv.getView(), this.bym.getHeaderViewsCount());
        }
        this.dLv.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.bym != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.dLx != null) {
                    this.bym.removeHeaderView(this.dLx);
                    this.dLx = null;
                    return;
                }
                return;
            }
            if (this.dLx == null) {
                this.dLx = new AdidasBanner(getContext());
                this.bym.addHeaderView(this.dLx, this.bym.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.dLx.setForumId(getForumId());
            this.dLx.an(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bD(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.bym != null) {
            if (w.z(list)) {
                if (this.dLw != null) {
                    this.bym.removeHeaderView(this.dLw);
                    this.dLw = null;
                    return;
                }
                return;
            }
            if (this.dLw == null) {
                this.dLw = new AutoBannerView(getContext());
                this.dLw.setOutOnCoverViewCallback(this.dLB);
                this.bym.addHeaderView(this.dLw, 0);
            }
            this.dLw.bE(list);
            this.dLw.Bb();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.dog != null) {
            this.dog.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dLv != null) {
                this.dLv.fA(isPrimary());
            }
            if (isPrimary()) {
                if (!this.dLz) {
                    init();
                }
                if (this.dog != null) {
                    this.dog.akH();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.dLu);
            aBw();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(d.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gKB) {
                string = TbadkCoreApplication.getInst().getString(d.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aBx();
        showNetRefreshView(this.dLu, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        Tv();
        aBs();
    }

    private void aBw() {
        this.dLs.setVisibility(0);
    }

    private void aBx() {
        this.dLs.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void Tv() {
        gz(false);
        hideLoadingView(this.dLu);
        hideNetRefreshView(this.dLu);
        aBw();
    }

    private void gz(boolean z) {
        if (this.dLs != null) {
            this.dLs.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            Tv();
            fn(true);
        }
    }

    private void aBy() {
        if (this.dLy == null || !l.jV()) {
            Un();
        } else if (this.dLy.hasMore()) {
            if (this.bym.getCount() > 3) {
                Ul();
            } else {
                avx();
            }
        } else if (this.bym.getCount() == 0) {
            Un();
        } else {
            Um();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dmp != null) {
            this.dmp.onDestory(getPageContext());
        }
        if (this.dLt != null) {
            this.dLt.onDestory();
        }
        if (this.bym != null) {
            this.bym.setOnSrollToBottomListener(null);
            this.bym.setScrollable(null);
        }
        if (this.dLy != null) {
            this.dLy.onDestroy();
        }
        if (this.dLv != null) {
            this.dLv.onDestroy();
        }
        if (this.dLw != null) {
            this.dLw.Bc();
        }
        if (this.dog != null) {
            this.dog.onDestroy();
        }
    }

    public void Ul() {
        this.bym.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.setOnClickListener(null);
        this.bvA.Ax();
    }

    public void Um() {
        this.bym.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.setOnClickListener(null);
        this.bvA.Ay();
        this.bvA.setText(getResources().getString(d.j.list_no_more));
    }

    public void avx() {
        this.bym.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.Tn();
            }
        });
        this.bvA.Ay();
        this.bvA.setText(getResources().getString(d.j.list_click_load_more));
    }

    public void Un() {
        this.bym.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        kw(i);
        if (this.cSy != null) {
            this.cSy.onChangeSkinType(getPageContext(), i);
        }
        if (this.bvA != null) {
            this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
            this.bvA.dC(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.dLv != null) {
            this.dLv.onChangeSkinType(i);
        }
        if (this.dLw != null) {
            this.dLw.onChangeSkinType(i);
        }
        if (this.dLx != null) {
            this.dLx.onChangeSkinType(i);
        }
        if (this.dLt != null) {
            this.dLt.notifyDataSetChanged();
        }
        am.j(this.NV, d.C0140d.cp_bg_line_d);
        am.j(this.dLs, d.C0140d.cp_bg_line_e);
    }

    private void kw(int i) {
        if (this.dmv != null) {
            mg(i);
        } else {
            kx(i);
        }
    }

    private void kx(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(am.cU(d.f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            am.j(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
        }
        int i2 = d.C0140d.select_topbar_icon_color_tint;
        aq.zv().c(this.bOq, d.f.icon_topbar_return_n_svg, i2);
        aq.zv().c(this.dBW, d.f.icon_topbar_search_n_svg, i2);
        if (this.dnX != null) {
            this.dnX.jm(i2);
            this.dnX.onChangeSkinType(i);
        }
        if (this.dLr != null) {
            this.dLr.setBackgroundDrawable(new BitmapDrawable(am.cU(d.f.s_navbar_bg)).mutate());
        }
    }

    private void mg(int i) {
        if (this.dmv != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                am.c(this.mNavigationBar.mCenterText, d.C0140d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dmv);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dmv);
            com.baidu.tieba.frs.worldcup.b.a(this.dLr, this.dmv);
            int i2 = d.C0140d.select_topbar_icon_white_color_tint;
            aq.zv().c(this.bOq, d.f.icon_topbar_return_n_svg, i2);
            aq.zv().c(this.dBW, d.f.icon_topbar_search_n_svg, i2);
            if (this.dnX != null) {
                this.dnX.jm(i2);
                this.dnX.onChangeSkinType(i);
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
    public NavigationBar Vf() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dmv = pair;
    }

    public String getForumId() {
        return this.dLy != null ? this.dLy.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmp == null) {
            this.dmp = VoiceManager.instance();
        }
        return this.dmp;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        kw(TbadkCoreApplication.getInst().getSkinType());
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onStop(getPageContext());
        }
    }
}
