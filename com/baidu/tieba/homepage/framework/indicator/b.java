package com.baidu.tieba.homepage.framework.indicator;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
/* loaded from: classes4.dex */
public class b extends AppBarLayout.Behavior {
    private AppBarLayout Aa;
    private StickyAppBarLayout.a gij;
    private NestedScrollHeader gik;
    private HomeTabBarView gil;
    private boolean Ac = false;
    private boolean Ae = false;
    private float gim = -1.0f;
    AppBarLayout.OnOffsetChangedListener Ab = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.b.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 0.0f;
            float totalScrollRange = appBarLayout.getTotalScrollRange();
            float abs = Math.abs(i);
            if (abs >= totalScrollRange) {
                if (!b.this.Ac) {
                    b.this.Ac = true;
                    if (b.this.gij != null) {
                        b.this.gij.lc(b.this.Ac);
                    }
                }
            } else if (b.this.Ac) {
                b.this.Ac = false;
                if (b.this.gij != null) {
                    b.this.gij.lc(b.this.Ac);
                }
            }
            if (b.this.gim != abs) {
                b.this.gim = abs;
                if (totalScrollRange > 0.0f) {
                    if (abs != 0.0f) {
                        if (abs >= totalScrollRange) {
                            f = 1.0f;
                        } else {
                            f = abs / totalScrollRange;
                        }
                    }
                    b.this.an(f);
                }
            }
        }
    };

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.gij = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(float f) {
        if (this.gil != null) {
            this.gil.am(f);
        }
        if (this.gik != null) {
            this.gik.am(1.0f - f);
        }
    }

    public b() {
        init();
    }

    private void init() {
        setDragCallback(new AppBarLayout.Behavior.DragCallback() { // from class: com.baidu.tieba.homepage.framework.indicator.b.2
            @Override // android.support.design.widget.AppBarLayout.Behavior.DragCallback
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return false;
            }
        });
    }

    public void btW() {
        if (this.Aa != null) {
            this.Aa.setExpanded(true, true);
        }
    }

    public boolean isSticky() {
        return this.Ac;
    }

    public NestedScrollHeader btX() {
        return this.gik;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Aa != null && !this.Ae) {
            this.Aa.addOnOffsetChangedListener(this.Ab);
            this.Ae = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Aa != null && this.Ae) {
            this.Aa.removeOnOffsetChangedListener(this.Ab);
            this.Ae = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Aa == null) {
            this.Aa = appBarLayout;
            View findViewById = this.Aa.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.gik = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Aa.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.gil = (HomeTabBarView) findViewById2;
            }
            btY();
        }
        if (this.Aa != null && !this.Ae) {
            this.Aa.addOnOffsetChangedListener(this.Ab);
            this.Ae = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void btY() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Aa instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Aa).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Ac) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Ac) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Ac) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Ac) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Ac) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Ac) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Ac) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Ac) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
