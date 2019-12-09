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
    private g dDz;
    private PbListView dvS;
    private View dxu;
    private AlphaAnimation dxx;
    private AlphaAnimation dxy;
    private com.baidu.tieba.f.a fSB;
    private m fwT;
    private com.baidu.tieba.homepage.personalize.bigday.a gdg;
    private BigdaySwipeRefreshLayout gdp;
    private ImageView giA;
    private TextView giB;
    private com.baidu.tieba.homepage.gamevideo.a.a giC;
    private GameVideoTitleBar giD;
    private boolean giE;
    private RotateAnimation giF;
    private RotateAnimation giG;
    private NEGFeedBackView.a gih;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private BdTypeRecyclerView yJ;
    private boolean giH = false;
    private boolean fwM = false;
    private int fwh = 0;
    private int duA = 0;
    private boolean mIsBackground = false;
    private boolean giI = true;
    h.d giJ = new h.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.h.d
        public void onListPullToRefresh(boolean z) {
            b.this.bup();
        }
    };
    h.b giK = new h.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.h.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.ld(true);
            if (b.this.fwT != null && !b.this.mIsBackground && b.this.giI) {
                b.this.fwT.c(b.this.fwh, b.this.duA, b.this.fwM, true);
            }
        }
    };
    private CustomMessageListener bVF = new CustomMessageListener(2921419) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.giC.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.giI) {
                        b.this.fwT.c(b.this.fwh, b.this.duA, b.this.fwM, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener czy = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.fSB != null) {
                b.this.fSB.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0400a eXk = new a.InterfaceC0400a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void t(int i, int i2) {
            b.this.fwM = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void u(int i, int i2) {
            b.this.fwM = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0400a
        public void v(int i, int i2) {
        }
    };
    private CustomMessageListener fwa = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            z buq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (buq = b.this.buq()) != null && buq.lV() != null) {
                    buq.lV().b(new a.C0044a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.fwT != null) {
                    b.this.fwT.ck(view);
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
                if (b.this.a(b.this.yJ)) {
                    b.this.aJz();
                }
                if (i == 0 && b.this.fwT != null && b.this.giI) {
                    b.this.fwT.a(b.this.fwh, b.this.duA, b.this.fwM, 1);
                    return;
                }
                return;
            }
            b.this.aJy();
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
            bB(i3, (i4 - i3) + 1);
        }

        public void bB(int i, int i2) {
            b.this.fwh = i;
            b.this.duA = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gih = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giD = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.yJ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.yJ.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.fSB = new com.baidu.tieba.f.a();
        this.fwT = new m(this.mPageContext, this.yJ);
        this.fwT.xF(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fwT.setUniqueId(this.mBdUniqueId);
        this.gdp = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gdg = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gdp.setProgressView(this.gdg);
        int i = (int) (61.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gdp.setCustomDistances(i, i, i * 2);
        this.dvS = new PbListView(this.mPageContext.getPageActivity());
        this.dvS.createView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.dvS.setLineGone();
        this.dvS.setTextSize(R.dimen.tbfontsize36);
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.giC = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.yJ);
        this.giC.b(this.gih);
        this.giC.setPageUniqueId(this.mBdUniqueId);
        this.dxu = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.giA = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.giB = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.giB.setText(com.baidu.tbadk.core.sharedPref.b.alP().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        anM();
    }

    public void init() {
        this.yJ.addOnScrollListener(this.mScrollListener);
        this.yJ.setOnTouchListener(this.czy);
        this.yJ.setRecyclerListener(this.mRecyclerListener);
        this.fSB.a(this.eXk);
        this.gdg.a(this.giJ);
        this.gdg.a(this.giK);
        this.gdg.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.bVF.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bVF);
        this.fwa.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.fwa);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.gdp.setRefreshing(true);
    }

    public void bun() {
        if (this.yJ != null) {
            this.yJ.setSelection(0);
            aJz();
        }
    }

    public void b(h.e eVar) {
        this.gdp.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void aJy() {
        if (!this.giE) {
            this.giE = true;
            this.dxu.setVisibility(0);
            if (this.dxx == null) {
                this.dxx = new AlphaAnimation(0.0f, 1.0f);
                this.dxx.setFillAfter(true);
                this.dxx.setDuration(300L);
            }
            this.dxu.startAnimation(this.dxx);
        }
    }

    public void aJz() {
        if (this.giE) {
            if (this.dxy == null) {
                this.dxy = new AlphaAnimation(1.0f, 0.0f);
                this.dxy.setFillAfter(true);
                this.dxy.setDuration(300L);
                this.dxy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.dxu.setVisibility(8);
                        b.this.giE = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dxu.startAnimation(this.dxy);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.yJ != null) {
            this.yJ.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.gdg != null) {
            this.gdg.setListPullRefreshListener(cVar);
        }
    }

    public void aq(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.giC != null) {
            this.giC.setData(list);
        }
        buo();
    }

    public void buo() {
        if (this.fwT != null && this.giI) {
            this.fwT.c(this.fwh, this.duA, this.fwM, true);
        }
    }

    public void bup() {
        if (this.fwT != null) {
            this.fwT.bup();
        }
    }

    public void ld(boolean z) {
        this.giI = z;
    }

    public z buq() {
        if (this.fwT == null || this.fwT.cck() == null || !(this.fwT.cck().getTag() instanceof z)) {
            return null;
        }
        return (z) this.fwT.cck().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.giC != null) {
            return this.giC.getDataList();
        }
        return null;
    }

    public void bur() {
        aq(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.dDz == null) {
                this.dDz = new g(this.mPageContext.getPageActivity());
                this.dDz.onChangeSkinType();
            }
            this.dDz.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.dDz == null) {
            return false;
        }
        return this.dDz.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this.mRootView);
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
        this.mRefreshView.jZ(j.isNetWorkAvailable() ? R.drawable.new_pic_emotion_08 : R.drawable.new_pic_emotion_09);
        this.mRefreshView.kb(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.jZ(R.drawable.new_pic_emotion_06);
        this.mRefreshView.pZ(this.mPageContext.getString(R.string.game_video_no_data));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void aJm() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.yJ.setNextPage(this.dvS);
            }
            this.dvS.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.dvS.setOnClickListener(onClickListener);
            this.dvS.endLoadData();
        }
    }

    public void aJi() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.yJ.setNextPage(this.dvS);
            }
            this.dvS.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.dvS.setOnClickListener(null);
            this.dvS.endLoadData();
        }
    }

    public void aJj() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.yJ.setNextPage(this.dvS);
            }
            this.dvS.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.dvS.setOnClickListener(null);
            this.dvS.startLoadData();
        }
    }

    public void sX(int i) {
        if (this.giC != null) {
            this.giC.sX(i);
        }
    }

    public void sZ() {
        if (this.giC != null) {
            this.giC.notifyDataSetChanged();
        }
    }

    public void anM() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.giA != null) {
            am.setImageResource(this.giA, R.drawable.icon_more_administration_n, skinType);
        }
        if (this.dDz != null) {
            this.dDz.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.dDz.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.giB != null) {
            am.setViewTextColor(this.giB, (int) R.color.cp_cont_b);
        }
        if (this.gdg != null) {
            this.gdg.changeSkin(skinType);
        }
        if (this.giC != null) {
            this.giC.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        jT(false);
    }

    public void bsX() {
        jT(true);
    }

    public void jT(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.fwT != null) {
            this.fwT.mY(!z);
            z buq = buq();
            if (buq != null && buq.lV() != null) {
                z2 = buq.lV().b(new a.C0044a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.fwT.bup();
                } else if (this.giI) {
                    this.fwT.c(this.fwh, this.duA, this.fwM, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.giC != null) {
            this.giC.onPause();
        }
    }

    public void onDestroy() {
        if (this.dDz != null) {
            this.dDz.release();
        }
        if (this.dxx != null) {
            this.dxx.cancel();
        }
        if (this.dxy != null) {
            this.dxy.cancel();
        }
        b((h.e) null);
        if (this.gdg != null) {
            this.gdg.release();
        }
        if (this.giC != null) {
            this.giC.onDestroy();
        }
        if (this.giF != null) {
            this.giF.cancel();
        }
        if (this.giG != null) {
            this.giG.cancel();
        }
        if (this.fwT != null) {
            this.fwT.destroy();
        }
        bus();
        MessageManager.getInstance().unRegisterListener(this.fwa);
        MessageManager.getInstance().unRegisterListener(this.bVF);
    }

    private void bus() {
        if (this.yJ != null) {
            this.yJ.removeOnScrollListener(this.mScrollListener);
            this.yJ.setOnTouchListener(null);
            this.yJ.setRecyclerListener(null);
        }
        if (this.fSB != null) {
            this.fSB.a((a.InterfaceC0400a) null);
        }
        if (this.gdg != null) {
            this.gdg.a((h.d) null);
            this.gdg.a((h.b) null);
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.giA != null) {
            this.giA.setOnClickListener(onClickListener);
        }
    }

    public View but() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void buu() {
        if (this.giF == null) {
            this.giF = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.giF.setDuration(300L);
            this.giF.setInterpolator(new AccelerateInterpolator());
            this.giF.setFillAfter(true);
            this.giF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.giA != null) {
                        am.setImageResource(b.this.giA, R.drawable.icon_more_administration_h);
                        b.this.giH = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.giA.startAnimation(this.giF);
    }

    public void buv() {
        if (this.giG == null) {
            this.giG = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.giG.setDuration(300L);
            this.giG.setInterpolator(new AccelerateInterpolator());
            this.giG.setFillAfter(true);
            this.giG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.giA != null) {
                        am.setImageResource(b.this.giA, R.drawable.icon_more_administration_n);
                        b.this.giH = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.giA.startAnimation(this.giG);
    }

    public boolean buw() {
        return this.giH;
    }

    public void le(boolean z) {
        this.giH = z;
    }

    public void lf(boolean z) {
        if (this.giA != null) {
            this.giA.setVisibility(0);
            if (z) {
                am.setImageResource(this.giA, R.drawable.icon_more_administration_h);
                am.setBackgroundResource(this.giD, R.color.cp_bg_line_d);
                return;
            }
            am.setImageResource(this.giA, R.drawable.icon_more_administration_n);
            am.setBackgroundResource(this.giD, R.color.cp_bg_line_h);
        }
    }

    public void bux() {
        if (this.giB != null) {
            this.giB.setVisibility(0);
        }
    }

    public void wY(String str) {
        if (!StringUtils.isNull(str) && this.giB != null) {
            this.giB.setVisibility(0);
            this.giB.setText(str);
        }
    }

    public void wZ(String str) {
        List<Integer> b = b(str, this.yJ);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.yJ.j(intValue, intValue2);
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
                    if (cVar.agG() != null && cVar.agG().getTid().equals(str)) {
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
