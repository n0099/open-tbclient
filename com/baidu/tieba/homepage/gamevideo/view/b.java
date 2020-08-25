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
import com.baidu.card.al;
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
/* loaded from: classes16.dex */
public class b {
    private BdTypeRecyclerView Wu;
    private PbListView fDW;
    private View fGj;
    private AlphaAnimation fGm;
    private AlphaAnimation fGn;
    private g fMN;
    private i hBL;
    private BigdaySwipeRefreshLayout iGB;
    private com.baidu.tieba.homepage.personalize.bigday.a iGs;
    private ImageView iKO;
    private TextView iKP;
    private com.baidu.tieba.homepage.gamevideo.a.a iKQ;
    private GameVideoTitleBar iKR;
    private boolean iKS;
    private RotateAnimation iKT;
    private RotateAnimation iKU;
    private NEGFeedBackView.a iKv;
    private com.baidu.tieba.f.a iuk;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean iKV = false;
    private boolean hVG = false;
    private int hUW = 0;
    private int fCF = 0;
    private boolean mIsBackground = false;
    private boolean iKW = true;
    f.d iKX = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cxp();
        }
    };
    f.b iKY = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.pE(true);
            if (b.this.hBL != null && !b.this.mIsBackground && b.this.iKW) {
                b.this.hBL.a(b.this.hUW, b.this.fCF, b.this.hVG, true);
            }
        }
    };
    private CustomMessageListener dVu = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.iKQ.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.iKW) {
                        b.this.hBL.a(b.this.hUW, b.this.fCF, b.this.hVG, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener eVD = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.iuk != null) {
                b.this.iuk.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0674a hrz = new a.InterfaceC0674a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            b.this.hVG = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            b.this.hVG = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void bZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void J(int i, int i2) {
        }
    };
    private CustomMessageListener hUD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            al cxq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cxq = b.this.cxq()) != null && cxq.tR() != null) {
                    cxq.tR().b(new a.C0095a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.hBL != null) {
                    b.this.hBL.cE(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).ccE().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Wu)) {
                    b.this.bGm();
                }
                if (i == 0 && b.this.hBL != null && b.this.iKW) {
                    b.this.hBL.a(b.this.hUW, b.this.fCF, b.this.hVG, 1);
                    return;
                }
                return;
            }
            b.this.bGl();
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
            cw(i3, (i4 - i3) + 1);
        }

        public void cw(int i, int i2) {
            b.this.hUW = i;
            b.this.fCF = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iKv = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iKR = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.iuk = new com.baidu.tieba.f.a();
        this.hBL = new i(this.mPageContext, this.Wu);
        this.hBL.FG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hBL.setUniqueId(this.mBdUniqueId);
        this.iGB = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.iGs = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.iGB.setProgressView(this.iGs);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.iGB.setCustomDistances(i, i, i * 2);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize36);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iKQ = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Wu);
        this.iKQ.b(this.iKv);
        this.iKQ.setPageUniqueId(this.mBdUniqueId);
        this.fGj = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.iKO = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.iKP = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.iKP.setText(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bkF();
    }

    public void init() {
        this.Wu.addOnScrollListener(this.mScrollListener);
        this.Wu.setOnTouchListener(this.eVD);
        this.Wu.setRecyclerListener(this.mRecyclerListener);
        this.iuk.a(this.hrz);
        this.iGs.a(this.iKX);
        this.iGs.a(this.iKY);
        this.iGs.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dVu.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dVu);
        this.hUD.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hUD);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.iGB.setRefreshing(true);
    }

    public void cxn() {
        if (this.Wu != null) {
            this.Wu.setSelection(0);
            bGm();
        }
    }

    public void b(f.e eVar) {
        this.iGB.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bGl() {
        if (!this.iKS) {
            this.iKS = true;
            this.fGj.setVisibility(0);
            if (this.fGm == null) {
                this.fGm = new AlphaAnimation(0.0f, 1.0f);
                this.fGm.setFillAfter(true);
                this.fGm.setDuration(300L);
            }
            this.fGj.startAnimation(this.fGm);
        }
    }

    public void bGm() {
        if (this.iKS) {
            if (this.fGn == null) {
                this.fGn = new AlphaAnimation(1.0f, 0.0f);
                this.fGn.setFillAfter(true);
                this.fGn.setDuration(300L);
                this.fGn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.fGj.setVisibility(8);
                        b.this.iKS = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fGj.startAnimation(this.fGn);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Wu != null) {
            this.Wu.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.iGs != null) {
            this.iGs.setListPullRefreshListener(cVar);
        }
    }

    public void aK(List<q> list) {
        if (this.iKQ != null) {
            this.iKQ.setData(list);
        }
        cxo();
    }

    public void cxo() {
        if (this.hBL != null && this.iKW) {
            this.hBL.a(this.hUW, this.fCF, this.hVG, true);
        }
    }

    public void cxp() {
        if (this.hBL != null) {
            this.hBL.cxp();
        }
    }

    public void pE(boolean z) {
        this.iKW = z;
    }

    public al cxq() {
        if (this.hBL == null || this.hBL.djT() == null || !(this.hBL.djT().getTag() instanceof al)) {
            return null;
        }
        return (al) this.hBL.djT().getTag();
    }

    public List<q> getDataList() {
        if (this.iKQ != null) {
            return this.iKQ.getDataList();
        }
        return null;
    }

    public void cxr() {
        aK(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fMN == null) {
                this.fMN = new g(this.mPageContext.getPageActivity());
                this.fMN.bsZ();
                this.fMN.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.fMN.onChangeSkinType();
            }
            this.fMN.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fMN == null) {
            return false;
        }
        return this.fMN.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.qt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.qv(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.qt(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Cn(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Wu.setNextPage(this.fDW);
            }
            this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.fDW.setOnClickListener(onClickListener);
            this.fDW.endLoadData();
        }
    }

    public void bFR() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Wu.setNextPage(this.fDW);
            }
            this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.fDW.setOnClickListener(null);
            this.fDW.endLoadData();
        }
    }

    public void bFS() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Wu.setNextPage(this.fDW);
            }
            this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fDW.setOnClickListener(null);
            this.fDW.startLoadData();
        }
    }

    public void zQ(int i) {
        if (this.iKQ != null) {
            this.iKQ.zQ(i);
        }
    }

    public void Jw() {
        if (this.iKQ != null) {
            this.iKQ.notifyDataSetChanged();
        }
    }

    public void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.iKO != null) {
            SvgManager.bjq().a(this.iKO, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.fMN != null) {
            this.fMN.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fMN.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.iKP != null) {
            ap.setViewTextColor(this.iKP, R.color.cp_cont_b);
        }
        if (this.iGs != null) {
            this.iGs.changeSkin(skinType);
        }
        if (this.iKQ != null) {
            this.iKQ.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        or(false);
    }

    public void cwg() {
        or(true);
    }

    public void or(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hBL != null) {
            this.hBL.rF(!z);
            al cxq = cxq();
            if (cxq != null && cxq.tR() != null) {
                z2 = cxq.tR().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hBL.cxp();
                } else if (this.iKW) {
                    this.hBL.a(this.hUW, this.fCF, this.hVG, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.iKQ != null) {
            this.iKQ.onPause();
        }
    }

    public void onDestroy() {
        if (this.fMN != null) {
            this.fMN.release();
        }
        if (this.fGm != null) {
            this.fGm.cancel();
        }
        if (this.fGn != null) {
            this.fGn.cancel();
        }
        b((f.e) null);
        if (this.iGs != null) {
            this.iGs.release();
        }
        if (this.iKQ != null) {
            this.iKQ.onDestroy();
        }
        if (this.iKT != null) {
            this.iKT.cancel();
        }
        if (this.iKU != null) {
            this.iKU.cancel();
        }
        if (this.hBL != null) {
            this.hBL.destroy();
        }
        cxs();
        MessageManager.getInstance().unRegisterListener(this.hUD);
        MessageManager.getInstance().unRegisterListener(this.dVu);
    }

    private void cxs() {
        if (this.Wu != null) {
            this.Wu.removeOnScrollListener(this.mScrollListener);
            this.Wu.setOnTouchListener(null);
            this.Wu.setRecyclerListener(null);
        }
        if (this.iuk != null) {
            this.iuk.a((a.InterfaceC0674a) null);
        }
        if (this.iGs != null) {
            this.iGs.a((f.d) null);
            this.iGs.a((f.b) null);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.iKO != null) {
            this.iKO.setOnClickListener(onClickListener);
        }
    }

    public View cxt() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cxu() {
        if (this.iKT == null) {
            this.iKT = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.iKT.setDuration(300L);
            this.iKT.setInterpolator(new AccelerateInterpolator());
            this.iKT.setFillAfter(true);
            this.iKT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iKO != null) {
                        SvgManager.bjq().a(b.this.iKO, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iKV = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iKO.startAnimation(this.iKT);
    }

    public void cxv() {
        if (this.iKU == null) {
            this.iKU = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.iKU.setDuration(300L);
            this.iKU.setInterpolator(new AccelerateInterpolator());
            this.iKU.setFillAfter(true);
            this.iKU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.iKO != null) {
                        SvgManager.bjq().a(b.this.iKO, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.iKV = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.iKO.startAnimation(this.iKU);
    }

    public boolean cxw() {
        return this.iKV;
    }

    public void pF(boolean z) {
        this.iKV = z;
    }

    public void pG(boolean z) {
        if (this.iKO != null) {
            this.iKO.setVisibility(0);
            if (z) {
                SvgManager.bjq().a(this.iKO, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.iKR, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.bjq().a(this.iKO, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.iKR, R.color.cp_bg_line_h);
        }
    }

    public void cxx() {
        if (this.iKP != null) {
            this.iKP.setVisibility(0);
        }
    }

    public void JF(String str) {
        if (!StringUtils.isNull(str) && this.iKP != null) {
            this.iKP.setVisibility(0);
            this.iKP.setText(str);
        }
    }

    public void JG(String str) {
        List<Integer> b = b(str, this.Wu);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Wu.o(intValue, intValue2);
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
                    if (cVar.bce() != null && cVar.bce().getTid().equals(str)) {
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
