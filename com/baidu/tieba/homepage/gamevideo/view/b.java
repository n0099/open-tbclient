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
    private PbListView fcj;
    private View fev;
    private AlphaAnimation fey;
    private AlphaAnimation fez;
    private g flb;
    private m gWx;
    private com.baidu.tieba.f.a hMQ;
    private com.baidu.tieba.homepage.personalize.bigday.a hXA;
    private BigdaySwipeRefreshLayout hXJ;
    private NEGFeedBackView.a ibD;
    private ImageView ibW;
    private TextView ibX;
    private com.baidu.tieba.homepage.gamevideo.a.a ibY;
    private GameVideoTitleBar ibZ;
    private boolean ica;
    private RotateAnimation icb;
    private RotateAnimation icc;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean icd = false;
    private boolean hpK = false;
    private int hpb = 0;
    private int faR = 0;
    private boolean mIsBackground = false;
    private boolean ice = true;
    f.d icf = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cfI();
        }
    };
    f.b icg = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.oj(true);
            if (b.this.gWx != null && !b.this.mIsBackground && b.this.ice) {
                b.this.gWx.a(b.this.hpb, b.this.faR, b.this.hpK, true);
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
                    b.this.ibY.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.ice) {
                        b.this.gWx.a(b.this.hpb, b.this.faR, b.this.hpK, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener evw = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.hMQ != null) {
                b.this.hMQ.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0607a gMe = new a.InterfaceC0607a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            b.this.hpK = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            b.this.hpK = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }
    };
    private CustomMessageListener hoS = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ag cfJ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cfJ = b.this.cfJ()) != null && cfJ.rM() != null) {
                    cfJ.rM().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.gWx != null) {
                    b.this.gWx.ct(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bLW().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Vw)) {
                    b.this.brh();
                }
                if (i == 0 && b.this.gWx != null && b.this.ice) {
                    b.this.gWx.a(b.this.hpb, b.this.faR, b.this.hpK, 1);
                    return;
                }
                return;
            }
            b.this.brg();
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
            b.this.hpb = i;
            b.this.faR = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ibD = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ibZ = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hMQ = new com.baidu.tieba.f.a();
        this.gWx = new m(this.mPageContext, this.Vw);
        this.gWx.BK(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gWx.setUniqueId(this.mBdUniqueId);
        this.hXJ = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.hXA = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.hXJ.setProgressView(this.hXA);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.hXJ.setCustomDistances(i, i, i * 2);
        this.fcj = new PbListView(this.mPageContext.getPageActivity());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize36);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ibY = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Vw);
        this.ibY.b(this.ibD);
        this.ibY.setPageUniqueId(this.mBdUniqueId);
        this.fev = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.ibW = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.ibX = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.ibX.setText(com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aWr();
    }

    public void init() {
        this.Vw.addOnScrollListener(this.mScrollListener);
        this.Vw.setOnTouchListener(this.evw);
        this.Vw.setRecyclerListener(this.mRecyclerListener);
        this.hMQ.a(this.gMe);
        this.hXA.a(this.icf);
        this.hXA.a(this.icg);
        this.hXA.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dzH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dzH);
        this.hoS.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hoS);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.hXJ.setRefreshing(true);
    }

    public void cfG() {
        if (this.Vw != null) {
            this.Vw.setSelection(0);
            brh();
        }
    }

    public void b(f.e eVar) {
        this.hXJ.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void brg() {
        if (!this.ica) {
            this.ica = true;
            this.fev.setVisibility(0);
            if (this.fey == null) {
                this.fey = new AlphaAnimation(0.0f, 1.0f);
                this.fey.setFillAfter(true);
                this.fey.setDuration(300L);
            }
            this.fev.startAnimation(this.fey);
        }
    }

    public void brh() {
        if (this.ica) {
            if (this.fez == null) {
                this.fez = new AlphaAnimation(1.0f, 0.0f);
                this.fez.setFillAfter(true);
                this.fez.setDuration(300L);
                this.fez.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.fev.setVisibility(8);
                        b.this.ica = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fev.startAnimation(this.fez);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Vw != null) {
            this.Vw.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.hXA != null) {
            this.hXA.setListPullRefreshListener(cVar);
        }
    }

    public void az(List<o> list) {
        if (this.ibY != null) {
            this.ibY.setData(list);
        }
        cfH();
    }

    public void cfH() {
        if (this.gWx != null && this.ice) {
            this.gWx.a(this.hpb, this.faR, this.hpK, true);
        }
    }

    public void cfI() {
        if (this.gWx != null) {
            this.gWx.cfI();
        }
    }

    public void oj(boolean z) {
        this.ice = z;
    }

    public ag cfJ() {
        if (this.gWx == null || this.gWx.cQU() == null || !(this.gWx.cQU().getTag() instanceof ag)) {
            return null;
        }
        return (ag) this.gWx.cQU().getTag();
    }

    public List<o> getDataList() {
        if (this.ibY != null) {
            return this.ibY.getDataList();
        }
        return null;
    }

    public void cfK() {
        az(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.flb == null) {
                this.flb = new g(this.mPageContext.getPageActivity());
                this.flb.bex();
                this.flb.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.flb.onChangeSkinType();
            }
            this.flb.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.flb == null) {
            return false;
        }
        return this.flb.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this.mRootView);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nv(R.drawable.new_pic_emotion_08);
        this.mRefreshView.nx(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.nv(R.drawable.new_pic_emotion_03);
        this.mRefreshView.yx(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bqQ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Vw.setNextPage(this.fcj);
            }
            this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.fcj.setOnClickListener(onClickListener);
            this.fcj.endLoadData();
        }
    }

    public void bqL() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Vw.setNextPage(this.fcj);
            }
            this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.fcj.setOnClickListener(null);
            this.fcj.endLoadData();
        }
    }

    public void bqM() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Vw.setNextPage(this.fcj);
            }
            this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fcj.setOnClickListener(null);
            this.fcj.startLoadData();
        }
    }

    public void wy(int i) {
        if (this.ibY != null) {
            this.ibY.wy(i);
        }
    }

    public void CZ() {
        if (this.ibY != null) {
            this.ibY.notifyDataSetChanged();
        }
    }

    public void aWr() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.ibW != null) {
            SvgManager.aUW().a(this.ibW, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.flb != null) {
            this.flb.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.flb.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.ibX != null) {
            am.setViewTextColor(this.ibX, (int) R.color.cp_cont_b);
        }
        if (this.hXA != null) {
            this.hXA.changeSkin(skinType);
        }
        if (this.ibY != null) {
            this.ibY.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        mX(false);
    }

    public void ceA() {
        mX(true);
    }

    public void mX(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gWx != null) {
            this.gWx.qi(!z);
            ag cfJ = cfJ();
            if (cfJ != null && cfJ.rM() != null) {
                z2 = cfJ.rM().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gWx.cfI();
                } else if (this.ice) {
                    this.gWx.a(this.hpb, this.faR, this.hpK, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.ibY != null) {
            this.ibY.onPause();
        }
    }

    public void onDestroy() {
        if (this.flb != null) {
            this.flb.release();
        }
        if (this.fey != null) {
            this.fey.cancel();
        }
        if (this.fez != null) {
            this.fez.cancel();
        }
        b((f.e) null);
        if (this.hXA != null) {
            this.hXA.release();
        }
        if (this.ibY != null) {
            this.ibY.onDestroy();
        }
        if (this.icb != null) {
            this.icb.cancel();
        }
        if (this.icc != null) {
            this.icc.cancel();
        }
        if (this.gWx != null) {
            this.gWx.destroy();
        }
        cfL();
        MessageManager.getInstance().unRegisterListener(this.hoS);
        MessageManager.getInstance().unRegisterListener(this.dzH);
    }

    private void cfL() {
        if (this.Vw != null) {
            this.Vw.removeOnScrollListener(this.mScrollListener);
            this.Vw.setOnTouchListener(null);
            this.Vw.setRecyclerListener(null);
        }
        if (this.hMQ != null) {
            this.hMQ.a((a.InterfaceC0607a) null);
        }
        if (this.hXA != null) {
            this.hXA.a((f.d) null);
            this.hXA.a((f.b) null);
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.ibW != null) {
            this.ibW.setOnClickListener(onClickListener);
        }
    }

    public View cfM() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cfN() {
        if (this.icb == null) {
            this.icb = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.icb.setDuration(300L);
            this.icb.setInterpolator(new AccelerateInterpolator());
            this.icb.setFillAfter(true);
            this.icb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.ibW != null) {
                        SvgManager.aUW().a(b.this.ibW, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.icd = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.ibW.startAnimation(this.icb);
    }

    public void cfO() {
        if (this.icc == null) {
            this.icc = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.icc.setDuration(300L);
            this.icc.setInterpolator(new AccelerateInterpolator());
            this.icc.setFillAfter(true);
            this.icc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.ibW != null) {
                        SvgManager.aUW().a(b.this.ibW, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.icd = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.ibW.startAnimation(this.icc);
    }

    public boolean cfP() {
        return this.icd;
    }

    public void ok(boolean z) {
        this.icd = z;
    }

    public void ol(boolean z) {
        if (this.ibW != null) {
            this.ibW.setVisibility(0);
            if (z) {
                SvgManager.aUW().a(this.ibW, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.ibZ, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aUW().a(this.ibW, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.ibZ, R.color.cp_bg_line_h);
        }
    }

    public void cfQ() {
        if (this.ibX != null) {
            this.ibX.setVisibility(0);
        }
    }

    public void FC(String str) {
        if (!StringUtils.isNull(str) && this.ibX != null) {
            this.ibX.setVisibility(0);
            this.ibX.setText(str);
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
