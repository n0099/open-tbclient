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
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Xi;
    private BdSwipeRefreshLayout glp;
    private View glq;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a glr;
    private InterfaceC0630a gls;
    private AlphaAnimation glt;
    private AlphaAnimation glu;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int glw = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.glw != i) {
                this.glw = i;
                if (this.glw != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bOK();
                        return;
                    } else {
                        a.this.bOJ();
                        return;
                    }
                }
                a.this.bOJ();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0630a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        bCo();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.glq = this.mRootView.findViewById(R.id.divider_shadow);
        this.Xi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Xi.setFadingEdgeLength(0);
        this.Xi.setOverScrollMode(2);
        this.Xi.addOnScrollListener(this.mOnScrollListener);
        this.Xi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.gls != null) {
                    a.this.gls.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.gls != null) {
                    a.this.gls.onListPullRefresh(z);
                }
            }
        });
        this.glp = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.glp.setProgressView(this.mPullView);
        this.glr = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Xi.addAdapters(this.glr.bOC());
    }

    private void bCo() {
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

    public View bOH() {
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
        ap.setBackgroundColor(this.glp, R.color.CAM_X0201);
        ap.setBackgroundColor(this.Xi, R.color.CAM_X0201);
    }

    private boolean bOI() {
        return this.glq.getVisibility() == 0;
    }

    public void bOJ() {
        if (!bOI()) {
            this.glq.setVisibility(0);
            if (this.glt == null) {
                this.glt = new AlphaAnimation(0.0f, 1.0f);
                this.glt.setFillAfter(true);
                this.glt.setDuration(300L);
            }
            this.glq.startAnimation(this.glt);
        }
    }

    public void bOK() {
        if (bOI()) {
            if (this.glu == null) {
                this.glu = new AlphaAnimation(1.0f, 0.0f);
                this.glu.setFillAfter(true);
                this.glu.setDuration(300L);
                this.glu.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.glq.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.glq.startAnimation(this.glu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void ld(boolean z) {
        if (!z) {
            this.glp.setRefreshing(false);
        }
    }

    public void a(InterfaceC0630a interfaceC0630a) {
        this.gls = interfaceC0630a;
    }

    public RelativeLayout bOL() {
        return this.mContainer;
    }

    public void setData(List<q> list) {
        this.Xi.setData(list);
    }

    public void x(Class<? extends BaseCardInfo> cls) {
        if (this.Xi != null) {
            for (int count = this.Xi.getCount() - 1; count >= 0; count--) {
                q item = this.Xi.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Xi.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Xi.removeOnScrollListener(this.mOnScrollListener);
        this.Xi.setOnSrollToBottomListener(null);
        this.Xi.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
