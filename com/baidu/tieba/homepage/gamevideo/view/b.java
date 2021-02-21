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
import com.baidu.tbadk.core.util.ap;
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
    private BdTypeRecyclerView XW;
    private PbListView gAw;
    private View gCR;
    private AlphaAnimation gCU;
    private AlphaAnimation gCV;
    private g gJB;
    private i iPw;
    private com.baidu.tieba.f.a jKU;
    private com.baidu.tieba.homepage.personalize.bigday.a kae;
    private BigdaySwipeRefreshLayout kan;
    private ImageView kfR;
    private TextView kfS;
    private com.baidu.tieba.homepage.gamevideo.a.a kfT;
    private GameVideoTitleBar kfU;
    private boolean kfV;
    private RotateAnimation kfW;
    private RotateAnimation kfX;
    private NEGFeedBackView.a kfy;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean kfY = false;
    private boolean jjo = false;
    private int jiE = 0;
    private int gzf = 0;
    private boolean mIsBackground = false;
    private boolean kfZ = true;
    f.d kga = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cQB();
        }
    };
    f.b kgb = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.se(true);
            if (b.this.iPw != null && !b.this.mIsBackground && b.this.kfZ) {
                b.this.iPw.b(b.this.jiE, b.this.gzf, b.this.jjo, true);
            }
        }
    };
    private CustomMessageListener eKB = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.kfT.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.kfZ) {
                        b.this.iPw.b(b.this.jiE, b.this.gzf, b.this.jjo, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jKU != null) {
                b.this.jKU.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0711a iFs = new a.InterfaceC0711a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void G(int i, int i2) {
            b.this.jjo = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void H(int i, int i2) {
            b.this.jjo = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void ch(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0711a
        public void I(int i, int i2) {
        }
    };
    private CustomMessageListener jil = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cQC;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cQC = b.this.cQC()) != null && cQC.tj() != null) {
                    cQC.tj().b(new a.C0089a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iPw != null) {
                    b.this.iPw.dt(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).cti().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.c(b.this.XW)) {
                    b.this.bRR();
                }
                if (i == 0 && b.this.iPw != null && b.this.kfZ) {
                    b.this.iPw.a(b.this.jiE, b.this.gzf, b.this.jjo, 1);
                    return;
                }
                return;
            }
            b.this.bRQ();
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
            cD(i4, (i3 - i4) + 1);
        }

        public void cD(int i, int i2) {
            b.this.jiE = i;
            b.this.gzf = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kfy = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.kfU = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.XW.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.XW.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jKU = new com.baidu.tieba.f.a();
        this.iPw = new i(this.mPageContext, this.XW);
        this.iPw.Hn(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iPw.setUniqueId(this.mBdUniqueId);
        this.kan = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.kae = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.kan.setProgressView(this.kae);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.kan.setCustomDistances(i, i, i * 2);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize36);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.kfT = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.XW);
        this.kfT.b(this.kfy);
        this.kfT.setPageUniqueId(this.mBdUniqueId);
        this.gCR = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.kfR = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.kfS = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.kfS.setText(com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bup();
    }

    public void init() {
        this.XW.addOnScrollListener(this.mScrollListener);
        this.XW.setOnTouchListener(this.bST);
        this.XW.setRecyclerListener(this.mRecyclerListener);
        this.jKU.a(this.iFs);
        this.kae.a(this.kga);
        this.kae.a(this.kgb);
        this.kae.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eKB.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eKB);
        this.jil.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jil);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.kan.setRefreshing(true);
    }

    public void cQz() {
        if (this.XW != null) {
            this.XW.setSelection(0);
            bRR();
        }
    }

    public void b(f.e eVar) {
        this.kan.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bRQ() {
        if (!this.kfV) {
            this.kfV = true;
            this.gCR.setVisibility(0);
            if (this.gCU == null) {
                this.gCU = new AlphaAnimation(0.0f, 1.0f);
                this.gCU.setFillAfter(true);
                this.gCU.setDuration(300L);
            }
            this.gCR.startAnimation(this.gCU);
        }
    }

    public void bRR() {
        if (this.kfV) {
            if (this.gCV == null) {
                this.gCV = new AlphaAnimation(1.0f, 0.0f);
                this.gCV.setFillAfter(true);
                this.gCV.setDuration(300L);
                this.gCV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.gCR.setVisibility(8);
                        b.this.kfV = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gCR.startAnimation(this.gCV);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.XW != null) {
            this.XW.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.kae != null) {
            this.kae.setListPullRefreshListener(cVar);
        }
    }

    public void bn(List<n> list) {
        if (this.kfT != null) {
            this.kfT.setData(list);
        }
        cQA();
    }

    public void cQA() {
        if (this.iPw != null && this.kfZ) {
            this.iPw.b(this.jiE, this.gzf, this.jjo, true);
        }
    }

    public void cQB() {
        if (this.iPw != null) {
            this.iPw.cQB();
        }
    }

    public void se(boolean z) {
        this.kfZ = z;
    }

    public ThreadCardViewHolder cQC() {
        if (this.iPw == null || this.iPw.dAc() == null || !(this.iPw.dAc().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iPw.dAc().getTag();
    }

    public List<n> getDataList() {
        if (this.kfT != null) {
            return this.kfT.getDataList();
        }
        return null;
    }

    public void cQD() {
        bn(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gJB == null) {
                this.gJB = new g(this.mPageContext.getPageActivity());
                this.gJB.bCS();
                this.gJB.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gJB == null) {
            return false;
        }
        return this.gJB.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rp(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.rn(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Dk(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.gAw.setOnClickListener(onClickListener);
            this.gAw.endLoadData();
        }
    }

    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.gAw.setOnClickListener(null);
            this.gAw.endLoadData();
        }
    }

    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gAw.setOnClickListener(null);
            this.gAw.startLoadData();
        }
    }

    public void BN(int i) {
        if (this.kfT != null) {
            this.kfT.BN(i);
        }
    }

    public void Kx() {
        if (this.kfT != null) {
            this.kfT.notifyDataSetChanged();
        }
    }

    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.kfR != null) {
            SvgManager.bsR().a(this.kfR, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gJB != null) {
            this.gJB.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gJB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.kfS != null) {
            ap.setViewTextColor(this.kfS, R.color.CAM_X0105);
        }
        if (this.kae != null) {
            this.kae.changeSkin(skinType);
        }
        if (this.kfT != null) {
            this.kfT.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        qJ(false);
    }

    public void cOU() {
        qJ(true);
    }

    public void qJ(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iPw != null) {
            this.iPw.tN(!z);
            ThreadCardViewHolder cQC = cQC();
            if (cQC != null && cQC.tj() != null) {
                z2 = cQC.tj().b(new a.C0089a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iPw.cQB();
                } else if (this.kfZ) {
                    this.iPw.b(this.jiE, this.gzf, this.jjo, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.kfT != null) {
            this.kfT.onPause();
        }
    }

    public void onDestroy() {
        if (this.gJB != null) {
            this.gJB.release();
        }
        if (this.gCU != null) {
            this.gCU.cancel();
        }
        if (this.gCV != null) {
            this.gCV.cancel();
        }
        b((f.e) null);
        if (this.kae != null) {
            this.kae.release();
        }
        if (this.kfT != null) {
            this.kfT.onDestroy();
        }
        if (this.kfW != null) {
            this.kfW.cancel();
        }
        if (this.kfX != null) {
            this.kfX.cancel();
        }
        if (this.iPw != null) {
            this.iPw.destroy();
        }
        cQE();
        MessageManager.getInstance().unRegisterListener(this.jil);
        MessageManager.getInstance().unRegisterListener(this.eKB);
    }

    private void cQE() {
        if (this.XW != null) {
            this.XW.removeOnScrollListener(this.mScrollListener);
            this.XW.setOnTouchListener(null);
            this.XW.setRecyclerListener(null);
        }
        if (this.jKU != null) {
            this.jKU.a((a.InterfaceC0711a) null);
        }
        if (this.kae != null) {
            this.kae.a((f.d) null);
            this.kae.a((f.b) null);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.kfR != null) {
            this.kfR.setOnClickListener(onClickListener);
        }
    }

    public View cQF() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cQG() {
        if (this.kfW == null) {
            this.kfW = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.kfW.setDuration(300L);
            this.kfW.setInterpolator(new AccelerateInterpolator());
            this.kfW.setFillAfter(true);
            this.kfW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.kfR != null) {
                        SvgManager.bsR().a(b.this.kfR, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.kfY = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.kfR.startAnimation(this.kfW);
    }

    public void cQH() {
        if (this.kfX == null) {
            this.kfX = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.kfX.setDuration(300L);
            this.kfX.setInterpolator(new AccelerateInterpolator());
            this.kfX.setFillAfter(true);
            this.kfX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.kfR != null) {
                        SvgManager.bsR().a(b.this.kfR, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.kfY = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.kfR.startAnimation(this.kfX);
    }

    public boolean cQI() {
        return this.kfY;
    }

    public void sf(boolean z) {
        this.kfY = z;
    }

    public void sg(boolean z) {
        if (this.kfR != null) {
            this.kfR.setVisibility(0);
            if (z) {
                SvgManager.bsR().a(this.kfR, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.kfU, R.color.CAM_X0201);
                return;
            }
            SvgManager.bsR().a(this.kfR, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.kfU, R.color.CAM_X0207);
        }
    }

    public void cQJ() {
        if (this.kfS != null) {
            this.kfS.setVisibility(0);
        }
    }

    public void LX(String str) {
        if (!StringUtils.isNull(str) && this.kfS != null) {
            this.kfS.setVisibility(0);
            this.kfS.setText(str);
        }
    }

    public void LY(String str) {
        List<Integer> b2 = b(str, this.XW);
        int intValue = b2.get(0).intValue();
        int intValue2 = b2.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.XW.p(intValue, intValue2);
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
                    if (bVar.bln() != null && bVar.bln().getTid().equals(str)) {
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
