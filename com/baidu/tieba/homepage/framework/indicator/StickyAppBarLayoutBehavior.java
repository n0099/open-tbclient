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
/* loaded from: classes7.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private AppBarLayout Ck;
    AppBarLayout.OnOffsetChangedListener Cl;
    private boolean Cm;
    private boolean Cn;
    private StickyAppBarLayout.a gYh;
    private NestedScrollHeader gYk;
    private HomeTabBarView gYl;
    private float gYm;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.gYh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(float f) {
        if (this.gYl != null) {
            this.gYl.az(f);
        }
        if (this.gYk != null) {
            this.gYk.az(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Cm = false;
        this.Cn = false;
        this.gYm = -1.0f;
        this.Cl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Cm) {
                        StickyAppBarLayoutBehavior.this.Cm = true;
                        if (StickyAppBarLayoutBehavior.this.gYh != null) {
                            StickyAppBarLayoutBehavior.this.gYh.mA(StickyAppBarLayoutBehavior.this.Cm);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Cm) {
                    StickyAppBarLayoutBehavior.this.Cm = false;
                    if (StickyAppBarLayoutBehavior.this.gYh != null) {
                        StickyAppBarLayoutBehavior.this.gYh.mA(StickyAppBarLayoutBehavior.this.Cm);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.gYm != abs) {
                    StickyAppBarLayoutBehavior.this.gYm = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aA(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Cm = false;
        this.Cn = false;
        this.gYm = -1.0f;
        this.Cl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Cm) {
                        StickyAppBarLayoutBehavior.this.Cm = true;
                        if (StickyAppBarLayoutBehavior.this.gYh != null) {
                            StickyAppBarLayoutBehavior.this.gYh.mA(StickyAppBarLayoutBehavior.this.Cm);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Cm) {
                    StickyAppBarLayoutBehavior.this.Cm = false;
                    if (StickyAppBarLayoutBehavior.this.gYh != null) {
                        StickyAppBarLayoutBehavior.this.gYh.mA(StickyAppBarLayoutBehavior.this.Cm);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.gYm != abs) {
                    StickyAppBarLayoutBehavior.this.gYm = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aA(f);
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

    public void bMp() {
        if (this.Ck != null) {
            this.Ck.setExpanded(true, true);
        }
    }

    public void bMq() {
        if (this.Ck != null) {
            this.Ck.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Cm;
    }

    public NestedScrollHeader bMr() {
        return this.gYk;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Ck != null && !this.Cn) {
            this.Ck.addOnOffsetChangedListener(this.Cl);
            this.Cn = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Ck != null && this.Cn) {
            this.Ck.removeOnOffsetChangedListener(this.Cl);
            this.Cn = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Ck == null) {
            this.Ck = appBarLayout;
            View findViewById = this.Ck.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.gYk = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Ck.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.gYl = (HomeTabBarView) findViewById2;
            }
            bMs();
        }
        if (this.Ck != null && !this.Cn) {
            this.Ck.addOnOffsetChangedListener(this.Cl);
            this.Cn = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void bMs() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Ck instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Ck).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
        if (this.Cm) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i) {
        if (this.Cm) {
            return false;
        }
        return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (!this.Cm) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        if (!this.Cm) {
            super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, iArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (!this.Cm) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        if (!this.Cm) {
            super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2) {
        if (this.Cm) {
            return false;
        }
        return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        if (this.Cm) {
            return false;
        }
        return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f, f2, z);
    }
}
