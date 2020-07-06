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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeRecyclerView Wa;
    private BdSwipeRefreshLayout fpF;
    private View fpG;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a fpH;
    private InterfaceC0532a fpI;
    private AlphaAnimation fpJ;
    private AlphaAnimation fpK;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int fpM = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.fpM != i) {
                this.fpM = i;
                if (this.fpM != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bue();
                        return;
                    } else {
                        a.this.bud();
                        return;
                    }
                }
                a.this.bud();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0532a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        biq();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.fpG = this.mRootView.findViewById(R.id.divider_shadow);
        this.Wa = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.Wa.addOnScrollListener(this.mOnScrollListener);
        this.Wa.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.fpI != null) {
                    a.this.fpI.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.fpI != null) {
                    a.this.fpI.onListPullRefresh(z);
                }
            }
        });
        this.fpF = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.fpF.setProgressView(this.mPullView);
        this.fpH = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Wa.addAdapters(this.fpH.btW());
    }

    private void biq() {
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

    public View bub() {
        return this.mContainer;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        an.setBackgroundColor(this.fpF, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.Wa, R.color.cp_bg_line_d);
    }

    private boolean buc() {
        return this.fpG.getVisibility() == 0;
    }

    public void bud() {
        if (!buc()) {
            this.fpG.setVisibility(0);
            if (this.fpJ == null) {
                this.fpJ = new AlphaAnimation(0.0f, 1.0f);
                this.fpJ.setFillAfter(true);
                this.fpJ.setDuration(300L);
            }
            this.fpG.startAnimation(this.fpJ);
        }
    }

    public void bue() {
        if (buc()) {
            if (this.fpK == null) {
                this.fpK = new AlphaAnimation(1.0f, 0.0f);
                this.fpK.setFillAfter(true);
                this.fpK.setDuration(300L);
                this.fpK.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.fpG.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fpG.startAnimation(this.fpK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void jc(boolean z) {
        if (!z) {
            this.fpF.setRefreshing(false);
        }
    }

    public void a(InterfaceC0532a interfaceC0532a) {
        this.fpI = interfaceC0532a;
    }

    public RelativeLayout buf() {
        return this.mContainer;
    }

    public void setData(List<q> list) {
        this.Wa.setData(list);
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Wa != null) {
            for (int count = this.Wa.getCount() - 1; count >= 0; count--) {
                q item = this.Wa.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Wa.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Wa.removeOnScrollListener(this.mOnScrollListener);
        this.Wa.setOnSrollToBottomListener(null);
        this.Wa.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
