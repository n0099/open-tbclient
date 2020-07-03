package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
/* loaded from: classes9.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private AppBarLayout WW;
    AppBarLayout.OnOffsetChangedListener WX;
    private boolean WY;
    private boolean WZ;
    private StickyAppBarLayout.a ipl;
    private NestedScrollHeader ipn;
    private HomeTabBarView ipo;
    private float ipp;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.ipl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(float f) {
        if (this.ipo != null) {
            this.ipo.ak(f);
        }
        if (this.ipn != null) {
            this.ipn.ak(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.WY = false;
        this.WZ = false;
        this.ipp = -1.0f;
        this.WX = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.WY) {
                        StickyAppBarLayoutBehavior.this.WY = true;
                        if (StickyAppBarLayoutBehavior.this.ipl != null) {
                            StickyAppBarLayoutBehavior.this.ipl.ot(StickyAppBarLayoutBehavior.this.WY);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.WY) {
                    StickyAppBarLayoutBehavior.this.WY = false;
                    if (StickyAppBarLayoutBehavior.this.ipl != null) {
                        StickyAppBarLayoutBehavior.this.ipl.ot(StickyAppBarLayoutBehavior.this.WY);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.ipp != abs) {
                    StickyAppBarLayoutBehavior.this.ipp = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.al(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WY = false;
        this.WZ = false;
        this.ipp = -1.0f;
        this.WX = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.WY) {
                        StickyAppBarLayoutBehavior.this.WY = true;
                        if (StickyAppBarLayoutBehavior.this.ipl != null) {
                            StickyAppBarLayoutBehavior.this.ipl.ot(StickyAppBarLayoutBehavior.this.WY);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.WY) {
                    StickyAppBarLayoutBehavior.this.WY = false;
                    if (StickyAppBarLayoutBehavior.this.ipl != null) {
                        StickyAppBarLayoutBehavior.this.ipl.ot(StickyAppBarLayoutBehavior.this.WY);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.ipp != abs) {
                    StickyAppBarLayoutBehavior.this.ipp = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.al(f);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        setDragCallback(new AppBarLayout.Behavior.DragCallback() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.2
            @Override // android.support.design.widget.AppBarLayout.Behavior.DragCallback
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return false;
            }
        });
    }

    public void ciI() {
        if (this.WW != null) {
            this.WW.setExpanded(true, true);
        }
    }

    public void ciJ() {
        if (this.WW != null) {
            this.WW.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.WY;
    }

    public NestedScrollHeader ciK() {
        return this.ipn;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.WW != null && !this.WZ) {
            this.WW.addOnOffsetChangedListener(this.WX);
            this.WZ = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.WW != null && this.WZ) {
            this.WW.removeOnOffsetChangedListener(this.WX);
            this.WZ = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.WW == null) {
            this.WW = appBarLayout;
            View findViewById = this.WW.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.ipn = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.WW.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.ipo = (HomeTabBarView) findViewById2;
            }
            ciL();
        }
        if (this.WW != null && !this.WZ) {
            this.WW.addOnOffsetChangedListener(this.WX);
            this.WZ = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void ciL() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.WW instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.WW).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.WY) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.WY) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.WY) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.WY) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.WY) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.WY) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.WY) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.WY) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
