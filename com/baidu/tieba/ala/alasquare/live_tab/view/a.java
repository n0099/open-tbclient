package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private PbListView dvS;
    private LinearLayout dyA;
    private f dyB;
    private BdSwipeRefreshLayout dyC;
    private com.baidu.tieba.ala.alasquare.live_tab.a dyD;
    private com.baidu.tbadk.m.h dyE;
    private ViewGroup dyz;
    private Context mContext;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.i mPullView;
    private ViewGroup mRootView;
    private BdTypeRecyclerView yJ;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        private int dxA = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.dxA != i) {
                this.dxA = i;
                if (this.dxA == 1) {
                    a.this.gE(true);
                } else {
                    a.this.aJG();
                }
            }
        }
    };
    private CustomMessageListener bVF = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dyD != null) {
                        a.this.dyD.notifyDataSetChanged();
                    }
                }
            }, 500L);
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        initView();
    }

    public void init() {
        this.yJ.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.bVF.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bVF);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.dyz = (ViewGroup) this.mRootView.findViewById(R.id.root_container);
        this.dyA = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.dyC = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        ((FrameLayout.LayoutParams) this.dyz.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.mPageContext);
        this.dyC.setProgressView(this.mPullView);
        this.yJ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.yJ.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.yJ.setFadingEdgeLength(0);
        this.yJ.setOverScrollMode(2);
        this.dyD = new com.baidu.tieba.ala.alasquare.live_tab.a(this.mPageContext, this.yJ);
        this.dvS = new PbListView(this.mContext);
        this.dvS.createView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.dvS.setLineGone();
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        onChangeSkinType();
    }

    public ViewGroup aJE() {
        return this.mRootView;
    }

    public void setData(List<m> list) {
        this.dyD.setData(list);
    }

    public void reload() {
        this.yJ.setSelection(0);
        startPullRefresh();
        aJG();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.yJ != null) {
            this.yJ.setOnSrollToBottomListener(eVar);
        }
    }

    public void mg(int i) {
        this.yJ.setVisibility(i);
    }

    public void startPullRefresh() {
        this.dyC.setRefreshing(true);
    }

    public void aJF() {
        this.dyC.setRefreshing(false);
    }

    public void aJi() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.yJ.setNextPage(this.dvS);
            }
            this.dvS.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.dvS.endLoadData();
        }
    }

    public void aJj() {
        if (this.dvS != null) {
            if (this.dvS.getView().getParent() == null) {
                this.yJ.setNextPage(this.dvS);
            }
            this.dvS.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.dvS.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.dvS.startLoadData();
        }
    }

    public void hideLoadingView() {
        this.yJ.setNextPage(null);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(skinType);
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dvS.changeSkin(skinType);
        }
        if (this.dyD != null) {
            this.dyD.notifyDataSetChanged();
        }
        if (this.dyB != null) {
            this.dyB.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundColor(this.dyC, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.yJ, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.dyA, R.color.cp_bg_line_d);
    }

    public void destroy() {
        if (this.yJ != null) {
            this.yJ.setOnSrollToBottomListener(null);
            this.yJ.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bVF);
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void aJG() {
        if (a(this.yJ)) {
            gE(false);
        } else {
            gE(true);
        }
    }

    public void aJH() {
        this.dyA.setVisibility(0);
        if (this.dyB == null) {
            this.dyB = new f(this.mPageContext);
        }
        this.dyA.addView(this.dyB.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256)));
        if (this.dyE == null) {
            this.dyE = new com.baidu.tbadk.m.h(this.mContext, null);
        }
        this.dyE.hideRefreshButton();
        this.dyE.ka(R.drawable.new_pic_emotion_02);
        this.dyE.pZ(this.mContext.getResources().getString(R.string.live_tab_no_data_tip));
        this.dyA.addView(this.dyE.getAttachedView(), new LinearLayout.LayoutParams(-1, -1));
    }

    public void gE(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }
}
