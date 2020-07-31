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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView VT;
    private BdSwipeRefreshLayout fuP;
    private View fuQ;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a fuR;
    private InterfaceC0543a fuS;
    private AlphaAnimation fuT;
    private AlphaAnimation fuU;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int fuW = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.fuW != i) {
                this.fuW = i;
                if (this.fuW != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bxn();
                        return;
                    } else {
                        a.this.bxm();
                        return;
                    }
                }
                a.this.bxm();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0543a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        bmb();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.fuQ = this.mRootView.findViewById(R.id.divider_shadow);
        this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.VT.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.VT.setFadingEdgeLength(0);
        this.VT.setOverScrollMode(2);
        this.VT.addOnScrollListener(this.mOnScrollListener);
        this.VT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.fuS != null) {
                    a.this.fuS.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.fuS != null) {
                    a.this.fuS.onListPullRefresh(z);
                }
            }
        });
        this.fuP = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.fuP.setProgressView(this.mPullView);
        this.fuR = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.VT.addAdapters(this.fuR.bxf());
    }

    private void bmb() {
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

    public View bxk() {
        return this.mContainer;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ao.setBackgroundColor(this.fuP, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.VT, R.color.cp_bg_line_d);
    }

    private boolean bxl() {
        return this.fuQ.getVisibility() == 0;
    }

    public void bxm() {
        if (!bxl()) {
            this.fuQ.setVisibility(0);
            if (this.fuT == null) {
                this.fuT = new AlphaAnimation(0.0f, 1.0f);
                this.fuT.setFillAfter(true);
                this.fuT.setDuration(300L);
            }
            this.fuQ.startAnimation(this.fuT);
        }
    }

    public void bxn() {
        if (bxl()) {
            if (this.fuU == null) {
                this.fuU = new AlphaAnimation(1.0f, 0.0f);
                this.fuU.setFillAfter(true);
                this.fuU.setDuration(300L);
                this.fuU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.fuQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fuQ.startAnimation(this.fuU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void jH(boolean z) {
        if (!z) {
            this.fuP.setRefreshing(false);
        }
    }

    public void a(InterfaceC0543a interfaceC0543a) {
        this.fuS = interfaceC0543a;
    }

    public RelativeLayout bxo() {
        return this.mContainer;
    }

    public void setData(List<q> list) {
        this.VT.setData(list);
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.VT != null) {
            for (int count = this.VT.getCount() - 1; count >= 0; count--) {
                q item = this.VT.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.VT.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.VT.removeOnScrollListener(this.mOnScrollListener);
        this.VT.setOnSrollToBottomListener(null);
        this.VT.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
