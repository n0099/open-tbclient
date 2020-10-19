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
    private BdTypeRecyclerView Xc;
    private PbListView fTv;
    private View fVQ;
    private AlphaAnimation fVT;
    private AlphaAnimation fVU;
    private g gcx;
    private i hXO;
    private com.baidu.tieba.f.a iQC;
    private com.baidu.tieba.homepage.personalize.bigday.a jda;
    private BigdaySwipeRefreshLayout jdj;
    private com.baidu.tieba.homepage.gamevideo.a.a jiA;
    private GameVideoTitleBar jiB;
    private boolean jiC;
    private RotateAnimation jiD;
    private RotateAnimation jiE;
    private NEGFeedBackView.a jif;
    private ImageView jiy;
    private TextView jiz;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean jiF = false;
    private boolean irN = false;
    private int ird = 0;
    private int fSe = 0;
    private boolean mIsBackground = false;
    private boolean jiG = true;
    f.d jiH = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cEF();
        }
    };
    f.b jiI = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.qu(true);
            if (b.this.hXO != null && !b.this.mIsBackground && b.this.jiG) {
                b.this.hXO.a(b.this.ird, b.this.fSe, b.this.irN, true);
            }
        }
    };
    private CustomMessageListener ejK = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.jiA.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.jiG) {
                        b.this.hXO.a(b.this.ird, b.this.fSe, b.this.irN, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener fkK = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.iQC != null) {
                b.this.iQC.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0689a hNF = new a.InterfaceC0689a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void H(int i, int i2) {
            b.this.irN = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void I(int i, int i2) {
            b.this.irN = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void J(int i, int i2) {
        }
    };
    private CustomMessageListener iqK = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cEG;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cEG = b.this.cEG()) != null && cEG.tW() != null) {
                    cEG.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.hXO != null) {
                    b.this.hXO.cR(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).cjq().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Xc)) {
                    b.this.bKp();
                }
                if (i == 0 && b.this.hXO != null && b.this.jiG) {
                    b.this.hXO.a(b.this.ird, b.this.fSe, b.this.irN, 1);
                    return;
                }
                return;
            }
            b.this.bKo();
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
            b.this.ird = i;
            b.this.fSe = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jif = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jiB = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Xc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.iQC = new com.baidu.tieba.f.a();
        this.hXO = new i(this.mPageContext, this.Xc);
        this.hXO.GN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hXO.setUniqueId(this.mBdUniqueId);
        this.jdj = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jda = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jdj.setProgressView(this.jda);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jdj.setCustomDistances(i, i, i * 2);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize36);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jiA = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Xc);
        this.jiA.b(this.jif);
        this.jiA.setPageUniqueId(this.mBdUniqueId);
        this.fVQ = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.jiy = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.jiz = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.jiz.setText(com.baidu.tbadk.core.sharedPref.b.blO().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bok();
    }

    public void init() {
        this.Xc.addOnScrollListener(this.mScrollListener);
        this.Xc.setOnTouchListener(this.fkK);
        this.Xc.setRecyclerListener(this.mRecyclerListener);
        this.iQC.a(this.hNF);
        this.jda.a(this.jiH);
        this.jda.a(this.jiI);
        this.jda.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.ejK.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ejK);
        this.iqK.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iqK);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jdj.setRefreshing(true);
    }

    public void cED() {
        if (this.Xc != null) {
            this.Xc.setSelection(0);
            bKp();
        }
    }

    public void b(f.e eVar) {
        this.jdj.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bKo() {
        if (!this.jiC) {
            this.jiC = true;
            this.fVQ.setVisibility(0);
            if (this.fVT == null) {
                this.fVT = new AlphaAnimation(0.0f, 1.0f);
                this.fVT.setFillAfter(true);
                this.fVT.setDuration(300L);
            }
            this.fVQ.startAnimation(this.fVT);
        }
    }

    public void bKp() {
        if (this.jiC) {
            if (this.fVU == null) {
                this.fVU = new AlphaAnimation(1.0f, 0.0f);
                this.fVU.setFillAfter(true);
                this.fVU.setDuration(300L);
                this.fVU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.fVQ.setVisibility(8);
                        b.this.jiC = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fVQ.startAnimation(this.fVU);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Xc != null) {
            this.Xc.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jda != null) {
            this.jda.setListPullRefreshListener(cVar);
        }
    }

    public void aR(List<q> list) {
        if (this.jiA != null) {
            this.jiA.setData(list);
        }
        cEE();
    }

    public void cEE() {
        if (this.hXO != null && this.jiG) {
            this.hXO.a(this.ird, this.fSe, this.irN, true);
        }
    }

    public void cEF() {
        if (this.hXO != null) {
            this.hXO.cEF();
        }
    }

    public void qu(boolean z) {
        this.jiG = z;
    }

    public am cEG() {
        if (this.hXO == null || this.hXO.drn() == null || !(this.hXO.drn().getTag() instanceof am)) {
            return null;
        }
        return (am) this.hXO.drn().getTag();
    }

    public List<q> getDataList() {
        if (this.jiA != null) {
            return this.jiA.getDataList();
        }
        return null;
    }

    public void cEH() {
        aR(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gcx == null) {
                this.gcx = new g(this.mPageContext.getPageActivity());
                this.gcx.bwO();
                this.gcx.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gcx.onChangeSkinType();
            }
            this.gcx.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gcx == null) {
            return false;
        }
        return this.gcx.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rk(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.ri(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Dw(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.fTv.setOnClickListener(onClickListener);
            this.fTv.endLoadData();
        }
    }

    public void bJU() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.fTv.setOnClickListener(null);
            this.fTv.endLoadData();
        }
    }

    public void bJV() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fTv.setOnClickListener(null);
            this.fTv.startLoadData();
        }
    }

    public void AX(int i) {
        if (this.jiA != null) {
            this.jiA.AX(i);
        }
    }

    public void Lf() {
        if (this.jiA != null) {
            this.jiA.notifyDataSetChanged();
        }
    }

    public void bok() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.jiy != null) {
            SvgManager.bmU().a(this.jiy, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gcx != null) {
            this.gcx.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gcx.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jiz != null) {
            ap.setViewTextColor(this.jiz, R.color.cp_cont_b);
        }
        if (this.jda != null) {
            this.jda.changeSkin(skinType);
        }
        if (this.jiA != null) {
            this.jiA.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        pe(false);
    }

    public void cCY() {
        pe(true);
    }

    public void pe(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hXO != null) {
            this.hXO.sw(!z);
            am cEG = cEG();
            if (cEG != null && cEG.tW() != null) {
                z2 = cEG.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hXO.cEF();
                } else if (this.jiG) {
                    this.hXO.a(this.ird, this.fSe, this.irN, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.jiA != null) {
            this.jiA.onPause();
        }
    }

    public void onDestroy() {
        if (this.gcx != null) {
            this.gcx.release();
        }
        if (this.fVT != null) {
            this.fVT.cancel();
        }
        if (this.fVU != null) {
            this.fVU.cancel();
        }
        b((f.e) null);
        if (this.jda != null) {
            this.jda.release();
        }
        if (this.jiA != null) {
            this.jiA.onDestroy();
        }
        if (this.jiD != null) {
            this.jiD.cancel();
        }
        if (this.jiE != null) {
            this.jiE.cancel();
        }
        if (this.hXO != null) {
            this.hXO.destroy();
        }
        cEI();
        MessageManager.getInstance().unRegisterListener(this.iqK);
        MessageManager.getInstance().unRegisterListener(this.ejK);
    }

    private void cEI() {
        if (this.Xc != null) {
            this.Xc.removeOnScrollListener(this.mScrollListener);
            this.Xc.setOnTouchListener(null);
            this.Xc.setRecyclerListener(null);
        }
        if (this.iQC != null) {
            this.iQC.a((a.InterfaceC0689a) null);
        }
        if (this.jda != null) {
            this.jda.a((f.d) null);
            this.jda.a((f.b) null);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.jiy != null) {
            this.jiy.setOnClickListener(onClickListener);
        }
    }

    public View cEJ() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cEK() {
        if (this.jiD == null) {
            this.jiD = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.jiD.setDuration(300L);
            this.jiD.setInterpolator(new AccelerateInterpolator());
            this.jiD.setFillAfter(true);
            this.jiD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jiy != null) {
                        SvgManager.bmU().a(b.this.jiy, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jiF = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jiy.startAnimation(this.jiD);
    }

    public void cEL() {
        if (this.jiE == null) {
            this.jiE = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.jiE.setDuration(300L);
            this.jiE.setInterpolator(new AccelerateInterpolator());
            this.jiE.setFillAfter(true);
            this.jiE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jiy != null) {
                        SvgManager.bmU().a(b.this.jiy, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jiF = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jiy.startAnimation(this.jiE);
    }

    public boolean cEM() {
        return this.jiF;
    }

    public void qv(boolean z) {
        this.jiF = z;
    }

    public void qw(boolean z) {
        if (this.jiy != null) {
            this.jiy.setVisibility(0);
            if (z) {
                SvgManager.bmU().a(this.jiy, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.jiB, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.bmU().a(this.jiy, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.jiB, R.color.cp_bg_line_h);
        }
    }

    public void cEN() {
        if (this.jiz != null) {
            this.jiz.setVisibility(0);
        }
    }

    public void KX(String str) {
        if (!StringUtils.isNull(str) && this.jiz != null) {
            this.jiz.setVisibility(0);
            this.jiz.setText(str);
        }
    }

    public void KY(String str) {
        List<Integer> b = b(str, this.Xc);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Xc.o(intValue, intValue2);
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
                    if (cVar.bfG() != null && cVar.bfG().getTid().equals(str)) {
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
