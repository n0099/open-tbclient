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
    private AppBarLayout WP;
    AppBarLayout.OnOffsetChangedListener WQ;
    private boolean WR;
    private boolean WS;
    private StickyAppBarLayout.a ivp;
    private NestedScrollHeader ivr;
    private HomeTabBarView ivs;
    private float ivt;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.ivp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(float f) {
        if (this.ivs != null) {
            this.ivs.ak(f);
        }
        if (this.ivr != null) {
            this.ivr.ak(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.WR = false;
        this.WS = false;
        this.ivt = -1.0f;
        this.WQ = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.WR) {
                        StickyAppBarLayoutBehavior.this.WR = true;
                        if (StickyAppBarLayoutBehavior.this.ivp != null) {
                            StickyAppBarLayoutBehavior.this.ivp.oY(StickyAppBarLayoutBehavior.this.WR);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.WR) {
                    StickyAppBarLayoutBehavior.this.WR = false;
                    if (StickyAppBarLayoutBehavior.this.ivp != null) {
                        StickyAppBarLayoutBehavior.this.ivp.oY(StickyAppBarLayoutBehavior.this.WR);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.ivt != abs) {
                    StickyAppBarLayoutBehavior.this.ivt = abs;
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
        this.WR = false;
        this.WS = false;
        this.ivt = -1.0f;
        this.WQ = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.WR) {
                        StickyAppBarLayoutBehavior.this.WR = true;
                        if (StickyAppBarLayoutBehavior.this.ivp != null) {
                            StickyAppBarLayoutBehavior.this.ivp.oY(StickyAppBarLayoutBehavior.this.WR);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.WR) {
                    StickyAppBarLayoutBehavior.this.WR = false;
                    if (StickyAppBarLayoutBehavior.this.ivp != null) {
                        StickyAppBarLayoutBehavior.this.ivp.oY(StickyAppBarLayoutBehavior.this.WR);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.ivt != abs) {
                    StickyAppBarLayoutBehavior.this.ivt = abs;
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

    public void cmk() {
        if (this.WP != null) {
            this.WP.setExpanded(true, true);
        }
    }

    public void cml() {
        if (this.WP != null) {
            this.WP.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.WR;
    }

    public NestedScrollHeader cmm() {
        return this.ivr;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.WP != null && !this.WS) {
            this.WP.addOnOffsetChangedListener(this.WQ);
            this.WS = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.WP != null && this.WS) {
            this.WP.removeOnOffsetChangedListener(this.WQ);
            this.WS = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.WP == null) {
            this.WP = appBarLayout;
            View findViewById = this.WP.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.ivr = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.WP.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.ivs = (HomeTabBarView) findViewById2;
            }
            cmn();
        }
        if (this.WP != null && !this.WS) {
            this.WP.addOnOffsetChangedListener(this.WQ);
            this.WS = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cmn() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.WP instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.WP).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.WR) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.WR) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.WR) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.WR) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.WR) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.WR) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.WR) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.WR) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
