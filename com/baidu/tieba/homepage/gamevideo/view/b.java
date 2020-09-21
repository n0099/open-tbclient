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
/* loaded from: classes21.dex */
public class b {
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private AlphaAnimation fJC;
    private AlphaAnimation fJD;
    private View fJz;
    private g fQf;
    private i hIT;
    private com.baidu.tieba.f.a iBM;
    private com.baidu.tieba.homepage.personalize.bigday.a iOi;
    private BigdaySwipeRefreshLayout iOr;
    private ImageView iTA;
    private TextView iTB;
    private com.baidu.tieba.homepage.gamevideo.a.a iTC;
    private GameVideoTitleBar iTD;
    private boolean iTE;
    private RotateAnimation iTF;
    private RotateAnimation iTG;
    private NEGFeedBackView.a iTh;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean iTH = false;
    private boolean icM = false;
    private int icc = 0;
    private int fFV = 0;
    private boolean mIsBackground = false;
    private boolean iTI = true;
    f.d iTJ = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cAY();
        }
    };
    f.b iTK = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.pO(true);
            if (b.this.hIT != null && !b.this.mIsBackground && b.this.iTI) {
                b.this.hIT.a(b.this.icc, b.this.fFV, b.this.icM, true);
            }
        }
    };
    private CustomMessageListener dXI = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.iTC.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.iTI) {
                        b.this.hIT.a(b.this.icc, b.this.fFV, b.this.icM, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener eYy = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.iBM != null) {
                b.this.iBM.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0671a hyK = new a.InterfaceC0671a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void H(int i, int i2) {
            b.this.icM = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void I(int i, int i2) {
            b.this.icM = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0671a
        public void J(int i, int i2) {
        }
    };
    private CustomMessageListener ibJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cAZ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cAZ = b.this.cAZ()) != null && cAZ.tW() != null) {
                    cAZ.tW().b(new a.C0096a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.hIT != null) {
                    b.this.hIT.cN(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).cfU().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.WM)) {
                    b.this.bHD();
                }
                if (i == 0 && b.this.hIT != null && b.this.iTI) {
                    b.this.hIT.a(b.this.icc, b.this.fFV, b.this.icM, 1);
                    return;
                }
                return;
            }
            b.this.bHC();
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
            cz(i3, (i4 - i3) + 1);
        }

        public void cz(int i, int i2) {
            b.this.icc = i;
            b.this.fFV = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iTh = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iTD = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.WM = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.WM.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.iBM = new com.baidu.tieba.f.a();
        this.hIT = new i(this.mPageContext, this.WM);
        this.hIT.Gh(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hIT.setUniqueId(this.mBdUniqueId);
        this.iOr = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.iOi = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.iOr.setProgressView(this.iOi);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.iOr.setCustomDistances(i, i, i * 2);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize36);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iTC = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.WM);
        this.iTC.b(this.iTh);
        this.iTC.setPageUniqueId(this.mBdUniqueId);
        this.fJz = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.iTA = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.iTB = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.iTB.setText(com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        blA();
    }

    public void init() {
        this.WM.addOnScrollListener(this.mScrollListener);
        this.WM.setOnTouchListener(this.eYy);
        this.WM.setRecyclerListener(this.mRecyclerListener);
        this.iBM.a(this.hyK);
        this.iOi.a(this.iTJ);
        this.iOi.a(this.iTK);
        this.iOi.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dXI.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dXI);
        this.ibJ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ibJ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.iOr.setRefreshing(true);
    }

    public void cAW() {
        if (this.WM != null) {
            this.WM.setSelection(0);
            bHD();
        }
    }

    public void b(f.e eVar) {
        this.iOr.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bHC() {
        if (!this.iTE) {
            this.iTE = true;
            this.fJz.setVisibility(0);
            if (this.fJC == null) {
                this.fJC = new AlphaAnimation(0.0f, 1.0f);
                this.fJC.setFillAfter(true);
                this.fJC.setDuration(300L);
            }
            this.fJz.startAnimation(this.fJC);
        }
    }

    public void bHD() {
        if (this.iTE) {
            if (this.fJD == null) {
                this.fJD = new AlphaAnimation(1.0f, 0.0f);
                this.fJD.setFillAfter(true);
                this.fJD.setDuration(300L);
                this.fJD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.fJz.setVisibility(8);
                        b.this.iTE = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fJz.startAnimation(this.fJD);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.WM != null) {
            this.WM.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.iOi != null) {
            this.iOi.setListPullRefreshListener(cVar);
        }
    }

    public void aO(List<q> list) {
        if (this.iTC != null) {
            this.iTC.setData(list);
        }
        cAX();
    }

    public void cAX() {
        if (this.hIT != null && this.iTI) {
            this.hIT.a(this.icc, this.fFV, this.icM, true);
        }
    }

    public void cAY() {
        if (this.hIT != null) {
            this.hIT.cAY();
        }
    }

    public void pO(boolean z) {
        this.iTI = z;
    }

    public am cAZ() {
        if (this.hIT == null || this.hIT.dnC() == null || !(this.hIT.dnC().getTag() instanceof am)) {
            return null;
        }
        return (am) this.hIT.dnC().getTag();
    }

    public List<q> getDataList() {
        if (this.iTC != null) {
            return this.iTC.getDataList();
        }
        return null;
    }

    public void cBa() {
        aO(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fQf == null) {
                this.fQf = new g(this.mPageContext.getPageActivity());
                this.fQf.bue();
                this.fQf.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fQf == null) {
            return false;
        }
        return this.fQf.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.qK(R.drawable.new_pic_emotion_08);
        this.mRefreshView.qM(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.qK(R.drawable.new_pic_emotion_03);
        this.mRefreshView.CK(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.WM.setNextPage(this.fHm);
            }
            this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.fHm.setOnClickListener(onClickListener);
            this.fHm.endLoadData();
        }
    }

    public void bHi() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.WM.setNextPage(this.fHm);
            }
            this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.fHm.setOnClickListener(null);
            this.fHm.endLoadData();
        }
    }

    public void bHj() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.WM.setNextPage(this.fHm);
            }
            this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fHm.setOnClickListener(null);
            this.fHm.startLoadData();
        }
    }

    public void Ar(int i) {
        if (this.iTC != null) {
            this.iTC.Ar(i);
        }
    }

    public void Ka() {
        if (this.iTC != null) {
            this.iTC.notifyDataSetChanged();
        }
    }

    public void blA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.iTA != null) {
            SvgManager.bkl().a(this.iTA, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.fQf != null) {
            this.fQf.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fQf.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.iTB != null) {
            ap.setViewTextColor(this.iTB, R.color.cp_cont_b);
        }
        if (this.iOi != null) {
            this.iOi.changeSkin(skinType);
        }
        if (this.iTC != null) {
            this.iTC.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        oz(false);
    }

    public void czB() {
        oz(true);
    }

    public void oz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hIT != null) {
            this.hIT.rP(!z);
            am cAZ = cAZ();
            if (cAZ != null && cAZ.tW() != null) {
                z2 = cAZ.tW().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hIT.cAY();
                } else if (this.iTI) {
                    this.hIT.a(this.icc, this.fFV, this.icM, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.iTC != null) {
            this.iTC.onPause();
        }
    }

    public void onDestroy() {
        if (this.fQf != null) {
            this.fQf.release();
        }
        if (this.fJC != null) {
            this.fJC.cancel();
        }
        if (this.fJD != null) {
            this.fJD.cancel();
        }
        b((f.e) null);
        if (this.iOi != null) {
            this.iOi.release();
        }
        if (this.iTC != null) {
            this.iTC.onDestroy();
        }
        if (this.iTF != null) {
            this.iTF.cancel();
        }
        if (this.iTG != null) {
            this.iTG.cancel();
        }
        if (this.hIT != null) {
            this.hIT.destroy();
        }
        cBb();
        MessageManager.getInstance().unRegisterListener(this.ibJ);
        MessageManager.getInstance().unRegisterListener(this.dXI);
    }

    private void cBb() {
        if (this.WM != null) {
            this.WM.removeOnScrollListener(this.mScrollListener);
            this.WM.setOnTouchListener(null);
            this.WM.setRecyclerListener(null);
        }
        if (this.iBM != null) {
            this.iBM.a((a.InterfaceC0671a) null);
        }
        if (this.iOi != null) {
            this.iOi.a((f.d) null);
            this.iOi.a((f.b) null);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.iTA != null) {
            this.iTA.setOnClickListener(onClickListener);
        }
    }

    public View cBc() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cBd() {
        if (this.iTF == null) {
            this.iTF = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.iTF.setDuration(300L);
            this.iTF.setInterpolator(new AccelerateInterpolator());
            this.iTF.setFillAfter(true);
            this.iTF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iTA != null) {
                        SvgManager.bkl().a(b.this.iTA, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iTH = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iTA.startAnimation(this.iTF);
    }

    public void cBe() {
        if (this.iTG == null) {
            this.iTG = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.iTG.setDuration(300L);
            this.iTG.setInterpolator(new AccelerateInterpolator());
            this.iTG.setFillAfter(true);
            this.iTG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iTA != null) {
                        SvgManager.bkl().a(b.this.iTA, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iTH = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iTA.startAnimation(this.iTG);
    }

    public boolean cBf() {
        return this.iTH;
    }

    public void pP(boolean z) {
        this.iTH = z;
    }

    public void pQ(boolean z) {
        if (this.iTA != null) {
            this.iTA.setVisibility(0);
            if (z) {
                SvgManager.bkl().a(this.iTA, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.iTD, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.bkl().a(this.iTA, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.iTD, R.color.cp_bg_line_h);
        }
    }

    public void cBg() {
        if (this.iTB != null) {
            this.iTB.setVisibility(0);
        }
    }

    public void Ki(String str) {
        if (!StringUtils.isNull(str) && this.iTB != null) {
            this.iTB.setVisibility(0);
            this.iTB.setText(str);
        }
    }

    public void Kj(String str) {
        List<Integer> b = b(str, this.WM);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.WM.o(intValue, intValue2);
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
                    if (cVar.bcY() != null && cVar.bcY().getTid().equals(str)) {
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
