package com.baidu.tieba.homepage.gamevideo.view;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.adp.widget.ListView.n;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BdTypeRecyclerView Zq;
    private PbListView gCf;
    private View gEA;
    private AlphaAnimation gED;
    private AlphaAnimation gEE;
    private g gLk;
    private i iRf;
    private com.baidu.tieba.f.a jMD;
    private com.baidu.tieba.homepage.personalize.bigday.a kcg;
    private BigdaySwipeRefreshLayout kcp;
    private NEGFeedBackView.a khA;
    private ImageView khT;
    private TextView khU;
    private com.baidu.tieba.homepage.gamevideo.a.a khV;
    private GameVideoTitleBar khW;
    private boolean khX;
    private RotateAnimation khY;
    private RotateAnimation khZ;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean kia = false;
    private boolean jkX = false;
    private int jkn = 0;
    private int gAO = 0;
    private boolean mIsBackground = false;
    private boolean kib = true;
    f.d kic = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cQI();
        }
    };
    f.b kie = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.se(true);
            if (b.this.iRf != null && !b.this.mIsBackground && b.this.kib) {
                b.this.iRf.b(b.this.jkn, b.this.gAO, b.this.jkX, true);
            }
        }
    };
    private CustomMessageListener eMc = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.khV.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.kib) {
                        b.this.iRf.b(b.this.jkn, b.this.gAO, b.this.jkX, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jMD != null) {
                b.this.jMD.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0717a iHb = new a.InterfaceC0717a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void G(int i, int i2) {
            b.this.jkX = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void H(int i, int i2) {
            b.this.jkX = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0717a
        public void I(int i, int i2) {
        }
    };
    private CustomMessageListener jjU = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cQJ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cQJ = b.this.cQJ()) != null && cQJ.tj() != null) {
                    cQJ.tj().b(new a.C0095a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iRf != null) {
                    b.this.iRf.dt(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).cto().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.c(b.this.Zq)) {
                    b.this.bRX();
                }
                if (i == 0 && b.this.iRf != null && b.this.kib) {
                    b.this.iRf.a(b.this.jkn, b.this.gAO, b.this.jkX, 1);
                    return;
                }
                return;
            }
            b.this.bRW();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
                i4 = 0;
            } else {
                int firstVisiblePosition = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i3 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
                i4 = firstVisiblePosition;
            }
            cD(i4, (i3 - i4) + 1);
        }

        public void cD(int i, int i2) {
            b.this.jkn = i;
            b.this.gAO = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.khA = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.khW = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Zq = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Zq.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Zq.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jMD = new com.baidu.tieba.f.a();
        this.iRf = new i(this.mPageContext, this.Zq);
        this.iRf.Hq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iRf.setUniqueId(this.mBdUniqueId);
        this.kcp = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.kcg = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.kcp.setProgressView(this.kcg);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.kcp.setCustomDistances(i, i, i * 2);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize36);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.khV = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Zq);
        this.khV.b(this.khA);
        this.khV.setPageUniqueId(this.mBdUniqueId);
        this.gEA = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.khT = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.khU = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.khU.setText(com.baidu.tbadk.core.sharedPref.b.brR().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bus();
    }

    public void init() {
        this.Zq.addOnScrollListener(this.mScrollListener);
        this.Zq.setOnTouchListener(this.bUt);
        this.Zq.setRecyclerListener(this.mRecyclerListener);
        this.jMD.a(this.iHb);
        this.kcg.a(this.kic);
        this.kcg.a(this.kie);
        this.kcg.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eMc.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eMc);
        this.jjU.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jjU);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.kcp.setRefreshing(true);
    }

    public void cQG() {
        if (this.Zq != null) {
            this.Zq.setSelection(0);
            bRX();
        }
    }

    public void b(f.e eVar) {
        this.kcp.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bRW() {
        if (!this.khX) {
            this.khX = true;
            this.gEA.setVisibility(0);
            if (this.gED == null) {
                this.gED = new AlphaAnimation(0.0f, 1.0f);
                this.gED.setFillAfter(true);
                this.gED.setDuration(300L);
            }
            this.gEA.startAnimation(this.gED);
        }
    }

    public void bRX() {
        if (this.khX) {
            if (this.gEE == null) {
                this.gEE = new AlphaAnimation(1.0f, 0.0f);
                this.gEE.setFillAfter(true);
                this.gEE.setDuration(300L);
                this.gEE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.gEA.setVisibility(8);
                        b.this.khX = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gEA.startAnimation(this.gEE);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Zq != null) {
            this.Zq.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.kcg != null) {
            this.kcg.setListPullRefreshListener(cVar);
        }
    }

    public void bn(List<n> list) {
        if (this.khV != null) {
            this.khV.setData(list);
        }
        cQH();
    }

    public void cQH() {
        if (this.iRf != null && this.kib) {
            this.iRf.b(this.jkn, this.gAO, this.jkX, true);
        }
    }

    public void cQI() {
        if (this.iRf != null) {
            this.iRf.cQI();
        }
    }

    public void se(boolean z) {
        this.kib = z;
    }

    public ThreadCardViewHolder cQJ() {
        if (this.iRf == null || this.iRf.dAk() == null || !(this.iRf.dAk().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iRf.dAk().getTag();
    }

    public List<n> getDataList() {
        if (this.khV != null) {
            return this.khV.getDataList();
        }
        return null;
    }

    public void cQK() {
        bn(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gLk == null) {
                this.gLk = new g(this.mPageContext.getPageActivity());
                this.gLk.bCV();
                this.gLk.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gLk.onChangeSkinType();
            }
            this.gLk.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gLk == null) {
            return false;
        }
        return this.gLk.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.mRootView);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.ro(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rq(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.ro(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Dr(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Zq.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.gCf.setOnClickListener(onClickListener);
            this.gCf.endLoadData();
        }
    }

    public void bRD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Zq.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.gCf.setOnClickListener(null);
            this.gCf.endLoadData();
        }
    }

    public void bRE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Zq.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gCf.setOnClickListener(null);
            this.gCf.startLoadData();
        }
    }

    public void BQ(int i) {
        if (this.khV != null) {
            this.khV.BQ(i);
        }
    }

    public void KA() {
        if (this.khV != null) {
            this.khV.notifyDataSetChanged();
        }
    }

    public void bus() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.khT != null) {
            SvgManager.bsU().a(this.khT, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gLk != null) {
            this.gLk.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gLk.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.khU != null) {
            ap.setViewTextColor(this.khU, R.color.CAM_X0105);
        }
        if (this.kcg != null) {
            this.kcg.changeSkin(skinType);
        }
        if (this.khV != null) {
            this.khV.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        qJ(false);
    }

    public void cPb() {
        qJ(true);
    }

    public void qJ(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iRf != null) {
            this.iRf.tN(!z);
            ThreadCardViewHolder cQJ = cQJ();
            if (cQJ != null && cQJ.tj() != null) {
                z2 = cQJ.tj().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iRf.cQI();
                } else if (this.kib) {
                    this.iRf.b(this.jkn, this.gAO, this.jkX, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.khV != null) {
            this.khV.onPause();
        }
    }

    public void onDestroy() {
        if (this.gLk != null) {
            this.gLk.release();
        }
        if (this.gED != null) {
            this.gED.cancel();
        }
        if (this.gEE != null) {
            this.gEE.cancel();
        }
        b((f.e) null);
        if (this.kcg != null) {
            this.kcg.release();
        }
        if (this.khV != null) {
            this.khV.onDestroy();
        }
        if (this.khY != null) {
            this.khY.cancel();
        }
        if (this.khZ != null) {
            this.khZ.cancel();
        }
        if (this.iRf != null) {
            this.iRf.destroy();
        }
        cQL();
        MessageManager.getInstance().unRegisterListener(this.jjU);
        MessageManager.getInstance().unRegisterListener(this.eMc);
    }

    private void cQL() {
        if (this.Zq != null) {
            this.Zq.removeOnScrollListener(this.mScrollListener);
            this.Zq.setOnTouchListener(null);
            this.Zq.setRecyclerListener(null);
        }
        if (this.jMD != null) {
            this.jMD.a((a.InterfaceC0717a) null);
        }
        if (this.kcg != null) {
            this.kcg.a((f.d) null);
            this.kcg.a((f.b) null);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.khT != null) {
            this.khT.setOnClickListener(onClickListener);
        }
    }

    public View cQM() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cQN() {
        if (this.khY == null) {
            this.khY = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.khY.setDuration(300L);
            this.khY.setInterpolator(new AccelerateInterpolator());
            this.khY.setFillAfter(true);
            this.khY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.khT != null) {
                        SvgManager.bsU().a(b.this.khT, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.kia = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.khT.startAnimation(this.khY);
    }

    public void cQO() {
        if (this.khZ == null) {
            this.khZ = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.khZ.setDuration(300L);
            this.khZ.setInterpolator(new AccelerateInterpolator());
            this.khZ.setFillAfter(true);
            this.khZ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.khT != null) {
                        SvgManager.bsU().a(b.this.khT, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.kia = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.khT.startAnimation(this.khZ);
    }

    public boolean cQP() {
        return this.kia;
    }

    public void sf(boolean z) {
        this.kia = z;
    }

    public void sg(boolean z) {
        if (this.khT != null) {
            this.khT.setVisibility(0);
            if (z) {
                SvgManager.bsU().a(this.khT, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.khW, R.color.CAM_X0201);
                return;
            }
            SvgManager.bsU().a(this.khT, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.khW, R.color.CAM_X0207);
        }
    }

    public void cQQ() {
        if (this.khU != null) {
            this.khU.setVisibility(0);
        }
    }

    public void Md(String str) {
        if (!StringUtils.isNull(str) && this.khU != null) {
            this.khU.setVisibility(0);
            this.khU.setText(str);
        }
    }

    public void Me(String str) {
        List<Integer> b = b(str, this.Zq);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Zq.p(intValue, intValue2);
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = -1;
        ArrayList arrayList = new ArrayList(2);
        int i2 = 0;
        boolean z = false;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i2 < bdTypeRecyclerView.getCount()) {
                n item = bdTypeRecyclerView.getItem(i2);
                if (item instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
                    if (bVar.blp() != null && bVar.blp().getTid().equals(str)) {
                        if (!z) {
                            i4 = i2;
                        }
                        z = true;
                        i3 = i2;
                    }
                }
                i = i4;
                i2++;
            } else {
                arrayList.add(Integer.valueOf(i4));
                arrayList.add(Integer.valueOf(i3));
                return arrayList;
            }
        }
    }
}
