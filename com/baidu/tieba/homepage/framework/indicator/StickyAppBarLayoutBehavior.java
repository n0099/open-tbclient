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
    private AppBarLayout CD;
    AppBarLayout.OnOffsetChangedListener CE;
    private boolean CF;
    private boolean CG;
    private StickyAppBarLayout.a hai;
    private NestedScrollHeader hak;
    private HomeTabBarView hal;
    private float ham;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.hai = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(float f) {
        if (this.hal != null) {
            this.hal.ay(f);
        }
        if (this.hak != null) {
            this.hak.ay(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.CF = false;
        this.CG = false;
        this.ham = -1.0f;
        this.CE = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.CF) {
                        StickyAppBarLayoutBehavior.this.CF = true;
                        if (StickyAppBarLayoutBehavior.this.hai != null) {
                            StickyAppBarLayoutBehavior.this.hai.mC(StickyAppBarLayoutBehavior.this.CF);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.CF) {
                    StickyAppBarLayoutBehavior.this.CF = false;
                    if (StickyAppBarLayoutBehavior.this.hai != null) {
                        StickyAppBarLayoutBehavior.this.hai.mC(StickyAppBarLayoutBehavior.this.CF);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.ham != abs) {
                    StickyAppBarLayoutBehavior.this.ham = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.az(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CF = false;
        this.CG = false;
        this.ham = -1.0f;
        this.CE = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.CF) {
                        StickyAppBarLayoutBehavior.this.CF = true;
                        if (StickyAppBarLayoutBehavior.this.hai != null) {
                            StickyAppBarLayoutBehavior.this.hai.mC(StickyAppBarLayoutBehavior.this.CF);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.CF) {
                    StickyAppBarLayoutBehavior.this.CF = false;
                    if (StickyAppBarLayoutBehavior.this.hai != null) {
                        StickyAppBarLayoutBehavior.this.hai.mC(StickyAppBarLayoutBehavior.this.CF);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.ham != abs) {
                    StickyAppBarLayoutBehavior.this.ham = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.az(f);
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

    public void bNR() {
        if (this.CD != null) {
            this.CD.setExpanded(true, true);
        }
    }

    public void bNS() {
        if (this.CD != null) {
            this.CD.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.CF;
    }

    public NestedScrollHeader bNT() {
        return this.hak;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.CD != null && !this.CG) {
            this.CD.addOnOffsetChangedListener(this.CE);
            this.CG = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.CD != null && this.CG) {
            this.CD.removeOnOffsetChangedListener(this.CE);
            this.CG = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.CD == null) {
            this.CD = appBarLayout;
            View findViewById = this.CD.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.hak = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.CD.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.hal = (HomeTabBarView) findViewById2;
            }
            bNU();
        }
        if (this.CD != null && !this.CG) {
            this.CD.addOnOffsetChangedListener(this.CE);
            this.CG = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void bNU() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.CD instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.CD).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.CF) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.CF) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.CF) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.CF) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.CF) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.CF) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.CF) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.CF) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
