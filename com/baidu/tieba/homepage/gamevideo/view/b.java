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
    private PbListView gAi;
    private View gCD;
    private AlphaAnimation gCG;
    private AlphaAnimation gCH;
    private g gJn;
    private i iPi;
    private com.baidu.tieba.f.a jKG;
    private com.baidu.tieba.homepage.personalize.bigday.a jZQ;
    private BigdaySwipeRefreshLayout jZZ;
    private ImageView kfD;
    private TextView kfE;
    private com.baidu.tieba.homepage.gamevideo.a.a kfF;
    private GameVideoTitleBar kfG;
    private boolean kfH;
    private RotateAnimation kfI;
    private RotateAnimation kfJ;
    private NEGFeedBackView.a kfk;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean kfK = false;
    private boolean jja = false;
    private int jiq = 0;
    private int gyR = 0;
    private boolean mIsBackground = false;
    private boolean kfL = true;
    f.d kfM = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cQu();
        }
    };
    f.b kfN = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.se(true);
            if (b.this.iPi != null && !b.this.mIsBackground && b.this.kfL) {
                b.this.iPi.b(b.this.jiq, b.this.gyR, b.this.jja, true);
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
                    b.this.kfF.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.kfL) {
                        b.this.iPi.b(b.this.jiq, b.this.gyR, b.this.jja, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener bST = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jKG != null) {
                b.this.jKG.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0710a iFe = new a.InterfaceC0710a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            b.this.jja = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            b.this.jja = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }
    };
    private CustomMessageListener jhW = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cQv;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cQv = b.this.cQv()) != null && cQv.tj() != null) {
                    cQv.tj().b(new a.C0089a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iPi != null) {
                    b.this.iPi.dt(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).ctb().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.c(b.this.XW)) {
                    b.this.bRK();
                }
                if (i == 0 && b.this.iPi != null && b.this.kfL) {
                    b.this.iPi.a(b.this.jiq, b.this.gyR, b.this.jja, 1);
                    return;
                }
                return;
            }
            b.this.bRJ();
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
            cC(i4, (i3 - i4) + 1);
        }

        public void cC(int i, int i2) {
            b.this.jiq = i;
            b.this.gyR = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kfk = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.kfG = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.XW.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.XW.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jKG = new com.baidu.tieba.f.a();
        this.iPi = new i(this.mPageContext, this.XW);
        this.iPi.Hn(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iPi.setUniqueId(this.mBdUniqueId);
        this.jZZ = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jZQ = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jZZ.setProgressView(this.jZQ);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jZZ.setCustomDistances(i, i, i * 2);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize36);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.kfF = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.XW);
        this.kfF.b(this.kfk);
        this.kfF.setPageUniqueId(this.mBdUniqueId);
        this.gCD = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.kfD = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.kfE = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.kfE.setText(com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bup();
    }

    public void init() {
        this.XW.addOnScrollListener(this.mScrollListener);
        this.XW.setOnTouchListener(this.bST);
        this.XW.setRecyclerListener(this.mRecyclerListener);
        this.jKG.a(this.iFe);
        this.jZQ.a(this.kfM);
        this.jZQ.a(this.kfN);
        this.jZQ.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eKB.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eKB);
        this.jhW.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jhW);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jZZ.setRefreshing(true);
    }

    public void cQs() {
        if (this.XW != null) {
            this.XW.setSelection(0);
            bRK();
        }
    }

    public void b(f.e eVar) {
        this.jZZ.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bRJ() {
        if (!this.kfH) {
            this.kfH = true;
            this.gCD.setVisibility(0);
            if (this.gCG == null) {
                this.gCG = new AlphaAnimation(0.0f, 1.0f);
                this.gCG.setFillAfter(true);
                this.gCG.setDuration(300L);
            }
            this.gCD.startAnimation(this.gCG);
        }
    }

    public void bRK() {
        if (this.kfH) {
            if (this.gCH == null) {
                this.gCH = new AlphaAnimation(1.0f, 0.0f);
                this.gCH.setFillAfter(true);
                this.gCH.setDuration(300L);
                this.gCH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.gCD.setVisibility(8);
                        b.this.kfH = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gCD.startAnimation(this.gCH);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.XW != null) {
            this.XW.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jZQ != null) {
            this.jZQ.setListPullRefreshListener(cVar);
        }
    }

    public void bn(List<n> list) {
        if (this.kfF != null) {
            this.kfF.setData(list);
        }
        cQt();
    }

    public void cQt() {
        if (this.iPi != null && this.kfL) {
            this.iPi.b(this.jiq, this.gyR, this.jja, true);
        }
    }

    public void cQu() {
        if (this.iPi != null) {
            this.iPi.cQu();
        }
    }

    public void se(boolean z) {
        this.kfL = z;
    }

    public ThreadCardViewHolder cQv() {
        if (this.iPi == null || this.iPi.dzV() == null || !(this.iPi.dzV().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iPi.dzV().getTag();
    }

    public List<n> getDataList() {
        if (this.kfF != null) {
            return this.kfF.getDataList();
        }
        return null;
    }

    public void cQw() {
        bn(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gJn == null) {
                this.gJn = new g(this.mPageContext.getPageActivity());
                this.gJn.bCS();
                this.gJn.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gJn.onChangeSkinType();
            }
            this.gJn.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gJn == null) {
            return false;
        }
        return this.gJn.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.mRootView);
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
        this.mRefreshView.Dm(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.XW.setNextPage(this.gAi);
            }
            this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.gAi.setOnClickListener(onClickListener);
            this.gAi.endLoadData();
        }
    }

    public void bRq() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.XW.setNextPage(this.gAi);
            }
            this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.gAi.setOnClickListener(null);
            this.gAi.endLoadData();
        }
    }

    public void bRr() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.XW.setNextPage(this.gAi);
            }
            this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gAi.setOnClickListener(null);
            this.gAi.startLoadData();
        }
    }

    public void BN(int i) {
        if (this.kfF != null) {
            this.kfF.BN(i);
        }
    }

    public void Kx() {
        if (this.kfF != null) {
            this.kfF.notifyDataSetChanged();
        }
    }

    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.kfD != null) {
            SvgManager.bsR().a(this.kfD, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gJn != null) {
            this.gJn.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gJn.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.kfE != null) {
            ap.setViewTextColor(this.kfE, R.color.CAM_X0105);
        }
        if (this.jZQ != null) {
            this.jZQ.changeSkin(skinType);
        }
        if (this.kfF != null) {
            this.kfF.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        qJ(false);
    }

    public void cON() {
        qJ(true);
    }

    public void qJ(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iPi != null) {
            this.iPi.tN(!z);
            ThreadCardViewHolder cQv = cQv();
            if (cQv != null && cQv.tj() != null) {
                z2 = cQv.tj().b(new a.C0089a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iPi.cQu();
                } else if (this.kfL) {
                    this.iPi.b(this.jiq, this.gyR, this.jja, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.kfF != null) {
            this.kfF.onPause();
        }
    }

    public void onDestroy() {
        if (this.gJn != null) {
            this.gJn.release();
        }
        if (this.gCG != null) {
            this.gCG.cancel();
        }
        if (this.gCH != null) {
            this.gCH.cancel();
        }
        b((f.e) null);
        if (this.jZQ != null) {
            this.jZQ.release();
        }
        if (this.kfF != null) {
            this.kfF.onDestroy();
        }
        if (this.kfI != null) {
            this.kfI.cancel();
        }
        if (this.kfJ != null) {
            this.kfJ.cancel();
        }
        if (this.iPi != null) {
            this.iPi.destroy();
        }
        cQx();
        MessageManager.getInstance().unRegisterListener(this.jhW);
        MessageManager.getInstance().unRegisterListener(this.eKB);
    }

    private void cQx() {
        if (this.XW != null) {
            this.XW.removeOnScrollListener(this.mScrollListener);
            this.XW.setOnTouchListener(null);
            this.XW.setRecyclerListener(null);
        }
        if (this.jKG != null) {
            this.jKG.a((a.InterfaceC0710a) null);
        }
        if (this.jZQ != null) {
            this.jZQ.a((f.d) null);
            this.jZQ.a((f.b) null);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.kfD != null) {
            this.kfD.setOnClickListener(onClickListener);
        }
    }

    public View cQy() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cQz() {
        if (this.kfI == null) {
            this.kfI = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.kfI.setDuration(300L);
            this.kfI.setInterpolator(new AccelerateInterpolator());
            this.kfI.setFillAfter(true);
            this.kfI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.kfD != null) {
                        SvgManager.bsR().a(b.this.kfD, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.kfK = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.kfD.startAnimation(this.kfI);
    }

    public void cQA() {
        if (this.kfJ == null) {
            this.kfJ = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.kfJ.setDuration(300L);
            this.kfJ.setInterpolator(new AccelerateInterpolator());
            this.kfJ.setFillAfter(true);
            this.kfJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.kfD != null) {
                        SvgManager.bsR().a(b.this.kfD, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.kfK = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.kfD.startAnimation(this.kfJ);
    }

    public boolean cQB() {
        return this.kfK;
    }

    public void sf(boolean z) {
        this.kfK = z;
    }

    public void sg(boolean z) {
        if (this.kfD != null) {
            this.kfD.setVisibility(0);
            if (z) {
                SvgManager.bsR().a(this.kfD, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.kfG, R.color.CAM_X0201);
                return;
            }
            SvgManager.bsR().a(this.kfD, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.kfG, R.color.CAM_X0207);
        }
    }

    public void cQC() {
        if (this.kfE != null) {
            this.kfE.setVisibility(0);
        }
    }

    public void LW(String str) {
        if (!StringUtils.isNull(str) && this.kfE != null) {
            this.kfE.setVisibility(0);
            this.kfE.setText(str);
        }
    }

    public void LX(String str) {
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
