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
    private AppBarLayout VZ;
    AppBarLayout.OnOffsetChangedListener Wa;
    private boolean Wb;
    private boolean Wc;
    private StickyAppBarLayout.a hLu;
    private NestedScrollHeader hLw;
    private HomeTabBarView hLx;
    private float hLy;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.hLu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(float f) {
        if (this.hLx != null) {
            this.hLx.ai(f);
        }
        if (this.hLw != null) {
            this.hLw.ai(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Wb = false;
        this.Wc = false;
        this.hLy = -1.0f;
        this.Wa = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Wb) {
                        StickyAppBarLayoutBehavior.this.Wb = true;
                        if (StickyAppBarLayoutBehavior.this.hLu != null) {
                            StickyAppBarLayoutBehavior.this.hLu.nM(StickyAppBarLayoutBehavior.this.Wb);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Wb) {
                    StickyAppBarLayoutBehavior.this.Wb = false;
                    if (StickyAppBarLayoutBehavior.this.hLu != null) {
                        StickyAppBarLayoutBehavior.this.hLu.nM(StickyAppBarLayoutBehavior.this.Wb);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.hLy != abs) {
                    StickyAppBarLayoutBehavior.this.hLy = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aj(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wb = false;
        this.Wc = false;
        this.hLy = -1.0f;
        this.Wa = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Wb) {
                        StickyAppBarLayoutBehavior.this.Wb = true;
                        if (StickyAppBarLayoutBehavior.this.hLu != null) {
                            StickyAppBarLayoutBehavior.this.hLu.nM(StickyAppBarLayoutBehavior.this.Wb);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Wb) {
                    StickyAppBarLayoutBehavior.this.Wb = false;
                    if (StickyAppBarLayoutBehavior.this.hLu != null) {
                        StickyAppBarLayoutBehavior.this.hLu.nM(StickyAppBarLayoutBehavior.this.Wb);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.hLy != abs) {
                    StickyAppBarLayoutBehavior.this.hLy = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aj(f);
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

    public void bYJ() {
        if (this.VZ != null) {
            this.VZ.setExpanded(true, true);
        }
    }

    public void bYK() {
        if (this.VZ != null) {
            this.VZ.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Wb;
    }

    public NestedScrollHeader bYL() {
        return this.hLw;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.VZ != null && !this.Wc) {
            this.VZ.addOnOffsetChangedListener(this.Wa);
            this.Wc = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.VZ != null && this.Wc) {
            this.VZ.removeOnOffsetChangedListener(this.Wa);
            this.Wc = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.VZ == null) {
            this.VZ = appBarLayout;
            View findViewById = this.VZ.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.hLw = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.VZ.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.hLx = (HomeTabBarView) findViewById2;
            }
            bYM();
        }
        if (this.VZ != null && !this.Wc) {
            this.VZ.addOnOffsetChangedListener(this.Wa);
            this.Wc = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void bYM() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.VZ instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.VZ).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Wb) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Wb) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Wb) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Wb) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Wb) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Wb) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Wb) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Wb) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
