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
import com.baidu.tieba.f;
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
    private ImageView bOp;
    private PbListView bvC;
    private BdTypeRecyclerView byo;
    private NoNetworkView cSv;
    private ImageView dBT;
    private View dLn;
    private BdSwipeRefreshLayout dLo;
    private b dLp;
    private ViewGroup dLq;
    private com.baidu.tieba.frs.worldcup.talkball.view.a dLr;
    private AutoBannerView dLs;
    private AdidasBanner dLt;
    private com.baidu.tieba.frs.worldcup.talkball.c.a dLu;
    private boolean dLv;
    private VoiceManager dmn;
    private com.baidu.tieba.c.b dnV;
    private c doe;
    private ObservedChangeLinearLayout dox;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private Pair<Integer, Integer> dmt = null;
    private g.b bCE = new g.b() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.1
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            TalkBallFragment.this.fn(true);
        }
    };
    private BdListView.e dLw = new BdListView.e() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            TalkBallFragment.this.Tq();
        }
    };
    private NoNetworkView.a cDn = new NoNetworkView.a() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
            if (z) {
                TalkBallFragment.this.Ty();
                TalkBallFragment.this.fn(true);
            }
        }
    };
    private CustomMessageListener dnu = new CustomMessageListener(2001626) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof NewsRemindMessage) && customResponsedMessage.getCmd() == 2001626) {
                NewsRemindMessage newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                int notificationCount = newsRemindMessage.getNotificationCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount();
                boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
                if (TalkBallFragment.this.dnV != null) {
                    TalkBallFragment.this.dnV.f(z, notificationCount);
                }
            }
        }
    };
    private CustomMessageListener bxz = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    int g = com.baidu.adp.lib.g.b.g(split[1], -1);
                    if ("FrsTalkBallTab".equals(str) || 12 == g) {
                        TalkBallFragment.this.Ty();
                        TalkBallFragment.this.fn(true);
                    }
                }
            }
        }
    };
    private d<com.baidu.tieba.frs.worldcup.talkball.b.a> dLx = new d<com.baidu.tieba.frs.worldcup.talkball.b.a>() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.8
        @Override // com.baidu.tbadk.core.flow.a.d
        public void h(int i, String str) {
            com.baidu.tieba.frs.worldcup.talkball.b.a mj;
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && TalkBallFragment.this.dLs != null && (mj = TalkBallFragment.this.dLs.mj(i - 1)) != null) {
                TiebaStatic.log(new an("c13085").ae(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).r("obj_locate", i).ae("obj_param1", mj.tT()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.frs.worldcup.talkball.b.a aVar) {
            if (!TextUtils.isEmpty(TalkBallFragment.this.getForumId()) && aVar != null) {
                TiebaStatic.log(new an("c13084").ae(ImageViewerConfig.FORUM_ID, TalkBallFragment.this.getForumId()).r("obj_locate", i).ae("obj_param1", aVar.tT()));
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dmn = getVoiceManager();
        this.dmn.onCreate(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.talk_ball_layout, viewGroup, false);
        aF(inflate);
        aq(inflate);
        aG(inflate);
        aBs();
        aBq();
        aH(inflate);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        init();
    }

    private void init() {
        this.dLv = true;
        this.dLu = new com.baidu.tieba.frs.worldcup.talkball.c.b(getPageContext(), this, getArguments());
        registerListener(this.dnu);
        registerListener(2001446, this.bxz, getUniqueId());
        aBp();
    }

    private void aBp() {
        aBu();
        if (aBr()) {
            showLoadingView(this.dLq, true);
            fn(false);
            return;
        }
        Uq();
        d((d.a) null);
    }

    private void aF(View view) {
        this.dLn = view.findViewById(f.g.statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky() && (this.dLn.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dLn.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.dLn.setLayoutParams(layoutParams);
        }
    }

    private void aq(View view) {
        this.dox = (ObservedChangeLinearLayout) view.findViewById(f.g.navigationbar_wrapper);
        this.NV = (AppBarLayout) view.findViewById(f.g.app_bar_layout);
        this.mNavigationBar = (NavigationBar) view.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        if (getArguments() != null) {
            this.mNavigationBar.setCenterTextTitle(getArguments().getString(ImageViewerConfig.FORUM_NAME, ""));
        }
        this.bOp = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(f.g.widget_navi_back_button);
        this.dBT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.widget_nb_item_search, (View.OnClickListener) null);
        this.dBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dLu != null) {
                    TalkBallFragment.this.dLu.aBS();
                }
            }
        });
        this.dnV = new com.baidu.tieba.c.b(getActivity());
        this.dnV.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (TalkBallFragment.this.dLu != null) {
                    TalkBallFragment.this.dLu.aBT();
                }
            }
        });
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dnV.getView(), (View.OnClickListener) null);
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
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(f.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(f.g.abstract_img_layout);
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
        this.dLq = (ViewGroup) view.findViewById(f.g.content_container);
        this.mPullView = new h(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.mPullView.a(this.bCE);
        this.dLo = (BdSwipeRefreshLayout) view.findViewById(f.g.pull_refresh_layout);
        this.dLo.setProgressView(this.mPullView);
        this.byo = (BdTypeRecyclerView) view.findViewById(f.g.recycler_view);
        ((DefaultItemAnimator) this.byo.getItemAnimator()).setSupportsChangeAnimations(false);
        this.byo.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.byo.setScrollable(this);
        this.byo.setFadingEdgeLength(0);
        this.byo.setOverScrollMode(2);
        this.byo.setOnSrollToBottomListener(this.dLw);
        this.byo.setRecyclerListener(new a());
        this.dLp = new b(this, this.byo);
    }

    private void aH(View view) {
        if (view != null) {
            FloatingAnimationView floatingAnimationView = (FloatingAnimationView) view.findViewById(f.g.redpacket_view);
            floatingAnimationView.setPageId(getUniqueId());
            this.doe = new c(getPageContext(), floatingAnimationView, 2);
        }
    }

    private void aBq() {
        this.cSv = new NoNetworkView(getActivity());
        this.cSv.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.cSv.a(this.cDn);
        this.dox.addView(this.cSv);
        aBr();
    }

    private boolean aBr() {
        if (j.js()) {
            this.cSv.setVisibility(8);
            return true;
        }
        this.cSv.setVisibility(0);
        return false;
    }

    private void aBs() {
        this.bvC = new PbListView(getActivity());
        this.bvC.getView();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.setHeight(l.f(getActivity(), f.e.tbds182));
        this.bvC.As();
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
        this.bvC.dz(f.d.cp_cont_e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        if (aBr() && this.dLu != null) {
            gz(z);
            this.byo.setSelection(0);
            this.dLu.onRefresh();
            return;
        }
        gz(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq() {
        if (aBr() && this.dLu != null) {
            aBv();
            this.byo.stopScroll();
            this.dLu.aBR();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void W(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.dLp != null) {
            this.dLp.setData(arrayList);
            this.dLp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(e eVar) {
        if (eVar == null || w.y(eVar.aBC()) == 0) {
            if (this.dLr != null) {
                this.byo.removeHeaderView(this.dLr.getView());
                this.dLr = null;
                return;
            }
            return;
        }
        if (this.dLr == null) {
            this.dLr = new com.baidu.tieba.frs.worldcup.talkball.view.a(getPageContext(), this.byo);
            this.byo.addHeaderView(this.dLr.getView(), this.byo.getHeaderViewsCount());
        }
        this.dLr.b(eVar);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void a(AdidasAdvert adidasAdvert) {
        if (this.byo != null) {
            if (adidasAdvert == null || TextUtils.isEmpty(adidasAdvert.img_url)) {
                if (this.dLt != null) {
                    this.byo.removeHeaderView(this.dLt);
                    this.dLt = null;
                    return;
                }
                return;
            }
            if (this.dLt == null) {
                this.dLt = new AdidasBanner(getContext());
                this.byo.addHeaderView(this.dLt, this.byo.getHeaderViewsCount() < 1 ? 0 : 1);
            }
            this.dLt.setForumId(getForumId());
            this.dLt.am(adidasAdvert.img_url, adidasAdvert.ahead_url);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void bD(List<com.baidu.tieba.frs.worldcup.talkball.b.a> list) {
        if (this.byo != null) {
            if (w.z(list)) {
                if (this.dLs != null) {
                    this.byo.removeHeaderView(this.dLs);
                    this.dLs = null;
                    return;
                }
                return;
            }
            if (this.dLs == null) {
                this.dLs = new AutoBannerView(getContext());
                this.dLs.setOutOnCoverViewCallback(this.dLx);
                this.byo.addHeaderView(this.dLs, 0);
            }
            this.dLs.bE(list);
            this.dLs.AY();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void c(m mVar) {
        if (this.doe != null) {
            this.doe.a(mVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (this.dLr != null) {
                this.dLr.fA(isPrimary());
            }
            if (isPrimary()) {
                if (!this.dLv) {
                    init();
                }
                if (this.doe != null) {
                    this.doe.akJ();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public boolean d(d.a aVar) {
        if (aVar != null && aVar.isSuccess) {
            hideNetRefreshView(this.dLq);
            aBt();
            return true;
        }
        String string = TbadkCoreApplication.getInst().getString(f.j.error_unkown_try_again);
        if (aVar != null) {
            if (aVar.gKD) {
                string = TbadkCoreApplication.getInst().getString(f.j.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)});
            } else {
                string = aVar.errorMsg;
            }
        }
        aBu();
        showNetRefreshView(this.dLq, string, true);
        setNetRefreshViewEmotionDefMarginTop();
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        Ty();
        aBp();
    }

    private void aBt() {
        this.dLo.setVisibility(0);
    }

    private void aBu() {
        this.dLo.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.activity.a
    public void Ty() {
        gz(false);
        hideLoadingView(this.dLq);
        hideNetRefreshView(this.dLq);
        aBt();
    }

    private void gz(boolean z) {
        if (this.dLo != null) {
            this.dLo.setRefreshing(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921346, null));
            Ty();
            fn(true);
        }
    }

    private void aBv() {
        if (this.dLu == null || !l.jV()) {
            Uq();
        } else if (this.dLu.hasMore()) {
            if (this.byo.getCount() > 3) {
                Uo();
            } else {
                avw();
            }
        } else if (this.byo.getCount() == 0) {
            Uq();
        } else {
            Up();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
        if (this.dLp != null) {
            this.dLp.onDestory();
        }
        if (this.byo != null) {
            this.byo.setOnSrollToBottomListener(null);
            this.byo.setScrollable(null);
        }
        if (this.dLu != null) {
            this.dLu.onDestroy();
        }
        if (this.dLr != null) {
            this.dLr.onDestroy();
        }
        if (this.dLs != null) {
            this.dLs.AZ();
        }
        if (this.doe != null) {
            this.doe.onDestroy();
        }
    }

    public void Uo() {
        this.byo.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.setOnClickListener(null);
        this.bvC.Av();
    }

    public void Up() {
        this.byo.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.setOnClickListener(null);
        this.bvC.Aw();
        this.bvC.setText(getResources().getString(f.j.list_no_more));
    }

    public void avw() {
        this.byo.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TalkBallFragment.this.Tq();
            }
        });
        this.bvC.Aw();
        this.bvC.setText(getResources().getString(f.j.list_click_load_more));
    }

    public void Uq() {
        this.byo.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        kv(i);
        if (this.cSv != null) {
            this.cSv.onChangeSkinType(getPageContext(), i);
        }
        if (this.bvC != null) {
            this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
            this.bvC.dB(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.dLr != null) {
            this.dLr.onChangeSkinType(i);
        }
        if (this.dLs != null) {
            this.dLs.onChangeSkinType(i);
        }
        if (this.dLt != null) {
            this.dLt.onChangeSkinType(i);
        }
        if (this.dLp != null) {
            this.dLp.notifyDataSetChanged();
        }
        am.j(this.NV, f.d.cp_bg_line_d);
        am.j(this.dLo, f.d.cp_bg_line_e);
    }

    private void kv(int i) {
        if (this.dmt != null) {
            mg(i);
        } else {
            kw(i);
        }
    }

    private void kw(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(am.cU(f.C0146f.s_navbar_bg));
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            am.j(this.mNavigationBar.getBottomLine(), f.d.cp_bg_line_b);
        }
        int i2 = f.d.select_topbar_icon_color_tint;
        aq.zt().c(this.bOp, f.C0146f.icon_topbar_return_n_svg, i2);
        aq.zt().c(this.dBT, f.C0146f.icon_topbar_search_n_svg, i2);
        if (this.dnV != null) {
            this.dnV.jl(i2);
            this.dnV.onChangeSkinType(i);
        }
        if (this.dLn != null) {
            this.dLn.setBackgroundDrawable(new BitmapDrawable(am.cU(f.C0146f.s_navbar_bg)).mutate());
        }
    }

    private void mg(int i) {
        if (this.dmt != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(getPageContext(), i);
                am.c(this.mNavigationBar.mCenterText, f.d.cp_cont_i, 1);
                com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar.getBottomLine(), this.dmt);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, this.dmt);
            com.baidu.tieba.frs.worldcup.b.a(this.dLn, this.dmt);
            int i2 = f.d.select_topbar_icon_white_color_tint;
            aq.zt().c(this.bOp, f.C0146f.icon_topbar_return_n_svg, i2);
            aq.zt().c(this.dBT, f.C0146f.icon_topbar_search_n_svg, i2);
            if (this.dnV != null) {
                this.dnV.jl(i2);
                this.dnV.onChangeSkinType(i);
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
    public NavigationBar Vj() {
        return this.mNavigationBar;
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar.a
    public void b(Pair<Integer, Integer> pair) {
        this.dmt = pair;
    }

    public String getForumId() {
        return this.dLu != null ? this.dLu.getForumId() : "";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        kv(TbadkCoreApplication.getInst().getSkinType());
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }
}
