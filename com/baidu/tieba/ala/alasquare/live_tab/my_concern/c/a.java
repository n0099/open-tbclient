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
    private BdTypeRecyclerView Xc;
    private BdSwipeRefreshLayout fVP;
    private View fVQ;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a fVR;
    private InterfaceC0602a fVS;
    private AlphaAnimation fVT;
    private AlphaAnimation fVU;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int fVW = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.fVW != i) {
                this.fVW = i;
                if (this.fVW != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bKp();
                        return;
                    } else {
                        a.this.bKo();
                        return;
                    }
                }
                a.this.bKo();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0602a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        byD();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.fVQ = this.mRootView.findViewById(R.id.divider_shadow);
        this.Xc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Xc.setFadingEdgeLength(0);
        this.Xc.setOverScrollMode(2);
        this.Xc.addOnScrollListener(this.mOnScrollListener);
        this.Xc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.fVS != null) {
                    a.this.fVS.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.fVS != null) {
                    a.this.fVS.onListPullRefresh(z);
                }
            }
        });
        this.fVP = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.fVP.setProgressView(this.mPullView);
        this.fVR = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Xc.addAdapters(this.fVR.bKh());
    }

    private void byD() {
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

    public View bKm() {
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
        ap.setBackgroundColor(this.fVP, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.Xc, R.color.cp_bg_line_d);
    }

    private boolean bKn() {
        return this.fVQ.getVisibility() == 0;
    }

    public void bKo() {
        if (!bKn()) {
            this.fVQ.setVisibility(0);
            if (this.fVT == null) {
                this.fVT = new AlphaAnimation(0.0f, 1.0f);
                this.fVT.setFillAfter(true);
                this.fVT.setDuration(300L);
            }
            this.fVQ.startAnimation(this.fVT);
        }
    }

    public void bKp() {
        if (bKn()) {
            if (this.fVU == null) {
                this.fVU = new AlphaAnimation(1.0f, 0.0f);
                this.fVU.setFillAfter(true);
                this.fVU.setDuration(300L);
                this.fVU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.fVQ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fVQ.startAnimation(this.fVU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void kG(boolean z) {
        if (!z) {
            this.fVP.setRefreshing(false);
        }
    }

    public void a(InterfaceC0602a interfaceC0602a) {
        this.fVS = interfaceC0602a;
    }

    public RelativeLayout bKq() {
        return this.mContainer;
    }

    public void setData(List<q> list) {
        this.Xc.setData(list);
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Xc != null) {
            for (int count = this.Xc.getCount() - 1; count >= 0; count--) {
                q item = this.Xc.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Xc.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Xc.removeOnScrollListener(this.mOnScrollListener);
        this.Xc.setOnSrollToBottomListener(null);
        this.Xc.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
