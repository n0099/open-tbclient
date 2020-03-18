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
import com.baidu.tieba.homepage.personalize.a.f;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView BK;
    private PbListView elM;
    private View enZ;
    private AlphaAnimation eoc;
    private AlphaAnimation eod;
    private g euG;
    private com.baidu.tieba.f.a gNH;
    private com.baidu.tieba.homepage.personalize.bigday.a gYg;
    private BigdaySwipeRefreshLayout gYp;
    private m grz;
    private ImageView hcM;
    private TextView hcN;
    private com.baidu.tieba.homepage.gamevideo.a.a hcO;
    private GameVideoTitleBar hcP;
    private boolean hcQ;
    private RotateAnimation hcR;
    private RotateAnimation hcS;
    private NEGFeedBackView.a hct;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean hcT = false;
    private boolean grs = false;
    private int gqN = 0;
    private int eku = 0;
    private boolean mIsBackground = false;
    private boolean hcU = true;
    g.d hcV = new g.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            b.this.bOE();
        }
    };
    g.b hcW = new g.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.mJ(true);
            if (b.this.grz != null && !b.this.mIsBackground && b.this.hcU) {
                b.this.grz.a(b.this.gqN, b.this.eku, b.this.grs, true);
            }
        }
    };
    private CustomMessageListener cMx = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.hcO.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.hcU) {
                        b.this.grz.a(b.this.gqN, b.this.eku, b.this.grs, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener dsa = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.gNH != null) {
                b.this.gNH.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0499a fSv = new a.InterfaceC0499a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            b.this.grs = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            b.this.grs = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bB(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }
    };
    private CustomMessageListener gqF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOF;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOF = b.this.bOF()) != null && bOF.nk() != null) {
                    bOF.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.grz != null) {
                    b.this.grz.cl(view);
                }
                if (view.getTag() instanceof f) {
                    ((f) view.getTag()).bvQ().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.BK)) {
                    b.this.bcS();
                }
                if (i == 0 && b.this.grz != null && b.this.hcU) {
                    b.this.grz.a(b.this.gqN, b.this.eku, b.this.grs, 1);
                    return;
                }
                return;
            }
            b.this.bcR();
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
            bU(i3, (i4 - i3) + 1);
        }

        public void bU(int i, int i2) {
            b.this.gqN = i;
            b.this.eku = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hct = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hcP = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gNH = new com.baidu.tieba.f.a();
        this.grz = new m(this.mPageContext, this.BK);
        this.grz.Ay(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grz.setUniqueId(this.mBdUniqueId);
        this.gYp = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gYg = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gYp.setProgressView(this.gYg);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gYp.setCustomDistances(i, i, i * 2);
        this.elM = new PbListView(this.mPageContext.getPageActivity());
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize36);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elM.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hcO = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.BK);
        this.hcO.b(this.hct);
        this.hcO.setPageUniqueId(this.mBdUniqueId);
        this.enZ = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.hcM = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.hcN = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.hcN.setText(com.baidu.tbadk.core.sharedPref.b.aFH().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aHS();
    }

    public void init() {
        this.BK.addOnScrollListener(this.mScrollListener);
        this.BK.setOnTouchListener(this.dsa);
        this.BK.setRecyclerListener(this.mRecyclerListener);
        this.gNH.a(this.fSv);
        this.gYg.a(this.hcV);
        this.gYg.a(this.hcW);
        this.gYg.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cMx.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cMx);
        this.gqF.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gqF);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.gYp.setRefreshing(true);
    }

    public void bOC() {
        if (this.BK != null) {
            this.BK.setSelection(0);
            bcS();
        }
    }

    public void b(g.e eVar) {
        this.gYp.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bcR() {
        if (!this.hcQ) {
            this.hcQ = true;
            this.enZ.setVisibility(0);
            if (this.eoc == null) {
                this.eoc = new AlphaAnimation(0.0f, 1.0f);
                this.eoc.setFillAfter(true);
                this.eoc.setDuration(300L);
            }
            this.enZ.startAnimation(this.eoc);
        }
    }

    public void bcS() {
        if (this.hcQ) {
            if (this.eod == null) {
                this.eod = new AlphaAnimation(1.0f, 0.0f);
                this.eod.setFillAfter(true);
                this.eod.setDuration(300L);
                this.eod.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.enZ.setVisibility(8);
                        b.this.hcQ = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.enZ.startAnimation(this.eod);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.BK != null) {
            this.BK.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gYg != null) {
            this.gYg.setListPullRefreshListener(cVar);
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hcO != null) {
            this.hcO.setData(list);
        }
        bOD();
    }

    public void bOD() {
        if (this.grz != null && this.hcU) {
            this.grz.a(this.gqN, this.eku, this.grs, true);
        }
    }

    public void bOE() {
        if (this.grz != null) {
            this.grz.bOE();
        }
    }

    public void mJ(boolean z) {
        this.hcU = z;
    }

    public af bOF() {
        if (this.grz == null || this.grz.czc() == null || !(this.grz.czc().getTag() instanceof af)) {
            return null;
        }
        return (af) this.grz.czc().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.hcO != null) {
            return this.hcO.getDataList();
        }
        return null;
    }

    public void bOG() {
        av(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.euG == null) {
                this.euG = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.euG.aPY();
                this.euG.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.euG.onChangeSkinType();
            }
            this.euG.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.euG == null) {
            return false;
        }
        return this.euG.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mG(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mI(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mG(R.drawable.new_pic_emotion_03);
        this.mRefreshView.vy(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bcC() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.BK.setNextPage(this.elM);
            }
            this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elM.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.elM.setOnClickListener(onClickListener);
            this.elM.endLoadData();
        }
    }

    public void bcy() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.BK.setNextPage(this.elM);
            }
            this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elM.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.elM.setOnClickListener(null);
            this.elM.endLoadData();
        }
    }

    public void bcz() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.BK.setNextPage(this.elM);
            }
            this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elM.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.elM.setOnClickListener(null);
            this.elM.startLoadData();
        }
    }

    public void vs(int i) {
        if (this.hcO != null) {
            this.hcO.vs(i);
        }
    }

    public void wS() {
        if (this.hcO != null) {
            this.hcO.notifyDataSetChanged();
        }
    }

    public void aHS() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.hcM != null) {
            SvgManager.aGG().a(this.hcM, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.euG != null) {
            this.euG.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.euG.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hcN != null) {
            am.setViewTextColor(this.hcN, (int) R.color.cp_cont_b);
        }
        if (this.gYg != null) {
            this.gYg.changeSkin(skinType);
        }
        if (this.hcO != null) {
            this.hcO.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        lz(false);
    }

    public void bNu() {
        lz(true);
    }

    public void lz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.grz != null) {
            this.grz.oH(!z);
            af bOF = bOF();
            if (bOF != null && bOF.nk() != null) {
                z2 = bOF.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.grz.bOE();
                } else if (this.hcU) {
                    this.grz.a(this.gqN, this.eku, this.grs, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.hcO != null) {
            this.hcO.onPause();
        }
    }

    public void onDestroy() {
        if (this.euG != null) {
            this.euG.release();
        }
        if (this.eoc != null) {
            this.eoc.cancel();
        }
        if (this.eod != null) {
            this.eod.cancel();
        }
        b((g.e) null);
        if (this.gYg != null) {
            this.gYg.release();
        }
        if (this.hcO != null) {
            this.hcO.onDestroy();
        }
        if (this.hcR != null) {
            this.hcR.cancel();
        }
        if (this.hcS != null) {
            this.hcS.cancel();
        }
        if (this.grz != null) {
            this.grz.destroy();
        }
        bOH();
        MessageManager.getInstance().unRegisterListener(this.gqF);
        MessageManager.getInstance().unRegisterListener(this.cMx);
    }

    private void bOH() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mScrollListener);
            this.BK.setOnTouchListener(null);
            this.BK.setRecyclerListener(null);
        }
        if (this.gNH != null) {
            this.gNH.a((a.InterfaceC0499a) null);
        }
        if (this.gYg != null) {
            this.gYg.a((g.d) null);
            this.gYg.a((g.b) null);
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.hcM != null) {
            this.hcM.setOnClickListener(onClickListener);
        }
    }

    public View bOI() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bOJ() {
        if (this.hcR == null) {
            this.hcR = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.hcR.setDuration(300L);
            this.hcR.setInterpolator(new AccelerateInterpolator());
            this.hcR.setFillAfter(true);
            this.hcR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hcM != null) {
                        SvgManager.aGG().a(b.this.hcM, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hcT = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hcM.startAnimation(this.hcR);
    }

    public void bOK() {
        if (this.hcS == null) {
            this.hcS = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.hcS.setDuration(300L);
            this.hcS.setInterpolator(new AccelerateInterpolator());
            this.hcS.setFillAfter(true);
            this.hcS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hcM != null) {
                        SvgManager.aGG().a(b.this.hcM, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hcT = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hcM.startAnimation(this.hcS);
    }

    public boolean bOL() {
        return this.hcT;
    }

    public void mK(boolean z) {
        this.hcT = z;
    }

    public void mL(boolean z) {
        if (this.hcM != null) {
            this.hcM.setVisibility(0);
            if (z) {
                SvgManager.aGG().a(this.hcM, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.hcP, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aGG().a(this.hcM, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.hcP, R.color.cp_bg_line_h);
        }
    }

    public void bOM() {
        if (this.hcN != null) {
            this.hcN.setVisibility(0);
        }
    }

    public void Ch(String str) {
        if (!StringUtils.isNull(str) && this.hcN != null) {
            this.hcN.setVisibility(0);
            this.hcN.setText(str);
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
                    if (cVar.aAj() != null && cVar.aAj().getTid().equals(str)) {
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
