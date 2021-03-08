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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Zq;
    private View gEA;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a gEB;
    private InterfaceC0622a gEC;
    private AlphaAnimation gED;
    private AlphaAnimation gEE;
    private BdSwipeRefreshLayout gEz;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.5
        private int gEG = -1;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.gEG != i) {
                this.gEG = i;
                if (this.gEG != 1) {
                    if (a.this.c(recyclerView)) {
                        a.this.bRX();
                        return;
                    } else {
                        a.this.bRW();
                        return;
                    }
                }
                a.this.bRW();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0622a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        bEP();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.gEA = this.mRootView.findViewById(R.id.divider_shadow);
        this.Zq = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Zq.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Zq.setFadingEdgeLength(0);
        this.Zq.setOverScrollMode(2);
        this.Zq.addOnScrollListener(this.mOnScrollListener);
        this.Zq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.gEC != null) {
                    a.this.gEC.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.gEC != null) {
                    a.this.gEC.onListPullRefresh(z);
                }
            }
        });
        this.gEz = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.gEz.setProgressView(this.mPullView);
        this.gEB = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Zq.addAdapters(this.gEB.bRQ());
    }

    private void bEP() {
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

    public View getContainerView() {
        return this.mContainer;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.gEz, R.color.CAM_X0201);
        ap.setBackgroundColor(this.Zq, R.color.CAM_X0201);
    }

    private boolean bRV() {
        return this.gEA.getVisibility() == 0;
    }

    public void bRW() {
        if (!bRV()) {
            this.gEA.setVisibility(0);
            if (this.gED == null) {
                this.gED = new AlphaAnimation(0.0f, 1.0f);
                this.gED.setFillAfter(true);
                this.gED.setDuration(300L);
            }
            this.gEA.startAnimation(this.gED);
        }
    }

    public void bRX() {
        if (bRV()) {
            if (this.gEE == null) {
                this.gEE = new AlphaAnimation(1.0f, 0.0f);
                this.gEE.setFillAfter(true);
                this.gEE.setDuration(300L);
                this.gEE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.gEA.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gEA.startAnimation(this.gEE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void lU(boolean z) {
        if (!z) {
            this.gEz.setRefreshing(false);
        }
    }

    public void a(InterfaceC0622a interfaceC0622a) {
        this.gEC = interfaceC0622a;
    }

    public RelativeLayout bRY() {
        return this.mContainer;
    }

    public void setData(List<n> list) {
        this.Zq.setData(list);
    }

    public void q(Class<? extends BaseCardInfo> cls) {
        if (this.Zq != null) {
            for (int count = this.Zq.getCount() - 1; count >= 0; count--) {
                n item = this.Zq.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Zq.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Zq.removeOnScrollListener(this.mOnScrollListener);
        this.Zq.setOnSrollToBottomListener(null);
        this.Zq.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
