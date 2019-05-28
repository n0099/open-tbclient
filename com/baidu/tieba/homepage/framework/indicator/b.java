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
    private AppBarLayout PR;
    private StickyAppBarLayout.a gaY;
    private NestedScrollHeader gaZ;
    private HomeTabBarView gba;
    private boolean PU = false;
    private boolean PV = false;
    private float gbb = -1.0f;
    AppBarLayout.OnOffsetChangedListener PT = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.b.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 0.0f;
            float totalScrollRange = appBarLayout.getTotalScrollRange();
            float abs = Math.abs(i);
            if (abs >= totalScrollRange) {
                if (!b.this.PU) {
                    b.this.PU = true;
                    if (b.this.gaY != null) {
                        b.this.gaY.la(b.this.PU);
                    }
                }
            } else if (b.this.PU) {
                b.this.PU = false;
                if (b.this.gaY != null) {
                    b.this.gaY.la(b.this.PU);
                }
            }
            if (b.this.gbb != abs) {
                b.this.gbb = abs;
                if (totalScrollRange > 0.0f) {
                    if (abs != 0.0f) {
                        if (abs >= totalScrollRange) {
                            f = 1.0f;
                        } else {
                            f = abs / totalScrollRange;
                        }
                    }
                    b.this.aG(f);
                }
            }
        }
    };

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.gaY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        if (this.gba != null) {
            this.gba.aF(f);
        }
        if (this.gaZ != null) {
            this.gaZ.aF(1.0f - f);
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

    public void btM() {
        if (this.PR != null) {
            this.PR.setExpanded(true, true);
        }
    }

    public boolean isSticky() {
        return this.PU;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.PR != null && !this.PV) {
            this.PR.addOnOffsetChangedListener(this.PT);
            this.PV = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.PR != null && this.PV) {
            this.PR.removeOnOffsetChangedListener(this.PT);
            this.PV = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.PR == null) {
            this.PR = appBarLayout;
            View findViewById = this.PR.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.gaZ = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.PR.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.gba = (HomeTabBarView) findViewById2;
            }
            btN();
        }
        if (this.PR != null && !this.PV) {
            this.PR.addOnOffsetChangedListener(this.PT);
            this.PV = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void btN() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.PR instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.PR).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.PU) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.PU) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.PU) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.PU) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.PU) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.PU) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.PU) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.PU) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
