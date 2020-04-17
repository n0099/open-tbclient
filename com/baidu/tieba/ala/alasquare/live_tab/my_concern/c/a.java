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
    private BdTypeRecyclerView Vf;
    private AlphaAnimation eRA;
    private AlphaAnimation eRB;
    private BdSwipeRefreshLayout eRw;
    private View eRx;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a eRy;
    private InterfaceC0456a eRz;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int eRD = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.eRD != i) {
                this.eRD = i;
                if (this.eRD != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.blJ();
                        return;
                    } else {
                        a.this.blI();
                        return;
                    }
                }
                a.this.blI();
            }
        }
    };
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0456a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        blF();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.eRx = this.mRootView.findViewById(R.id.divider_shadow);
        this.Vf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Vf.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Vf.setFadingEdgeLength(0);
        this.Vf.setOverScrollMode(2);
        this.Vf.addOnScrollListener(this.mOnScrollListener);
        this.Vf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.eRz != null) {
                    a.this.eRz.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (a.this.eRz != null) {
                    a.this.eRz.onListPullRefresh(z);
                }
            }
        });
        this.eRw = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.eRw.setProgressView(this.mPullView);
        this.eRy = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Vf.addAdapters(this.eRy.blA());
    }

    private void blF() {
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

    public View blG() {
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
        am.setBackgroundColor(this.eRw, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Vf, R.color.cp_bg_line_d);
    }

    private boolean blH() {
        return this.eRx.getVisibility() == 0;
    }

    public void blI() {
        if (!blH()) {
            this.eRx.setVisibility(0);
            if (this.eRA == null) {
                this.eRA = new AlphaAnimation(0.0f, 1.0f);
                this.eRA.setFillAfter(true);
                this.eRA.setDuration(300L);
            }
            this.eRx.startAnimation(this.eRA);
        }
    }

    public void blJ() {
        if (blH()) {
            if (this.eRB == null) {
                this.eRB = new AlphaAnimation(1.0f, 0.0f);
                this.eRB.setFillAfter(true);
                this.eRB.setDuration(300L);
                this.eRB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.eRx.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eRx.startAnimation(this.eRB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void it(boolean z) {
        if (!z) {
            this.eRw.setRefreshing(false);
        }
    }

    public void a(InterfaceC0456a interfaceC0456a) {
        this.eRz = interfaceC0456a;
    }

    public RelativeLayout blK() {
        return this.mContainer;
    }

    public void setData(List<com.baidu.adp.widget.ListView.m> list) {
        this.Vf.setData(list);
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Vf != null) {
            for (int count = this.Vf.getCount() - 1; count >= 0; count--) {
                com.baidu.adp.widget.ListView.m item = this.Vf.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Vf.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Vf.removeOnScrollListener(this.mOnScrollListener);
        this.Vf.setOnSrollToBottomListener(null);
        this.Vf.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
