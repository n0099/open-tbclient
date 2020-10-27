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
/* loaded from: classes22.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private AppBarLayout Yh;
    AppBarLayout.OnOffsetChangedListener Yi;
    private boolean Yj;
    private boolean Yk;
    private StickyAppBarLayout.a jtN;
    private NestedScrollHeader jtP;
    private HomeTabBarView jtQ;
    private float jtR;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.jtN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(float f) {
        if (this.jtQ != null) {
            this.jtQ.ay(f);
        }
        if (this.jtP != null) {
            this.jtP.ay(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Yj = false;
        this.Yk = false;
        this.jtR = -1.0f;
        this.Yi = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Yj) {
                        StickyAppBarLayoutBehavior.this.Yj = true;
                        if (StickyAppBarLayoutBehavior.this.jtN != null) {
                            StickyAppBarLayoutBehavior.this.jtN.qL(StickyAppBarLayoutBehavior.this.Yj);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Yj) {
                    StickyAppBarLayoutBehavior.this.Yj = false;
                    if (StickyAppBarLayoutBehavior.this.jtN != null) {
                        StickyAppBarLayoutBehavior.this.jtN.qL(StickyAppBarLayoutBehavior.this.Yj);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jtR != abs) {
                    StickyAppBarLayoutBehavior.this.jtR = abs;
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
        this.Yj = false;
        this.Yk = false;
        this.jtR = -1.0f;
        this.Yi = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Yj) {
                        StickyAppBarLayoutBehavior.this.Yj = true;
                        if (StickyAppBarLayoutBehavior.this.jtN != null) {
                            StickyAppBarLayoutBehavior.this.jtN.qL(StickyAppBarLayoutBehavior.this.Yj);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Yj) {
                    StickyAppBarLayoutBehavior.this.Yj = false;
                    if (StickyAppBarLayoutBehavior.this.jtN != null) {
                        StickyAppBarLayoutBehavior.this.jtN.qL(StickyAppBarLayoutBehavior.this.Yj);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jtR != abs) {
                    StickyAppBarLayoutBehavior.this.jtR = abs;
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

    public void cHq() {
        if (this.Yh != null) {
            this.Yh.setExpanded(true, true);
        }
    }

    public void cHr() {
        if (this.Yh != null) {
            this.Yh.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Yj;
    }

    public NestedScrollHeader cHs() {
        return this.jtP;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Yh != null && !this.Yk) {
            this.Yh.addOnOffsetChangedListener(this.Yi);
            this.Yk = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Yh != null && this.Yk) {
            this.Yh.removeOnOffsetChangedListener(this.Yi);
            this.Yk = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Yh == null) {
            this.Yh = appBarLayout;
            View findViewById = this.Yh.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.jtP = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Yh.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.jtQ = (HomeTabBarView) findViewById2;
            }
            cHt();
        }
        if (this.Yh != null && !this.Yk) {
            this.Yh.addOnOffsetChangedListener(this.Yi);
            this.Yk = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cHt() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Yh instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Yh).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
