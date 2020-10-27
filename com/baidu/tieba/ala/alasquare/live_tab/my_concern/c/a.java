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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Xe;
    private BdSwipeRefreshLayout gfT;
    private View gfU;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a gfV;
    private InterfaceC0618a gfW;
    private AlphaAnimation gfX;
    private AlphaAnimation gfY;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int gga = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.gga != i) {
                this.gga = i;
                if (this.gga != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bMR();
                        return;
                    } else {
                        a.this.bMQ();
                        return;
                    }
                }
                a.this.bMQ();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0618a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        bAw();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.gfU = this.mRootView.findViewById(R.id.divider_shadow);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        this.Xe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.gfW != null) {
                    a.this.gfW.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.gfW != null) {
                    a.this.gfW.onListPullRefresh(z);
                }
            }
        });
        this.gfT = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.gfT.setProgressView(this.mPullView);
        this.gfV = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Xe.addAdapters(this.gfV.bMJ());
    }

    private void bAw() {
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

    public View bMO() {
        return this.mContainer;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.gfT, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_d);
    }

    private boolean bMP() {
        return this.gfU.getVisibility() == 0;
    }

    public void bMQ() {
        if (!bMP()) {
            this.gfU.setVisibility(0);
            if (this.gfX == null) {
                this.gfX = new AlphaAnimation(0.0f, 1.0f);
                this.gfX.setFillAfter(true);
                this.gfX.setDuration(300L);
            }
            this.gfU.startAnimation(this.gfX);
        }
    }

    public void bMR() {
        if (bMP()) {
            if (this.gfY == null) {
                this.gfY = new AlphaAnimation(1.0f, 0.0f);
                this.gfY.setFillAfter(true);
                this.gfY.setDuration(300L);
                this.gfY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.gfU.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gfU.startAnimation(this.gfY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void kT(boolean z) {
        if (!z) {
            this.gfT.setRefreshing(false);
        }
    }

    public void a(InterfaceC0618a interfaceC0618a) {
        this.gfW = interfaceC0618a;
    }

    public RelativeLayout bMS() {
        return this.mContainer;
    }

    public void setData(List<q> list) {
        this.Xe.setData(list);
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Xe != null) {
            for (int count = this.Xe.getCount() - 1; count >= 0; count--) {
                q item = this.Xe.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Xe.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Xe.removeOnScrollListener(this.mOnScrollListener);
        this.Xe.setOnSrollToBottomListener(null);
        this.Xe.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
