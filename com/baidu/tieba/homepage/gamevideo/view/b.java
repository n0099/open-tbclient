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
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView Xe;
    private PbListView gdy;
    private View gfU;
    private AlphaAnimation gfX;
    private AlphaAnimation gfY;
    private g gmB;
    private i iko;
    private com.baidu.tieba.f.a jcY;
    private BigdaySwipeRefreshLayout jpF;
    private com.baidu.tieba.homepage.personalize.bigday.a jpw;
    private NEGFeedBackView.a juC;
    private ImageView juV;
    private TextView juW;
    private com.baidu.tieba.homepage.gamevideo.a.a juX;
    private GameVideoTitleBar juY;
    private boolean juZ;
    private RotateAnimation jva;
    private RotateAnimation jvb;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean jvc = false;
    private boolean iEj = false;
    private int iDz = 0;
    private int gch = 0;
    private boolean mIsBackground = false;
    private boolean jvd = true;
    f.d jve = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cHM();
        }
    };
    f.b jvf = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.qM(true);
            if (b.this.iko != null && !b.this.mIsBackground && b.this.jvd) {
                b.this.iko.a(b.this.iDz, b.this.gch, b.this.iEj, true);
            }
        }
    };
    private CustomMessageListener esj = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.juX.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.jvd) {
                        b.this.iko.a(b.this.iDz, b.this.gch, b.this.iEj, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener ftj = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jcY != null) {
                b.this.jcY.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0705a iac = new a.InterfaceC0705a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void H(int i, int i2) {
            b.this.iEj = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void I(int i, int i2) {
            b.this.iEj = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void ce(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void J(int i, int i2) {
        }
    };
    private CustomMessageListener iDg = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cHN;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cHN = b.this.cHN()) != null && cHN.tW() != null) {
                    cHN.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iko != null) {
                    b.this.iko.cV(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).cmx().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Xe)) {
                    b.this.bMR();
                }
                if (i == 0 && b.this.iko != null && b.this.jvd) {
                    b.this.iko.a(b.this.iDz, b.this.gch, b.this.iEj, 1);
                    return;
                }
                return;
            }
            b.this.bMQ();
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
            cB(i3, (i4 - i3) + 1);
        }

        public void cB(int i, int i2) {
            b.this.iDz = i;
            b.this.gch = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.juC = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.juY = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.jcY = new com.baidu.tieba.f.a();
        this.iko = new i(this.mPageContext, this.Xe);
        this.iko.Hg(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iko.setUniqueId(this.mBdUniqueId);
        this.jpF = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jpw = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jpF.setProgressView(this.jpw);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jpF.setCustomDistances(i, i, i * 2);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize36);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.juX = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Xe);
        this.juX.b(this.juC);
        this.juX.setPageUniqueId(this.mBdUniqueId);
        this.gfU = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.juV = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.juW = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.juW.setText(com.baidu.tbadk.core.sharedPref.b.bnH().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bqd();
    }

    public void init() {
        this.Xe.addOnScrollListener(this.mScrollListener);
        this.Xe.setOnTouchListener(this.ftj);
        this.Xe.setRecyclerListener(this.mRecyclerListener);
        this.jcY.a(this.iac);
        this.jpw.a(this.jve);
        this.jpw.a(this.jvf);
        this.jpw.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.esj.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.esj);
        this.iDg.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iDg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jpF.setRefreshing(true);
    }

    public void cHK() {
        if (this.Xe != null) {
            this.Xe.setSelection(0);
            bMR();
        }
    }

    public void b(f.e eVar) {
        this.jpF.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bMQ() {
        if (!this.juZ) {
            this.juZ = true;
            this.gfU.setVisibility(0);
            if (this.gfX == null) {
                this.gfX = new AlphaAnimation(0.0f, 1.0f);
                this.gfX.setFillAfter(true);
                this.gfX.setDuration(300L);
            }
            this.gfU.startAnimation(this.gfX);
        }
    }

    public void bMR() {
        if (this.juZ) {
            if (this.gfY == null) {
                this.gfY = new AlphaAnimation(1.0f, 0.0f);
                this.gfY.setFillAfter(true);
                this.gfY.setDuration(300L);
                this.gfY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.gfU.setVisibility(8);
                        b.this.juZ = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gfU.startAnimation(this.gfY);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Xe != null) {
            this.Xe.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jpw != null) {
            this.jpw.setListPullRefreshListener(cVar);
        }
    }

    public void bb(List<q> list) {
        if (this.juX != null) {
            this.juX.setData(list);
        }
        cHL();
    }

    public void cHL() {
        if (this.iko != null && this.jvd) {
            this.iko.a(this.iDz, this.gch, this.iEj, true);
        }
    }

    public void cHM() {
        if (this.iko != null) {
            this.iko.cHM();
        }
    }

    public void qM(boolean z) {
        this.jvd = z;
    }

    public am cHN() {
        if (this.iko == null || this.iko.duu() == null || !(this.iko.duu().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iko.duu().getTag();
    }

    public List<q> getDataList() {
        if (this.juX != null) {
            return this.juX.getDataList();
        }
        return null;
    }

    public void cHO() {
        bb(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gmB == null) {
                this.gmB = new g(this.mPageContext.getPageActivity());
                this.gmB.byH();
                this.gmB.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gmB.onChangeSkinType();
            }
            this.gmB.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gmB == null) {
            return false;
        }
        return this.gmB.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rv(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.rt(R.drawable.new_pic_emotion_03);
        this.mRefreshView.DP(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.gdy.setOnClickListener(onClickListener);
            this.gdy.endLoadData();
        }
    }

    public void bMw() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.gdy.setOnClickListener(null);
            this.gdy.endLoadData();
        }
    }

    public void bMx() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gdy.setOnClickListener(null);
            this.gdy.startLoadData();
        }
    }

    public void Bq(int i) {
        if (this.juX != null) {
            this.juX.Bq(i);
        }
    }

    public void Lz() {
        if (this.juX != null) {
            this.juX.notifyDataSetChanged();
        }
    }

    public void bqd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.juV != null) {
            SvgManager.boN().a(this.juV, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gmB != null) {
            this.gmB.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gmB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.juW != null) {
            ap.setViewTextColor(this.juW, R.color.cp_cont_b);
        }
        if (this.jpw != null) {
            this.jpw.changeSkin(skinType);
        }
        if (this.juX != null) {
            this.juX.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        pw(false);
    }

    public void cGf() {
        pw(true);
    }

    public void pw(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iko != null) {
            this.iko.sO(!z);
            am cHN = cHN();
            if (cHN != null && cHN.tW() != null) {
                z2 = cHN.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iko.cHM();
                } else if (this.jvd) {
                    this.iko.a(this.iDz, this.gch, this.iEj, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.juX != null) {
            this.juX.onPause();
        }
    }

    public void onDestroy() {
        if (this.gmB != null) {
            this.gmB.release();
        }
        if (this.gfX != null) {
            this.gfX.cancel();
        }
        if (this.gfY != null) {
            this.gfY.cancel();
        }
        b((f.e) null);
        if (this.jpw != null) {
            this.jpw.release();
        }
        if (this.juX != null) {
            this.juX.onDestroy();
        }
        if (this.jva != null) {
            this.jva.cancel();
        }
        if (this.jvb != null) {
            this.jvb.cancel();
        }
        if (this.iko != null) {
            this.iko.destroy();
        }
        cHP();
        MessageManager.getInstance().unRegisterListener(this.iDg);
        MessageManager.getInstance().unRegisterListener(this.esj);
    }

    private void cHP() {
        if (this.Xe != null) {
            this.Xe.removeOnScrollListener(this.mScrollListener);
            this.Xe.setOnTouchListener(null);
            this.Xe.setRecyclerListener(null);
        }
        if (this.jcY != null) {
            this.jcY.a((a.InterfaceC0705a) null);
        }
        if (this.jpw != null) {
            this.jpw.a((f.d) null);
            this.jpw.a((f.b) null);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.juV != null) {
            this.juV.setOnClickListener(onClickListener);
        }
    }

    public View cHQ() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cHR() {
        if (this.jva == null) {
            this.jva = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.jva.setDuration(300L);
            this.jva.setInterpolator(new AccelerateInterpolator());
            this.jva.setFillAfter(true);
            this.jva.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.juV != null) {
                        SvgManager.boN().a(b.this.juV, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jvc = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.juV.startAnimation(this.jva);
    }

    public void cHS() {
        if (this.jvb == null) {
            this.jvb = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.jvb.setDuration(300L);
            this.jvb.setInterpolator(new AccelerateInterpolator());
            this.jvb.setFillAfter(true);
            this.jvb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.juV != null) {
                        SvgManager.boN().a(b.this.juV, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jvc = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.juV.startAnimation(this.jvb);
    }

    public boolean cHT() {
        return this.jvc;
    }

    public void qN(boolean z) {
        this.jvc = z;
    }

    public void qO(boolean z) {
        if (this.juV != null) {
            this.juV.setVisibility(0);
            if (z) {
                SvgManager.boN().a(this.juV, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.juY, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.boN().a(this.juV, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.juY, R.color.cp_bg_line_h);
        }
    }

    public void cHU() {
        if (this.juW != null) {
            this.juW.setVisibility(0);
        }
    }

    public void Lv(String str) {
        if (!StringUtils.isNull(str) && this.juW != null) {
            this.juW.setVisibility(0);
            this.juW.setText(str);
        }
    }

    public void Lw(String str) {
        List<Integer> b = b(str, this.Xe);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Xe.o(intValue, intValue2);
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
                    if (cVar.bhz() != null && cVar.bhz().getTid().equals(str)) {
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
