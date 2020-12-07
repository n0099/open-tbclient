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
    private g gAe;
    private PbListView gre;
    private AlphaAnimation gtC;
    private AlphaAnimation gtD;
    private View gtz;
    private i iBT;
    private com.baidu.tieba.homepage.personalize.bigday.a jJG;
    private BigdaySwipeRefreshLayout jJP;
    private NEGFeedBackView.a jOX;
    private ImageView jPq;
    private TextView jPr;
    private com.baidu.tieba.homepage.gamevideo.a.a jPs;
    private GameVideoTitleBar jPt;
    private boolean jPu;
    private RotateAnimation jPv;
    private RotateAnimation jPw;
    private com.baidu.tieba.g.a jxj;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean jPx = false;
    private boolean iVM = false;
    private int iVc = 0;
    private int gpN = 0;
    private boolean mIsBackground = false;
    private boolean jPy = true;
    f.d jPz = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cPh();
        }
    };
    f.b jPA = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.rz(true);
            if (b.this.iBT != null && !b.this.mIsBackground && b.this.jPy) {
                b.this.iBT.a(b.this.iVc, b.this.gpN, b.this.iVM, true);
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
                    b.this.jPs.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.jPy) {
                        b.this.iBT.a(b.this.iVc, b.this.gpN, b.this.iVM, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jxj != null) {
                b.this.jxj.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0756a irM = new a.InterfaceC0756a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void G(int i, int i2) {
            b.this.iVM = false;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void H(int i, int i2) {
            b.this.iVM = true;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void ck(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void I(int i, int i2) {
        }
    };
    private CustomMessageListener iUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cPi;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cPi = b.this.cPi()) != null && cPi.tZ() != null) {
                    cPi.tZ().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iBT != null) {
                    b.this.iBT.dl(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).csM().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Yf)) {
                    b.this.bSv();
                }
                if (i == 0 && b.this.iBT != null && b.this.jPy) {
                    b.this.iBT.a(b.this.iVc, b.this.gpN, b.this.iVM, 1);
                    return;
                }
                return;
            }
            b.this.bSu();
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
            b.this.iVc = i;
            b.this.gpN = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jOX = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jPt = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Yf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jxj = new com.baidu.tieba.g.a();
        this.iBT = new i(this.mPageContext, this.Yf);
        this.iBT.II(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iBT.setUniqueId(this.mBdUniqueId);
        this.jJP = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jJG = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jJP.setProgressView(this.jJG);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jJP.setCustomDistances(i, i, i * 2);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize36);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jPs = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Yf);
        this.jPs.b(this.jOX);
        this.jPs.setPageUniqueId(this.mBdUniqueId);
        this.gtz = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.jPq = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.jPr = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.jPr.setText(com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bvt();
    }

    public void init() {
        this.Yf.addOnScrollListener(this.mScrollListener);
        this.Yf.setOnTouchListener(this.fGd);
        this.Yf.setRecyclerListener(this.mRecyclerListener);
        this.jxj.a(this.irM);
        this.jJG.a(this.jPz);
        this.jJG.a(this.jPA);
        this.jJG.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eDt.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eDt);
        this.iUJ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iUJ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jJP.setRefreshing(true);
    }

    public void cPf() {
        if (this.Yf != null) {
            this.Yf.setSelection(0);
            bSv();
        }
    }

    public void b(f.e eVar) {
        this.jJP.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bSu() {
        if (!this.jPu) {
            this.jPu = true;
            this.gtz.setVisibility(0);
            if (this.gtC == null) {
                this.gtC = new AlphaAnimation(0.0f, 1.0f);
                this.gtC.setFillAfter(true);
                this.gtC.setDuration(300L);
            }
            this.gtz.startAnimation(this.gtC);
        }
    }

    public void bSv() {
        if (this.jPu) {
            if (this.gtD == null) {
                this.gtD = new AlphaAnimation(1.0f, 0.0f);
                this.gtD.setFillAfter(true);
                this.gtD.setDuration(300L);
                this.gtD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.gtz.setVisibility(8);
                        b.this.jPu = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gtz.startAnimation(this.gtD);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Yf != null) {
            this.Yf.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jJG != null) {
            this.jJG.setListPullRefreshListener(cVar);
        }
    }

    public void bl(List<q> list) {
        if (this.jPs != null) {
            this.jPs.setData(list);
        }
        cPg();
    }

    public void cPg() {
        if (this.iBT != null && this.jPy) {
            this.iBT.a(this.iVc, this.gpN, this.iVM, true);
        }
    }

    public void cPh() {
        if (this.iBT != null) {
            this.iBT.cPh();
        }
    }

    public void rz(boolean z) {
        this.jPy = z;
    }

    public am cPi() {
        if (this.iBT == null || this.iBT.dBO() == null || !(this.iBT.dBO().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iBT.dBO().getTag();
    }

    public List<q> getDataList() {
        if (this.jPs != null) {
            return this.jPs.getDataList();
        }
        return null;
    }

    public void cPj() {
        bl(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gAe == null) {
                this.gAe = new g(this.mPageContext.getPageActivity());
                this.gAe.bDY();
                this.gAe.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gAe.onChangeSkinType();
            }
            this.gAe.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gAe == null) {
            return false;
        }
        return this.gAe.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this.mRootView);
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
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.Yf.setNextPage(this.gre);
            }
            this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gre.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.gre.setOnClickListener(onClickListener);
            this.gre.endLoadData();
        }
    }

    public void bSa() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.Yf.setNextPage(this.gre);
            }
            this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gre.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.gre.setOnClickListener(null);
            this.gre.endLoadData();
        }
    }

    public void bSb() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.Yf.setNextPage(this.gre);
            }
            this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gre.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gre.setOnClickListener(null);
            this.gre.startLoadData();
        }
    }

    public void CQ(int i) {
        if (this.jPs != null) {
            this.jPs.CQ(i);
        }
    }

    public void Nv() {
        if (this.jPs != null) {
            this.jPs.notifyDataSetChanged();
        }
    }

    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.jPq != null) {
            SvgManager.btW().a(this.jPq, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gAe != null) {
            this.gAe.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gAe.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jPr != null) {
            ap.setViewTextColor(this.jPr, R.color.CAM_X0105);
        }
        if (this.jJG != null) {
            this.jJG.changeSkin(skinType);
        }
        if (this.jPs != null) {
            this.jPs.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        qf(false);
    }

    public void cNA() {
        qf(true);
    }

    public void qf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iBT != null) {
            this.iBT.tC(!z);
            am cPi = cPi();
            if (cPi != null && cPi.tZ() != null) {
                z2 = cPi.tZ().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iBT.cPh();
                } else if (this.jPy) {
                    this.iBT.a(this.iVc, this.gpN, this.iVM, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.jPs != null) {
            this.jPs.onPause();
        }
    }

    public void onDestroy() {
        if (this.gAe != null) {
            this.gAe.release();
        }
        if (this.gtC != null) {
            this.gtC.cancel();
        }
        if (this.gtD != null) {
            this.gtD.cancel();
        }
        b((f.e) null);
        if (this.jJG != null) {
            this.jJG.release();
        }
        if (this.jPs != null) {
            this.jPs.onDestroy();
        }
        if (this.jPv != null) {
            this.jPv.cancel();
        }
        if (this.jPw != null) {
            this.jPw.cancel();
        }
        if (this.iBT != null) {
            this.iBT.destroy();
        }
        cPk();
        MessageManager.getInstance().unRegisterListener(this.iUJ);
        MessageManager.getInstance().unRegisterListener(this.eDt);
    }

    private void cPk() {
        if (this.Yf != null) {
            this.Yf.removeOnScrollListener(this.mScrollListener);
            this.Yf.setOnTouchListener(null);
            this.Yf.setRecyclerListener(null);
        }
        if (this.jxj != null) {
            this.jxj.a((a.InterfaceC0756a) null);
        }
        if (this.jJG != null) {
            this.jJG.a((f.d) null);
            this.jJG.a((f.b) null);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jPq != null) {
            this.jPq.setOnClickListener(onClickListener);
        }
    }

    public View cPl() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cPm() {
        if (this.jPv == null) {
            this.jPv = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.jPv.setDuration(300L);
            this.jPv.setInterpolator(new AccelerateInterpolator());
            this.jPv.setFillAfter(true);
            this.jPv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jPq != null) {
                        SvgManager.btW().a(b.this.jPq, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jPx = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jPq.startAnimation(this.jPv);
    }

    public void cPn() {
        if (this.jPw == null) {
            this.jPw = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.jPw.setDuration(300L);
            this.jPw.setInterpolator(new AccelerateInterpolator());
            this.jPw.setFillAfter(true);
            this.jPw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jPq != null) {
                        SvgManager.btW().a(b.this.jPq, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jPx = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jPq.startAnimation(this.jPw);
    }

    public boolean cPo() {
        return this.jPx;
    }

    public void rA(boolean z) {
        this.jPx = z;
    }

    public void rB(boolean z) {
        if (this.jPq != null) {
            this.jPq.setVisibility(0);
            if (z) {
                SvgManager.btW().a(this.jPq, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.jPt, R.color.CAM_X0201);
                return;
            }
            SvgManager.btW().a(this.jPq, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.jPt, R.color.CAM_X0207);
        }
    }

    public void cPp() {
        if (this.jPr != null) {
            this.jPr.setVisibility(0);
        }
    }

    public void Mu(String str) {
        if (!StringUtils.isNull(str) && this.jPr != null) {
            this.jPr.setVisibility(0);
            this.jPr.setText(str);
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
