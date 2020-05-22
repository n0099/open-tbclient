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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeRecyclerView Vw;
    private BdSwipeRefreshLayout fej;
    private View fek;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a fel;
    private InterfaceC0524a fem;
    private AlphaAnimation fen;
    private AlphaAnimation feo;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int feq = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.feq != i) {
                this.feq = i;
                if (this.feq != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.brf();
                        return;
                    } else {
                        a.this.bre();
                        return;
                    }
                }
                a.this.bre();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0524a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        brb();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.fek = this.mRootView.findViewById(R.id.divider_shadow);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.Vw.addOnScrollListener(this.mOnScrollListener);
        this.Vw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.fem != null) {
                    a.this.fem.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.fem != null) {
                    a.this.fem.onListPullRefresh(z);
                }
            }
        });
        this.fej = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.fej.setProgressView(this.mPullView);
        this.fel = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Vw.addAdapters(this.fel.bqW());
    }

    private void brb() {
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

    public View brc() {
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
        am.setBackgroundColor(this.fej, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Vw, R.color.cp_bg_line_d);
    }

    private boolean brd() {
        return this.fek.getVisibility() == 0;
    }

    public void bre() {
        if (!brd()) {
            this.fek.setVisibility(0);
            if (this.fen == null) {
                this.fen = new AlphaAnimation(0.0f, 1.0f);
                this.fen.setFillAfter(true);
                this.fen.setDuration(300L);
            }
            this.fek.startAnimation(this.fen);
        }
    }

    public void brf() {
        if (brd()) {
            if (this.feo == null) {
                this.feo = new AlphaAnimation(1.0f, 0.0f);
                this.feo.setFillAfter(true);
                this.feo.setDuration(300L);
                this.feo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.fek.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fek.startAnimation(this.feo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void iQ(boolean z) {
        if (!z) {
            this.fej.setRefreshing(false);
        }
    }

    public void a(InterfaceC0524a interfaceC0524a) {
        this.fem = interfaceC0524a;
    }

    public RelativeLayout brg() {
        return this.mContainer;
    }

    public void setData(List<com.baidu.adp.widget.ListView.o> list) {
        this.Vw.setData(list);
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Vw != null) {
            for (int count = this.Vw.getCount() - 1; count >= 0; count--) {
                com.baidu.adp.widget.ListView.o item = this.Vw.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Vw.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Vw.removeOnScrollListener(this.mOnScrollListener);
        this.Vw.setOnSrollToBottomListener(null);
        this.Vw.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
