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
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
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
    private BdTypeRecyclerView VT;
    private g fBv;
    private PbListView fsC;
    private View fuQ;
    private AlphaAnimation fuT;
    private AlphaAnimation fuU;
    private i hoU;
    private com.baidu.tieba.f.a igg;
    private com.baidu.tieba.homepage.personalize.bigday.a isd;
    private BigdaySwipeRefreshLayout ism;
    private TextView iwA;
    private com.baidu.tieba.homepage.gamevideo.a.a iwB;
    private GameVideoTitleBar iwC;
    private boolean iwD;
    private RotateAnimation iwE;
    private RotateAnimation iwF;
    private NEGFeedBackView.a iwg;
    private ImageView iwz;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean iwG = false;
    private boolean hIq = false;
    private int hHG = 0;
    private int frk = 0;
    private boolean mIsBackground = false;
    private boolean iwH = true;
    f.d iwI = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cmG();
        }
    };
    f.b iwJ = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.oZ(true);
            if (b.this.hoU != null && !b.this.mIsBackground && b.this.iwH) {
                b.this.hoU.a(b.this.hHG, b.this.frk, b.this.hIq, true);
            }
        }
    };
    private CustomMessageListener dMl = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.iwB.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.iwH) {
                        b.this.hoU.a(b.this.hHG, b.this.frk, b.this.hIq, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener eKY = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.igg != null) {
                b.this.igg.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0623a heG = new a.InterfaceC0623a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void D(int i, int i2) {
            b.this.hIq = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void E(int i, int i2) {
            b.this.hIq = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void bR(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0623a
        public void F(int i, int i2) {
        }
    };
    private CustomMessageListener hHn = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak cmH;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cmH = b.this.cmH()) != null && cmH.sg() != null) {
                    cmH.sg().b(new a.C0096a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.hoU != null) {
                    b.this.hoU.cA(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bSs().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.VT)) {
                    b.this.bxn();
                }
                if (i == 0 && b.this.hoU != null && b.this.iwH) {
                    b.this.hoU.a(b.this.hHG, b.this.frk, b.this.hIq, 1);
                    return;
                }
                return;
            }
            b.this.bxm();
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
            co(i3, (i4 - i3) + 1);
        }

        public void co(int i, int i2) {
            b.this.hHG = i;
            b.this.frk = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iwg = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iwC = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.VT.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.igg = new com.baidu.tieba.f.a();
        this.hoU = new i(this.mPageContext, this.VT);
        this.hoU.Dl(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hoU.setUniqueId(this.mBdUniqueId);
        this.ism = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.isd = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.ism.setProgressView(this.isd);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.ism.setCustomDistances(i, i, i * 2);
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize36);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iwB = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.VT);
        this.iwB.b(this.iwg);
        this.iwB.setPageUniqueId(this.mBdUniqueId);
        this.fuQ = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.iwz = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.iwA = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.iwA.setText(com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bci();
    }

    public void init() {
        this.VT.addOnScrollListener(this.mScrollListener);
        this.VT.setOnTouchListener(this.eKY);
        this.VT.setRecyclerListener(this.mRecyclerListener);
        this.igg.a(this.heG);
        this.isd.a(this.iwI);
        this.isd.a(this.iwJ);
        this.isd.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dMl.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dMl);
        this.hHn.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hHn);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.ism.setRefreshing(true);
    }

    public void cmE() {
        if (this.VT != null) {
            this.VT.setSelection(0);
            bxn();
        }
    }

    public void b(f.e eVar) {
        this.ism.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bxm() {
        if (!this.iwD) {
            this.iwD = true;
            this.fuQ.setVisibility(0);
            if (this.fuT == null) {
                this.fuT = new AlphaAnimation(0.0f, 1.0f);
                this.fuT.setFillAfter(true);
                this.fuT.setDuration(300L);
            }
            this.fuQ.startAnimation(this.fuT);
        }
    }

    public void bxn() {
        if (this.iwD) {
            if (this.fuU == null) {
                this.fuU = new AlphaAnimation(1.0f, 0.0f);
                this.fuU.setFillAfter(true);
                this.fuU.setDuration(300L);
                this.fuU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.fuQ.setVisibility(8);
                        b.this.iwD = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fuQ.startAnimation(this.fuU);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.VT != null) {
            this.VT.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.isd != null) {
            this.isd.setListPullRefreshListener(cVar);
        }
    }

    public void aK(List<q> list) {
        if (this.iwB != null) {
            this.iwB.setData(list);
        }
        cmF();
    }

    public void cmF() {
        if (this.hoU != null && this.iwH) {
            this.hoU.a(this.hHG, this.frk, this.hIq, true);
        }
    }

    public void cmG() {
        if (this.hoU != null) {
            this.hoU.cmG();
        }
    }

    public void oZ(boolean z) {
        this.iwH = z;
    }

    public ak cmH() {
        if (this.hoU == null || this.hoU.cYQ() == null || !(this.hoU.cYQ().getTag() instanceof ak)) {
            return null;
        }
        return (ak) this.hoU.cYQ().getTag();
    }

    public List<q> getDataList() {
        if (this.iwB != null) {
            return this.iwB.getDataList();
        }
        return null;
    }

    public void cmI() {
        aK(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fBv == null) {
                this.fBv = new g(this.mPageContext.getPageActivity());
                this.fBv.bkn();
                this.fBv.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.fBv.onChangeSkinType();
            }
            this.fBv.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fBv == null) {
            return false;
        }
        return this.fBv.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.oi(R.drawable.new_pic_emotion_08);
        this.mRefreshView.ok(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.oi(R.drawable.new_pic_emotion_03);
        this.mRefreshView.zX(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.VT.setNextPage(this.fsC);
            }
            this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.fsC.setOnClickListener(onClickListener);
            this.fsC.endLoadData();
        }
    }

    public void bwS() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.VT.setNextPage(this.fsC);
            }
            this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.fsC.setOnClickListener(null);
            this.fsC.endLoadData();
        }
    }

    public void bwT() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.VT.setNextPage(this.fsC);
            }
            this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fsC.setOnClickListener(null);
            this.fsC.startLoadData();
        }
    }

    public void xw(int i) {
        if (this.iwB != null) {
            this.iwB.xw(i);
        }
    }

    public void DT() {
        if (this.iwB != null) {
            this.iwB.notifyDataSetChanged();
        }
    }

    public void bci() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.iwz != null) {
            SvgManager.baR().a(this.iwz, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.fBv != null) {
            this.fBv.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fBv.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.iwA != null) {
            ao.setViewTextColor(this.iwA, R.color.cp_cont_b);
        }
        if (this.isd != null) {
            this.isd.changeSkin(skinType);
        }
        if (this.iwB != null) {
            this.iwB.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        nN(false);
    }

    public void clx() {
        nN(true);
    }

    public void nN(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hoU != null) {
            this.hoU.qZ(!z);
            ak cmH = cmH();
            if (cmH != null && cmH.sg() != null) {
                z2 = cmH.sg().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hoU.cmG();
                } else if (this.iwH) {
                    this.hoU.a(this.hHG, this.frk, this.hIq, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.iwB != null) {
            this.iwB.onPause();
        }
    }

    public void onDestroy() {
        if (this.fBv != null) {
            this.fBv.release();
        }
        if (this.fuT != null) {
            this.fuT.cancel();
        }
        if (this.fuU != null) {
            this.fuU.cancel();
        }
        b((f.e) null);
        if (this.isd != null) {
            this.isd.release();
        }
        if (this.iwB != null) {
            this.iwB.onDestroy();
        }
        if (this.iwE != null) {
            this.iwE.cancel();
        }
        if (this.iwF != null) {
            this.iwF.cancel();
        }
        if (this.hoU != null) {
            this.hoU.destroy();
        }
        cmJ();
        MessageManager.getInstance().unRegisterListener(this.hHn);
        MessageManager.getInstance().unRegisterListener(this.dMl);
    }

    private void cmJ() {
        if (this.VT != null) {
            this.VT.removeOnScrollListener(this.mScrollListener);
            this.VT.setOnTouchListener(null);
            this.VT.setRecyclerListener(null);
        }
        if (this.igg != null) {
            this.igg.a((a.InterfaceC0623a) null);
        }
        if (this.isd != null) {
            this.isd.a((f.d) null);
            this.isd.a((f.b) null);
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.iwz != null) {
            this.iwz.setOnClickListener(onClickListener);
        }
    }

    public View cmK() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cmL() {
        if (this.iwE == null) {
            this.iwE = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.iwE.setDuration(300L);
            this.iwE.setInterpolator(new AccelerateInterpolator());
            this.iwE.setFillAfter(true);
            this.iwE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iwz != null) {
                        SvgManager.baR().a(b.this.iwz, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iwG = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iwz.startAnimation(this.iwE);
    }

    public void cmM() {
        if (this.iwF == null) {
            this.iwF = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.iwF.setDuration(300L);
            this.iwF.setInterpolator(new AccelerateInterpolator());
            this.iwF.setFillAfter(true);
            this.iwF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iwz != null) {
                        SvgManager.baR().a(b.this.iwz, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iwG = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iwz.startAnimation(this.iwF);
    }

    public boolean cmN() {
        return this.iwG;
    }

    public void pa(boolean z) {
        this.iwG = z;
    }

    public void pb(boolean z) {
        if (this.iwz != null) {
            this.iwz.setVisibility(0);
            if (z) {
                SvgManager.baR().a(this.iwz, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                ao.setBackgroundResource(this.iwC, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.baR().a(this.iwz, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            ao.setBackgroundResource(this.iwC, R.color.cp_bg_line_h);
        }
    }

    public void cmO() {
        if (this.iwA != null) {
            this.iwA.setVisibility(0);
        }
    }

    public void GP(String str) {
        if (!StringUtils.isNull(str) && this.iwA != null) {
            this.iwA.setVisibility(0);
            this.iwA.setText(str);
        }
    }

    public void GQ(String str) {
        List<Integer> b = b(str, this.VT);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.VT.m(intValue, intValue2);
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
                    if (cVar.aTN() != null && cVar.aTN().getTid().equals(str)) {
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
