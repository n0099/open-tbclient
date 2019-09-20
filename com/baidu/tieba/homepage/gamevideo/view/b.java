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
    private BdTypeRecyclerView Oo;
    private g dly;
    private PbListView dpz;
    private View drb;
    private AlphaAnimation dre;
    private AlphaAnimation drf;
    private TextView eeg;
    private com.baidu.tieba.f.a fTY;
    private m fyw;
    private com.baidu.tieba.homepage.personalize.bigday.a geB;
    private BigdaySwipeRefreshLayout geK;
    private NEGFeedBackView.a gjB;
    private ImageView gjU;
    private com.baidu.tieba.homepage.gamevideo.a.a gjV;
    private GameVideoTitleBar gjW;
    private boolean gjX;
    private RotateAnimation gjY;
    private RotateAnimation gjZ;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean gka = false;
    private boolean fyp = false;
    private int fxK = 0;
    private int dof = 0;
    private boolean mIsBackground = false;
    private boolean gkb = true;
    h.d gkc = new h.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.h.d
        public void ev(boolean z) {
            b.this.bxn();
        }
    };
    h.b gkd = new h.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.h.b
        public void f(View view, boolean z) {
            b.this.lp(true);
            if (b.this.fyw != null && !b.this.mIsBackground && b.this.gkb) {
                b.this.fyw.c(b.this.fxK, b.this.dof, b.this.fyp, true);
            }
        }
    };
    private CustomMessageListener bEF = new CustomMessageListener(2921419) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.gjV.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.gkb) {
                        b.this.fyw.c(b.this.fxK, b.this.dof, b.this.fyp, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener cnr = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.fTY != null) {
                b.this.fTY.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0316a ebT = new a.InterfaceC0316a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aY(int i, int i2) {
            b.this.fyp = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aZ(int i, int i2) {
            b.this.fyp = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void ba(int i, int i2) {
        }
    };
    private CustomMessageListener fxD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bxo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bxo = b.this.bxo()) != null && bxo.qQ() != null) {
                    bxo.qQ().b(new a.C0038a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.fyw != null) {
                    b.this.fyw.cn(view);
                }
                if (view.getTag() instanceof c) {
                    ((c) view.getTag()).baX().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Oo)) {
                    b.this.aKb();
                }
                if (i == 0 && b.this.fyw != null && b.this.gkb) {
                    b.this.fyw.a(b.this.fxK, b.this.dof, b.this.fyp, 1);
                    return;
                }
                return;
            }
            b.this.aKa();
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
            b.this.fxK = i;
            b.this.dof = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gjB = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjW = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Oo = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Oo.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.fTY = new com.baidu.tieba.f.a();
        this.fyw = new m(this.mPageContext, this.Oo);
        this.fyw.zb(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fyw.setUniqueId(this.mBdUniqueId);
        this.geK = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.geB = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.geK.setProgressView(this.geB);
        int i = (int) (61.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.geK.setCustomDistances(i, i, i * 2);
        this.dpz = new PbListView(this.mPageContext.getPageActivity());
        this.dpz.nZ();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.dpz.akO();
        this.dpz.setTextSize(R.dimen.tbfontsize36);
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dpz.iW(R.color.cp_cont_e);
        this.dpz.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gjV = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Oo);
        this.gjV.b(this.gjB);
        this.gjV.setPageUniqueId(this.mBdUniqueId);
        this.drb = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.gjU = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.eeg = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.eeg.setText(com.baidu.tbadk.core.sharedPref.b.ahU().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        akZ();
    }

    public void init() {
        this.Oo.addOnScrollListener(this.mScrollListener);
        this.Oo.setOnTouchListener(this.cnr);
        this.Oo.setRecyclerListener(this.mRecyclerListener);
        this.fTY.a(this.ebT);
        this.geB.a(this.gkc);
        this.geB.a(this.gkd);
        this.geB.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.bEF.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bEF);
        this.fxD.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.fxD);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.geK.setRefreshing(true);
    }

    public void bxl() {
        if (this.Oo != null) {
            this.Oo.setSelection(0);
            aKb();
        }
    }

    public void b(h.e eVar) {
        this.geK.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void aKa() {
        if (!this.gjX) {
            this.gjX = true;
            this.drb.setVisibility(0);
            if (this.dre == null) {
                this.dre = new AlphaAnimation(0.0f, 1.0f);
                this.dre.setFillAfter(true);
                this.dre.setDuration(300L);
            }
            this.drb.startAnimation(this.dre);
        }
    }

    public void aKb() {
        if (this.gjX) {
            if (this.drf == null) {
                this.drf = new AlphaAnimation(1.0f, 0.0f);
                this.drf.setFillAfter(true);
                this.drf.setDuration(300L);
                this.drf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.drb.setVisibility(8);
                        b.this.gjX = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.drb.startAnimation(this.drf);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Oo != null) {
            this.Oo.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.geB != null) {
            this.geB.setListPullRefreshListener(cVar);
        }
    }

    public void T(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.gjV != null) {
            this.gjV.setData(list);
        }
        bxm();
    }

    public void bxm() {
        if (this.fyw != null && this.gkb) {
            this.fyw.c(this.fxK, this.dof, this.fyp, true);
        }
    }

    public void bxn() {
        if (this.fyw != null) {
            this.fyw.bxn();
        }
    }

    public void lp(boolean z) {
        this.gkb = z;
    }

    public z bxo() {
        if (this.fyw == null || this.fyw.cfk() == null || !(this.fyw.cfk().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fyw.cfk().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.gjV != null) {
            return this.gjV.getDataList();
        }
        return null;
    }

    public void bxp() {
        T(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.dly == null) {
                this.dly = new g(this.mPageContext.getPageActivity());
                this.dly.onChangeSkinType();
            }
            this.dly.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.dly == null) {
            return false;
        }
        return this.dly.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this.mRootView);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        String string;
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.atW();
        this.mRefreshView.qY(null);
        if (j.kc()) {
            string = this.mPageContext.getResources().getString(R.string.load_error_new_tip);
        } else {
            string = this.mPageContext.getResources().getString(R.string.recommend_pb_no_net_text);
        }
        this.mRefreshView.setTitle(string);
        this.mRefreshView.kM(j.kc() ? R.drawable.new_pic_emotion_08 : R.drawable.new_pic_emotion_09);
        this.mRefreshView.kP(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.aud();
        this.mRefreshView.kM(R.drawable.new_pic_emotion_06);
        this.mRefreshView.qZ(this.mPageContext.getString(R.string.game_video_no_data));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void aJN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void x(View.OnClickListener onClickListener) {
        if (this.dpz != null) {
            if (this.dpz.getView().getParent() == null) {
                this.Oo.setNextPage(this.dpz);
            }
            this.dpz.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dpz.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.dpz.setOnClickListener(onClickListener);
            this.dpz.akS();
        }
    }

    public void aJJ() {
        if (this.dpz != null) {
            if (this.dpz.getView().getParent() == null) {
                this.Oo.setNextPage(this.dpz);
            }
            this.dpz.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dpz.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.dpz.setOnClickListener(null);
            this.dpz.akS();
        }
    }

    public void aJK() {
        if (this.dpz != null) {
            if (this.dpz.getView().getParent() == null) {
                this.Oo.setNextPage(this.dpz);
            }
            this.dpz.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dpz.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.dpz.setOnClickListener(null);
            this.dpz.akR();
        }
    }

    public void ud(int i) {
        if (this.gjV != null) {
            this.gjV.ud(i);
        }
    }

    public void refreshListView() {
        if (this.gjV != null) {
            this.gjV.notifyDataSetChanged();
        }
    }

    public void akZ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gjU != null) {
            am.b(this.gjU, (int) R.drawable.icon_more_administration_n, skinType);
        }
        if (this.dly != null) {
            this.dly.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.dly.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.eeg != null) {
            am.j(this.eeg, R.color.cp_cont_b);
        }
        if (this.geB != null) {
            this.geB.iY(skinType);
        }
        if (this.gjV != null) {
            this.gjV.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        kf(false);
    }

    public void bvU() {
        kf(true);
    }

    public void kf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.fyw != null) {
            this.fyw.nk(!z);
            z bxo = bxo();
            if (bxo != null && bxo.qQ() != null) {
                z2 = bxo.qQ().b(new a.C0038a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fyw.bxn();
                } else if (this.gkb) {
                    this.fyw.c(this.fxK, this.dof, this.fyp, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.gjV != null) {
            this.gjV.onPause();
        }
    }

    public void onDestroy() {
        if (this.dly != null) {
            this.dly.release();
        }
        if (this.dre != null) {
            this.dre.cancel();
        }
        if (this.drf != null) {
            this.drf.cancel();
        }
        b((h.e) null);
        if (this.geB != null) {
            this.geB.release();
        }
        if (this.gjV != null) {
            this.gjV.onDestroy();
        }
        if (this.gjY != null) {
            this.gjY.cancel();
        }
        if (this.gjZ != null) {
            this.gjZ.cancel();
        }
        if (this.fyw != null) {
            this.fyw.destroy();
        }
        bxq();
        MessageManager.getInstance().unRegisterListener(this.fxD);
        MessageManager.getInstance().unRegisterListener(this.bEF);
    }

    private void bxq() {
        if (this.Oo != null) {
            this.Oo.removeOnScrollListener(this.mScrollListener);
            this.Oo.setOnTouchListener(null);
            this.Oo.setRecyclerListener(null);
        }
        if (this.fTY != null) {
            this.fTY.a((a.InterfaceC0316a) null);
        }
        if (this.geB != null) {
            this.geB.a((h.d) null);
            this.geB.a((h.b) null);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.gjU != null) {
            this.gjU.setOnClickListener(onClickListener);
        }
    }

    public View bxr() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bxs() {
        if (this.gjY == null) {
            this.gjY = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.gjY.setDuration(300L);
            this.gjY.setInterpolator(new AccelerateInterpolator());
            this.gjY.setFillAfter(true);
            this.gjY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gjU != null) {
                        am.c(b.this.gjU, (int) R.drawable.icon_more_administration_h);
                        b.this.gka = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gjU.startAnimation(this.gjY);
    }

    public void bxt() {
        if (this.gjZ == null) {
            this.gjZ = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.gjZ.setDuration(300L);
            this.gjZ.setInterpolator(new AccelerateInterpolator());
            this.gjZ.setFillAfter(true);
            this.gjZ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gjU != null) {
                        am.c(b.this.gjU, (int) R.drawable.icon_more_administration_n);
                        b.this.gka = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gjU.startAnimation(this.gjZ);
    }

    public boolean bxu() {
        return this.gka;
    }

    public void lq(boolean z) {
        this.gka = z;
    }

    public void lr(boolean z) {
        if (this.gjU != null) {
            this.gjU.setVisibility(0);
            if (z) {
                am.c(this.gjU, (int) R.drawable.icon_more_administration_h);
                am.k(this.gjW, R.color.cp_bg_line_d);
                return;
            }
            am.c(this.gjU, (int) R.drawable.icon_more_administration_n);
            am.k(this.gjW, R.color.cp_bg_line_h);
        }
    }

    public void bxv() {
        if (this.eeg != null) {
            this.eeg.setVisibility(0);
        }
    }

    public void yF(String str) {
        if (!StringUtils.isNull(str) && this.eeg != null) {
            this.eeg.setVisibility(0);
            this.eeg.setText(str);
        }
    }

    public void yG(String str) {
        List<Integer> b = b(str, this.Oo);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Oo.t(intValue, intValue2);
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
                    if (cVar.acC() != null && cVar.acC().getTid().equals(str)) {
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
