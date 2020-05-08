package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeRecyclerView Vi;
    private BdSwipeRefreshLayout eRB;
    private View eRC;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a eRD;
    private InterfaceC0477a eRE;
    private AlphaAnimation eRF;
    private AlphaAnimation eRG;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int eRI = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.eRI != i) {
                this.eRI = i;
                if (this.eRI != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.blH();
                        return;
                    } else {
                        a.this.blG();
                        return;
                    }
                }
                a.this.blG();
            }
        }
    };
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0477a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        blD();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.eRC = this.mRootView.findViewById(R.id.divider_shadow);
        this.Vi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Vi.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Vi.setFadingEdgeLength(0);
        this.Vi.setOverScrollMode(2);
        this.Vi.addOnScrollListener(this.mOnScrollListener);
        this.Vi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.eRE != null) {
                    a.this.eRE.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (a.this.eRE != null) {
                    a.this.eRE.onListPullRefresh(z);
                }
            }
        });
        this.eRB = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.eRB.setProgressView(this.mPullView);
        this.eRD = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Vi.addAdapters(this.eRD.bly());
    }

    private void blD() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
        this.mNavigationBar.setCenterTextTitle(this.mTbPageContext.getResources().getString(R.string.live_tab_my_concern));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mTbPageContext != null && a.this.mTbPageContext.getPageActivity() != null) {
                    a.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public View blE() {
        return this.mContainer;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        am.setBackgroundColor(this.eRB, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Vi, R.color.cp_bg_line_d);
    }

    private boolean blF() {
        return this.eRC.getVisibility() == 0;
    }

    public void blG() {
        if (!blF()) {
            this.eRC.setVisibility(0);
            if (this.eRF == null) {
                this.eRF = new AlphaAnimation(0.0f, 1.0f);
                this.eRF.setFillAfter(true);
                this.eRF.setDuration(300L);
            }
            this.eRC.startAnimation(this.eRF);
        }
    }

    public void blH() {
        if (blF()) {
            if (this.eRG == null) {
                this.eRG = new AlphaAnimation(1.0f, 0.0f);
                this.eRG.setFillAfter(true);
                this.eRG.setDuration(300L);
                this.eRG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.eRC.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eRC.startAnimation(this.eRG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void it(boolean z) {
        if (!z) {
            this.eRB.setRefreshing(false);
        }
    }

    public void a(InterfaceC0477a interfaceC0477a) {
        this.eRE = interfaceC0477a;
    }

    public RelativeLayout blI() {
        return this.mContainer;
    }

    public void setData(List<com.baidu.adp.widget.ListView.m> list) {
        this.Vi.setData(list);
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Vi != null) {
            for (int count = this.Vi.getCount() - 1; count >= 0; count--) {
                com.baidu.adp.widget.ListView.m item = this.Vi.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Vi.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Vi.removeOnScrollListener(this.mOnScrollListener);
        this.Vi.setOnSrollToBottomListener(null);
        this.Vi.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
