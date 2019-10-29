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
    private g dEq;
    private PbListView dwJ;
    private View dyl;
    private AlphaAnimation dyo;
    private AlphaAnimation dyp;
    private com.baidu.tieba.f.a fTs;
    private m fxK;
    private com.baidu.tieba.homepage.personalize.bigday.a gdX;
    private BigdaySwipeRefreshLayout geg;
    private NEGFeedBackView.a giY;
    private ImageView gjr;
    private TextView gjs;
    private com.baidu.tieba.homepage.gamevideo.a.a gjt;
    private GameVideoTitleBar gju;
    private boolean gjv;
    private RotateAnimation gjw;
    private RotateAnimation gjx;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private BdTypeRecyclerView zj;
    private boolean gjy = false;
    private boolean fxD = false;
    private int fwY = 0;
    private int dvr = 0;
    private boolean mIsBackground = false;
    private boolean gjz = true;
    h.d gjA = new h.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.h.d
        public void onListPullToRefresh(boolean z) {
            b.this.bur();
        }
    };
    h.b gjB = new h.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.ld(true);
            if (b.this.fxK != null && !b.this.mIsBackground && b.this.gjz) {
                b.this.fxK.c(b.this.fwY, b.this.dvr, b.this.fxD, true);
            }
        }
    };
    private CustomMessageListener bWw = new CustomMessageListener(2921419) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.gjt.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.gjz) {
                        b.this.fxK.c(b.this.fwY, b.this.dvr, b.this.fxD, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener cAp = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.fTs != null) {
                b.this.fTs.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0405a eYb = new a.InterfaceC0405a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void v(int i, int i2) {
            b.this.fxD = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void w(int i, int i2) {
            b.this.fxD = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0405a
        public void x(int i, int i2) {
        }
    };
    private CustomMessageListener fwR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z bus;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bus = b.this.bus()) != null && bus.lV() != null) {
                    bus.lV().b(new a.C0044a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.fxK != null) {
                    b.this.fxK.ck(view);
                }
                if (view.getTag() instanceof c) {
                    ((c) view.getTag()).baZ().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.zj)) {
                    b.this.aJB();
                }
                if (i == 0 && b.this.fxK != null && b.this.gjz) {
                    b.this.fxK.a(b.this.fwY, b.this.dvr, b.this.fxD, 1);
                    return;
                }
                return;
            }
            b.this.aJA();
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
            bD(i3, (i4 - i3) + 1);
        }

        public void bD(int i, int i2) {
            b.this.fwY = i;
            b.this.dvr = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.giY = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gju = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.zj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.zj.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.fTs = new com.baidu.tieba.f.a();
        this.fxK = new m(this.mPageContext, this.zj);
        this.fxK.xG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fxK.setUniqueId(this.mBdUniqueId);
        this.geg = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gdX = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.geg.setProgressView(this.gdX);
        int i = (int) (61.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.geg.setCustomDistances(i, i, i * 2);
        this.dwJ = new PbListView(this.mPageContext.getPageActivity());
        this.dwJ.createView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.dwJ.setLineGone();
        this.dwJ.setTextSize(R.dimen.tbfontsize36);
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dwJ.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gjt = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.zj);
        this.gjt.b(this.giY);
        this.gjt.setPageUniqueId(this.mBdUniqueId);
        this.dyl = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.gjr = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.gjs = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.gjs.setText(com.baidu.tbadk.core.sharedPref.b.alR().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        anO();
    }

    public void init() {
        this.zj.addOnScrollListener(this.mScrollListener);
        this.zj.setOnTouchListener(this.cAp);
        this.zj.setRecyclerListener(this.mRecyclerListener);
        this.fTs.a(this.eYb);
        this.gdX.a(this.gjA);
        this.gdX.a(this.gjB);
        this.gdX.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.bWw.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bWw);
        this.fwR.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.fwR);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.geg.setRefreshing(true);
    }

    public void bup() {
        if (this.zj != null) {
            this.zj.setSelection(0);
            aJB();
        }
    }

    public void b(h.e eVar) {
        this.geg.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void aJA() {
        if (!this.gjv) {
            this.gjv = true;
            this.dyl.setVisibility(0);
            if (this.dyo == null) {
                this.dyo = new AlphaAnimation(0.0f, 1.0f);
                this.dyo.setFillAfter(true);
                this.dyo.setDuration(300L);
            }
            this.dyl.startAnimation(this.dyo);
        }
    }

    public void aJB() {
        if (this.gjv) {
            if (this.dyp == null) {
                this.dyp = new AlphaAnimation(1.0f, 0.0f);
                this.dyp.setFillAfter(true);
                this.dyp.setDuration(300L);
                this.dyp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.dyl.setVisibility(8);
                        b.this.gjv = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dyl.startAnimation(this.dyp);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.zj != null) {
            this.zj.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.gdX != null) {
            this.gdX.setListPullRefreshListener(cVar);
        }
    }

    public void aq(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.gjt != null) {
            this.gjt.setData(list);
        }
        buq();
    }

    public void buq() {
        if (this.fxK != null && this.gjz) {
            this.fxK.c(this.fwY, this.dvr, this.fxD, true);
        }
    }

    public void bur() {
        if (this.fxK != null) {
            this.fxK.bur();
        }
    }

    public void ld(boolean z) {
        this.gjz = z;
    }

    public z bus() {
        if (this.fxK == null || this.fxK.ccm() == null || !(this.fxK.ccm().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fxK.ccm().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.gjt != null) {
            return this.gjt.getDataList();
        }
        return null;
    }

    public void but() {
        aq(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.dEq == null) {
                this.dEq = new g(this.mPageContext.getPageActivity());
                this.dEq.onChangeSkinType();
            }
            this.dEq.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.dEq == null) {
            return false;
        }
        return this.dEq.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        String string;
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        if (j.isNetWorkAvailable()) {
            string = this.mPageContext.getResources().getString(R.string.load_error_new_tip);
        } else {
            string = this.mPageContext.getResources().getString(R.string.recommend_pb_no_net_text);
        }
        this.mRefreshView.setTitle(string);
        this.mRefreshView.ka(j.isNetWorkAvailable() ? R.drawable.new_pic_emotion_08 : R.drawable.new_pic_emotion_09);
        this.mRefreshView.kc(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.ka(R.drawable.new_pic_emotion_06);
        this.mRefreshView.pZ(this.mPageContext.getString(R.string.game_video_no_data));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void aJo() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.zj.setNextPage(this.dwJ);
            }
            this.dwJ.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.dwJ.setOnClickListener(onClickListener);
            this.dwJ.endLoadData();
        }
    }

    public void aJk() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.zj.setNextPage(this.dwJ);
            }
            this.dwJ.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.dwJ.setOnClickListener(null);
            this.dwJ.endLoadData();
        }
    }

    public void aJl() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.zj.setNextPage(this.dwJ);
            }
            this.dwJ.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.dwJ.setOnClickListener(null);
            this.dwJ.startLoadData();
        }
    }

    public void sY(int i) {
        if (this.gjt != null) {
            this.gjt.sY(i);
        }
    }

    public void sY() {
        if (this.gjt != null) {
            this.gjt.notifyDataSetChanged();
        }
    }

    public void anO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gjr != null) {
            am.setImageResource(this.gjr, R.drawable.icon_more_administration_n, skinType);
        }
        if (this.dEq != null) {
            this.dEq.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.dEq.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gjs != null) {
            am.setViewTextColor(this.gjs, (int) R.color.cp_cont_b);
        }
        if (this.gdX != null) {
            this.gdX.changeSkin(skinType);
        }
        if (this.gjt != null) {
            this.gjt.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        jT(false);
    }

    public void bsZ() {
        jT(true);
    }

    public void jT(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.fxK != null) {
            this.fxK.mY(!z);
            z bus = bus();
            if (bus != null && bus.lV() != null) {
                z2 = bus.lV().b(new a.C0044a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fxK.bur();
                } else if (this.gjz) {
                    this.fxK.c(this.fwY, this.dvr, this.fxD, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.gjt != null) {
            this.gjt.onPause();
        }
    }

    public void onDestroy() {
        if (this.dEq != null) {
            this.dEq.release();
        }
        if (this.dyo != null) {
            this.dyo.cancel();
        }
        if (this.dyp != null) {
            this.dyp.cancel();
        }
        b((h.e) null);
        if (this.gdX != null) {
            this.gdX.release();
        }
        if (this.gjt != null) {
            this.gjt.onDestroy();
        }
        if (this.gjw != null) {
            this.gjw.cancel();
        }
        if (this.gjx != null) {
            this.gjx.cancel();
        }
        if (this.fxK != null) {
            this.fxK.destroy();
        }
        buu();
        MessageManager.getInstance().unRegisterListener(this.fwR);
        MessageManager.getInstance().unRegisterListener(this.bWw);
    }

    private void buu() {
        if (this.zj != null) {
            this.zj.removeOnScrollListener(this.mScrollListener);
            this.zj.setOnTouchListener(null);
            this.zj.setRecyclerListener(null);
        }
        if (this.fTs != null) {
            this.fTs.a((a.InterfaceC0405a) null);
        }
        if (this.gdX != null) {
            this.gdX.a((h.d) null);
            this.gdX.a((h.b) null);
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.gjr != null) {
            this.gjr.setOnClickListener(onClickListener);
        }
    }

    public View buv() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void buw() {
        if (this.gjw == null) {
            this.gjw = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.gjw.setDuration(300L);
            this.gjw.setInterpolator(new AccelerateInterpolator());
            this.gjw.setFillAfter(true);
            this.gjw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gjr != null) {
                        am.setImageResource(b.this.gjr, R.drawable.icon_more_administration_h);
                        b.this.gjy = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gjr.startAnimation(this.gjw);
    }

    public void bux() {
        if (this.gjx == null) {
            this.gjx = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.gjx.setDuration(300L);
            this.gjx.setInterpolator(new AccelerateInterpolator());
            this.gjx.setFillAfter(true);
            this.gjx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gjr != null) {
                        am.setImageResource(b.this.gjr, R.drawable.icon_more_administration_n);
                        b.this.gjy = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gjr.startAnimation(this.gjx);
    }

    public boolean buy() {
        return this.gjy;
    }

    public void le(boolean z) {
        this.gjy = z;
    }

    public void lf(boolean z) {
        if (this.gjr != null) {
            this.gjr.setVisibility(0);
            if (z) {
                am.setImageResource(this.gjr, R.drawable.icon_more_administration_h);
                am.setBackgroundResource(this.gju, R.color.cp_bg_line_d);
                return;
            }
            am.setImageResource(this.gjr, R.drawable.icon_more_administration_n);
            am.setBackgroundResource(this.gju, R.color.cp_bg_line_h);
        }
    }

    public void buz() {
        if (this.gjs != null) {
            this.gjs.setVisibility(0);
        }
    }

    public void wY(String str) {
        if (!StringUtils.isNull(str) && this.gjs != null) {
            this.gjs.setVisibility(0);
            this.gjs.setText(str);
        }
    }

    public void wZ(String str) {
        List<Integer> b = b(str, this.zj);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.zj.l(intValue, intValue2);
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
                    if (cVar.agI() != null && cVar.agI().getTid().equals(str)) {
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
