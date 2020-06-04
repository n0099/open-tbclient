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
    private BdSwipeRefreshLayout feu;
    private View fev;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a few;
    private InterfaceC0524a fex;
    private AlphaAnimation fey;
    private AlphaAnimation fez;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int feB = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.feB != i) {
                this.feB = i;
                if (this.feB != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.brh();
                        return;
                    } else {
                        a.this.brg();
                        return;
                    }
                }
                a.this.brg();
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
        brd();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.fev = this.mRootView.findViewById(R.id.divider_shadow);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.Vw.addOnScrollListener(this.mOnScrollListener);
        this.Vw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.fex != null) {
                    a.this.fex.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.fex != null) {
                    a.this.fex.onListPullRefresh(z);
                }
            }
        });
        this.feu = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.feu.setProgressView(this.mPullView);
        this.few = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Vw.addAdapters(this.few.bqY());
    }

    private void brd() {
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

    public View bre() {
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
        am.setBackgroundColor(this.feu, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Vw, R.color.cp_bg_line_d);
    }

    private boolean brf() {
        return this.fev.getVisibility() == 0;
    }

    public void brg() {
        if (!brf()) {
            this.fev.setVisibility(0);
            if (this.fey == null) {
                this.fey = new AlphaAnimation(0.0f, 1.0f);
                this.fey.setFillAfter(true);
                this.fey.setDuration(300L);
            }
            this.fev.startAnimation(this.fey);
        }
    }

    public void brh() {
        if (brf()) {
            if (this.fez == null) {
                this.fez = new AlphaAnimation(1.0f, 0.0f);
                this.fez.setFillAfter(true);
                this.fez.setDuration(300L);
                this.fez.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.fev.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fev.startAnimation(this.fez);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void iQ(boolean z) {
        if (!z) {
            this.feu.setRefreshing(false);
        }
    }

    public void a(InterfaceC0524a interfaceC0524a) {
        this.fex = interfaceC0524a;
    }

    public RelativeLayout bri() {
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
