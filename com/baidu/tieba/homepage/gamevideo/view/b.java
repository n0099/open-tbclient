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
    private g djG;
    private PbListView dnG;
    private View dpj;
    private AlphaAnimation dpm;
    private AlphaAnimation dpn;
    private TextView ecp;
    private com.baidu.tieba.f.a fRt;
    private m fwk;
    private com.baidu.tieba.homepage.personalize.bigday.a gbT;
    private BigdaySwipeRefreshLayout gcc;
    private NEGFeedBackView.a ggS;
    private ImageView ghl;
    private com.baidu.tieba.homepage.gamevideo.a.a ghm;
    private GameVideoTitleBar ghn;
    private boolean gho;
    private RotateAnimation ghp;
    private RotateAnimation ghq;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean ghr = false;
    private boolean fwd = false;
    private int fvy = 0;
    private int dml = 0;
    private boolean mIsBackground = false;
    private boolean ghs = true;
    h.d ght = new h.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.h.d
        public void es(boolean z) {
            b.this.bwl();
        }
    };
    h.b ghu = new h.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            b.this.lm(true);
            if (b.this.fwk != null && !b.this.mIsBackground && b.this.ghs) {
                b.this.fwk.c(b.this.fvy, b.this.dml, b.this.fwd, true);
            }
        }
    };
    private CustomMessageListener bEg = new CustomMessageListener(2921419) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ghm.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.ghs) {
                        b.this.fwk.c(b.this.fvy, b.this.dml, b.this.fwd, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener cmp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.fRt != null) {
                b.this.fRt.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0299a eac = new a.InterfaceC0299a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0299a
        public void aY(int i, int i2) {
            b.this.fwd = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0299a
        public void aZ(int i, int i2) {
            b.this.fwd = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0299a
        public void ba(int i, int i2) {
        }
    };
    private CustomMessageListener fvr = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bwm;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bwm = b.this.bwm()) != null && bwm.qP() != null) {
                    bwm.qP().b(new a.C0038a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.fwk != null) {
                    b.this.fwk.cm(view);
                }
                if (view.getTag() instanceof c) {
                    ((c) view.getTag()).bar().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Op)) {
                    b.this.aJv();
                }
                if (i == 0 && b.this.fwk != null && b.this.ghs) {
                    b.this.fwk.a(b.this.fvy, b.this.dml, b.this.fwd, 1);
                    return;
                }
                return;
            }
            b.this.aJu();
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
            b.this.fvy = i;
            b.this.dml = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ggS = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ghn = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Op = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Op.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.fRt = new com.baidu.tieba.f.a();
        this.fwk = new m(this.mPageContext, this.Op);
        this.fwk.yW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fwk.setUniqueId(this.mBdUniqueId);
        this.gcc = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gbT = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gcc.setProgressView(this.gbT);
        int i = (int) (61.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gcc.setCustomDistances(i, i, i * 2);
        this.dnG = new PbListView(this.mPageContext.getPageActivity());
        this.dnG.nZ();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.dnG.akA();
        this.dnG.setTextSize(R.dimen.tbfontsize36);
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dnG.iT(R.color.cp_cont_e);
        this.dnG.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ghm = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Op);
        this.ghm.b(this.ggS);
        this.ghm.setPageUniqueId(this.mBdUniqueId);
        this.dpj = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.ghl = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.ecp = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.ecp.setText(com.baidu.tbadk.core.sharedPref.b.ahO().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        akL();
    }

    public void init() {
        this.Op.addOnScrollListener(this.mScrollListener);
        this.Op.setOnTouchListener(this.cmp);
        this.Op.setRecyclerListener(this.mRecyclerListener);
        this.fRt.a(this.eac);
        this.gbT.a(this.ght);
        this.gbT.a(this.ghu);
        this.gbT.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.bEg.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bEg);
        this.fvr.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.fvr);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.gcc.setRefreshing(true);
    }

    public void bwj() {
        if (this.Op != null) {
            this.Op.setSelection(0);
            aJv();
        }
    }

    public void b(h.e eVar) {
        this.gcc.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void aJu() {
        if (!this.gho) {
            this.gho = true;
            this.dpj.setVisibility(0);
            if (this.dpm == null) {
                this.dpm = new AlphaAnimation(0.0f, 1.0f);
                this.dpm.setFillAfter(true);
                this.dpm.setDuration(300L);
            }
            this.dpj.startAnimation(this.dpm);
        }
    }

    public void aJv() {
        if (this.gho) {
            if (this.dpn == null) {
                this.dpn = new AlphaAnimation(1.0f, 0.0f);
                this.dpn.setFillAfter(true);
                this.dpn.setDuration(300L);
                this.dpn.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.dpj.setVisibility(8);
                        b.this.gho = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dpj.startAnimation(this.dpn);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Op != null) {
            this.Op.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.gbT != null) {
            this.gbT.setListPullRefreshListener(cVar);
        }
    }

    public void T(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.ghm != null) {
            this.ghm.setData(list);
        }
        bwk();
    }

    public void bwk() {
        if (this.fwk != null && this.ghs) {
            this.fwk.c(this.fvy, this.dml, this.fwd, true);
        }
    }

    public void bwl() {
        if (this.fwk != null) {
            this.fwk.bwl();
        }
    }

    public void lm(boolean z) {
        this.ghs = z;
    }

    public z bwm() {
        if (this.fwk == null || this.fwk.ced() == null || !(this.fwk.ced().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fwk.ced().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.ghm != null) {
            return this.ghm.getDataList();
        }
        return null;
    }

    public void bwn() {
        T(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.djG == null) {
                this.djG = new g(this.mPageContext.getPageActivity());
                this.djG.onChangeSkinType();
            }
            this.djG.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.djG == null) {
            return false;
        }
        return this.djG.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this.mRootView);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        String string;
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.atI();
        this.mRefreshView.qN(null);
        if (j.kc()) {
            string = this.mPageContext.getResources().getString(R.string.load_error_new_tip);
        } else {
            string = this.mPageContext.getResources().getString(R.string.recommend_pb_no_net_text);
        }
        this.mRefreshView.setTitle(string);
        this.mRefreshView.kI(j.kc() ? R.drawable.new_pic_emotion_08 : R.drawable.new_pic_emotion_09);
        this.mRefreshView.kL(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.atP();
        this.mRefreshView.kI(R.drawable.new_pic_emotion_06);
        this.mRefreshView.qO(this.mPageContext.getString(R.string.game_video_no_data));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void aJh() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void x(View.OnClickListener onClickListener) {
        if (this.dnG != null) {
            if (this.dnG.getView().getParent() == null) {
                this.Op.setNextPage(this.dnG);
            }
            this.dnG.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dnG.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.dnG.setOnClickListener(onClickListener);
            this.dnG.akE();
        }
    }

    public void aJd() {
        if (this.dnG != null) {
            if (this.dnG.getView().getParent() == null) {
                this.Op.setNextPage(this.dnG);
            }
            this.dnG.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dnG.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.dnG.setOnClickListener(null);
            this.dnG.akE();
        }
    }

    public void aJe() {
        if (this.dnG != null) {
            if (this.dnG.getView().getParent() == null) {
                this.Op.setNextPage(this.dnG);
            }
            this.dnG.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dnG.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.dnG.setOnClickListener(null);
            this.dnG.akD();
        }
    }

    public void tX(int i) {
        if (this.ghm != null) {
            this.ghm.tX(i);
        }
    }

    public void refreshListView() {
        if (this.ghm != null) {
            this.ghm.notifyDataSetChanged();
        }
    }

    public void akL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.ghl != null) {
            am.b(this.ghl, (int) R.drawable.icon_more_administration_n, skinType);
        }
        if (this.djG != null) {
            this.djG.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.djG.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.ecp != null) {
            am.j(this.ecp, R.color.cp_cont_b);
        }
        if (this.gbT != null) {
            this.gbT.iV(skinType);
        }
        if (this.ghm != null) {
            this.ghm.notifyDataSetChanged();
        }
        am.k(this.ghn, R.color.cp_bg_line_d);
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        kc(false);
    }

    public void buT() {
        kc(true);
    }

    public void kc(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.fwk != null) {
            this.fwk.nh(!z);
            z bwm = bwm();
            if (bwm != null && bwm.qP() != null) {
                z2 = bwm.qP().b(new a.C0038a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fwk.bwl();
                } else if (this.ghs) {
                    this.fwk.c(this.fvy, this.dml, this.fwd, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.ghm != null) {
            this.ghm.onPause();
        }
    }

    public void onDestroy() {
        if (this.djG != null) {
            this.djG.release();
        }
        if (this.dpm != null) {
            this.dpm.cancel();
        }
        if (this.dpn != null) {
            this.dpn.cancel();
        }
        b((h.e) null);
        if (this.gbT != null) {
            this.gbT.release();
        }
        if (this.ghm != null) {
            this.ghm.onDestroy();
        }
        if (this.ghp != null) {
            this.ghp.cancel();
        }
        if (this.ghq != null) {
            this.ghq.cancel();
        }
        if (this.fwk != null) {
            this.fwk.destroy();
        }
        bwo();
        MessageManager.getInstance().unRegisterListener(this.fvr);
        MessageManager.getInstance().unRegisterListener(this.bEg);
    }

    private void bwo() {
        if (this.Op != null) {
            this.Op.removeOnScrollListener(this.mScrollListener);
            this.Op.setOnTouchListener(null);
            this.Op.setRecyclerListener(null);
        }
        if (this.fRt != null) {
            this.fRt.a((a.InterfaceC0299a) null);
        }
        if (this.gbT != null) {
            this.gbT.a((h.d) null);
            this.gbT.a((h.b) null);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.ghl != null) {
            this.ghl.setOnClickListener(onClickListener);
        }
    }

    public View bwp() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bwq() {
        if (this.ghp == null) {
            this.ghp = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.ghp.setDuration(300L);
            this.ghp.setInterpolator(new AccelerateInterpolator());
            this.ghp.setFillAfter(true);
            this.ghp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.ghl != null) {
                        am.c(b.this.ghl, (int) R.drawable.icon_more_administration_h);
                        b.this.ghr = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.ghl.startAnimation(this.ghp);
    }

    public void bwr() {
        if (this.ghq == null) {
            this.ghq = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.ghq.setDuration(300L);
            this.ghq.setInterpolator(new AccelerateInterpolator());
            this.ghq.setFillAfter(true);
            this.ghq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.ghl != null) {
                        am.c(b.this.ghl, (int) R.drawable.icon_more_administration_n);
                        b.this.ghr = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.ghl.startAnimation(this.ghq);
    }

    public boolean bws() {
        return this.ghr;
    }

    public void ln(boolean z) {
        this.ghr = z;
    }

    public void lo(boolean z) {
        if (this.ghl != null) {
            this.ghl.setVisibility(0);
            if (z) {
                am.c(this.ghl, (int) R.drawable.icon_more_administration_h);
            } else {
                am.c(this.ghl, (int) R.drawable.icon_more_administration_n);
            }
        }
    }

    public void bwt() {
        if (this.ecp != null) {
            this.ecp.setVisibility(0);
        }
    }

    public void yf(String str) {
        if (!StringUtils.isNull(str) && this.ecp != null) {
            this.ecp.setVisibility(0);
            this.ecp.setText(str);
        }
    }

    public void yg(String str) {
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
                    if (cVar.acx() != null && cVar.acx().getTid().equals(str)) {
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
