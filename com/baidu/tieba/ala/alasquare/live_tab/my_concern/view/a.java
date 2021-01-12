package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Ya;
    private BdSwipeRefreshLayout gzS;
    private View gzT;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a gzU;
    private InterfaceC0616a gzV;
    private AlphaAnimation gzW;
    private AlphaAnimation gzX;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.5
        private int gzZ = -1;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.gzZ != i) {
                this.gzZ = i;
                if (this.gzZ != 1) {
                    if (a.this.c(recyclerView)) {
                        a.this.bRh();
                        return;
                    } else {
                        a.this.bRg();
                        return;
                    }
                }
                a.this.bRg();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0616a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        bEt();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.gzT = this.mRootView.findViewById(R.id.divider_shadow);
        this.Ya = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Ya.setFadingEdgeLength(0);
        this.Ya.setOverScrollMode(2);
        this.Ya.addOnScrollListener(this.mOnScrollListener);
        this.Ya.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.gzV != null) {
                    a.this.gzV.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.gzV != null) {
                    a.this.gzV.onListPullRefresh(z);
                }
            }
        });
        this.gzS = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.gzS.setProgressView(this.mPullView);
        this.gzU = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Ya.addAdapters(this.gzU.bQZ());
    }

    private void bEt() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
        this.mNavigationBar.setCenterTextTitle(this.mTbPageContext.getResources().getString(R.string.live_tab_my_concern));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.3
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

    public View bRe() {
        return this.mContainer;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ao.setBackgroundColor(this.gzS, R.color.CAM_X0201);
        ao.setBackgroundColor(this.Ya, R.color.CAM_X0201);
    }

    private boolean bRf() {
        return this.gzT.getVisibility() == 0;
    }

    public void bRg() {
        if (!bRf()) {
            this.gzT.setVisibility(0);
            if (this.gzW == null) {
                this.gzW = new AlphaAnimation(0.0f, 1.0f);
                this.gzW.setFillAfter(true);
                this.gzW.setDuration(300L);
            }
            this.gzT.startAnimation(this.gzW);
        }
    }

    public void bRh() {
        if (bRf()) {
            if (this.gzX == null) {
                this.gzX = new AlphaAnimation(1.0f, 0.0f);
                this.gzX.setFillAfter(true);
                this.gzX.setDuration(300L);
                this.gzX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.gzT.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gzT.startAnimation(this.gzX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void lQ(boolean z) {
        if (!z) {
            this.gzS.setRefreshing(false);
        }
    }

    public void a(InterfaceC0616a interfaceC0616a) {
        this.gzV = interfaceC0616a;
    }

    public RelativeLayout bRi() {
        return this.mContainer;
    }

    public void setData(List<n> list) {
        this.Ya.setData(list);
    }

    public void q(Class<? extends BaseCardInfo> cls) {
        if (this.Ya != null) {
            for (int count = this.Ya.getCount() - 1; count >= 0; count--) {
                n item = this.Ya.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Ya.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Ya.removeOnScrollListener(this.mOnScrollListener);
        this.Ya.setOnSrollToBottomListener(null);
        this.Ya.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
