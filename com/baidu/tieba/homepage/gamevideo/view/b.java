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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.g.a;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView Yf;
    private g gAg;
    private PbListView grg;
    private View gtB;
    private AlphaAnimation gtE;
    private AlphaAnimation gtF;
    private i iBV;
    private com.baidu.tieba.homepage.personalize.bigday.a jJI;
    private BigdaySwipeRefreshLayout jJR;
    private NEGFeedBackView.a jOZ;
    private ImageView jPs;
    private TextView jPt;
    private com.baidu.tieba.homepage.gamevideo.a.a jPu;
    private GameVideoTitleBar jPv;
    private boolean jPw;
    private RotateAnimation jPx;
    private RotateAnimation jPy;
    private com.baidu.tieba.g.a jxl;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean jPz = false;
    private boolean iVO = false;
    private int iVe = 0;
    private int gpP = 0;
    private boolean mIsBackground = false;
    private boolean jPA = true;
    f.d jPB = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cPi();
        }
    };
    f.b jPC = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.rz(true);
            if (b.this.iBV != null && !b.this.mIsBackground && b.this.jPA) {
                b.this.iBV.a(b.this.iVe, b.this.gpP, b.this.iVO, true);
            }
        }
    };
    private CustomMessageListener eDt = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.jPu.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.jPA) {
                        b.this.iBV.a(b.this.iVe, b.this.gpP, b.this.iVO, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jxl != null) {
                b.this.jxl.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0756a irO = new a.InterfaceC0756a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void G(int i, int i2) {
            b.this.iVO = false;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void H(int i, int i2) {
            b.this.iVO = true;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void ck(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void I(int i, int i2) {
        }
    };
    private CustomMessageListener iUL = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cPj;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cPj = b.this.cPj()) != null && cPj.tZ() != null) {
                    cPj.tZ().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iBV != null) {
                    b.this.iBV.dl(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).csN().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Yf)) {
                    b.this.bSw();
                }
                if (i == 0 && b.this.iBV != null && b.this.jPA) {
                    b.this.iBV.a(b.this.iVe, b.this.gpP, b.this.iVO, 1);
                    return;
                }
                return;
            }
            b.this.bSv();
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
            cI(i3, (i4 - i3) + 1);
        }

        public void cI(int i, int i2) {
            b.this.iVe = i;
            b.this.gpP = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jOZ = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jPv = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Yf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jxl = new com.baidu.tieba.g.a();
        this.iBV = new i(this.mPageContext, this.Yf);
        this.iBV.II(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iBV.setUniqueId(this.mBdUniqueId);
        this.jJR = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jJI = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jJR.setProgressView(this.jJI);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jJR.setCustomDistances(i, i, i * 2);
        this.grg = new PbListView(this.mPageContext.getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize36);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jPu = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Yf);
        this.jPu.b(this.jOZ);
        this.jPu.setPageUniqueId(this.mBdUniqueId);
        this.gtB = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.jPs = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.jPt = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.jPt.setText(com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bvt();
    }

    public void init() {
        this.Yf.addOnScrollListener(this.mScrollListener);
        this.Yf.setOnTouchListener(this.fGd);
        this.Yf.setRecyclerListener(this.mRecyclerListener);
        this.jxl.a(this.irO);
        this.jJI.a(this.jPB);
        this.jJI.a(this.jPC);
        this.jJI.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eDt.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eDt);
        this.iUL.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iUL);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jJR.setRefreshing(true);
    }

    public void cPg() {
        if (this.Yf != null) {
            this.Yf.setSelection(0);
            bSw();
        }
    }

    public void b(f.e eVar) {
        this.jJR.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bSv() {
        if (!this.jPw) {
            this.jPw = true;
            this.gtB.setVisibility(0);
            if (this.gtE == null) {
                this.gtE = new AlphaAnimation(0.0f, 1.0f);
                this.gtE.setFillAfter(true);
                this.gtE.setDuration(300L);
            }
            this.gtB.startAnimation(this.gtE);
        }
    }

    public void bSw() {
        if (this.jPw) {
            if (this.gtF == null) {
                this.gtF = new AlphaAnimation(1.0f, 0.0f);
                this.gtF.setFillAfter(true);
                this.gtF.setDuration(300L);
                this.gtF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.gtB.setVisibility(8);
                        b.this.jPw = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gtB.startAnimation(this.gtF);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Yf != null) {
            this.Yf.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jJI != null) {
            this.jJI.setListPullRefreshListener(cVar);
        }
    }

    public void bl(List<q> list) {
        if (this.jPu != null) {
            this.jPu.setData(list);
        }
        cPh();
    }

    public void cPh() {
        if (this.iBV != null && this.jPA) {
            this.iBV.a(this.iVe, this.gpP, this.iVO, true);
        }
    }

    public void cPi() {
        if (this.iBV != null) {
            this.iBV.cPi();
        }
    }

    public void rz(boolean z) {
        this.jPA = z;
    }

    public am cPj() {
        if (this.iBV == null || this.iBV.dBP() == null || !(this.iBV.dBP().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iBV.dBP().getTag();
    }

    public List<q> getDataList() {
        if (this.jPu != null) {
            return this.jPu.getDataList();
        }
        return null;
    }

    public void cPk() {
        bl(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gAg == null) {
                this.gAg = new g(this.mPageContext.getPageActivity());
                this.gAg.bDY();
                this.gAg.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gAg == null) {
            return false;
        }
        return this.gAg.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this.mRootView);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sC(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sE(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.sC(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Ek(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.grg.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.grg.setOnClickListener(onClickListener);
            this.grg.endLoadData();
        }
    }

    public void bSb() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.grg.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.grg.setOnClickListener(null);
            this.grg.endLoadData();
        }
    }

    public void bSc() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.grg.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.grg.setOnClickListener(null);
            this.grg.startLoadData();
        }
    }

    public void CQ(int i) {
        if (this.jPu != null) {
            this.jPu.CQ(i);
        }
    }

    public void Nv() {
        if (this.jPu != null) {
            this.jPu.notifyDataSetChanged();
        }
    }

    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.jPs != null) {
            SvgManager.btW().a(this.jPs, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gAg != null) {
            this.gAg.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gAg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jPt != null) {
            ap.setViewTextColor(this.jPt, R.color.CAM_X0105);
        }
        if (this.jJI != null) {
            this.jJI.changeSkin(skinType);
        }
        if (this.jPu != null) {
            this.jPu.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        qf(false);
    }

    public void cNB() {
        qf(true);
    }

    public void qf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iBV != null) {
            this.iBV.tC(!z);
            am cPj = cPj();
            if (cPj != null && cPj.tZ() != null) {
                z2 = cPj.tZ().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iBV.cPi();
                } else if (this.jPA) {
                    this.iBV.a(this.iVe, this.gpP, this.iVO, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.jPu != null) {
            this.jPu.onPause();
        }
    }

    public void onDestroy() {
        if (this.gAg != null) {
            this.gAg.release();
        }
        if (this.gtE != null) {
            this.gtE.cancel();
        }
        if (this.gtF != null) {
            this.gtF.cancel();
        }
        b((f.e) null);
        if (this.jJI != null) {
            this.jJI.release();
        }
        if (this.jPu != null) {
            this.jPu.onDestroy();
        }
        if (this.jPx != null) {
            this.jPx.cancel();
        }
        if (this.jPy != null) {
            this.jPy.cancel();
        }
        if (this.iBV != null) {
            this.iBV.destroy();
        }
        cPl();
        MessageManager.getInstance().unRegisterListener(this.iUL);
        MessageManager.getInstance().unRegisterListener(this.eDt);
    }

    private void cPl() {
        if (this.Yf != null) {
            this.Yf.removeOnScrollListener(this.mScrollListener);
            this.Yf.setOnTouchListener(null);
            this.Yf.setRecyclerListener(null);
        }
        if (this.jxl != null) {
            this.jxl.a((a.InterfaceC0756a) null);
        }
        if (this.jJI != null) {
            this.jJI.a((f.d) null);
            this.jJI.a((f.b) null);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jPs != null) {
            this.jPs.setOnClickListener(onClickListener);
        }
    }

    public View cPm() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cPn() {
        if (this.jPx == null) {
            this.jPx = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.jPx.setDuration(300L);
            this.jPx.setInterpolator(new AccelerateInterpolator());
            this.jPx.setFillAfter(true);
            this.jPx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jPs != null) {
                        SvgManager.btW().a(b.this.jPs, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jPz = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jPs.startAnimation(this.jPx);
    }

    public void cPo() {
        if (this.jPy == null) {
            this.jPy = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.jPy.setDuration(300L);
            this.jPy.setInterpolator(new AccelerateInterpolator());
            this.jPy.setFillAfter(true);
            this.jPy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jPs != null) {
                        SvgManager.btW().a(b.this.jPs, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jPz = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jPs.startAnimation(this.jPy);
    }

    public boolean cPp() {
        return this.jPz;
    }

    public void rA(boolean z) {
        this.jPz = z;
    }

    public void rB(boolean z) {
        if (this.jPs != null) {
            this.jPs.setVisibility(0);
            if (z) {
                SvgManager.btW().a(this.jPs, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.jPv, R.color.CAM_X0201);
                return;
            }
            SvgManager.btW().a(this.jPs, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.jPv, R.color.CAM_X0207);
        }
    }

    public void cPq() {
        if (this.jPt != null) {
            this.jPt.setVisibility(0);
        }
    }

    public void Mu(String str) {
        if (!StringUtils.isNull(str) && this.jPt != null) {
            this.jPt.setVisibility(0);
            this.jPt.setText(str);
        }
    }

    public void Mv(String str) {
        List<Integer> b = b(str, this.Yf);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Yf.p(intValue, intValue2);
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
                if (item instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
                    if (bVar.bmn() != null && bVar.bmn().getTid().equals(str)) {
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
