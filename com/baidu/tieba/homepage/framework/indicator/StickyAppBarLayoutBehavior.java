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
/* loaded from: classes6.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private AppBarLayout Cf;
    AppBarLayout.OnOffsetChangedListener Cg;
    private boolean Ch;
    private boolean Ci;
    private StickyAppBarLayout.a gUL;
    private NestedScrollHeader gUM;
    private HomeTabBarView gUN;
    private float gUO;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.gUL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(float f) {
        if (this.gUN != null) {
            this.gUN.aA(f);
        }
        if (this.gUM != null) {
            this.gUM.aA(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Ch = false;
        this.Ci = false;
        this.gUO = -1.0f;
        this.Cg = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Ch) {
                        StickyAppBarLayoutBehavior.this.Ch = true;
                        if (StickyAppBarLayoutBehavior.this.gUL != null) {
                            StickyAppBarLayoutBehavior.this.gUL.mp(StickyAppBarLayoutBehavior.this.Ch);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Ch) {
                    StickyAppBarLayoutBehavior.this.Ch = false;
                    if (StickyAppBarLayoutBehavior.this.gUL != null) {
                        StickyAppBarLayoutBehavior.this.gUL.mp(StickyAppBarLayoutBehavior.this.Ch);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.gUO != abs) {
                    StickyAppBarLayoutBehavior.this.gUO = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aB(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ch = false;
        this.Ci = false;
        this.gUO = -1.0f;
        this.Cg = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Ch) {
                        StickyAppBarLayoutBehavior.this.Ch = true;
                        if (StickyAppBarLayoutBehavior.this.gUL != null) {
                            StickyAppBarLayoutBehavior.this.gUL.mp(StickyAppBarLayoutBehavior.this.Ch);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Ch) {
                    StickyAppBarLayoutBehavior.this.Ch = false;
                    if (StickyAppBarLayoutBehavior.this.gUL != null) {
                        StickyAppBarLayoutBehavior.this.gUL.mp(StickyAppBarLayoutBehavior.this.Ch);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.gUO != abs) {
                    StickyAppBarLayoutBehavior.this.gUO = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aB(f);
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

    public void bLi() {
        if (this.Cf != null) {
            this.Cf.setExpanded(true, true);
        }
    }

    public boolean isSticky() {
        return this.Ch;
    }

    public NestedScrollHeader bLj() {
        return this.gUM;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Cf != null && !this.Ci) {
            this.Cf.addOnOffsetChangedListener(this.Cg);
            this.Ci = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Cf != null && this.Ci) {
            this.Cf.removeOnOffsetChangedListener(this.Cg);
            this.Ci = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Cf == null) {
            this.Cf = appBarLayout;
            View findViewById = this.Cf.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.gUM = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Cf.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.gUN = (HomeTabBarView) findViewById2;
            }
            bLk();
        }
        if (this.Cf != null && !this.Ci) {
            this.Cf.addOnOffsetChangedListener(this.Cg);
            this.Ci = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void bLk() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Cf instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Cf).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Ch) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Ch) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Ch) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Ch) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Ch) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Ch) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Ch) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Ch) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
