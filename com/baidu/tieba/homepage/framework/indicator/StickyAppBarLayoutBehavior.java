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
    private AppBarLayout Wc;
    AppBarLayout.OnOffsetChangedListener We;
    private boolean Wf;
    private boolean Wg;
    private StickyAppBarLayout.a hLA;
    private NestedScrollHeader hLC;
    private HomeTabBarView hLD;
    private float hLE;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.hLA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(float f) {
        if (this.hLD != null) {
            this.hLD.ai(f);
        }
        if (this.hLC != null) {
            this.hLC.ai(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Wf = false;
        this.Wg = false;
        this.hLE = -1.0f;
        this.We = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Wf) {
                        StickyAppBarLayoutBehavior.this.Wf = true;
                        if (StickyAppBarLayoutBehavior.this.hLA != null) {
                            StickyAppBarLayoutBehavior.this.hLA.nM(StickyAppBarLayoutBehavior.this.Wf);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Wf) {
                    StickyAppBarLayoutBehavior.this.Wf = false;
                    if (StickyAppBarLayoutBehavior.this.hLA != null) {
                        StickyAppBarLayoutBehavior.this.hLA.nM(StickyAppBarLayoutBehavior.this.Wf);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.hLE != abs) {
                    StickyAppBarLayoutBehavior.this.hLE = abs;
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
        this.Wf = false;
        this.Wg = false;
        this.hLE = -1.0f;
        this.We = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Wf) {
                        StickyAppBarLayoutBehavior.this.Wf = true;
                        if (StickyAppBarLayoutBehavior.this.hLA != null) {
                            StickyAppBarLayoutBehavior.this.hLA.nM(StickyAppBarLayoutBehavior.this.Wf);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Wf) {
                    StickyAppBarLayoutBehavior.this.Wf = false;
                    if (StickyAppBarLayoutBehavior.this.hLA != null) {
                        StickyAppBarLayoutBehavior.this.hLA.nM(StickyAppBarLayoutBehavior.this.Wf);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.hLE != abs) {
                    StickyAppBarLayoutBehavior.this.hLE = abs;
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

    public void bYI() {
        if (this.Wc != null) {
            this.Wc.setExpanded(true, true);
        }
    }

    public void bYJ() {
        if (this.Wc != null) {
            this.Wc.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Wf;
    }

    public NestedScrollHeader bYK() {
        return this.hLC;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Wc != null && !this.Wg) {
            this.Wc.addOnOffsetChangedListener(this.We);
            this.Wg = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Wc != null && this.Wg) {
            this.Wc.removeOnOffsetChangedListener(this.We);
            this.Wg = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Wc == null) {
            this.Wc = appBarLayout;
            View findViewById = this.Wc.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.hLC = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Wc.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.hLD = (HomeTabBarView) findViewById2;
            }
            bYL();
        }
        if (this.Wc != null && !this.Wg) {
            this.Wc.addOnOffsetChangedListener(this.We);
            this.Wg = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void bYL() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Wc instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Wc).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Wf) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Wf) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Wf) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Wf) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Wf) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Wf) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Wf) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Wf) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
