package com.baidu.tieba.homepage.gamevideo.view;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.adp.widget.ListView.n;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BdTypeRecyclerView Ya;
    private g gGD;
    private PbListView gxy;
    private View gzT;
    private AlphaAnimation gzW;
    private AlphaAnimation gzX;
    private i iJA;
    private com.baidu.tieba.f.a jFc;
    private com.baidu.tieba.homepage.personalize.bigday.a jSp;
    private BigdaySwipeRefreshLayout jSy;
    private NEGFeedBackView.a jXI;
    private ImageView jYb;
    private TextView jYc;
    private com.baidu.tieba.homepage.gamevideo.a.a jYd;
    private GameVideoTitleBar jYe;
    private boolean jYf;
    private RotateAnimation jYg;
    private RotateAnimation jYh;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean jYi = false;
    private boolean jdt = false;
    private int jcJ = 0;
    private int gwh = 0;
    private boolean mIsBackground = false;
    private boolean jYj = true;
    f.d jYk = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cOx();
        }
    };
    f.b jYl = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.rS(true);
            if (b.this.iJA != null && !b.this.mIsBackground && b.this.jYj) {
                b.this.iJA.b(b.this.jcJ, b.this.gwh, b.this.jdt, true);
            }
        }
    };
    private CustomMessageListener eIv = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.jYd.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.jYj) {
                        b.this.iJA.b(b.this.jcJ, b.this.gwh, b.this.jdt, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener bPd = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jFc != null) {
                b.this.jFc.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0710a izu = new a.InterfaceC0710a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            b.this.jdt = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            b.this.jdt = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }
    };
    private CustomMessageListener jcq = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cOy;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cOy = b.this.cOy()) != null && cOy.tm() != null) {
                    cOy.tm().b(new a.C0089a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iJA != null) {
                    b.this.iJA.dv(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).crP().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.c(b.this.Ya)) {
                    b.this.bRh();
                }
                if (i == 0 && b.this.iJA != null && b.this.jYj) {
                    b.this.iJA.a(b.this.jcJ, b.this.gwh, b.this.jdt, 1);
                    return;
                }
                return;
            }
            b.this.bRg();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
                i4 = 0;
            } else {
                int firstVisiblePosition = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i3 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
                i4 = firstVisiblePosition;
            }
            cF(i4, (i3 - i4) + 1);
        }

        public void cF(int i, int i2) {
            b.this.jcJ = i;
            b.this.gwh = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jXI = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jYe = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Ya = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Ya.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jFc = new com.baidu.tieba.f.a();
        this.iJA = new i(this.mPageContext, this.Ya);
        this.iJA.GV(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iJA.setUniqueId(this.mBdUniqueId);
        this.jSy = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jSp = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jSy.setProgressView(this.jSp);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jSy.setCustomDistances(i, i, i * 2);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize36);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jYd = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Ya);
        this.jYd.b(this.jXI);
        this.jYd.setPageUniqueId(this.mBdUniqueId);
        this.gzT = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.jYb = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.jYc = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.jYc.setText(com.baidu.tbadk.core.sharedPref.b.brx().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        btV();
    }

    public void init() {
        this.Ya.addOnScrollListener(this.mScrollListener);
        this.Ya.setOnTouchListener(this.bPd);
        this.Ya.setRecyclerListener(this.mRecyclerListener);
        this.jFc.a(this.izu);
        this.jSp.a(this.jYk);
        this.jSp.a(this.jYl);
        this.jSp.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eIv.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eIv);
        this.jcq.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jcq);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jSy.setRefreshing(true);
    }

    public void cOv() {
        if (this.Ya != null) {
            this.Ya.setSelection(0);
            bRh();
        }
    }

    public void b(f.e eVar) {
        this.jSy.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bRg() {
        if (!this.jYf) {
            this.jYf = true;
            this.gzT.setVisibility(0);
            if (this.gzW == null) {
                this.gzW = new AlphaAnimation(0.0f, 1.0f);
                this.gzW.setFillAfter(true);
                this.gzW.setDuration(300L);
            }
            this.gzT.startAnimation(this.gzW);
        }
    }

    public void bRh() {
        if (this.jYf) {
            if (this.gzX == null) {
                this.gzX = new AlphaAnimation(1.0f, 0.0f);
                this.gzX.setFillAfter(true);
                this.gzX.setDuration(300L);
                this.gzX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.gzT.setVisibility(8);
                        b.this.jYf = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gzT.startAnimation(this.gzX);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Ya != null) {
            this.Ya.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jSp != null) {
            this.jSp.setListPullRefreshListener(cVar);
        }
    }

    public void bs(List<n> list) {
        if (this.jYd != null) {
            this.jYd.setData(list);
        }
        cOw();
    }

    public void cOw() {
        if (this.iJA != null && this.jYj) {
            this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
        }
    }

    public void cOx() {
        if (this.iJA != null) {
            this.iJA.cOx();
        }
    }

    public void rS(boolean z) {
        this.jYj = z;
    }

    public ThreadCardViewHolder cOy() {
        if (this.iJA == null || this.iJA.dxN() == null || !(this.iJA.dxN().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iJA.dxN().getTag();
    }

    public List<n> getDataList() {
        if (this.jYd != null) {
            return this.jYd.getDataList();
        }
        return null;
    }

    public void cOz() {
        bs(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gGD == null) {
                this.gGD = new g(this.mPageContext.getPageActivity());
                this.gGD.bCA();
                this.gGD.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gGD == null) {
            return false;
        }
        return this.gGD.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.mRootView);
        }
    }

    public void n(View.OnClickListener onClickListener) {
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
        this.mRefreshView.CV(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.gxy.setOnClickListener(onClickListener);
            this.gxy.endLoadData();
        }
    }

    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.gxy.setOnClickListener(null);
            this.gxy.endLoadData();
        }
    }

    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gxy.setOnClickListener(null);
            this.gxy.startLoadData();
        }
    }

    public void Bx(int i) {
        if (this.jYd != null) {
            this.jYd.Bx(i);
        }
    }

    public void IZ() {
        if (this.jYd != null) {
            this.jYd.notifyDataSetChanged();
        }
    }

    public void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.jYb != null) {
            SvgManager.bsx().a(this.jYb, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gGD != null) {
            this.gGD.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gGD.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jYc != null) {
            ao.setViewTextColor(this.jYc, R.color.CAM_X0105);
        }
        if (this.jSp != null) {
            this.jSp.changeSkin(skinType);
        }
        if (this.jYd != null) {
            this.jYd.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        qz(false);
    }

    public void cMQ() {
        qz(true);
    }

    public void qz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iJA != null) {
            this.iJA.tA(!z);
            ThreadCardViewHolder cOy = cOy();
            if (cOy != null && cOy.tm() != null) {
                z2 = cOy.tm().b(new a.C0089a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iJA.cOx();
                } else if (this.jYj) {
                    this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.jYd != null) {
            this.jYd.onPause();
        }
    }

    public void onDestroy() {
        if (this.gGD != null) {
            this.gGD.release();
        }
        if (this.gzW != null) {
            this.gzW.cancel();
        }
        if (this.gzX != null) {
            this.gzX.cancel();
        }
        b((f.e) null);
        if (this.jSp != null) {
            this.jSp.release();
        }
        if (this.jYd != null) {
            this.jYd.onDestroy();
        }
        if (this.jYg != null) {
            this.jYg.cancel();
        }
        if (this.jYh != null) {
            this.jYh.cancel();
        }
        if (this.iJA != null) {
            this.iJA.destroy();
        }
        cOA();
        MessageManager.getInstance().unRegisterListener(this.jcq);
        MessageManager.getInstance().unRegisterListener(this.eIv);
    }

    private void cOA() {
        if (this.Ya != null) {
            this.Ya.removeOnScrollListener(this.mScrollListener);
            this.Ya.setOnTouchListener(null);
            this.Ya.setRecyclerListener(null);
        }
        if (this.jFc != null) {
            this.jFc.a((a.InterfaceC0710a) null);
        }
        if (this.jSp != null) {
            this.jSp.a((f.d) null);
            this.jSp.a((f.b) null);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.jYb != null) {
            this.jYb.setOnClickListener(onClickListener);
        }
    }

    public View cOB() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cOC() {
        if (this.jYg == null) {
            this.jYg = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.jYg.setDuration(300L);
            this.jYg.setInterpolator(new AccelerateInterpolator());
            this.jYg.setFillAfter(true);
            this.jYg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jYb != null) {
                        SvgManager.bsx().a(b.this.jYb, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jYi = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jYb.startAnimation(this.jYg);
    }

    public void cOD() {
        if (this.jYh == null) {
            this.jYh = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.jYh.setDuration(300L);
            this.jYh.setInterpolator(new AccelerateInterpolator());
            this.jYh.setFillAfter(true);
            this.jYh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jYb != null) {
                        SvgManager.bsx().a(b.this.jYb, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jYi = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jYb.startAnimation(this.jYh);
    }

    public boolean cOE() {
        return this.jYi;
    }

    public void rT(boolean z) {
        this.jYi = z;
    }

    public void rU(boolean z) {
        if (this.jYb != null) {
            this.jYb.setVisibility(0);
            if (z) {
                SvgManager.bsx().a(this.jYb, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                ao.setBackgroundResource(this.jYe, R.color.CAM_X0201);
                return;
            }
            SvgManager.bsx().a(this.jYb, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            ao.setBackgroundResource(this.jYe, R.color.CAM_X0207);
        }
    }

    public void cOF() {
        if (this.jYc != null) {
            this.jYc.setVisibility(0);
        }
    }

    public void Lm(String str) {
        if (!StringUtils.isNull(str) && this.jYc != null) {
            this.jYc.setVisibility(0);
            this.jYc.setText(str);
        }
    }

    public void Ln(String str) {
        List<Integer> b2 = b(str, this.Ya);
        int intValue = b2.get(0).intValue();
        int intValue2 = b2.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Ya.p(intValue, intValue2);
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = -1;
        ArrayList arrayList = new ArrayList(2);
        int i2 = 0;
        boolean z = false;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i2 < bdTypeRecyclerView.getCount()) {
                n item = bdTypeRecyclerView.getItem(i2);
                if (item instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
                    if (bVar.bkV() != null && bVar.bkV().getTid().equals(str)) {
                        if (!z) {
                            i4 = i2;
                        }
                        z = true;
                        i3 = i2;
                    }
                }
                i = i4;
                i2++;
            } else {
                arrayList.add(Integer.valueOf(i4));
                arrayList.add(Integer.valueOf(i3));
                return arrayList;
            }
        }
    }
}
