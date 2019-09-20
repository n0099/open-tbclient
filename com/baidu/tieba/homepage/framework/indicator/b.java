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
    private AppBarLayout Qi;
    private StickyAppBarLayout.a giL;
    private NestedScrollHeader giM;
    private HomeTabBarView giN;
    private boolean Qk = false;
    private boolean Ql = false;
    private float giO = -1.0f;
    AppBarLayout.OnOffsetChangedListener Qj = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.b.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 0.0f;
            float totalScrollRange = appBarLayout.getTotalScrollRange();
            float abs = Math.abs(i);
            if (abs >= totalScrollRange) {
                if (!b.this.Qk) {
                    b.this.Qk = true;
                    if (b.this.giL != null) {
                        b.this.giL.lo(b.this.Qk);
                    }
                }
            } else if (b.this.Qk) {
                b.this.Qk = false;
                if (b.this.giL != null) {
                    b.this.giL.lo(b.this.Qk);
                }
            }
            if (b.this.giO != abs) {
                b.this.giO = abs;
                if (totalScrollRange > 0.0f) {
                    if (abs != 0.0f) {
                        if (abs >= totalScrollRange) {
                            f = 1.0f;
                        } else {
                            f = abs / totalScrollRange;
                        }
                    }
                    b.this.aH(f);
                }
            }
        }
    };

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.giL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f) {
        if (this.giN != null) {
            this.giN.aG(f);
        }
        if (this.giM != null) {
            this.giM.aG(1.0f - f);
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

    public void bwR() {
        if (this.Qi != null) {
            this.Qi.setExpanded(true, true);
        }
    }

    public boolean isSticky() {
        return this.Qk;
    }

    public NestedScrollHeader bwS() {
        return this.giM;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Qi != null && !this.Ql) {
            this.Qi.addOnOffsetChangedListener(this.Qj);
            this.Ql = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Qi != null && this.Ql) {
            this.Qi.removeOnOffsetChangedListener(this.Qj);
            this.Ql = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Qi == null) {
            this.Qi = appBarLayout;
            View findViewById = this.Qi.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.giM = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Qi.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.giN = (HomeTabBarView) findViewById2;
            }
            bwT();
        }
        if (this.Qi != null && !this.Ql) {
            this.Qi.addOnOffsetChangedListener(this.Qj);
            this.Ql = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void bwT() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Qi instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Qi).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Qk) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Qk) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Qk) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Qk) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Qk) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Qk) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Qk) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Qk) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
