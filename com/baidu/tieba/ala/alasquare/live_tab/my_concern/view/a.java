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
/* loaded from: classes10.dex */
public class a {
    private BdTypeRecyclerView XW;
    private BdSwipeRefreshLayout gCQ;
    private View gCR;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a gCS;
    private InterfaceC0616a gCT;
    private AlphaAnimation gCU;
    private AlphaAnimation gCV;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.5
        private int gCX = -1;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.gCX != i) {
                this.gCX = i;
                if (this.gCX != 1) {
                    if (a.this.c(recyclerView)) {
                        a.this.bRR();
                        return;
                    } else {
                        a.this.bRQ();
                        return;
                    }
                }
                a.this.bRQ();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
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
        bEL();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.gCR = this.mRootView.findViewById(R.id.divider_shadow);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.XW.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.XW.addOnScrollListener(this.mOnScrollListener);
        this.XW.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.gCT != null) {
                    a.this.gCT.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.gCT != null) {
                    a.this.gCT.onListPullRefresh(z);
                }
            }
        });
        this.gCQ = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.gCQ.setProgressView(this.mPullView);
        this.gCS = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.XW.addAdapters(this.gCS.bRK());
    }

    private void bEL() {
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
        ap.setBackgroundColor(this.gCQ, R.color.CAM_X0201);
        ap.setBackgroundColor(this.XW, R.color.CAM_X0201);
    }

    private boolean bRP() {
        return this.gCR.getVisibility() == 0;
    }

    public void bRQ() {
        if (!bRP()) {
            this.gCR.setVisibility(0);
            if (this.gCU == null) {
                this.gCU = new AlphaAnimation(0.0f, 1.0f);
                this.gCU.setFillAfter(true);
                this.gCU.setDuration(300L);
            }
            this.gCR.startAnimation(this.gCU);
        }
    }

    public void bRR() {
        if (bRP()) {
            if (this.gCV == null) {
                this.gCV = new AlphaAnimation(1.0f, 0.0f);
                this.gCV.setFillAfter(true);
                this.gCV.setDuration(300L);
                this.gCV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.gCR.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gCR.startAnimation(this.gCV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void lU(boolean z) {
        if (!z) {
            this.gCQ.setRefreshing(false);
        }
    }

    public void a(InterfaceC0616a interfaceC0616a) {
        this.gCT = interfaceC0616a;
    }

    public RelativeLayout bRS() {
        return this.mContainer;
    }

    public void setData(List<n> list) {
        this.XW.setData(list);
    }

    public void q(Class<? extends BaseCardInfo> cls) {
        if (this.XW != null) {
            for (int count = this.XW.getCount() - 1; count >= 0; count--) {
                n item = this.XW.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.XW.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.XW.removeOnScrollListener(this.mOnScrollListener);
        this.XW.setOnSrollToBottomListener(null);
        this.XW.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
