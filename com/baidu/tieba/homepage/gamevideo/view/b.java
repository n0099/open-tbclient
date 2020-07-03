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
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;
    private View fpG;
    private AlphaAnimation fpJ;
    private AlphaAnimation fpK;
    private g fwo;
    private m hjm;
    private com.baidu.tieba.f.a iac;
    private com.baidu.tieba.homepage.personalize.bigday.a ilY;
    private BigdaySwipeRefreshLayout imi;
    private NEGFeedBackView.a iqa;
    private ImageView iqt;
    private TextView iqu;
    private com.baidu.tieba.homepage.gamevideo.a.a iqv;
    private GameVideoTitleBar iqw;
    private boolean iqx;
    private RotateAnimation iqy;
    private RotateAnimation iqz;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean iqA = false;
    private boolean hCs = false;
    private int hBI = 0;
    private int fmb = 0;
    private boolean mIsBackground = false;
    private boolean iqB = true;
    f.d iqC = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cje();
        }
    };
    f.b iqD = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.ou(true);
            if (b.this.hjm != null && !b.this.mIsBackground && b.this.iqB) {
                b.this.hjm.a(b.this.hBI, b.this.fmb, b.this.hCs, true);
            }
        }
    };
    private CustomMessageListener dGa = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.iqv.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.iqB) {
                        b.this.hjm.a(b.this.hBI, b.this.fmb, b.this.hCs, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener eEC = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.iac != null) {
                b.this.iac.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0614a gZb = new a.InterfaceC0614a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void D(int i, int i2) {
            b.this.hCs = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void E(int i, int i2) {
            b.this.hCs = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void bO(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0614a
        public void F(int i, int i2) {
        }
    };
    private CustomMessageListener hBs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak cjf;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cjf = b.this.cjf()) != null && cjf.se() != null) {
                    cjf.se().b(new a.C0098a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.hjm != null) {
                    b.this.hjm.cu(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bPg().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Wa)) {
                    b.this.bud();
                }
                if (i == 0 && b.this.hjm != null && b.this.iqB) {
                    b.this.hjm.a(b.this.hBI, b.this.fmb, b.this.hCs, 1);
                    return;
                }
                return;
            }
            b.this.buc();
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
            cl(i3, (i4 - i3) + 1);
        }

        public void cl(int i, int i2) {
            b.this.hBI = i;
            b.this.fmb = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iqa = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iqw = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Wa = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.iac = new com.baidu.tieba.f.a();
        this.hjm = new m(this.mPageContext, this.Wa);
        this.hjm.CM(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hjm.setUniqueId(this.mBdUniqueId);
        this.imi = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.ilY = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.imi.setProgressView(this.ilY);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.imi.setCustomDistances(i, i, i * 2);
        this.fnt = new PbListView(this.mPageContext.getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize36);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iqv = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Wa);
        this.iqv.b(this.iqa);
        this.iqv.setPageUniqueId(this.mBdUniqueId);
        this.fpG = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.iqt = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.iqu = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.iqu.setText(com.baidu.tbadk.core.sharedPref.b.aVP().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aYj();
    }

    public void init() {
        this.Wa.addOnScrollListener(this.mScrollListener);
        this.Wa.setOnTouchListener(this.eEC);
        this.Wa.setRecyclerListener(this.mRecyclerListener);
        this.iac.a(this.gZb);
        this.ilY.a(this.iqC);
        this.ilY.a(this.iqD);
        this.ilY.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dGa.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dGa);
        this.hBs.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hBs);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.imi.setRefreshing(true);
    }

    public void cjc() {
        if (this.Wa != null) {
            this.Wa.setSelection(0);
            bud();
        }
    }

    public void b(f.e eVar) {
        this.imi.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void buc() {
        if (!this.iqx) {
            this.iqx = true;
            this.fpG.setVisibility(0);
            if (this.fpJ == null) {
                this.fpJ = new AlphaAnimation(0.0f, 1.0f);
                this.fpJ.setFillAfter(true);
                this.fpJ.setDuration(300L);
            }
            this.fpG.startAnimation(this.fpJ);
        }
    }

    public void bud() {
        if (this.iqx) {
            if (this.fpK == null) {
                this.fpK = new AlphaAnimation(1.0f, 0.0f);
                this.fpK.setFillAfter(true);
                this.fpK.setDuration(300L);
                this.fpK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.fpG.setVisibility(8);
                        b.this.iqx = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fpG.startAnimation(this.fpK);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Wa != null) {
            this.Wa.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.ilY != null) {
            this.ilY.setListPullRefreshListener(cVar);
        }
    }

    public void aD(List<q> list) {
        if (this.iqv != null) {
            this.iqv.setData(list);
        }
        cjd();
    }

    public void cjd() {
        if (this.hjm != null && this.iqB) {
            this.hjm.a(this.hBI, this.fmb, this.hCs, true);
        }
    }

    public void cje() {
        if (this.hjm != null) {
            this.hjm.cje();
        }
    }

    public void ou(boolean z) {
        this.iqB = z;
    }

    public ak cjf() {
        if (this.hjm == null || this.hjm.cVl() == null || !(this.hjm.cVl().getTag() instanceof ak)) {
            return null;
        }
        return (ak) this.hjm.cVl().getTag();
    }

    public List<q> getDataList() {
        if (this.iqv != null) {
            return this.iqv.getDataList();
        }
        return null;
    }

    public void cjg() {
        aD(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fwo == null) {
                this.fwo = new g(this.mPageContext.getPageActivity());
                this.fwo.bgC();
                this.fwo.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.fwo.onChangeSkinType();
            }
            this.fwo.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fwo == null) {
            return false;
        }
        return this.fwo.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nQ(R.drawable.new_pic_emotion_08);
        this.mRefreshView.nS(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.nQ(R.drawable.new_pic_emotion_03);
        this.mRefreshView.yQ(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void btN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.fnt.setOnClickListener(onClickListener);
            this.fnt.endLoadData();
        }
    }

    public void btI() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.fnt.setOnClickListener(null);
            this.fnt.endLoadData();
        }
    }

    public void btJ() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fnt.setOnClickListener(null);
            this.fnt.startLoadData();
        }
    }

    public void xe(int i) {
        if (this.iqv != null) {
            this.iqv.xe(i);
        }
    }

    public void DA() {
        if (this.iqv != null) {
            this.iqv.notifyDataSetChanged();
        }
    }

    public void aYj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.iqt != null) {
            SvgManager.aWQ().a(this.iqt, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.fwo != null) {
            this.fwo.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fwo.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.iqu != null) {
            an.setViewTextColor(this.iqu, (int) R.color.cp_cont_b);
        }
        if (this.ilY != null) {
            this.ilY.changeSkin(skinType);
        }
        if (this.iqv != null) {
            this.iqv.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        ni(false);
    }

    public void chX() {
        ni(true);
    }

    public void ni(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hjm != null) {
            this.hjm.qs(!z);
            ak cjf = cjf();
            if (cjf != null && cjf.se() != null) {
                z2 = cjf.se().b(new a.C0098a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hjm.cje();
                } else if (this.iqB) {
                    this.hjm.a(this.hBI, this.fmb, this.hCs, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.iqv != null) {
            this.iqv.onPause();
        }
    }

    public void onDestroy() {
        if (this.fwo != null) {
            this.fwo.release();
        }
        if (this.fpJ != null) {
            this.fpJ.cancel();
        }
        if (this.fpK != null) {
            this.fpK.cancel();
        }
        b((f.e) null);
        if (this.ilY != null) {
            this.ilY.release();
        }
        if (this.iqv != null) {
            this.iqv.onDestroy();
        }
        if (this.iqy != null) {
            this.iqy.cancel();
        }
        if (this.iqz != null) {
            this.iqz.cancel();
        }
        if (this.hjm != null) {
            this.hjm.destroy();
        }
        cjh();
        MessageManager.getInstance().unRegisterListener(this.hBs);
        MessageManager.getInstance().unRegisterListener(this.dGa);
    }

    private void cjh() {
        if (this.Wa != null) {
            this.Wa.removeOnScrollListener(this.mScrollListener);
            this.Wa.setOnTouchListener(null);
            this.Wa.setRecyclerListener(null);
        }
        if (this.iac != null) {
            this.iac.a((a.InterfaceC0614a) null);
        }
        if (this.ilY != null) {
            this.ilY.a((f.d) null);
            this.ilY.a((f.b) null);
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.iqt != null) {
            this.iqt.setOnClickListener(onClickListener);
        }
    }

    public View cji() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cjj() {
        if (this.iqy == null) {
            this.iqy = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.iqy.setDuration(300L);
            this.iqy.setInterpolator(new AccelerateInterpolator());
            this.iqy.setFillAfter(true);
            this.iqy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iqt != null) {
                        SvgManager.aWQ().a(b.this.iqt, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iqA = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iqt.startAnimation(this.iqy);
    }

    public void cjk() {
        if (this.iqz == null) {
            this.iqz = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.iqz.setDuration(300L);
            this.iqz.setInterpolator(new AccelerateInterpolator());
            this.iqz.setFillAfter(true);
            this.iqz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iqt != null) {
                        SvgManager.aWQ().a(b.this.iqt, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iqA = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iqt.startAnimation(this.iqz);
    }

    public boolean cjl() {
        return this.iqA;
    }

    public void ov(boolean z) {
        this.iqA = z;
    }

    public void ow(boolean z) {
        if (this.iqt != null) {
            this.iqt.setVisibility(0);
            if (z) {
                SvgManager.aWQ().a(this.iqt, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                an.setBackgroundResource(this.iqw, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aWQ().a(this.iqt, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            an.setBackgroundResource(this.iqw, R.color.cp_bg_line_h);
        }
    }

    public void cjm() {
        if (this.iqu != null) {
            this.iqu.setVisibility(0);
        }
    }

    public void Gd(String str) {
        if (!StringUtils.isNull(str) && this.iqu != null) {
            this.iqu.setVisibility(0);
            this.iqu.setText(str);
        }
    }

    public void Ge(String str) {
        List<Integer> b = b(str, this.Wa);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Wa.m(intValue, intValue2);
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
                q item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.aPS() != null && cVar.aPS().getTid().equals(str)) {
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
