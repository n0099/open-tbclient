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
    private PbListView dwJ;
    private ViewGroup dzq;
    private LinearLayout dzr;
    private f dzs;
    private BdSwipeRefreshLayout dzt;
    private com.baidu.tieba.ala.alasquare.live_tab.a dzu;
    private com.baidu.tbadk.m.h dzv;
    private Context mContext;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.i mPullView;
    private ViewGroup mRootView;
    private BdTypeRecyclerView zj;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.1
        private int dyr = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.dyr != i) {
                this.dyr = i;
                if (this.dyr == 1) {
                    a.this.gE(true);
                } else {
                    a.this.aJI();
                }
            }
        }
    };
    private CustomMessageListener bWw = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.a.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dzu != null) {
                        a.this.dzu.notifyDataSetChanged();
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
        this.zj.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setTag(this.mPageContext.getUniqueId());
        this.bWw.setTag(this.mPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bWw);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.dzq = (ViewGroup) this.mRootView.findViewById(R.id.root_container);
        this.dzr = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.dzt = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        ((FrameLayout.LayoutParams) this.dzq.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.mPageContext);
        this.dzt.setProgressView(this.mPullView);
        this.zj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.zj.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.zj.setFadingEdgeLength(0);
        this.zj.setOverScrollMode(2);
        this.dzu = new com.baidu.tieba.ala.alasquare.live_tab.a(this.mPageContext, this.zj);
        this.dwJ = new PbListView(this.mContext);
        this.dwJ.createView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.dwJ.setLineGone();
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dwJ.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        onChangeSkinType();
    }

    public ViewGroup aJG() {
        return this.mRootView;
    }

    public void setData(List<m> list) {
        this.dzu.setData(list);
    }

    public void reload() {
        this.zj.setSelection(0);
        startPullRefresh();
        aJI();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.zj != null) {
            this.zj.setOnSrollToBottomListener(eVar);
        }
    }

    public void mh(int i) {
        this.zj.setVisibility(i);
    }

    public void startPullRefresh() {
        this.dzt.setRefreshing(true);
    }

    public void aJH() {
        this.dzt.setRefreshing(false);
    }

    public void aJk() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.zj.setNextPage(this.dwJ);
            }
            this.dwJ.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.list_no_more));
            this.dwJ.endLoadData();
        }
    }

    public void aJl() {
        if (this.dwJ != null) {
            if (this.dwJ.getView().getParent() == null) {
                this.zj.setNextPage(this.dwJ);
            }
            this.dwJ.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.dwJ.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.dwJ.startLoadData();
        }
    }

    public void hideLoadingView() {
        this.zj.setNextPage(null);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(skinType);
        }
        if (this.dwJ != null) {
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dwJ.changeSkin(skinType);
        }
        if (this.dzu != null) {
            this.dzu.notifyDataSetChanged();
        }
        if (this.dzs != null) {
            this.dzs.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
        am.setBackgroundColor(this.dzt, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.zj, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.dzr, R.color.cp_bg_line_d);
    }

    public void destroy() {
        if (this.zj != null) {
            this.zj.setOnSrollToBottomListener(null);
            this.zj.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        MessageManager.getInstance().unRegisterListener(this.bWw);
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void aJI() {
        if (a(this.zj)) {
            gE(false);
        } else {
            gE(true);
        }
    }

    public void aJJ() {
        this.dzr.setVisibility(0);
        if (this.dzs == null) {
            this.dzs = new f(this.mPageContext);
        }
        this.dzr.addView(this.dzs.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds256)));
        if (this.dzv == null) {
            this.dzv = new com.baidu.tbadk.m.h(this.mContext, null);
        }
        this.dzv.hideRefreshButton();
        this.dzv.kb(R.drawable.new_pic_emotion_02);
        this.dzv.pZ(this.mContext.getResources().getString(R.string.live_tab_no_data_tip));
        this.dzr.addView(this.dzv.getAttachedView(), new LinearLayout.LayoutParams(-1, -1));
    }

    public void gE(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }
}
