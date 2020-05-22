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
    private AppBarLayout Wr;
    AppBarLayout.OnOffsetChangedListener Ws;
    private boolean Wt;
    private boolean Wu;
    private StickyAppBarLayout.a iab;
    private NestedScrollHeader iad;
    private HomeTabBarView iae;
    private float iaf;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.iab = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(float f) {
        if (this.iae != null) {
            this.iae.ag(f);
        }
        if (this.iad != null) {
            this.iad.ag(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Wt = false;
        this.Wu = false;
        this.iaf = -1.0f;
        this.Ws = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Wt) {
                        StickyAppBarLayoutBehavior.this.Wt = true;
                        if (StickyAppBarLayoutBehavior.this.iab != null) {
                            StickyAppBarLayoutBehavior.this.iab.oi(StickyAppBarLayoutBehavior.this.Wt);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Wt) {
                    StickyAppBarLayoutBehavior.this.Wt = false;
                    if (StickyAppBarLayoutBehavior.this.iab != null) {
                        StickyAppBarLayoutBehavior.this.iab.oi(StickyAppBarLayoutBehavior.this.Wt);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.iaf != abs) {
                    StickyAppBarLayoutBehavior.this.iaf = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.ah(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wt = false;
        this.Wu = false;
        this.iaf = -1.0f;
        this.Ws = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Wt) {
                        StickyAppBarLayoutBehavior.this.Wt = true;
                        if (StickyAppBarLayoutBehavior.this.iab != null) {
                            StickyAppBarLayoutBehavior.this.iab.oi(StickyAppBarLayoutBehavior.this.Wt);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Wt) {
                    StickyAppBarLayoutBehavior.this.Wt = false;
                    if (StickyAppBarLayoutBehavior.this.iab != null) {
                        StickyAppBarLayoutBehavior.this.iab.oi(StickyAppBarLayoutBehavior.this.Wt);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.iaf != abs) {
                    StickyAppBarLayoutBehavior.this.iaf = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.ah(f);
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

    public void cfd() {
        if (this.Wr != null) {
            this.Wr.setExpanded(true, true);
        }
    }

    public void cfe() {
        if (this.Wr != null) {
            this.Wr.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Wt;
    }

    public NestedScrollHeader cff() {
        return this.iad;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Wr != null && !this.Wu) {
            this.Wr.addOnOffsetChangedListener(this.Ws);
            this.Wu = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Wr != null && this.Wu) {
            this.Wr.removeOnOffsetChangedListener(this.Ws);
            this.Wu = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Wr == null) {
            this.Wr = appBarLayout;
            View findViewById = this.Wr.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.iad = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Wr.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.iae = (HomeTabBarView) findViewById2;
            }
            cfg();
        }
        if (this.Wr != null && !this.Wu) {
            this.Wr.addOnOffsetChangedListener(this.Ws);
            this.Wu = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cfg() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Wr instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Wr).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Wt) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Wt) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Wt) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Wt) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Wt) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Wt) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Wt) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Wt) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
