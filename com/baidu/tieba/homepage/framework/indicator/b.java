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
    private AppBarLayout Qj;
    private StickyAppBarLayout.a ggc;
    private NestedScrollHeader ggd;
    private HomeTabBarView gge;
    private boolean Ql = false;
    private boolean Qm = false;
    private float ggf = -1.0f;
    AppBarLayout.OnOffsetChangedListener Qk = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.b.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 0.0f;
            float totalScrollRange = appBarLayout.getTotalScrollRange();
            float abs = Math.abs(i);
            if (abs >= totalScrollRange) {
                if (!b.this.Ql) {
                    b.this.Ql = true;
                    if (b.this.ggc != null) {
                        b.this.ggc.ll(b.this.Ql);
                    }
                }
            } else if (b.this.Ql) {
                b.this.Ql = false;
                if (b.this.ggc != null) {
                    b.this.ggc.ll(b.this.Ql);
                }
            }
            if (b.this.ggf != abs) {
                b.this.ggf = abs;
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
        this.ggc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        if (this.gge != null) {
            this.gge.aF(f);
        }
        if (this.ggd != null) {
            this.ggd.aF(1.0f - f);
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

    public void bvQ() {
        if (this.Qj != null) {
            this.Qj.setExpanded(true, true);
        }
    }

    public boolean isSticky() {
        return this.Ql;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Qj != null && !this.Qm) {
            this.Qj.addOnOffsetChangedListener(this.Qk);
            this.Qm = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Qj != null && this.Qm) {
            this.Qj.removeOnOffsetChangedListener(this.Qk);
            this.Qm = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Qj == null) {
            this.Qj = appBarLayout;
            View findViewById = this.Qj.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.ggd = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Qj.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.gge = (HomeTabBarView) findViewById2;
            }
            bvR();
        }
        if (this.Qj != null && !this.Qm) {
            this.Qj.addOnOffsetChangedListener(this.Qk);
            this.Qm = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void bvR() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Qj instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Qj).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Ql) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Ql) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Ql) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Ql) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Ql) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Ql) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Ql) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Ql) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
