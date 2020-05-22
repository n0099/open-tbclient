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
import com.baidu.adp.widget.ListView.o;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
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
    private BdTypeRecyclerView Vw;
    private PbListView fbY;
    private View fek;
    private AlphaAnimation fen;
    private AlphaAnimation feo;
    private g fkQ;
    private m gWm;
    private com.baidu.tieba.f.a hMd;
    private com.baidu.tieba.homepage.personalize.bigday.a hWN;
    private BigdaySwipeRefreshLayout hWW;
    private NEGFeedBackView.a iaQ;
    private ImageView ibj;
    private TextView ibk;
    private com.baidu.tieba.homepage.gamevideo.a.a ibl;
    private GameVideoTitleBar ibm;
    private boolean ibn;
    private RotateAnimation ibo;
    private RotateAnimation ibp;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean ibq = false;
    private boolean hpz = false;
    private int hoQ = 0;
    private int faG = 0;
    private boolean mIsBackground = false;
    private boolean ibr = true;
    f.d ibs = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cfz();
        }
    };
    f.b ibt = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.oj(true);
            if (b.this.gWm != null && !b.this.mIsBackground && b.this.ibr) {
                b.this.gWm.a(b.this.hoQ, b.this.faG, b.this.hpz, true);
            }
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ibl.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.ibr) {
                        b.this.gWm.a(b.this.hoQ, b.this.faG, b.this.hpz, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.hMd != null) {
                b.this.hMd.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0607a gLT = new a.InterfaceC0607a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            b.this.hpz = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            b.this.hpz = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }
    };
    private CustomMessageListener hoH = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ag cfA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cfA = b.this.cfA()) != null && cfA.rM() != null) {
                    cfA.rM().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.gWm != null) {
                    b.this.gWm.ct(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bLU().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Vw)) {
                    b.this.brf();
                }
                if (i == 0 && b.this.gWm != null && b.this.ibr) {
                    b.this.gWm.a(b.this.hoQ, b.this.faG, b.this.hpz, 1);
                    return;
                }
                return;
            }
            b.this.bre();
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
            cf(i3, (i4 - i3) + 1);
        }

        public void cf(int i, int i2) {
            b.this.hoQ = i;
            b.this.faG = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iaQ = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ibm = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hMd = new com.baidu.tieba.f.a();
        this.gWm = new m(this.mPageContext, this.Vw);
        this.gWm.BI(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gWm.setUniqueId(this.mBdUniqueId);
        this.hWW = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.hWN = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.hWW.setProgressView(this.hWN);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.hWW.setCustomDistances(i, i, i * 2);
        this.fbY = new PbListView(this.mPageContext.getPageActivity());
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize36);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ibl = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Vw);
        this.ibl.b(this.iaQ);
        this.ibl.setPageUniqueId(this.mBdUniqueId);
        this.fek = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.ibj = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.ibk = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.ibk.setText(com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aWq();
    }

    public void init() {
        this.Vw.addOnScrollListener(this.mScrollListener);
        this.Vw.setOnTouchListener(this.evw);
        this.Vw.setRecyclerListener(this.mRecyclerListener);
        this.hMd.a(this.gLT);
        this.hWN.a(this.ibs);
        this.hWN.a(this.ibt);
        this.hWN.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dzH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dzH);
        this.hoH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hoH);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.hWW.setRefreshing(true);
    }

    public void cfx() {
        if (this.Vw != null) {
            this.Vw.setSelection(0);
            brf();
        }
    }

    public void b(f.e eVar) {
        this.hWW.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bre() {
        if (!this.ibn) {
            this.ibn = true;
            this.fek.setVisibility(0);
            if (this.fen == null) {
                this.fen = new AlphaAnimation(0.0f, 1.0f);
                this.fen.setFillAfter(true);
                this.fen.setDuration(300L);
            }
            this.fek.startAnimation(this.fen);
        }
    }

    public void brf() {
        if (this.ibn) {
            if (this.feo == null) {
                this.feo = new AlphaAnimation(1.0f, 0.0f);
                this.feo.setFillAfter(true);
                this.feo.setDuration(300L);
                this.feo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.fek.setVisibility(8);
                        b.this.ibn = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fek.startAnimation(this.feo);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Vw != null) {
            this.Vw.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.hWN != null) {
            this.hWN.setListPullRefreshListener(cVar);
        }
    }

    public void az(List<o> list) {
        if (this.ibl != null) {
            this.ibl.setData(list);
        }
        cfy();
    }

    public void cfy() {
        if (this.gWm != null && this.ibr) {
            this.gWm.a(this.hoQ, this.faG, this.hpz, true);
        }
    }

    public void cfz() {
        if (this.gWm != null) {
            this.gWm.cfz();
        }
    }

    public void oj(boolean z) {
        this.ibr = z;
    }

    public ag cfA() {
        if (this.gWm == null || this.gWm.cQE() == null || !(this.gWm.cQE().getTag() instanceof ag)) {
            return null;
        }
        return (ag) this.gWm.cQE().getTag();
    }

    public List<o> getDataList() {
        if (this.ibl != null) {
            return this.ibl.getDataList();
        }
        return null;
    }

    public void cfB() {
        az(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fkQ == null) {
                this.fkQ = new g(this.mPageContext.getPageActivity());
                this.fkQ.bew();
                this.fkQ.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.fkQ.onChangeSkinType();
            }
            this.fkQ.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fkQ == null) {
            return false;
        }
        return this.fkQ.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this.mRootView);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.nv(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.nt(R.drawable.new_pic_emotion_03);
        this.mRefreshView.yx(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bqO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.fbY.setOnClickListener(onClickListener);
            this.fbY.endLoadData();
        }
    }

    public void bqJ() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.fbY.setOnClickListener(null);
            this.fbY.endLoadData();
        }
    }

    public void bqK() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fbY.setOnClickListener(null);
            this.fbY.startLoadData();
        }
    }

    public void ww(int i) {
        if (this.ibl != null) {
            this.ibl.ww(i);
        }
    }

    public void CZ() {
        if (this.ibl != null) {
            this.ibl.notifyDataSetChanged();
        }
    }

    public void aWq() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.ibj != null) {
            SvgManager.aUV().a(this.ibj, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.fkQ != null) {
            this.fkQ.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fkQ.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.ibk != null) {
            am.setViewTextColor(this.ibk, (int) R.color.cp_cont_b);
        }
        if (this.hWN != null) {
            this.hWN.changeSkin(skinType);
        }
        if (this.ibl != null) {
            this.ibl.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        mX(false);
    }

    public void ces() {
        mX(true);
    }

    public void mX(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gWm != null) {
            this.gWm.qi(!z);
            ag cfA = cfA();
            if (cfA != null && cfA.rM() != null) {
                z2 = cfA.rM().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gWm.cfz();
                } else if (this.ibr) {
                    this.gWm.a(this.hoQ, this.faG, this.hpz, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.ibl != null) {
            this.ibl.onPause();
        }
    }

    public void onDestroy() {
        if (this.fkQ != null) {
            this.fkQ.release();
        }
        if (this.fen != null) {
            this.fen.cancel();
        }
        if (this.feo != null) {
            this.feo.cancel();
        }
        b((f.e) null);
        if (this.hWN != null) {
            this.hWN.release();
        }
        if (this.ibl != null) {
            this.ibl.onDestroy();
        }
        if (this.ibo != null) {
            this.ibo.cancel();
        }
        if (this.ibp != null) {
            this.ibp.cancel();
        }
        if (this.gWm != null) {
            this.gWm.destroy();
        }
        cfC();
        MessageManager.getInstance().unRegisterListener(this.hoH);
        MessageManager.getInstance().unRegisterListener(this.dzH);
    }

    private void cfC() {
        if (this.Vw != null) {
            this.Vw.removeOnScrollListener(this.mScrollListener);
            this.Vw.setOnTouchListener(null);
            this.Vw.setRecyclerListener(null);
        }
        if (this.hMd != null) {
            this.hMd.a((a.InterfaceC0607a) null);
        }
        if (this.hWN != null) {
            this.hWN.a((f.d) null);
            this.hWN.a((f.b) null);
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.ibj != null) {
            this.ibj.setOnClickListener(onClickListener);
        }
    }

    public View cfD() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cfE() {
        if (this.ibo == null) {
            this.ibo = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.ibo.setDuration(300L);
            this.ibo.setInterpolator(new AccelerateInterpolator());
            this.ibo.setFillAfter(true);
            this.ibo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.ibj != null) {
                        SvgManager.aUV().a(b.this.ibj, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.ibq = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.ibj.startAnimation(this.ibo);
    }

    public void cfF() {
        if (this.ibp == null) {
            this.ibp = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.ibp.setDuration(300L);
            this.ibp.setInterpolator(new AccelerateInterpolator());
            this.ibp.setFillAfter(true);
            this.ibp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.ibj != null) {
                        SvgManager.aUV().a(b.this.ibj, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.ibq = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.ibj.startAnimation(this.ibp);
    }

    public boolean cfG() {
        return this.ibq;
    }

    public void ok(boolean z) {
        this.ibq = z;
    }

    public void ol(boolean z) {
        if (this.ibj != null) {
            this.ibj.setVisibility(0);
            if (z) {
                SvgManager.aUV().a(this.ibj, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.ibm, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aUV().a(this.ibj, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.ibm, R.color.cp_bg_line_h);
        }
    }

    public void cfH() {
        if (this.ibk != null) {
            this.ibk.setVisibility(0);
        }
    }

    public void FC(String str) {
        if (!StringUtils.isNull(str) && this.ibk != null) {
            this.ibk.setVisibility(0);
            this.ibk.setText(str);
        }
    }

    public void FD(String str) {
        List<Integer> b = b(str, this.Vw);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Vw.l(intValue, intValue2);
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
                o item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.aOi() != null && cVar.aOi().getTid().equals(str)) {
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
