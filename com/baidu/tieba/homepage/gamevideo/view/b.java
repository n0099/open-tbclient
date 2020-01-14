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
/* loaded from: classes7.dex */
public class b {
    private BdTypeRecyclerView Bs;
    private PbListView ehe;
    private View ejk;
    private AlphaAnimation ejn;
    private AlphaAnimation ejo;
    private g epL;
    private com.baidu.tieba.f.a gKp;
    private com.baidu.tieba.homepage.personalize.bigday.a gUK;
    private BigdaySwipeRefreshLayout gUT;
    private NEGFeedBackView.a gYX;
    private ImageView gZq;
    private TextView gZr;
    private com.baidu.tieba.homepage.gamevideo.a.a gZs;
    private GameVideoTitleBar gZt;
    private boolean gZu;
    private RotateAnimation gZv;
    private RotateAnimation gZw;
    private m goz;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean gZx = false;
    private boolean gos = false;
    private int gnN = 0;
    private int efM = 0;
    private boolean mIsBackground = false;
    private boolean gZy = true;
    g.d gZz = new g.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            b.this.bML();
        }
    };
    g.b gZA = new g.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.mB(true);
            if (b.this.goz != null && !b.this.mIsBackground && b.this.gZy) {
                b.this.goz.a(b.this.gnN, b.this.efM, b.this.gos, true);
            }
        }
    };
    private CustomMessageListener cIh = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.gZs.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.gZy) {
                        b.this.goz.a(b.this.gnN, b.this.efM, b.this.gos, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener dnp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.gKp != null) {
                b.this.gKp.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0492a fPc = new a.InterfaceC0492a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void y(int i, int i2) {
            b.this.gos = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void z(int i, int i2) {
            b.this.gos = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void bz(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0492a
        public void A(int i, int i2) {
        }
    };
    private CustomMessageListener gnF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bMM;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bMM = b.this.bMM()) != null && bMM.mU() != null) {
                    bMM.mU().b(new a.C0050a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.goz != null) {
                    b.this.goz.cl(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).bue().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Bs)) {
                    b.this.baw();
                }
                if (i == 0 && b.this.goz != null && b.this.gZy) {
                    b.this.goz.a(b.this.gnN, b.this.efM, b.this.gos, 1);
                    return;
                }
                return;
            }
            b.this.bav();
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
            bS(i3, (i4 - i3) + 1);
        }

        public void bS(int i, int i2) {
            b.this.gnN = i;
            b.this.efM = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gYX = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gZt = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Bs = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Bs.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gKp = new com.baidu.tieba.f.a();
        this.goz = new m(this.mPageContext, this.Bs);
        this.goz.Ah(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.goz.setUniqueId(this.mBdUniqueId);
        this.gUT = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gUK = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gUT.setProgressView(this.gUK);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gUT.setCustomDistances(i, i, i * 2);
        this.ehe = new PbListView(this.mPageContext.getPageActivity());
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize36);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gZs = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Bs);
        this.gZs.b(this.gYX);
        this.gZs.setPageUniqueId(this.mBdUniqueId);
        this.ejk = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.gZq = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.gZr = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.gZr.setText(com.baidu.tbadk.core.sharedPref.b.aDr().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aFw();
    }

    public void init() {
        this.Bs.addOnScrollListener(this.mScrollListener);
        this.Bs.setOnTouchListener(this.dnp);
        this.Bs.setRecyclerListener(this.mRecyclerListener);
        this.gKp.a(this.fPc);
        this.gUK.a(this.gZz);
        this.gUK.a(this.gZA);
        this.gUK.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cIh.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cIh);
        this.gnF.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gnF);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.gUT.setRefreshing(true);
    }

    public void bMJ() {
        if (this.Bs != null) {
            this.Bs.setSelection(0);
            baw();
        }
    }

    public void b(g.e eVar) {
        this.gUT.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bav() {
        if (!this.gZu) {
            this.gZu = true;
            this.ejk.setVisibility(0);
            if (this.ejn == null) {
                this.ejn = new AlphaAnimation(0.0f, 1.0f);
                this.ejn.setFillAfter(true);
                this.ejn.setDuration(300L);
            }
            this.ejk.startAnimation(this.ejn);
        }
    }

    public void baw() {
        if (this.gZu) {
            if (this.ejo == null) {
                this.ejo = new AlphaAnimation(1.0f, 0.0f);
                this.ejo.setFillAfter(true);
                this.ejo.setDuration(300L);
                this.ejo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.ejk.setVisibility(8);
                        b.this.gZu = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.ejk.startAnimation(this.ejo);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Bs != null) {
            this.Bs.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gUK != null) {
            this.gUK.setListPullRefreshListener(cVar);
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.gZs != null) {
            this.gZs.setData(list);
        }
        bMK();
    }

    public void bMK() {
        if (this.goz != null && this.gZy) {
            this.goz.a(this.gnN, this.efM, this.gos, true);
        }
    }

    public void bML() {
        if (this.goz != null) {
            this.goz.bML();
        }
    }

    public void mB(boolean z) {
        this.gZy = z;
    }

    public af bMM() {
        if (this.goz == null || this.goz.cxn() == null || !(this.goz.cxn().getTag() instanceof af)) {
            return null;
        }
        return (af) this.goz.cxn().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.gZs != null) {
            return this.gZs.getDataList();
        }
        return null;
    }

    public void bMN() {
        av(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.epL == null) {
                this.epL = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.epL.aNv();
                this.epL.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.epL.onChangeSkinType();
            }
            this.epL.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.epL == null) {
            return false;
        }
        return this.epL.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mp(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mn(R.drawable.new_pic_emotion_03);
        this.mRefreshView.vh(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void baf() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Bs.setNextPage(this.ehe);
            }
            this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.ehe.setOnClickListener(onClickListener);
            this.ehe.endLoadData();
        }
    }

    public void bab() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Bs.setNextPage(this.ehe);
            }
            this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.ehe.setOnClickListener(null);
            this.ehe.endLoadData();
        }
    }

    public void bac() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Bs.setNextPage(this.ehe);
            }
            this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.ehe.setOnClickListener(null);
            this.ehe.startLoadData();
        }
    }

    public void vf(int i) {
        if (this.gZs != null) {
            this.gZs.vf(i);
        }
    }

    public void vj() {
        if (this.gZs != null) {
            this.gZs.notifyDataSetChanged();
        }
    }

    public void aFw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gZq != null) {
            SvgManager.aEp().a(this.gZq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.epL != null) {
            this.epL.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.epL.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gZr != null) {
            am.setViewTextColor(this.gZr, (int) R.color.cp_cont_b);
        }
        if (this.gUK != null) {
            this.gUK.changeSkin(skinType);
        }
        if (this.gZs != null) {
            this.gZs.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        lq(false);
    }

    public void bLA() {
        lq(true);
    }

    public void lq(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.goz != null) {
            this.goz.oz(!z);
            af bMM = bMM();
            if (bMM != null && bMM.mU() != null) {
                z2 = bMM.mU().b(new a.C0050a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.goz.bML();
                } else if (this.gZy) {
                    this.goz.a(this.gnN, this.efM, this.gos, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.gZs != null) {
            this.gZs.onPause();
        }
    }

    public void onDestroy() {
        if (this.epL != null) {
            this.epL.release();
        }
        if (this.ejn != null) {
            this.ejn.cancel();
        }
        if (this.ejo != null) {
            this.ejo.cancel();
        }
        b((g.e) null);
        if (this.gUK != null) {
            this.gUK.release();
        }
        if (this.gZs != null) {
            this.gZs.onDestroy();
        }
        if (this.gZv != null) {
            this.gZv.cancel();
        }
        if (this.gZw != null) {
            this.gZw.cancel();
        }
        if (this.goz != null) {
            this.goz.destroy();
        }
        bMO();
        MessageManager.getInstance().unRegisterListener(this.gnF);
        MessageManager.getInstance().unRegisterListener(this.cIh);
    }

    private void bMO() {
        if (this.Bs != null) {
            this.Bs.removeOnScrollListener(this.mScrollListener);
            this.Bs.setOnTouchListener(null);
            this.Bs.setRecyclerListener(null);
        }
        if (this.gKp != null) {
            this.gKp.a((a.InterfaceC0492a) null);
        }
        if (this.gUK != null) {
            this.gUK.a((g.d) null);
            this.gUK.a((g.b) null);
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.gZq != null) {
            this.gZq.setOnClickListener(onClickListener);
        }
    }

    public View bMP() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bMQ() {
        if (this.gZv == null) {
            this.gZv = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.gZv.setDuration(300L);
            this.gZv.setInterpolator(new AccelerateInterpolator());
            this.gZv.setFillAfter(true);
            this.gZv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gZq != null) {
                        SvgManager.aEp().a(b.this.gZq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.gZx = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gZq.startAnimation(this.gZv);
    }

    public void bMR() {
        if (this.gZw == null) {
            this.gZw = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.gZw.setDuration(300L);
            this.gZw.setInterpolator(new AccelerateInterpolator());
            this.gZw.setFillAfter(true);
            this.gZw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gZq != null) {
                        SvgManager.aEp().a(b.this.gZq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.gZx = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gZq.startAnimation(this.gZw);
    }

    public boolean bMS() {
        return this.gZx;
    }

    public void mC(boolean z) {
        this.gZx = z;
    }

    public void mD(boolean z) {
        if (this.gZq != null) {
            this.gZq.setVisibility(0);
            if (z) {
                SvgManager.aEp().a(this.gZq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.gZt, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aEp().a(this.gZq, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.gZt, R.color.cp_bg_line_h);
        }
    }

    public void bMT() {
        if (this.gZr != null) {
            this.gZr.setVisibility(0);
        }
    }

    public void BR(String str) {
        if (!StringUtils.isNull(str) && this.gZr != null) {
            this.gZr.setVisibility(0);
            this.gZr.setText(str);
        }
    }

    public void BS(String str) {
        List<Integer> b = b(str, this.Bs);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Bs.l(intValue, intValue2);
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
                    if (cVar.axQ() != null && cVar.axQ().getTid().equals(str)) {
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
