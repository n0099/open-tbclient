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
import com.baidu.card.al;
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
/* loaded from: classes16.dex */
public class b {
    private BdTypeRecyclerView Wu;
    private PbListView fEa;
    private View fGn;
    private AlphaAnimation fGq;
    private AlphaAnimation fGr;
    private g fMR;
    private i hBR;
    private BigdaySwipeRefreshLayout iGH;
    private com.baidu.tieba.homepage.personalize.bigday.a iGy;
    private NEGFeedBackView.a iKB;
    private ImageView iKU;
    private TextView iKV;
    private com.baidu.tieba.homepage.gamevideo.a.a iKW;
    private GameVideoTitleBar iKX;
    private boolean iKY;
    private RotateAnimation iKZ;
    private RotateAnimation iLa;
    private com.baidu.tieba.f.a iuq;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean iLb = false;
    private boolean hVM = false;
    private int hVc = 0;
    private int fCJ = 0;
    private boolean mIsBackground = false;
    private boolean iLc = true;
    f.d iLd = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cxq();
        }
    };
    f.b iLe = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.pG(true);
            if (b.this.hBR != null && !b.this.mIsBackground && b.this.iLc) {
                b.this.hBR.a(b.this.hVc, b.this.fCJ, b.this.hVM, true);
            }
        }
    };
    private CustomMessageListener dVy = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.iKW.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.iLc) {
                        b.this.hBR.a(b.this.hVc, b.this.fCJ, b.this.hVM, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener eVH = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.iuq != null) {
                b.this.iuq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0674a hrF = new a.InterfaceC0674a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            b.this.hVM = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            b.this.hVM = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void bZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void J(int i, int i2) {
        }
    };
    private CustomMessageListener hUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            al cxr;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cxr = b.this.cxr()) != null && cxr.tR() != null) {
                    cxr.tR().b(new a.C0095a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.hBR != null) {
                    b.this.hBR.cE(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).ccF().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Wu)) {
                    b.this.bGn();
                }
                if (i == 0 && b.this.hBR != null && b.this.iLc) {
                    b.this.hBR.a(b.this.hVc, b.this.fCJ, b.this.hVM, 1);
                    return;
                }
                return;
            }
            b.this.bGm();
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
            cw(i3, (i4 - i3) + 1);
        }

        public void cw(int i, int i2) {
            b.this.hVc = i;
            b.this.fCJ = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iKB = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iKX = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.iuq = new com.baidu.tieba.f.a();
        this.hBR = new i(this.mPageContext, this.Wu);
        this.hBR.FG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hBR.setUniqueId(this.mBdUniqueId);
        this.iGH = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.iGy = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.iGH.setProgressView(this.iGy);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.iGH.setCustomDistances(i, i, i * 2);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize36);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iKW = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Wu);
        this.iKW.b(this.iKB);
        this.iKW.setPageUniqueId(this.mBdUniqueId);
        this.fGn = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.iKU = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.iKV = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.iKV.setText(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bkF();
    }

    public void init() {
        this.Wu.addOnScrollListener(this.mScrollListener);
        this.Wu.setOnTouchListener(this.eVH);
        this.Wu.setRecyclerListener(this.mRecyclerListener);
        this.iuq.a(this.hrF);
        this.iGy.a(this.iLd);
        this.iGy.a(this.iLe);
        this.iGy.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dVy.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dVy);
        this.hUJ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hUJ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.iGH.setRefreshing(true);
    }

    public void cxo() {
        if (this.Wu != null) {
            this.Wu.setSelection(0);
            bGn();
        }
    }

    public void b(f.e eVar) {
        this.iGH.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bGm() {
        if (!this.iKY) {
            this.iKY = true;
            this.fGn.setVisibility(0);
            if (this.fGq == null) {
                this.fGq = new AlphaAnimation(0.0f, 1.0f);
                this.fGq.setFillAfter(true);
                this.fGq.setDuration(300L);
            }
            this.fGn.startAnimation(this.fGq);
        }
    }

    public void bGn() {
        if (this.iKY) {
            if (this.fGr == null) {
                this.fGr = new AlphaAnimation(1.0f, 0.0f);
                this.fGr.setFillAfter(true);
                this.fGr.setDuration(300L);
                this.fGr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.fGn.setVisibility(8);
                        b.this.iKY = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fGn.startAnimation(this.fGr);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Wu != null) {
            this.Wu.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.iGy != null) {
            this.iGy.setListPullRefreshListener(cVar);
        }
    }

    public void aK(List<q> list) {
        if (this.iKW != null) {
            this.iKW.setData(list);
        }
        cxp();
    }

    public void cxp() {
        if (this.hBR != null && this.iLc) {
            this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
        }
    }

    public void cxq() {
        if (this.hBR != null) {
            this.hBR.cxq();
        }
    }

    public void pG(boolean z) {
        this.iLc = z;
    }

    public al cxr() {
        if (this.hBR == null || this.hBR.djW() == null || !(this.hBR.djW().getTag() instanceof al)) {
            return null;
        }
        return (al) this.hBR.djW().getTag();
    }

    public List<q> getDataList() {
        if (this.iKW != null) {
            return this.iKW.getDataList();
        }
        return null;
    }

    public void cxs() {
        aK(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fMR == null) {
                this.fMR = new g(this.mPageContext.getPageActivity());
                this.fMR.bta();
                this.fMR.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.fMR.onChangeSkinType();
            }
            this.fMR.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fMR == null) {
            return false;
        }
        return this.fMR.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.qt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.qv(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.qt(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Co(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Wu.setNextPage(this.fEa);
            }
            this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.fEa.setOnClickListener(onClickListener);
            this.fEa.endLoadData();
        }
    }

    public void bFS() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Wu.setNextPage(this.fEa);
            }
            this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.fEa.setOnClickListener(null);
            this.fEa.endLoadData();
        }
    }

    public void bFT() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Wu.setNextPage(this.fEa);
            }
            this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fEa.setOnClickListener(null);
            this.fEa.startLoadData();
        }
    }

    public void zQ(int i) {
        if (this.iKW != null) {
            this.iKW.zQ(i);
        }
    }

    public void Jw() {
        if (this.iKW != null) {
            this.iKW.notifyDataSetChanged();
        }
    }

    public void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.iKU != null) {
            SvgManager.bjq().a(this.iKU, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.fMR != null) {
            this.fMR.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fMR.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.iKV != null) {
            ap.setViewTextColor(this.iKV, R.color.cp_cont_b);
        }
        if (this.iGy != null) {
            this.iGy.changeSkin(skinType);
        }
        if (this.iKW != null) {
            this.iKW.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        ot(false);
    }

    public void cwh() {
        ot(true);
    }

    public void ot(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hBR != null) {
            this.hBR.rH(!z);
            al cxr = cxr();
            if (cxr != null && cxr.tR() != null) {
                z2 = cxr.tR().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hBR.cxq();
                } else if (this.iLc) {
                    this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.iKW != null) {
            this.iKW.onPause();
        }
    }

    public void onDestroy() {
        if (this.fMR != null) {
            this.fMR.release();
        }
        if (this.fGq != null) {
            this.fGq.cancel();
        }
        if (this.fGr != null) {
            this.fGr.cancel();
        }
        b((f.e) null);
        if (this.iGy != null) {
            this.iGy.release();
        }
        if (this.iKW != null) {
            this.iKW.onDestroy();
        }
        if (this.iKZ != null) {
            this.iKZ.cancel();
        }
        if (this.iLa != null) {
            this.iLa.cancel();
        }
        if (this.hBR != null) {
            this.hBR.destroy();
        }
        cxt();
        MessageManager.getInstance().unRegisterListener(this.hUJ);
        MessageManager.getInstance().unRegisterListener(this.dVy);
    }

    private void cxt() {
        if (this.Wu != null) {
            this.Wu.removeOnScrollListener(this.mScrollListener);
            this.Wu.setOnTouchListener(null);
            this.Wu.setRecyclerListener(null);
        }
        if (this.iuq != null) {
            this.iuq.a((a.InterfaceC0674a) null);
        }
        if (this.iGy != null) {
            this.iGy.a((f.d) null);
            this.iGy.a((f.b) null);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.iKU != null) {
            this.iKU.setOnClickListener(onClickListener);
        }
    }

    public View cxu() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cxv() {
        if (this.iKZ == null) {
            this.iKZ = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.iKZ.setDuration(300L);
            this.iKZ.setInterpolator(new AccelerateInterpolator());
            this.iKZ.setFillAfter(true);
            this.iKZ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iKU != null) {
                        SvgManager.bjq().a(b.this.iKU, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iLb = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iKU.startAnimation(this.iKZ);
    }

    public void cxw() {
        if (this.iLa == null) {
            this.iLa = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.iLa.setDuration(300L);
            this.iLa.setInterpolator(new AccelerateInterpolator());
            this.iLa.setFillAfter(true);
            this.iLa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iKU != null) {
                        SvgManager.bjq().a(b.this.iKU, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iLb = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iKU.startAnimation(this.iLa);
    }

    public boolean cxx() {
        return this.iLb;
    }

    public void pH(boolean z) {
        this.iLb = z;
    }

    public void pI(boolean z) {
        if (this.iKU != null) {
            this.iKU.setVisibility(0);
            if (z) {
                SvgManager.bjq().a(this.iKU, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.iKX, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.bjq().a(this.iKU, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.iKX, R.color.cp_bg_line_h);
        }
    }

    public void cxy() {
        if (this.iKV != null) {
            this.iKV.setVisibility(0);
        }
    }

    public void JG(String str) {
        if (!StringUtils.isNull(str) && this.iKV != null) {
            this.iKV.setVisibility(0);
            this.iKV.setText(str);
        }
    }

    public void JH(String str) {
        List<Integer> b = b(str, this.Wu);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Wu.o(intValue, intValue2);
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
                    if (cVar.bce() != null && cVar.bce().getTid().equals(str)) {
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
