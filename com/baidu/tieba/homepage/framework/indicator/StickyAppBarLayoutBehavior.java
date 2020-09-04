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
    private boolean XA;
    private AppBarLayout Xx;
    AppBarLayout.OnOffsetChangedListener Xy;
    private boolean Xz;
    private StickyAppBarLayout.a iJM;
    private NestedScrollHeader iJO;
    private HomeTabBarView iJP;
    private float iJQ;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.iJM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f) {
        if (this.iJP != null) {
            this.iJP.aq(f);
        }
        if (this.iJO != null) {
            this.iJO.aq(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Xz = false;
        this.XA = false;
        this.iJQ = -1.0f;
        this.Xy = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Xz) {
                        StickyAppBarLayoutBehavior.this.Xz = true;
                        if (StickyAppBarLayoutBehavior.this.iJM != null) {
                            StickyAppBarLayoutBehavior.this.iJM.pF(StickyAppBarLayoutBehavior.this.Xz);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Xz) {
                    StickyAppBarLayoutBehavior.this.Xz = false;
                    if (StickyAppBarLayoutBehavior.this.iJM != null) {
                        StickyAppBarLayoutBehavior.this.iJM.pF(StickyAppBarLayoutBehavior.this.Xz);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.iJQ != abs) {
                    StickyAppBarLayoutBehavior.this.iJQ = abs;
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
        this.Xz = false;
        this.XA = false;
        this.iJQ = -1.0f;
        this.Xy = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Xz) {
                        StickyAppBarLayoutBehavior.this.Xz = true;
                        if (StickyAppBarLayoutBehavior.this.iJM != null) {
                            StickyAppBarLayoutBehavior.this.iJM.pF(StickyAppBarLayoutBehavior.this.Xz);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Xz) {
                    StickyAppBarLayoutBehavior.this.Xz = false;
                    if (StickyAppBarLayoutBehavior.this.iJM != null) {
                        StickyAppBarLayoutBehavior.this.iJM.pF(StickyAppBarLayoutBehavior.this.Xz);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.iJQ != abs) {
                    StickyAppBarLayoutBehavior.this.iJQ = abs;
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

    public void cwU() {
        if (this.Xx != null) {
            this.Xx.setExpanded(true, true);
        }
    }

    public void cwV() {
        if (this.Xx != null) {
            this.Xx.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Xz;
    }

    public NestedScrollHeader cwW() {
        return this.iJO;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Xx != null && !this.XA) {
            this.Xx.addOnOffsetChangedListener(this.Xy);
            this.XA = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Xx != null && this.XA) {
            this.Xx.removeOnOffsetChangedListener(this.Xy);
            this.XA = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Xx == null) {
            this.Xx = appBarLayout;
            View findViewById = this.Xx.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.iJO = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Xx.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.iJP = (HomeTabBarView) findViewById2;
            }
            cwX();
        }
        if (this.Xx != null && !this.XA) {
            this.Xx.addOnOffsetChangedListener(this.Xy);
            this.XA = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cwX() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Xx instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Xx).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Xz) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Xz) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Xz) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Xz) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Xz) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Xz) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Xz) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Xz) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
