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
    public boolean f17085a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout f17086b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17087c;

    /* renamed from: d  reason: collision with root package name */
    public NestedScrollHeader f17088d;

    /* renamed from: e  reason: collision with root package name */
    public HomeTabBarView f17089e;

    /* renamed from: f  reason: collision with root package name */
    public View f17090f;

    /* renamed from: g  reason: collision with root package name */
    public float f17091g;

    /* renamed from: h  reason: collision with root package name */
    public StickyAppBarLayout.b f17092h;

    /* renamed from: i  reason: collision with root package name */
    public AppBarLayout.OnOffsetChangedListener f17093i;

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
                if (!StickyAppBarLayoutBehavior.this.f17085a) {
                    StickyAppBarLayoutBehavior.this.f17085a = true;
                    if (StickyAppBarLayoutBehavior.this.f17092h != null) {
                        StickyAppBarLayoutBehavior.this.f17092h.a(StickyAppBarLayoutBehavior.this.f17085a);
                    }
                }
            } else if (StickyAppBarLayoutBehavior.this.f17085a) {
                StickyAppBarLayoutBehavior.this.f17085a = false;
                if (StickyAppBarLayoutBehavior.this.f17092h != null) {
                    StickyAppBarLayoutBehavior.this.f17092h.a(StickyAppBarLayoutBehavior.this.f17085a);
                }
            }
            if (StickyAppBarLayoutBehavior.this.f17091g == abs) {
                return;
            }
            StickyAppBarLayoutBehavior.this.f17091g = abs;
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
        this.f17085a = false;
        this.f17087c = false;
        this.f17091g = -1.0f;
        this.f17093i = new a();
        j();
    }

    public void g() {
        StickyAppBarLayout.b onHeaderStickyListener;
        AppBarLayout appBarLayout = this.f17086b;
        if (!(appBarLayout instanceof StickyAppBarLayout) || (onHeaderStickyListener = ((StickyAppBarLayout) appBarLayout).getOnHeaderStickyListener()) == null) {
            return;
        }
        k(onHeaderStickyListener);
    }

    public NestedScrollHeader h() {
        return this.f17088d;
    }

    public void i() {
        AppBarLayout appBarLayout = this.f17086b;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.f17085a;
    }

    public final void j() {
        setDragCallback(new b(this));
    }

    public void k(StickyAppBarLayout.b bVar) {
        this.f17092h = bVar;
    }

    public void l() {
        AppBarLayout appBarLayout = this.f17086b;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(true, true);
        }
    }

    public final void m(float f2) {
        int i2;
        HomeTabBarView homeTabBarView = this.f17089e;
        if (homeTabBarView != null) {
            homeTabBarView.n(f2);
        }
        NestedScrollHeader nestedScrollHeader = this.f17088d;
        if (nestedScrollHeader != null) {
            nestedScrollHeader.r(1.0f - f2);
        }
        View view = this.f17090f;
        if (view == null || f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        if (i2 == 0) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        this.f17090f.setAlpha(f2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        AppBarLayout appBarLayout = this.f17086b;
        if (appBarLayout == null || this.f17087c) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener(this.f17093i);
        this.f17087c = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        AppBarLayout appBarLayout = this.f17086b;
        if (appBarLayout == null || !this.f17087c) {
            return;
        }
        appBarLayout.removeOnOffsetChangedListener(this.f17093i);
        this.f17087c = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        if (this.f17086b == null) {
            this.f17086b = appBarLayout;
            View findViewById = appBarLayout.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.f17088d = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.f17086b.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.f17089e = (HomeTabBarView) findViewById2;
            }
            this.f17090f = this.f17086b.findViewById(R.id.divider_line);
            g();
        }
        AppBarLayout appBarLayout2 = this.f17086b;
        if (appBarLayout2 != null && !this.f17087c) {
            appBarLayout2.addOnOffsetChangedListener(this.f17093i);
            this.f17087c = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17085a = false;
        this.f17087c = false;
        this.f17091g = -1.0f;
        this.f17093i = new a();
        j();
    }
}
