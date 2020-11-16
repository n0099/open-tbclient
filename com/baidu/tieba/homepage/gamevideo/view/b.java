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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.g.a;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private BdTypeRecyclerView Xi;
    private PbListView giV;
    private View glq;
    private AlphaAnimation glt;
    private AlphaAnimation glu;
    private g grV;
    private i irb;
    private ImageView jBO;
    private TextView jBP;
    private com.baidu.tieba.homepage.gamevideo.a.a jBQ;
    private GameVideoTitleBar jBR;
    private boolean jBS;
    private RotateAnimation jBT;
    private RotateAnimation jBU;
    private NEGFeedBackView.a jBv;
    private com.baidu.tieba.g.a jjH;
    private com.baidu.tieba.homepage.personalize.bigday.a jwf;
    private BigdaySwipeRefreshLayout jwo;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean jBV = false;
    private boolean iKT = false;
    private int iKj = 0;
    private int ghD = 0;
    private boolean mIsBackground = false;
    private boolean jBW = true;
    f.d jBX = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cJS();
        }
    };
    f.b jBY = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.qY(true);
            if (b.this.irb != null && !b.this.mIsBackground && b.this.jBW) {
                b.this.irb.a(b.this.iKj, b.this.ghD, b.this.iKT, true);
            }
        }
    };
    private CustomMessageListener ews = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.jBQ.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.jBW) {
                        b.this.irb.a(b.this.iKj, b.this.ghD, b.this.iKT, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener fyo = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jjH != null) {
                b.this.jjH.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0740a igS = new a.InterfaceC0740a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void H(int i, int i2) {
            b.this.iKT = false;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void I(int i, int i2) {
            b.this.iKT = true;
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void J(int i, int i2) {
        }
    };
    private CustomMessageListener iJR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cJT;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cJT = b.this.cJT()) != null && cJT.tW() != null) {
                    cJT.tW().b(new a.C0096a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.irb != null) {
                    b.this.irb.de(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).coz().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Xi)) {
                    b.this.bOK();
                }
                if (i == 0 && b.this.irb != null && b.this.jBW) {
                    b.this.irb.a(b.this.iKj, b.this.ghD, b.this.iKT, 1);
                    return;
                }
                return;
            }
            b.this.bOJ();
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
            cD(i3, (i4 - i3) + 1);
        }

        public void cD(int i, int i2) {
            b.this.iKj = i;
            b.this.ghD = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jBv = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jBR = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Xi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Xi.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jjH = new com.baidu.tieba.g.a();
        this.irb = new i(this.mPageContext, this.Xi);
        this.irb.HR(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.irb.setUniqueId(this.mBdUniqueId);
        this.jwo = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jwf = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jwo.setProgressView(this.jwf);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jwo.setCustomDistances(i, i, i * 2);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize36);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jBQ = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Xi);
        this.jBQ.b(this.jBv);
        this.jBQ.setPageUniqueId(this.mBdUniqueId);
        this.glq = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.jBO = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.jBP = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.jBP.setText(com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        brT();
    }

    public void init() {
        this.Xi.addOnScrollListener(this.mScrollListener);
        this.Xi.setOnTouchListener(this.fyo);
        this.Xi.setRecyclerListener(this.mRecyclerListener);
        this.jjH.a(this.igS);
        this.jwf.a(this.jBX);
        this.jwf.a(this.jBY);
        this.jwf.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.ews.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ews);
        this.iJR.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iJR);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jwo.setRefreshing(true);
    }

    public void cJQ() {
        if (this.Xi != null) {
            this.Xi.setSelection(0);
            bOK();
        }
    }

    public void b(f.e eVar) {
        this.jwo.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bOJ() {
        if (!this.jBS) {
            this.jBS = true;
            this.glq.setVisibility(0);
            if (this.glt == null) {
                this.glt = new AlphaAnimation(0.0f, 1.0f);
                this.glt.setFillAfter(true);
                this.glt.setDuration(300L);
            }
            this.glq.startAnimation(this.glt);
        }
    }

    public void bOK() {
        if (this.jBS) {
            if (this.glu == null) {
                this.glu = new AlphaAnimation(1.0f, 0.0f);
                this.glu.setFillAfter(true);
                this.glu.setDuration(300L);
                this.glu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.glq.setVisibility(8);
                        b.this.jBS = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.glq.startAnimation(this.glu);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Xi != null) {
            this.Xi.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jwf != null) {
            this.jwf.setListPullRefreshListener(cVar);
        }
    }

    public void bi(List<q> list) {
        if (this.jBQ != null) {
            this.jBQ.setData(list);
        }
        cJR();
    }

    public void cJR() {
        if (this.irb != null && this.jBW) {
            this.irb.a(this.iKj, this.ghD, this.iKT, true);
        }
    }

    public void cJS() {
        if (this.irb != null) {
            this.irb.cJS();
        }
    }

    public void qY(boolean z) {
        this.jBW = z;
    }

    public am cJT() {
        if (this.irb == null || this.irb.dww() == null || !(this.irb.dww().getTag() instanceof am)) {
            return null;
        }
        return (am) this.irb.dww().getTag();
    }

    public List<q> getDataList() {
        if (this.jBQ != null) {
            return this.jBQ.getDataList();
        }
        return null;
    }

    public void cJU() {
        bi(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.grV == null) {
                this.grV = new g(this.mPageContext.getPageActivity());
                this.grV.bAw();
                this.grV.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.grV.onChangeSkinType();
            }
            this.grV.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.grV == null) {
            return false;
        }
        return this.grV.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this.mRootView);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sb(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sd(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.sb(R.drawable.new_pic_emotion_03);
        this.mRefreshView.DC(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.giV.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.giV.setOnClickListener(onClickListener);
            this.giV.endLoadData();
        }
    }

    public void bOp() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.giV.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.giV.setOnClickListener(null);
            this.giV.endLoadData();
        }
    }

    public void bOq() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.giV.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.giV.setOnClickListener(null);
            this.giV.startLoadData();
        }
    }

    public void Cb(int i) {
        if (this.jBQ != null) {
            this.jBQ.Cb(i);
        }
    }

    public void Lq() {
        if (this.jBQ != null) {
            this.jBQ.notifyDataSetChanged();
        }
    }

    public void brT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.jBO != null) {
            SvgManager.bqB().a(this.jBO, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.grV != null) {
            this.grV.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.grV.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jBP != null) {
            ap.setViewTextColor(this.jBP, R.color.CAM_X0105);
        }
        if (this.jwf != null) {
            this.jwf.changeSkin(skinType);
        }
        if (this.jBQ != null) {
            this.jBQ.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        pI(false);
    }

    public void cIl() {
        pI(true);
    }

    public void pI(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.irb != null) {
            this.irb.ta(!z);
            am cJT = cJT();
            if (cJT != null && cJT.tW() != null) {
                z2 = cJT.tW().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.irb.cJS();
                } else if (this.jBW) {
                    this.irb.a(this.iKj, this.ghD, this.iKT, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.jBQ != null) {
            this.jBQ.onPause();
        }
    }

    public void onDestroy() {
        if (this.grV != null) {
            this.grV.release();
        }
        if (this.glt != null) {
            this.glt.cancel();
        }
        if (this.glu != null) {
            this.glu.cancel();
        }
        b((f.e) null);
        if (this.jwf != null) {
            this.jwf.release();
        }
        if (this.jBQ != null) {
            this.jBQ.onDestroy();
        }
        if (this.jBT != null) {
            this.jBT.cancel();
        }
        if (this.jBU != null) {
            this.jBU.cancel();
        }
        if (this.irb != null) {
            this.irb.destroy();
        }
        cJV();
        MessageManager.getInstance().unRegisterListener(this.iJR);
        MessageManager.getInstance().unRegisterListener(this.ews);
    }

    private void cJV() {
        if (this.Xi != null) {
            this.Xi.removeOnScrollListener(this.mScrollListener);
            this.Xi.setOnTouchListener(null);
            this.Xi.setRecyclerListener(null);
        }
        if (this.jjH != null) {
            this.jjH.a((a.InterfaceC0740a) null);
        }
        if (this.jwf != null) {
            this.jwf.a((f.d) null);
            this.jwf.a((f.b) null);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jBO != null) {
            this.jBO.setOnClickListener(onClickListener);
        }
    }

    public View cJW() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cJX() {
        if (this.jBT == null) {
            this.jBT = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.jBT.setDuration(300L);
            this.jBT.setInterpolator(new AccelerateInterpolator());
            this.jBT.setFillAfter(true);
            this.jBT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jBO != null) {
                        SvgManager.bqB().a(b.this.jBO, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jBV = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jBO.startAnimation(this.jBT);
    }

    public void cJY() {
        if (this.jBU == null) {
            this.jBU = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.jBU.setDuration(300L);
            this.jBU.setInterpolator(new AccelerateInterpolator());
            this.jBU.setFillAfter(true);
            this.jBU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jBO != null) {
                        SvgManager.bqB().a(b.this.jBO, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jBV = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jBO.startAnimation(this.jBU);
    }

    public boolean cJZ() {
        return this.jBV;
    }

    public void qZ(boolean z) {
        this.jBV = z;
    }

    public void ra(boolean z) {
        if (this.jBO != null) {
            this.jBO.setVisibility(0);
            if (z) {
                SvgManager.bqB().a(this.jBO, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.jBR, R.color.CAM_X0201);
                return;
            }
            SvgManager.bqB().a(this.jBO, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.jBR, R.color.CAM_X0207);
        }
    }

    public void cKa() {
        if (this.jBP != null) {
            this.jBP.setVisibility(0);
        }
    }

    public void Ln(String str) {
        if (!StringUtils.isNull(str) && this.jBP != null) {
            this.jBP.setVisibility(0);
            this.jBP.setText(str);
        }
    }

    public void Lo(String str) {
        List<Integer> b = b(str, this.Xi);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Xi.o(intValue, intValue2);
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
                if (item instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
                    if (bVar.bjd() != null && bVar.bjd().getTid().equals(str)) {
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
