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
    private StickyAppBarLayout.a ghr;
    private NestedScrollHeader ghs;
    private HomeTabBarView ght;
    private AppBarLayout zA;
    private boolean zC = false;
    private boolean zD = false;
    private float ghu = -1.0f;
    AppBarLayout.OnOffsetChangedListener zB = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.b.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            float f = 0.0f;
            float totalScrollRange = appBarLayout.getTotalScrollRange();
            float abs = Math.abs(i);
            if (abs >= totalScrollRange) {
                if (!b.this.zC) {
                    b.this.zC = true;
                    if (b.this.ghr != null) {
                        b.this.ghr.lc(b.this.zC);
                    }
                }
            } else if (b.this.zC) {
                b.this.zC = false;
                if (b.this.ghr != null) {
                    b.this.ghr.lc(b.this.zC);
                }
            }
            if (b.this.ghu != abs) {
                b.this.ghu = abs;
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
        this.ghr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(float f) {
        if (this.ght != null) {
            this.ght.am(f);
        }
        if (this.ghs != null) {
            this.ghs.am(1.0f - f);
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

    public void btU() {
        if (this.zA != null) {
            this.zA.setExpanded(true, true);
        }
    }

    public boolean isSticky() {
        return this.zC;
    }

    public NestedScrollHeader btV() {
        return this.ghs;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.zA != null && !this.zD) {
            this.zA.addOnOffsetChangedListener(this.zB);
            this.zD = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.zA != null && this.zD) {
            this.zA.removeOnOffsetChangedListener(this.zB);
            this.zD = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.zA == null) {
            this.zA = appBarLayout;
            View findViewById = this.zA.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.ghs = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.zA.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.ght = (HomeTabBarView) findViewById2;
            }
            btW();
        }
        if (this.zA != null && !this.zD) {
            this.zA.addOnOffsetChangedListener(this.zB);
            this.zD = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void btW() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.zA instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.zA).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.zC) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.zC) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.zC) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.zC) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.zC) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.zC) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.zC) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.zC) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
