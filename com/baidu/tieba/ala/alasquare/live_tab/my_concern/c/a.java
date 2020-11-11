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
    private BdSwipeRefreshLayout glI;
    private View glJ;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a glK;
    private InterfaceC0630a glL;
    private AlphaAnimation glM;
    private AlphaAnimation glN;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int glP = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.glP != i) {
                this.glP = i;
                if (this.glP != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bPr();
                        return;
                    } else {
                        a.this.bPq();
                        return;
                    }
                }
                a.this.bPq();
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
        bCV();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.glJ = this.mRootView.findViewById(R.id.divider_shadow);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        this.Xe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.glL != null) {
                    a.this.glL.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.glL != null) {
                    a.this.glL.onListPullRefresh(z);
                }
            }
        });
        this.glI = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.glI.setProgressView(this.mPullView);
        this.glK = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Xe.addAdapters(this.glK.bPj());
    }

    private void bCV() {
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

    public View bPo() {
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
        ap.setBackgroundColor(this.glI, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_d);
    }

    private boolean bPp() {
        return this.glJ.getVisibility() == 0;
    }

    public void bPq() {
        if (!bPp()) {
            this.glJ.setVisibility(0);
            if (this.glM == null) {
                this.glM = new AlphaAnimation(0.0f, 1.0f);
                this.glM.setFillAfter(true);
                this.glM.setDuration(300L);
            }
            this.glJ.startAnimation(this.glM);
        }
    }

    public void bPr() {
        if (bPp()) {
            if (this.glN == null) {
                this.glN = new AlphaAnimation(1.0f, 0.0f);
                this.glN.setFillAfter(true);
                this.glN.setDuration(300L);
                this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.glJ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.glJ.startAnimation(this.glN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void lc(boolean z) {
        if (!z) {
            this.glI.setRefreshing(false);
        }
    }

    public void a(InterfaceC0630a interfaceC0630a) {
        this.glL = interfaceC0630a;
    }

    public RelativeLayout bPs() {
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
