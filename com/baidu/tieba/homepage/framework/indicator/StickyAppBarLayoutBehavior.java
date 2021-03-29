package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes3.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {

    /* renamed from: a  reason: collision with root package name */
    public boolean f17143a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout f17144b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17145c;

    /* renamed from: d  reason: collision with root package name */
    public NestedScrollHeader f17146d;

    /* renamed from: e  reason: collision with root package name */
    public HomeTabBarView f17147e;

    /* renamed from: f  reason: collision with root package name */
    public View f17148f;

    /* renamed from: g  reason: collision with root package name */
    public float f17149g;

    /* renamed from: h  reason: collision with root package name */
    public StickyAppBarLayout.b f17150h;
    public AppBarLayout.OnOffsetChangedListener i;

    /* loaded from: classes3.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float totalScrollRange = appBarLayout.getTotalScrollRange();
            float abs = Math.abs(i);
            int i2 = (abs > totalScrollRange ? 1 : (abs == totalScrollRange ? 0 : -1));
            if (i2 >= 0) {
                if (!StickyAppBarLayoutBehavior.this.f17143a) {
                    StickyAppBarLayoutBehavior.this.f17143a = true;
                    if (StickyAppBarLayoutBehavior.this.f17150h != null) {
                        StickyAppBarLayoutBehavior.this.f17150h.a(StickyAppBarLayoutBehavior.this.f17143a);
                    }
                }
            } else if (StickyAppBarLayoutBehavior.this.f17143a) {
                StickyAppBarLayoutBehavior.this.f17143a = false;
                if (StickyAppBarLayoutBehavior.this.f17150h != null) {
                    StickyAppBarLayoutBehavior.this.f17150h.a(StickyAppBarLayoutBehavior.this.f17143a);
                }
            }
            if (StickyAppBarLayoutBehavior.this.f17149g == abs) {
                return;
            }
            StickyAppBarLayoutBehavior.this.f17149g = abs;
            if (totalScrollRange <= 0.0f) {
                return;
            }
            StickyAppBarLayoutBehavior.this.m(abs != 0.0f ? i2 >= 0 ? 1.0f : abs / totalScrollRange : 0.0f);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AppBarLayout.Behavior.DragCallback {
        public b(StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior) {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
        public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
            return false;
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.f17143a = false;
        this.f17145c = false;
        this.f17149g = -1.0f;
        this.i = new a();
        j();
    }

    public void g() {
        StickyAppBarLayout.b onHeaderStickyListener;
        AppBarLayout appBarLayout = this.f17144b;
        if (!(appBarLayout instanceof StickyAppBarLayout) || (onHeaderStickyListener = ((StickyAppBarLayout) appBarLayout).getOnHeaderStickyListener()) == null) {
            return;
        }
        k(onHeaderStickyListener);
    }

    public NestedScrollHeader h() {
        return this.f17146d;
    }

    public void i() {
        AppBarLayout appBarLayout = this.f17144b;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.f17143a;
    }

    public final void j() {
        setDragCallback(new b(this));
    }

    public void k(StickyAppBarLayout.b bVar) {
        this.f17150h = bVar;
    }

    public void l() {
        AppBarLayout appBarLayout = this.f17144b;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(true, true);
        }
    }

    public final void m(float f2) {
        int i;
        HomeTabBarView homeTabBarView = this.f17147e;
        if (homeTabBarView != null) {
            homeTabBarView.o(f2);
        }
        NestedScrollHeader nestedScrollHeader = this.f17146d;
        if (nestedScrollHeader != null) {
            nestedScrollHeader.m(1.0f - f2);
        }
        View view = this.f17148f;
        if (view == null || f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        if (i == 0) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        this.f17148f.setAlpha(f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        AppBarLayout appBarLayout = this.f17144b;
        if (appBarLayout == null || this.f17145c) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(this.i);
        this.f17145c = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        AppBarLayout appBarLayout = this.f17144b;
        if (appBarLayout == null || !this.f17145c) {
            return;
        }
        appBarLayout.removeOnOffsetChangedListener(this.i);
        this.f17145c = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.f17144b == null) {
            this.f17144b = appBarLayout;
            View findViewById = appBarLayout.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.f17146d = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.f17144b.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.f17147e = (HomeTabBarView) findViewById2;
            }
            this.f17148f = this.f17144b.findViewById(R.id.divider_line);
            g();
        }
        AppBarLayout appBarLayout2 = this.f17144b;
        if (appBarLayout2 != null && !this.f17145c) {
            appBarLayout2.addOnOffsetChangedListener(this.i);
            this.f17145c = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17143a = false;
        this.f17145c = false;
        this.f17149g = -1.0f;
        this.i = new a();
        j();
    }
}
