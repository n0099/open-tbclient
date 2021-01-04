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
    private BdTypeRecyclerView Yc;
    private PbListView gCf;
    private View gEA;
    private AlphaAnimation gED;
    private AlphaAnimation gEE;
    private g gLj;
    private i iOh;
    private com.baidu.tieba.f.a jJI;
    private com.baidu.tieba.homepage.personalize.bigday.a jWU;
    private BigdaySwipeRefreshLayout jXd;
    private ImageView kcG;
    private TextView kcH;
    private com.baidu.tieba.homepage.gamevideo.a.a kcI;
    private GameVideoTitleBar kcJ;
    private boolean kcK;
    private RotateAnimation kcL;
    private RotateAnimation kcM;
    private NEGFeedBackView.a kcn;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean kcN = false;
    private boolean jia = false;
    private int jhq = 0;
    private int gAO = 0;
    private boolean mIsBackground = false;
    private boolean kcO = true;
    f.d kcP = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cSo();
        }
    };
    f.b kcQ = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.rW(true);
            if (b.this.iOh != null && !b.this.mIsBackground && b.this.kcO) {
                b.this.iOh.b(b.this.jhq, b.this.gAO, b.this.jia, true);
            }
        }
    };
    private CustomMessageListener eNg = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.kcI.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.kcO) {
                        b.this.iOh.b(b.this.jhq, b.this.gAO, b.this.jia, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener bTP = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jJI != null) {
                b.this.jJI.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0727a iEb = new a.InterfaceC0727a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void G(int i, int i2) {
            b.this.jia = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void H(int i, int i2) {
            b.this.jia = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void I(int i, int i2) {
        }
    };
    private CustomMessageListener jgX = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cSp;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cSp = b.this.cSp()) != null && cSp.ty() != null) {
                    cSp.ty().b(new a.C0090a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iOh != null) {
                    b.this.iOh.dv(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).cvG().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.c(b.this.Yc)) {
                    b.this.bUY();
                }
                if (i == 0 && b.this.iOh != null && b.this.kcO) {
                    b.this.iOh.a(b.this.jhq, b.this.gAO, b.this.jia, 1);
                    return;
                }
                return;
            }
            b.this.bUX();
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
            b.this.jhq = i;
            b.this.gAO = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kcn = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.kcJ = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Yc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Yc.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Yc.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jJI = new com.baidu.tieba.f.a();
        this.iOh = new i(this.mPageContext, this.Yc);
        this.iOh.IC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iOh.setUniqueId(this.mBdUniqueId);
        this.jXd = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jWU = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jXd.setProgressView(this.jWU);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jXd.setCustomDistances(i, i, i * 2);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize36);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.kcI = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Yc);
        this.kcI.b(this.kcn);
        this.kcI.setPageUniqueId(this.mBdUniqueId);
        this.gEA = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.kcG = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.kcH = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.kcH.setText(com.baidu.tbadk.core.sharedPref.b.bvq().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bxO();
    }

    public void init() {
        this.Yc.addOnScrollListener(this.mScrollListener);
        this.Yc.setOnTouchListener(this.bTP);
        this.Yc.setRecyclerListener(this.mRecyclerListener);
        this.jJI.a(this.iEb);
        this.jWU.a(this.kcP);
        this.jWU.a(this.kcQ);
        this.jWU.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eNg.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eNg);
        this.jgX.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jgX);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jXd.setRefreshing(true);
    }

    public void cSm() {
        if (this.Yc != null) {
            this.Yc.setSelection(0);
            bUY();
        }
    }

    public void b(f.e eVar) {
        this.jXd.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bUX() {
        if (!this.kcK) {
            this.kcK = true;
            this.gEA.setVisibility(0);
            if (this.gED == null) {
                this.gED = new AlphaAnimation(0.0f, 1.0f);
                this.gED.setFillAfter(true);
                this.gED.setDuration(300L);
            }
            this.gEA.startAnimation(this.gED);
        }
    }

    public void bUY() {
        if (this.kcK) {
            if (this.gEE == null) {
                this.gEE = new AlphaAnimation(1.0f, 0.0f);
                this.gEE.setFillAfter(true);
                this.gEE.setDuration(300L);
                this.gEE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.gEA.setVisibility(8);
                        b.this.kcK = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gEA.startAnimation(this.gEE);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Yc != null) {
            this.Yc.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jWU != null) {
            this.jWU.setListPullRefreshListener(cVar);
        }
    }

    public void bs(List<n> list) {
        if (this.kcI != null) {
            this.kcI.setData(list);
        }
        cSn();
    }

    public void cSn() {
        if (this.iOh != null && this.kcO) {
            this.iOh.b(this.jhq, this.gAO, this.jia, true);
        }
    }

    public void cSo() {
        if (this.iOh != null) {
            this.iOh.cSo();
        }
    }

    public void rW(boolean z) {
        this.kcO = z;
    }

    public ThreadCardViewHolder cSp() {
        if (this.iOh == null || this.iOh.dBE() == null || !(this.iOh.dBE().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iOh.dBE().getTag();
    }

    public List<n> getDataList() {
        if (this.kcI != null) {
            return this.kcI.getDataList();
        }
        return null;
    }

    public void cSq() {
        bs(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gLj == null) {
                this.gLj = new g(this.mPageContext.getPageActivity());
                this.gLj.bGs();
                this.gLj.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gLj == null) {
            return false;
        }
        return this.gLj.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.mRootView);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sO(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sQ(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.sO(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Eh(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Zi() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.gCf.setOnClickListener(onClickListener);
            this.gCf.endLoadData();
        }
    }

    public void bUD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.gCf.setOnClickListener(null);
            this.gCf.endLoadData();
        }
    }

    public void bUE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gCf.setOnClickListener(null);
            this.gCf.startLoadData();
        }
    }

    public void De(int i) {
        if (this.kcI != null) {
            this.kcI.De(i);
        }
    }

    public void MU() {
        if (this.kcI != null) {
            this.kcI.notifyDataSetChanged();
        }
    }

    public void bxO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.kcG != null) {
            SvgManager.bwq().a(this.kcG, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gLj != null) {
            this.gLj.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gLj.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.kcH != null) {
            ao.setViewTextColor(this.kcH, R.color.CAM_X0105);
        }
        if (this.jWU != null) {
            this.jWU.changeSkin(skinType);
        }
        if (this.kcI != null) {
            this.kcI.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        qD(false);
    }

    public void cQH() {
        qD(true);
    }

    public void qD(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iOh != null) {
            this.iOh.tE(!z);
            ThreadCardViewHolder cSp = cSp();
            if (cSp != null && cSp.ty() != null) {
                z2 = cSp.ty().b(new a.C0090a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iOh.cSo();
                } else if (this.kcO) {
                    this.iOh.b(this.jhq, this.gAO, this.jia, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.kcI != null) {
            this.kcI.onPause();
        }
    }

    public void onDestroy() {
        if (this.gLj != null) {
            this.gLj.release();
        }
        if (this.gED != null) {
            this.gED.cancel();
        }
        if (this.gEE != null) {
            this.gEE.cancel();
        }
        b((f.e) null);
        if (this.jWU != null) {
            this.jWU.release();
        }
        if (this.kcI != null) {
            this.kcI.onDestroy();
        }
        if (this.kcL != null) {
            this.kcL.cancel();
        }
        if (this.kcM != null) {
            this.kcM.cancel();
        }
        if (this.iOh != null) {
            this.iOh.destroy();
        }
        cSr();
        MessageManager.getInstance().unRegisterListener(this.jgX);
        MessageManager.getInstance().unRegisterListener(this.eNg);
    }

    private void cSr() {
        if (this.Yc != null) {
            this.Yc.removeOnScrollListener(this.mScrollListener);
            this.Yc.setOnTouchListener(null);
            this.Yc.setRecyclerListener(null);
        }
        if (this.jJI != null) {
            this.jJI.a((a.InterfaceC0727a) null);
        }
        if (this.jWU != null) {
            this.jWU.a((f.d) null);
            this.jWU.a((f.b) null);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.kcG != null) {
            this.kcG.setOnClickListener(onClickListener);
        }
    }

    public View cSs() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cSt() {
        if (this.kcL == null) {
            this.kcL = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.kcL.setDuration(300L);
            this.kcL.setInterpolator(new AccelerateInterpolator());
            this.kcL.setFillAfter(true);
            this.kcL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.kcG != null) {
                        SvgManager.bwq().a(b.this.kcG, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.kcN = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.kcG.startAnimation(this.kcL);
    }

    public void cSu() {
        if (this.kcM == null) {
            this.kcM = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.kcM.setDuration(300L);
            this.kcM.setInterpolator(new AccelerateInterpolator());
            this.kcM.setFillAfter(true);
            this.kcM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.kcG != null) {
                        SvgManager.bwq().a(b.this.kcG, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.kcN = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.kcG.startAnimation(this.kcM);
    }

    public boolean cSv() {
        return this.kcN;
    }

    public void rX(boolean z) {
        this.kcN = z;
    }

    public void rY(boolean z) {
        if (this.kcG != null) {
            this.kcG.setVisibility(0);
            if (z) {
                SvgManager.bwq().a(this.kcG, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                ao.setBackgroundResource(this.kcJ, R.color.CAM_X0201);
                return;
            }
            SvgManager.bwq().a(this.kcG, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            ao.setBackgroundResource(this.kcJ, R.color.CAM_X0207);
        }
    }

    public void cSw() {
        if (this.kcH != null) {
            this.kcH.setVisibility(0);
        }
    }

    public void Mu(String str) {
        if (!StringUtils.isNull(str) && this.kcH != null) {
            this.kcH.setVisibility(0);
            this.kcH.setText(str);
        }
    }

    public void Mv(String str) {
        List<Integer> b2 = b(str, this.Yc);
        int intValue = b2.get(0).intValue();
        int intValue2 = b2.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Yc.p(intValue, intValue2);
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
                    if (bVar.boO() != null && bVar.boO().getTid().equals(str)) {
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
