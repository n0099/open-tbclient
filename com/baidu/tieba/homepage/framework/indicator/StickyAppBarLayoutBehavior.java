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
/* loaded from: classes16.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private AppBarLayout Xv;
    AppBarLayout.OnOffsetChangedListener Xw;
    private boolean Xx;
    private boolean Xy;
    private StickyAppBarLayout.a iJG;
    private NestedScrollHeader iJI;
    private HomeTabBarView iJJ;
    private float iJK;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.iJG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f) {
        if (this.iJJ != null) {
            this.iJJ.aq(f);
        }
        if (this.iJI != null) {
            this.iJI.aq(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Xx = false;
        this.Xy = false;
        this.iJK = -1.0f;
        this.Xw = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Xx) {
                        StickyAppBarLayoutBehavior.this.Xx = true;
                        if (StickyAppBarLayoutBehavior.this.iJG != null) {
                            StickyAppBarLayoutBehavior.this.iJG.pD(StickyAppBarLayoutBehavior.this.Xx);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Xx) {
                    StickyAppBarLayoutBehavior.this.Xx = false;
                    if (StickyAppBarLayoutBehavior.this.iJG != null) {
                        StickyAppBarLayoutBehavior.this.iJG.pD(StickyAppBarLayoutBehavior.this.Xx);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.iJK != abs) {
                    StickyAppBarLayoutBehavior.this.iJK = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.ar(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xx = false;
        this.Xy = false;
        this.iJK = -1.0f;
        this.Xw = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Xx) {
                        StickyAppBarLayoutBehavior.this.Xx = true;
                        if (StickyAppBarLayoutBehavior.this.iJG != null) {
                            StickyAppBarLayoutBehavior.this.iJG.pD(StickyAppBarLayoutBehavior.this.Xx);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Xx) {
                    StickyAppBarLayoutBehavior.this.Xx = false;
                    if (StickyAppBarLayoutBehavior.this.iJG != null) {
                        StickyAppBarLayoutBehavior.this.iJG.pD(StickyAppBarLayoutBehavior.this.Xx);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.iJK != abs) {
                    StickyAppBarLayoutBehavior.this.iJK = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.ar(f);
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

    public void cwT() {
        if (this.Xv != null) {
            this.Xv.setExpanded(true, true);
        }
    }

    public void cwU() {
        if (this.Xv != null) {
            this.Xv.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Xx;
    }

    public NestedScrollHeader cwV() {
        return this.iJI;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Xv != null && !this.Xy) {
            this.Xv.addOnOffsetChangedListener(this.Xw);
            this.Xy = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Xv != null && this.Xy) {
            this.Xv.removeOnOffsetChangedListener(this.Xw);
            this.Xy = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Xv == null) {
            this.Xv = appBarLayout;
            View findViewById = this.Xv.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.iJI = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Xv.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.iJJ = (HomeTabBarView) findViewById2;
            }
            cwW();
        }
        if (this.Xv != null && !this.Xy) {
            this.Xv.addOnOffsetChangedListener(this.Xw);
            this.Xy = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cwW() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Xv instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Xv).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Xx) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Xx) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Xx) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Xx) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Xx) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Xx) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Xx) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Xx) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
