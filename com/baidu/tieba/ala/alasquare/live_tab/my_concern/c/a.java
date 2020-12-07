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
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView Yf;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a gtA;
    private InterfaceC0642a gtB;
    private AlphaAnimation gtC;
    private AlphaAnimation gtD;
    private BdSwipeRefreshLayout gty;
    private View gtz;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int gtF = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.gtF != i) {
                this.gtF = i;
                if (this.gtF != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bSv();
                        return;
                    } else {
                        a.this.bSu();
                        return;
                    }
                }
                a.this.bSu();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0642a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        bFP();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.gtz = this.mRootView.findViewById(R.id.divider_shadow);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.Yf.addOnScrollListener(this.mOnScrollListener);
        this.Yf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.gtB != null) {
                    a.this.gtB.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.gtB != null) {
                    a.this.gtB.onListPullRefresh(z);
                }
            }
        });
        this.gty = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.gty.setProgressView(this.mPullView);
        this.gtA = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Yf.addAdapters(this.gtA.bSn());
    }

    private void bFP() {
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

    public View bSs() {
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
        ap.setBackgroundColor(this.gty, R.color.CAM_X0201);
        ap.setBackgroundColor(this.Yf, R.color.CAM_X0201);
    }

    private boolean bSt() {
        return this.gtz.getVisibility() == 0;
    }

    public void bSu() {
        if (!bSt()) {
            this.gtz.setVisibility(0);
            if (this.gtC == null) {
                this.gtC = new AlphaAnimation(0.0f, 1.0f);
                this.gtC.setFillAfter(true);
                this.gtC.setDuration(300L);
            }
            this.gtz.startAnimation(this.gtC);
        }
    }

    public void bSv() {
        if (bSt()) {
            if (this.gtD == null) {
                this.gtD = new AlphaAnimation(1.0f, 0.0f);
                this.gtD.setFillAfter(true);
                this.gtD.setDuration(300L);
                this.gtD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.gtz.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.gtz.startAnimation(this.gtD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void lx(boolean z) {
        if (!z) {
            this.gty.setRefreshing(false);
        }
    }

    public void a(InterfaceC0642a interfaceC0642a) {
        this.gtB = interfaceC0642a;
    }

    public RelativeLayout bSw() {
        return this.mContainer;
    }

    public void setData(List<q> list) {
        this.Yf.setData(list);
    }

    public void x(Class<? extends BaseCardInfo> cls) {
        if (this.Yf != null) {
            for (int count = this.Yf.getCount() - 1; count >= 0; count--) {
                q item = this.Yf.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Yf.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Yf.removeOnScrollListener(this.mOnScrollListener);
        this.Yf.setOnSrollToBottomListener(null);
        this.Yf.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
