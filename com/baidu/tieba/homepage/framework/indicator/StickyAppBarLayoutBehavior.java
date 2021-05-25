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
    public boolean f16305a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout f16306b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16307c;

    /* renamed from: d  reason: collision with root package name */
    public NestedScrollHeader f16308d;

    /* renamed from: e  reason: collision with root package name */
    public HomeTabBarView f16309e;

    /* renamed from: f  reason: collision with root package name */
    public View f16310f;

    /* renamed from: g  reason: collision with root package name */
    public float f16311g;

    /* renamed from: h  reason: collision with root package name */
    public StickyAppBarLayout.b f16312h;

    /* renamed from: i  reason: collision with root package name */
    public AppBarLayout.OnOffsetChangedListener f16313i;

    /* loaded from: classes4.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921553, Integer.valueOf(i2)));
            float totalScrollRange = appBarLayout.getTotalScrollRange();
            float abs = Math.abs(i2);
            int i3 = (abs > totalScrollRange ? 1 : (abs == totalScrollRange ? 0 : -1));
            if (i3 >= 0) {
                if (!StickyAppBarLayoutBehavior.this.f16305a) {
                    StickyAppBarLayoutBehavior.this.f16305a = true;
                    if (StickyAppBarLayoutBehavior.this.f16312h != null) {
                        StickyAppBarLayoutBehavior.this.f16312h.a(StickyAppBarLayoutBehavior.this.f16305a);
                    }
                }
            } else if (StickyAppBarLayoutBehavior.this.f16305a) {
                StickyAppBarLayoutBehavior.this.f16305a = false;
                if (StickyAppBarLayoutBehavior.this.f16312h != null) {
                    StickyAppBarLayoutBehavior.this.f16312h.a(StickyAppBarLayoutBehavior.this.f16305a);
                }
            }
            if (StickyAppBarLayoutBehavior.this.f16311g == abs) {
                return;
            }
            StickyAppBarLayoutBehavior.this.f16311g = abs;
            if (totalScrollRange <= 0.0f) {
                return;
            }
            StickyAppBarLayoutBehavior.this.m(abs != 0.0f ? i3 >= 0 ? 1.0f : abs / totalScrollRange : 0.0f);
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
        this.f16305a = false;
        this.f16307c = false;
        this.f16311g = -1.0f;
        this.f16313i = new a();
        j();
    }

    public void g() {
        StickyAppBarLayout.b onHeaderStickyListener;
        AppBarLayout appBarLayout = this.f16306b;
        if (!(appBarLayout instanceof StickyAppBarLayout) || (onHeaderStickyListener = ((StickyAppBarLayout) appBarLayout).getOnHeaderStickyListener()) == null) {
            return;
        }
        k(onHeaderStickyListener);
    }

    public NestedScrollHeader h() {
        return this.f16308d;
    }

    public void i() {
        AppBarLayout appBarLayout = this.f16306b;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.f16305a;
    }

    public final void j() {
        setDragCallback(new b(this));
    }

    public void k(StickyAppBarLayout.b bVar) {
        this.f16312h = bVar;
    }

    public void l() {
        AppBarLayout appBarLayout = this.f16306b;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(true, true);
        }
    }

    public final void m(float f2) {
        int i2;
        HomeTabBarView homeTabBarView = this.f16309e;
        if (homeTabBarView != null) {
            homeTabBarView.n(f2);
        }
        NestedScrollHeader nestedScrollHeader = this.f16308d;
        if (nestedScrollHeader != null) {
            nestedScrollHeader.q(1.0f - f2);
        }
        View view = this.f16310f;
        if (view == null || f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        if (i2 == 0) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        this.f16310f.setAlpha(f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        AppBarLayout appBarLayout = this.f16306b;
        if (appBarLayout == null || this.f16307c) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(this.f16313i);
        this.f16307c = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        AppBarLayout appBarLayout = this.f16306b;
        if (appBarLayout == null || !this.f16307c) {
            return;
        }
        appBarLayout.removeOnOffsetChangedListener(this.f16313i);
        this.f16307c = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        if (this.f16306b == null) {
            this.f16306b = appBarLayout;
            View findViewById = appBarLayout.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.f16308d = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.f16306b.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.f16309e = (HomeTabBarView) findViewById2;
            }
            this.f16310f = this.f16306b.findViewById(R.id.divider_line);
            g();
        }
        AppBarLayout appBarLayout2 = this.f16306b;
        if (appBarLayout2 != null && !this.f16307c) {
            appBarLayout2.addOnOffsetChangedListener(this.f16313i);
            this.f16307c = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16305a = false;
        this.f16307c = false;
        this.f16311g = -1.0f;
        this.f16313i = new a();
        j();
    }
}
