package com.baidu.tieba.homepage.gamevideo.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.a.f;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView Vi;
    private PbListView ePr;
    private View eRC;
    private AlphaAnimation eRF;
    private AlphaAnimation eRG;
    private g eYg;
    private m gHB;
    private com.baidu.tieba.homepage.personalize.bigday.a hId;
    private BigdaySwipeRefreshLayout hIm;
    private ImageView hMI;
    private TextView hMJ;
    private com.baidu.tieba.homepage.gamevideo.a.a hMK;
    private GameVideoTitleBar hML;
    private boolean hMM;
    private RotateAnimation hMN;
    private RotateAnimation hMO;
    private NEGFeedBackView.a hMp;
    private com.baidu.tieba.f.a hxq;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean hMP = false;
    private boolean haL = false;
    private int hac = 0;
    private int eNZ = 0;
    private boolean mIsBackground = false;
    private boolean hMQ = true;
    g.d hMR = new g.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            b.this.bZd();
        }
    };
    g.b hMS = new g.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.nN(true);
            if (b.this.gHB != null && !b.this.mIsBackground && b.this.hMQ) {
                b.this.gHB.a(b.this.hac, b.this.eNZ, b.this.haL, true);
            }
        }
    };
    private CustomMessageListener dlH = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.hMK.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.hMQ) {
                        b.this.gHB.a(b.this.hac, b.this.eNZ, b.this.haL, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener dSb = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.hxq != null) {
                b.this.hxq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0557a gxj = new a.InterfaceC0557a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void y(int i, int i2) {
            b.this.haL = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void z(int i, int i2) {
            b.this.haL = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void A(int i, int i2) {
        }
    };
    private CustomMessageListener gZT = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bZe;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bZe = b.this.bZe()) != null && bZe.rD() != null) {
                    bZe.rD().b(new a.C0095a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.gHB != null) {
                    b.this.gHB.ct(view);
                }
                if (view.getTag() instanceof f) {
                    ((f) view.getTag()).bFz().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Vi)) {
                    b.this.blH();
                }
                if (i == 0 && b.this.gHB != null && b.this.hMQ) {
                    b.this.gHB.a(b.this.hac, b.this.eNZ, b.this.haL, 1);
                    return;
                }
                return;
            }
            b.this.blG();
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4 = 0;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
            } else {
                i3 = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i4 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            ca(i3, (i4 - i3) + 1);
        }

        public void ca(int i, int i2) {
            b.this.hac = i;
            b.this.eNZ = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hMp = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hML = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Vi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Vi.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hxq = new com.baidu.tieba.f.a();
        this.gHB = new m(this.mPageContext, this.Vi);
        this.gHB.AY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gHB.setUniqueId(this.mBdUniqueId);
        this.hIm = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.hId = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.hIm.setProgressView(this.hId);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.hIm.setCustomDistances(i, i, i * 2);
        this.ePr = new PbListView(this.mPageContext.getPageActivity());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize36);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hMK = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Vi);
        this.hMK.b(this.hMp);
        this.hMK.setPageUniqueId(this.mBdUniqueId);
        this.eRC = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.hMI = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.hMJ = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.hMJ.setText(com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aQm();
    }

    public void init() {
        this.Vi.addOnScrollListener(this.mScrollListener);
        this.Vi.setOnTouchListener(this.dSb);
        this.Vi.setRecyclerListener(this.mRecyclerListener);
        this.hxq.a(this.gxj);
        this.hId.a(this.hMR);
        this.hId.a(this.hMS);
        this.hId.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dlH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dlH);
        this.gZT.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gZT);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.hIm.setRefreshing(true);
    }

    public void bZb() {
        if (this.Vi != null) {
            this.Vi.setSelection(0);
            blH();
        }
    }

    public void b(g.e eVar) {
        this.hIm.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void blG() {
        if (!this.hMM) {
            this.hMM = true;
            this.eRC.setVisibility(0);
            if (this.eRF == null) {
                this.eRF = new AlphaAnimation(0.0f, 1.0f);
                this.eRF.setFillAfter(true);
                this.eRF.setDuration(300L);
            }
            this.eRC.startAnimation(this.eRF);
        }
    }

    public void blH() {
        if (this.hMM) {
            if (this.eRG == null) {
                this.eRG = new AlphaAnimation(1.0f, 0.0f);
                this.eRG.setFillAfter(true);
                this.eRG.setDuration(300L);
                this.eRG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.eRC.setVisibility(8);
                        b.this.hMM = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eRC.startAnimation(this.eRG);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Vi != null) {
            this.Vi.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.hId != null) {
            this.hId.setListPullRefreshListener(cVar);
        }
    }

    public void aE(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hMK != null) {
            this.hMK.setData(list);
        }
        bZc();
    }

    public void bZc() {
        if (this.gHB != null && this.hMQ) {
            this.gHB.a(this.hac, this.eNZ, this.haL, true);
        }
    }

    public void bZd() {
        if (this.gHB != null) {
            this.gHB.bZd();
        }
    }

    public void nN(boolean z) {
        this.hMQ = z;
    }

    public af bZe() {
        if (this.gHB == null || this.gHB.cJE() == null || !(this.gHB.cJE().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gHB.cJE().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.hMK != null) {
            return this.hMK.getDataList();
        }
        return null;
    }

    public void bZf() {
        aE(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.eYg == null) {
                this.eYg = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.eYg.aYn();
                this.eYg.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.eYg.onChangeSkinType();
            }
            this.eYg.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.eYg == null) {
            return false;
        }
        return this.eYg.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mT(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mR(R.drawable.new_pic_emotion_03);
        this.mRefreshView.wR(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void blr() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Vi.setNextPage(this.ePr);
            }
            this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.ePr.setOnClickListener(onClickListener);
            this.ePr.endLoadData();
        }
    }

    public void bln() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Vi.setNextPage(this.ePr);
            }
            this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.ePr.setOnClickListener(null);
            this.ePr.endLoadData();
        }
    }

    public void blo() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Vi.setNextPage(this.ePr);
            }
            this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.ePr.setOnClickListener(null);
            this.ePr.startLoadData();
        }
    }

    public void vQ(int i) {
        if (this.hMK != null) {
            this.hMK.vQ(i);
        }
    }

    public void BC() {
        if (this.hMK != null) {
            this.hMK.notifyDataSetChanged();
        }
    }

    public void aQm() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.hMI != null) {
            SvgManager.aOR().a(this.hMI, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.eYg != null) {
            this.eYg.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eYg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hMJ != null) {
            am.setViewTextColor(this.hMJ, (int) R.color.cp_cont_b);
        }
        if (this.hId != null) {
            this.hId.changeSkin(skinType);
        }
        if (this.hMK != null) {
            this.hMK.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        mC(false);
    }

    public void bXT() {
        mC(true);
    }

    public void mC(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gHB != null) {
            this.gHB.pL(!z);
            af bZe = bZe();
            if (bZe != null && bZe.rD() != null) {
                z2 = bZe.rD().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gHB.bZd();
                } else if (this.hMQ) {
                    this.gHB.a(this.hac, this.eNZ, this.haL, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.hMK != null) {
            this.hMK.onPause();
        }
    }

    public void onDestroy() {
        if (this.eYg != null) {
            this.eYg.release();
        }
        if (this.eRF != null) {
            this.eRF.cancel();
        }
        if (this.eRG != null) {
            this.eRG.cancel();
        }
        b((g.e) null);
        if (this.hId != null) {
            this.hId.release();
        }
        if (this.hMK != null) {
            this.hMK.onDestroy();
        }
        if (this.hMN != null) {
            this.hMN.cancel();
        }
        if (this.hMO != null) {
            this.hMO.cancel();
        }
        if (this.gHB != null) {
            this.gHB.destroy();
        }
        bZg();
        MessageManager.getInstance().unRegisterListener(this.gZT);
        MessageManager.getInstance().unRegisterListener(this.dlH);
    }

    private void bZg() {
        if (this.Vi != null) {
            this.Vi.removeOnScrollListener(this.mScrollListener);
            this.Vi.setOnTouchListener(null);
            this.Vi.setRecyclerListener(null);
        }
        if (this.hxq != null) {
            this.hxq.a((a.InterfaceC0557a) null);
        }
        if (this.hId != null) {
            this.hId.a((g.d) null);
            this.hId.a((g.b) null);
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.hMI != null) {
            this.hMI.setOnClickListener(onClickListener);
        }
    }

    public View bZh() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bZi() {
        if (this.hMN == null) {
            this.hMN = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.hMN.setDuration(300L);
            this.hMN.setInterpolator(new AccelerateInterpolator());
            this.hMN.setFillAfter(true);
            this.hMN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hMI != null) {
                        SvgManager.aOR().a(b.this.hMI, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hMP = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hMI.startAnimation(this.hMN);
    }

    public void bZj() {
        if (this.hMO == null) {
            this.hMO = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.hMO.setDuration(300L);
            this.hMO.setInterpolator(new AccelerateInterpolator());
            this.hMO.setFillAfter(true);
            this.hMO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hMI != null) {
                        SvgManager.aOR().a(b.this.hMI, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hMP = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hMI.startAnimation(this.hMO);
    }

    public boolean bZk() {
        return this.hMP;
    }

    public void nO(boolean z) {
        this.hMP = z;
    }

    public void nP(boolean z) {
        if (this.hMI != null) {
            this.hMI.setVisibility(0);
            if (z) {
                SvgManager.aOR().a(this.hMI, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.hML, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aOR().a(this.hMI, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.hML, R.color.cp_bg_line_h);
        }
    }

    public void bZl() {
        if (this.hMJ != null) {
            this.hMJ.setVisibility(0);
        }
    }

    public void DT(String str) {
        if (!StringUtils.isNull(str) && this.hMJ != null) {
            this.hMJ.setVisibility(0);
            this.hMJ.setText(str);
        }
    }

    public void DU(String str) {
        List<Integer> b = b(str, this.Vi);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Vi.l(intValue, intValue2);
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i4 < bdTypeRecyclerView.getCount()) {
                com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.aIu() != null && cVar.aIu().getTid().equals(str)) {
                        if (!z) {
                            i3 = i4;
                        }
                        z = true;
                        i2 = i4;
                    }
                }
                i = i4 + 1;
            } else {
                arrayList.add(Integer.valueOf(i3));
                arrayList.add(Integer.valueOf(i2));
                return arrayList;
            }
        }
    }
}
