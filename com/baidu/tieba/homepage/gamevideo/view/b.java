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
import com.baidu.tieba.homepage.personalize.a.d;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView BK;
    private PbListView eli;
    private View ent;
    private AlphaAnimation enx;
    private AlphaAnimation eny;
    private g etW;
    private com.baidu.tieba.f.a gMo;
    private com.baidu.tieba.homepage.personalize.bigday.a gWL;
    private BigdaySwipeRefreshLayout gWU;
    private m gqA;
    private NEGFeedBackView.a haX;
    private ImageView hbq;
    private TextView hbr;
    private com.baidu.tieba.homepage.gamevideo.a.a hbs;
    private GameVideoTitleBar hbt;
    private boolean hbu;
    private RotateAnimation hbv;
    private RotateAnimation hbw;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean hbx = false;
    private boolean gqt = false;
    private int gpO = 0;
    private int ejQ = 0;
    private boolean mIsBackground = false;
    private boolean hby = true;
    g.d hbz = new g.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            b.this.bOn();
        }
    };
    g.b hbA = new g.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.mD(true);
            if (b.this.gqA != null && !b.this.mIsBackground && b.this.hby) {
                b.this.gqA.a(b.this.gpO, b.this.ejQ, b.this.gqt, true);
            }
        }
    };
    private CustomMessageListener cMk = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.hbs.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.hby) {
                        b.this.gqA.a(b.this.gpO, b.this.ejQ, b.this.gqt, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener drz = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.gMo != null) {
                b.this.gMo.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0499a fRx = new a.InterfaceC0499a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            b.this.gqt = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            b.this.gqt = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }
    };
    private CustomMessageListener gpG = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOo = b.this.bOo()) != null && bOo.nk() != null) {
                    bOo.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.gqA != null) {
                    b.this.gqA.cl(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).bvI().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.BK)) {
                    b.this.bcL();
                }
                if (i == 0 && b.this.gqA != null && b.this.hby) {
                    b.this.gqA.a(b.this.gpO, b.this.ejQ, b.this.gqt, 1);
                    return;
                }
                return;
            }
            b.this.bcK();
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
            bT(i3, (i4 - i3) + 1);
        }

        public void bT(int i, int i2) {
            b.this.gpO = i;
            b.this.ejQ = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.haX = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hbt = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gMo = new com.baidu.tieba.f.a();
        this.gqA = new m(this.mPageContext, this.BK);
        this.gqA.Aq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gqA.setUniqueId(this.mBdUniqueId);
        this.gWU = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gWL = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gWU.setProgressView(this.gWL);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gWU.setCustomDistances(i, i, i * 2);
        this.eli = new PbListView(this.mPageContext.getPageActivity());
        this.eli.createView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.eli.setLineGone();
        this.eli.setTextSize(R.dimen.tbfontsize36);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hbs = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.BK);
        this.hbs.b(this.haX);
        this.hbs.setPageUniqueId(this.mBdUniqueId);
        this.ent = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.hbq = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.hbr = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.hbr.setText(com.baidu.tbadk.core.sharedPref.b.aFB().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aHL();
    }

    public void init() {
        this.BK.addOnScrollListener(this.mScrollListener);
        this.BK.setOnTouchListener(this.drz);
        this.BK.setRecyclerListener(this.mRecyclerListener);
        this.gMo.a(this.fRx);
        this.gWL.a(this.hbz);
        this.gWL.a(this.hbA);
        this.gWL.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cMk.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cMk);
        this.gpG.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gpG);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.gWU.setRefreshing(true);
    }

    public void bOl() {
        if (this.BK != null) {
            this.BK.setSelection(0);
            bcL();
        }
    }

    public void b(g.e eVar) {
        this.gWU.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bcK() {
        if (!this.hbu) {
            this.hbu = true;
            this.ent.setVisibility(0);
            if (this.enx == null) {
                this.enx = new AlphaAnimation(0.0f, 1.0f);
                this.enx.setFillAfter(true);
                this.enx.setDuration(300L);
            }
            this.ent.startAnimation(this.enx);
        }
    }

    public void bcL() {
        if (this.hbu) {
            if (this.eny == null) {
                this.eny = new AlphaAnimation(1.0f, 0.0f);
                this.eny.setFillAfter(true);
                this.eny.setDuration(300L);
                this.eny.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.ent.setVisibility(8);
                        b.this.hbu = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.ent.startAnimation(this.eny);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.BK != null) {
            this.BK.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gWL != null) {
            this.gWL.setListPullRefreshListener(cVar);
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hbs != null) {
            this.hbs.setData(list);
        }
        bOm();
    }

    public void bOm() {
        if (this.gqA != null && this.hby) {
            this.gqA.a(this.gpO, this.ejQ, this.gqt, true);
        }
    }

    public void bOn() {
        if (this.gqA != null) {
            this.gqA.bOn();
        }
    }

    public void mD(boolean z) {
        this.hby = z;
    }

    public af bOo() {
        if (this.gqA == null || this.gqA.cyG() == null || !(this.gqA.cyG().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gqA.cyG().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.hbs != null) {
            return this.hbs.getDataList();
        }
        return null;
    }

    public void bOp() {
        av(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.etW == null) {
                this.etW = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.etW.aPR();
                this.etW.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.etW.onChangeSkinType();
            }
            this.etW.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.etW == null) {
            return false;
        }
        return this.etW.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mE(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mG(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mE(R.drawable.new_pic_emotion_03);
        this.mRefreshView.vy(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bcv() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.BK.setNextPage(this.eli);
            }
            this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.eli.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.eli.setOnClickListener(onClickListener);
            this.eli.endLoadData();
        }
    }

    public void bcr() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.BK.setNextPage(this.eli);
            }
            this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.eli.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.eli.setOnClickListener(null);
            this.eli.endLoadData();
        }
    }

    public void bcs() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.BK.setNextPage(this.eli);
            }
            this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.eli.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.eli.setOnClickListener(null);
            this.eli.startLoadData();
        }
    }

    public void vl(int i) {
        if (this.hbs != null) {
            this.hbs.vl(i);
        }
    }

    public void wN() {
        if (this.hbs != null) {
            this.hbs.notifyDataSetChanged();
        }
    }

    public void aHL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.hbq != null) {
            SvgManager.aGA().a(this.hbq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.etW != null) {
            this.etW.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.etW.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hbr != null) {
            am.setViewTextColor(this.hbr, (int) R.color.cp_cont_b);
        }
        if (this.gWL != null) {
            this.gWL.changeSkin(skinType);
        }
        if (this.hbs != null) {
            this.hbs.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        lt(false);
    }

    public void bNd() {
        lt(true);
    }

    public void lt(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gqA != null) {
            this.gqA.oB(!z);
            af bOo = bOo();
            if (bOo != null && bOo.nk() != null) {
                z2 = bOo.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gqA.bOn();
                } else if (this.hby) {
                    this.gqA.a(this.gpO, this.ejQ, this.gqt, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.hbs != null) {
            this.hbs.onPause();
        }
    }

    public void onDestroy() {
        if (this.etW != null) {
            this.etW.release();
        }
        if (this.enx != null) {
            this.enx.cancel();
        }
        if (this.eny != null) {
            this.eny.cancel();
        }
        b((g.e) null);
        if (this.gWL != null) {
            this.gWL.release();
        }
        if (this.hbs != null) {
            this.hbs.onDestroy();
        }
        if (this.hbv != null) {
            this.hbv.cancel();
        }
        if (this.hbw != null) {
            this.hbw.cancel();
        }
        if (this.gqA != null) {
            this.gqA.destroy();
        }
        bOq();
        MessageManager.getInstance().unRegisterListener(this.gpG);
        MessageManager.getInstance().unRegisterListener(this.cMk);
    }

    private void bOq() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mScrollListener);
            this.BK.setOnTouchListener(null);
            this.BK.setRecyclerListener(null);
        }
        if (this.gMo != null) {
            this.gMo.a((a.InterfaceC0499a) null);
        }
        if (this.gWL != null) {
            this.gWL.a((g.d) null);
            this.gWL.a((g.b) null);
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.hbq != null) {
            this.hbq.setOnClickListener(onClickListener);
        }
    }

    public View bOr() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bOs() {
        if (this.hbv == null) {
            this.hbv = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.hbv.setDuration(300L);
            this.hbv.setInterpolator(new AccelerateInterpolator());
            this.hbv.setFillAfter(true);
            this.hbv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hbq != null) {
                        SvgManager.aGA().a(b.this.hbq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hbx = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hbq.startAnimation(this.hbv);
    }

    public void bOt() {
        if (this.hbw == null) {
            this.hbw = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.hbw.setDuration(300L);
            this.hbw.setInterpolator(new AccelerateInterpolator());
            this.hbw.setFillAfter(true);
            this.hbw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hbq != null) {
                        SvgManager.aGA().a(b.this.hbq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hbx = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hbq.startAnimation(this.hbw);
    }

    public boolean bOu() {
        return this.hbx;
    }

    public void mE(boolean z) {
        this.hbx = z;
    }

    public void mF(boolean z) {
        if (this.hbq != null) {
            this.hbq.setVisibility(0);
            if (z) {
                SvgManager.aGA().a(this.hbq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.hbt, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aGA().a(this.hbq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.hbt, R.color.cp_bg_line_h);
        }
    }

    public void bOv() {
        if (this.hbr != null) {
            this.hbr.setVisibility(0);
        }
    }

    public void Ch(String str) {
        if (!StringUtils.isNull(str) && this.hbr != null) {
            this.hbr.setVisibility(0);
            this.hbr.setText(str);
        }
    }

    public void Ci(String str) {
        List<Integer> b = b(str, this.BK);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.BK.m(intValue, intValue2);
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
                    if (cVar.aAe() != null && cVar.aAe().getTid().equals(str)) {
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
