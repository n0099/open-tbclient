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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.a.a;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.a.c;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private BdTypeRecyclerView Op;
    private g djN;
    private PbListView dnN;
    private View dpq;
    private AlphaAnimation dpt;
    private AlphaAnimation dpu;
    private TextView ecw;
    private com.baidu.tieba.f.a fSh;
    private m fwJ;
    private com.baidu.tieba.homepage.personalize.bigday.a gcJ;
    private BigdaySwipeRefreshLayout gcS;
    private NEGFeedBackView.a ghI;
    private ImageView gib;
    private com.baidu.tieba.homepage.gamevideo.a.a gic;
    private GameVideoTitleBar gie;
    private boolean gif;
    private RotateAnimation gig;
    private RotateAnimation gih;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean gii = false;
    private boolean fwC = false;
    private int fvX = 0;
    private int dms = 0;
    private boolean mIsBackground = false;
    private boolean gij = true;
    h.d gik = new h.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.h.d
        public void es(boolean z) {
            b.this.bwz();
        }
    };
    h.b gil = new h.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            b.this.lm(true);
            if (b.this.fwJ != null && !b.this.mIsBackground && b.this.gij) {
                b.this.fwJ.c(b.this.fvX, b.this.dms, b.this.fwC, true);
            }
        }
    };
    private CustomMessageListener bEh = new CustomMessageListener(2921419) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.gic.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.gij) {
                        b.this.fwJ.c(b.this.fvX, b.this.dms, b.this.fwC, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener cmw = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.fSh != null) {
                b.this.fSh.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0305a eaj = new a.InterfaceC0305a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            b.this.fwC = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            b.this.fwC = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }
    };
    private CustomMessageListener fvQ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bwA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bwA = b.this.bwA()) != null && bwA.qP() != null) {
                    bwA.qP().b(new a.C0038a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.fwJ != null) {
                    b.this.fwJ.cn(view);
                }
                if (view.getTag() instanceof c) {
                    ((c) view.getTag()).bat().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Op)) {
                    b.this.aJx();
                }
                if (i == 0 && b.this.fwJ != null && b.this.gij) {
                    b.this.fwJ.a(b.this.fvX, b.this.dms, b.this.fwC, 1);
                    return;
                }
                return;
            }
            b.this.aJw();
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
            bH(i3, (i4 - i3) + 1);
        }

        public void bH(int i, int i2) {
            b.this.fvX = i;
            b.this.dms = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ghI = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gie = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Op = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Op.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.fSh = new com.baidu.tieba.f.a();
        this.fwJ = new m(this.mPageContext, this.Op);
        this.fwJ.yY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fwJ.setUniqueId(this.mBdUniqueId);
        this.gcS = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gcJ = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gcS.setProgressView(this.gcJ);
        int i = (int) (61.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gcS.setCustomDistances(i, i, i * 2);
        this.dnN = new PbListView(this.mPageContext.getPageActivity());
        this.dnN.nZ();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.dnN.akC();
        this.dnN.setTextSize(R.dimen.tbfontsize36);
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dnN.iT(R.color.cp_cont_e);
        this.dnN.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gic = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Op);
        this.gic.b(this.ghI);
        this.gic.setPageUniqueId(this.mBdUniqueId);
        this.dpq = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.gib = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.ecw = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.ecw.setText(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        akN();
    }

    public void init() {
        this.Op.addOnScrollListener(this.mScrollListener);
        this.Op.setOnTouchListener(this.cmw);
        this.Op.setRecyclerListener(this.mRecyclerListener);
        this.fSh.a(this.eaj);
        this.gcJ.a(this.gik);
        this.gcJ.a(this.gil);
        this.gcJ.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.bEh.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bEh);
        this.fvQ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.fvQ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.gcS.setRefreshing(true);
    }

    public void bwx() {
        if (this.Op != null) {
            this.Op.setSelection(0);
            aJx();
        }
    }

    public void b(h.e eVar) {
        this.gcS.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void aJw() {
        if (!this.gif) {
            this.gif = true;
            this.dpq.setVisibility(0);
            if (this.dpt == null) {
                this.dpt = new AlphaAnimation(0.0f, 1.0f);
                this.dpt.setFillAfter(true);
                this.dpt.setDuration(300L);
            }
            this.dpq.startAnimation(this.dpt);
        }
    }

    public void aJx() {
        if (this.gif) {
            if (this.dpu == null) {
                this.dpu = new AlphaAnimation(1.0f, 0.0f);
                this.dpu.setFillAfter(true);
                this.dpu.setDuration(300L);
                this.dpu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.dpq.setVisibility(8);
                        b.this.gif = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dpq.startAnimation(this.dpu);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Op != null) {
            this.Op.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.gcJ != null) {
            this.gcJ.setListPullRefreshListener(cVar);
        }
    }

    public void T(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.gic != null) {
            this.gic.setData(list);
        }
        bwy();
    }

    public void bwy() {
        if (this.fwJ != null && this.gij) {
            this.fwJ.c(this.fvX, this.dms, this.fwC, true);
        }
    }

    public void bwz() {
        if (this.fwJ != null) {
            this.fwJ.bwz();
        }
    }

    public void lm(boolean z) {
        this.gij = z;
    }

    public z bwA() {
        if (this.fwJ == null || this.fwJ.cev() == null || !(this.fwJ.cev().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fwJ.cev().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.gic != null) {
            return this.gic.getDataList();
        }
        return null;
    }

    public void bwB() {
        T(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.djN == null) {
                this.djN = new g(this.mPageContext.getPageActivity());
                this.djN.onChangeSkinType();
            }
            this.djN.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.djN == null) {
            return false;
        }
        return this.djN.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.djN != null) {
            this.djN.dettachView(this.mRootView);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        String string;
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.atK();
        this.mRefreshView.qN(null);
        if (j.kc()) {
            string = this.mPageContext.getResources().getString(R.string.load_error_new_tip);
        } else {
            string = this.mPageContext.getResources().getString(R.string.recommend_pb_no_net_text);
        }
        this.mRefreshView.setTitle(string);
        this.mRefreshView.kJ(j.kc() ? R.drawable.new_pic_emotion_08 : R.drawable.new_pic_emotion_09);
        this.mRefreshView.kM(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.atR();
        this.mRefreshView.kJ(R.drawable.new_pic_emotion_06);
        this.mRefreshView.qO(this.mPageContext.getString(R.string.game_video_no_data));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void aJj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void x(View.OnClickListener onClickListener) {
        if (this.dnN != null) {
            if (this.dnN.getView().getParent() == null) {
                this.Op.setNextPage(this.dnN);
            }
            this.dnN.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dnN.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.dnN.setOnClickListener(onClickListener);
            this.dnN.akG();
        }
    }

    public void aJf() {
        if (this.dnN != null) {
            if (this.dnN.getView().getParent() == null) {
                this.Op.setNextPage(this.dnN);
            }
            this.dnN.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dnN.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.dnN.setOnClickListener(null);
            this.dnN.akG();
        }
    }

    public void aJg() {
        if (this.dnN != null) {
            if (this.dnN.getView().getParent() == null) {
                this.Op.setNextPage(this.dnN);
            }
            this.dnN.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dnN.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.dnN.setOnClickListener(null);
            this.dnN.akF();
        }
    }

    public void tZ(int i) {
        if (this.gic != null) {
            this.gic.tZ(i);
        }
    }

    public void refreshListView() {
        if (this.gic != null) {
            this.gic.notifyDataSetChanged();
        }
    }

    public void akN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gib != null) {
            am.b(this.gib, (int) R.drawable.icon_more_administration_n, skinType);
        }
        if (this.djN != null) {
            this.djN.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.djN.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.ecw != null) {
            am.j(this.ecw, R.color.cp_cont_b);
        }
        if (this.gcJ != null) {
            this.gcJ.iV(skinType);
        }
        if (this.gic != null) {
            this.gic.notifyDataSetChanged();
        }
        am.k(this.gie, R.color.cp_bg_line_d);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        kc(false);
    }

    public void bvg() {
        kc(true);
    }

    public void kc(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.fwJ != null) {
            this.fwJ.nh(!z);
            z bwA = bwA();
            if (bwA != null && bwA.qP() != null) {
                z2 = bwA.qP().b(new a.C0038a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fwJ.bwz();
                } else if (this.gij) {
                    this.fwJ.c(this.fvX, this.dms, this.fwC, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.gic != null) {
            this.gic.onPause();
        }
    }

    public void onDestroy() {
        if (this.djN != null) {
            this.djN.release();
        }
        if (this.dpt != null) {
            this.dpt.cancel();
        }
        if (this.dpu != null) {
            this.dpu.cancel();
        }
        b((h.e) null);
        if (this.gcJ != null) {
            this.gcJ.release();
        }
        if (this.gic != null) {
            this.gic.onDestroy();
        }
        if (this.gig != null) {
            this.gig.cancel();
        }
        if (this.gih != null) {
            this.gih.cancel();
        }
        if (this.fwJ != null) {
            this.fwJ.destroy();
        }
        bwC();
        MessageManager.getInstance().unRegisterListener(this.fvQ);
        MessageManager.getInstance().unRegisterListener(this.bEh);
    }

    private void bwC() {
        if (this.Op != null) {
            this.Op.removeOnScrollListener(this.mScrollListener);
            this.Op.setOnTouchListener(null);
            this.Op.setRecyclerListener(null);
        }
        if (this.fSh != null) {
            this.fSh.a((a.InterfaceC0305a) null);
        }
        if (this.gcJ != null) {
            this.gcJ.a((h.d) null);
            this.gcJ.a((h.b) null);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.gib != null) {
            this.gib.setOnClickListener(onClickListener);
        }
    }

    public View bwD() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bwE() {
        if (this.gig == null) {
            this.gig = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.gig.setDuration(300L);
            this.gig.setInterpolator(new AccelerateInterpolator());
            this.gig.setFillAfter(true);
            this.gig.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gib != null) {
                        am.c(b.this.gib, (int) R.drawable.icon_more_administration_h);
                        b.this.gii = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gib.startAnimation(this.gig);
    }

    public void bwF() {
        if (this.gih == null) {
            this.gih = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.gih.setDuration(300L);
            this.gih.setInterpolator(new AccelerateInterpolator());
            this.gih.setFillAfter(true);
            this.gih.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gib != null) {
                        am.c(b.this.gib, (int) R.drawable.icon_more_administration_n);
                        b.this.gii = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gib.startAnimation(this.gih);
    }

    public boolean bwG() {
        return this.gii;
    }

    public void ln(boolean z) {
        this.gii = z;
    }

    public void lo(boolean z) {
        if (this.gib != null) {
            this.gib.setVisibility(0);
            if (z) {
                am.c(this.gib, (int) R.drawable.icon_more_administration_h);
            } else {
                am.c(this.gib, (int) R.drawable.icon_more_administration_n);
            }
        }
    }

    public void bwH() {
        if (this.ecw != null) {
            this.ecw.setVisibility(0);
        }
    }

    public void yg(String str) {
        if (!StringUtils.isNull(str) && this.ecw != null) {
            this.ecw.setVisibility(0);
            this.ecw.setText(str);
        }
    }

    public void yh(String str) {
        List<Integer> b = b(str, this.Op);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Op.t(intValue, intValue2);
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
                if (item instanceof com.baidu.tieba.card.data.c) {
                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) item;
                    if (cVar.acy() != null && cVar.acy().getTid().equals(str)) {
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
