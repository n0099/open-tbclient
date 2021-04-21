package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes4.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {

    /* renamed from: a  reason: collision with root package name */
    public boolean f16824a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout f16825b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16826c;

    /* renamed from: d  reason: collision with root package name */
    public NestedScrollHeader f16827d;

    /* renamed from: e  reason: collision with root package name */
    public HomeTabBarView f16828e;

    /* renamed from: f  reason: collision with root package name */
    public View f16829f;

    /* renamed from: g  reason: collision with root package name */
    public float f16830g;

    /* renamed from: h  reason: collision with root package name */
    public StickyAppBarLayout.b f16831h;
    public AppBarLayout.OnOffsetChangedListener i;

    /* loaded from: classes4.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, Integer.valueOf(i)));
            float totalScrollRange = appBarLayout.getTotalScrollRange();
            float abs = Math.abs(i);
            int i2 = (abs > totalScrollRange ? 1 : (abs == totalScrollRange ? 0 : -1));
            if (i2 >= 0) {
                if (!StickyAppBarLayoutBehavior.this.f16824a) {
                    StickyAppBarLayoutBehavior.this.f16824a = true;
                    if (StickyAppBarLayoutBehavior.this.f16831h != null) {
                        StickyAppBarLayoutBehavior.this.f16831h.a(StickyAppBarLayoutBehavior.this.f16824a);
                    }
                }
            } else if (StickyAppBarLayoutBehavior.this.f16824a) {
                StickyAppBarLayoutBehavior.this.f16824a = false;
                if (StickyAppBarLayoutBehavior.this.f16831h != null) {
                    StickyAppBarLayoutBehavior.this.f16831h.a(StickyAppBarLayoutBehavior.this.f16824a);
                }
            }
            if (StickyAppBarLayoutBehavior.this.f16830g == abs) {
                return;
            }
            StickyAppBarLayoutBehavior.this.f16830g = abs;
            if (totalScrollRange <= 0.0f) {
                return;
            }
            StickyAppBarLayoutBehavior.this.m(abs != 0.0f ? i2 >= 0 ? 1.0f : abs / totalScrollRange : 0.0f);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AppBarLayout.Behavior.DragCallback {
        public b(StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior) {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
        public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
            return false;
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.f16824a = false;
        this.f16826c = false;
        this.f16830g = -1.0f;
        this.i = new a();
        j();
    }

    public void g() {
        StickyAppBarLayout.b onHeaderStickyListener;
        AppBarLayout appBarLayout = this.f16825b;
        if (!(appBarLayout instanceof StickyAppBarLayout) || (onHeaderStickyListener = ((StickyAppBarLayout) appBarLayout).getOnHeaderStickyListener()) == null) {
            return;
        }
        k(onHeaderStickyListener);
    }

    public NestedScrollHeader h() {
        return this.f16827d;
    }

    public void i() {
        AppBarLayout appBarLayout = this.f16825b;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.f16824a;
    }

    public final void j() {
        setDragCallback(new b(this));
    }

    public void k(StickyAppBarLayout.b bVar) {
        this.f16831h = bVar;
    }

    public void l() {
        AppBarLayout appBarLayout = this.f16825b;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(true, true);
        }
    }

    public final void m(float f2) {
        int i;
        HomeTabBarView homeTabBarView = this.f16828e;
        if (homeTabBarView != null) {
            homeTabBarView.o(f2);
        }
        NestedScrollHeader nestedScrollHeader = this.f16827d;
        if (nestedScrollHeader != null) {
            nestedScrollHeader.q(1.0f - f2);
        }
        View view = this.f16829f;
        if (view == null || f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        if (i == 0) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        this.f16829f.setAlpha(f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        AppBarLayout appBarLayout = this.f16825b;
        if (appBarLayout == null || this.f16826c) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(this.i);
        this.f16826c = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        AppBarLayout appBarLayout = this.f16825b;
        if (appBarLayout == null || !this.f16826c) {
            return;
        }
        appBarLayout.removeOnOffsetChangedListener(this.i);
        this.f16826c = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.f16825b == null) {
            this.f16825b = appBarLayout;
            View findViewById = appBarLayout.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.f16827d = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.f16825b.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.f16828e = (HomeTabBarView) findViewById2;
            }
            this.f16829f = this.f16825b.findViewById(R.id.divider_line);
            g();
        }
        AppBarLayout appBarLayout2 = this.f16825b;
        if (appBarLayout2 != null && !this.f16826c) {
            appBarLayout2.addOnOffsetChangedListener(this.i);
            this.f16826c = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16824a = false;
        this.f16826c = false;
        this.f16830g = -1.0f;
        this.i = new a();
        j();
    }
}
