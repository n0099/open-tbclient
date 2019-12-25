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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Bn;
    private PbListView egU;
    private ViewGroup ejB;
    private LinearLayout ejC;
    private f ejD;
    private BdSwipeRefreshLayout ejE;
    private com.baidu.tieba.ala.alasquare.live_tab.a ejF;
    private com.baidu.tbadk.k.h ejG;
    private Context mContext;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        private int eiC = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.eiC != i) {
                this.eiC = i;
                if (this.eiC == 1) {
                    a.this.hJ(true);
                } else {
                    a.this.bae();
                }
            }
        }
    };
    private CustomMessageListener cHV = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ejF != null) {
                        a.this.ejF.notifyDataSetChanged();
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
        this.Bn.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.cHV.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.cHV);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.ejB = (ViewGroup) this.mRootView.findViewById(R.id.root_container);
        this.ejC = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.ejE = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        ((FrameLayout.LayoutParams) this.ejB.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mPageContext);
        this.ejE.setProgressView(this.mPullView);
        this.Bn = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Bn.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Bn.setFadingEdgeLength(0);
        this.Bn.setOverScrollMode(2);
        this.ejF = new com.baidu.tieba.ala.alasquare.live_tab.a(this.mPageContext, this.Bn);
        this.egU = new PbListView(this.mContext);
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        onChangeSkinType();
    }

    public ViewGroup bac() {
        return this.mRootView;
    }

    public void setData(List<m> list) {
        this.ejF.setData(list);
    }

    public void reload() {
        this.Bn.setSelection(0);
        startPullRefresh();
        bae();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Bn != null) {
            this.Bn.setOnSrollToBottomListener(eVar);
        }
    }

    public void op(int i) {
        this.Bn.setVisibility(i);
    }

    public void startPullRefresh() {
        this.ejE.setRefreshing(true);
    }

    public void bad() {
        this.ejE.setRefreshing(false);
    }

    public void aZG() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Bn.setNextPage(this.egU);
            }
            this.egU.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.egU.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.egU.endLoadData();
        }
    }

    public void aZH() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Bn.setNextPage(this.egU);
            }
            this.egU.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.egU.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.egU.startLoadData();
        }
    }

    public void hideLoadingView() {
        this.Bn.setNextPage(null);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(skinType);
        }
        if (this.egU != null) {
            this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
            this.egU.changeSkin(skinType);
        }
        if (this.ejF != null) {
            this.ejF.notifyDataSetChanged();
        }
        if (this.ejD != null) {
            this.ejD.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundColor(this.ejE, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Bn, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.ejC, R.color.cp_bg_line_d);
        if (this.ejG != null) {
            this.ejG.onChangeSkinType();
        }
    }

    public void destroy() {
        if (this.Bn != null) {
            this.Bn.setOnSrollToBottomListener(null);
            this.Bn.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        MessageManager.getInstance().unRegisterListener(this.cHV);
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bae() {
        if (a(this.Bn)) {
            hJ(false);
        } else {
            hJ(true);
        }
    }

    public void baf() {
        this.ejC.setVisibility(0);
        if (this.ejD == null) {
            this.ejD = new f(this.mPageContext);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.ejD.getView() != null && this.ejD.getView().getParent() == null) {
            this.ejC.addView(this.ejD.getView(), layoutParams);
        }
        if (this.ejG == null) {
            this.ejG = new com.baidu.tbadk.k.h(this.mContext, null);
        }
        this.ejG.hideRefreshButton();
        this.ejG.mn(R.drawable.new_pic_emotion_03);
        this.ejG.vc(this.mContext.getResources().getString(R.string.no_data_common_txt));
        this.ejG.onChangeSkinType();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        if (this.ejG.getAttachedView() != null && this.ejG.getAttachedView().getParent() == null) {
            this.ejC.addView(this.ejG.getAttachedView(), layoutParams2);
        }
    }

    public void hJ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    public void bag() {
        this.ejC.setVisibility(8);
    }
}
