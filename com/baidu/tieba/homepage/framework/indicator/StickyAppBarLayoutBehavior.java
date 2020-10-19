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
    private AppBarLayout Yg;
    AppBarLayout.OnOffsetChangedListener Yh;
    private boolean Yi;
    private boolean Yj;
    private StickyAppBarLayout.a jhp;
    private NestedScrollHeader jhr;
    private HomeTabBarView jhs;
    private float jht;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.jhp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(float f) {
        if (this.jhs != null) {
            this.jhs.aw(f);
        }
        if (this.jhr != null) {
            this.jhr.aw(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Yi = false;
        this.Yj = false;
        this.jht = -1.0f;
        this.Yh = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Yi) {
                        StickyAppBarLayoutBehavior.this.Yi = true;
                        if (StickyAppBarLayoutBehavior.this.jhp != null) {
                            StickyAppBarLayoutBehavior.this.jhp.qt(StickyAppBarLayoutBehavior.this.Yi);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Yi) {
                    StickyAppBarLayoutBehavior.this.Yi = false;
                    if (StickyAppBarLayoutBehavior.this.jhp != null) {
                        StickyAppBarLayoutBehavior.this.jhp.qt(StickyAppBarLayoutBehavior.this.Yi);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jht != abs) {
                    StickyAppBarLayoutBehavior.this.jht = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.ax(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yi = false;
        this.Yj = false;
        this.jht = -1.0f;
        this.Yh = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Yi) {
                        StickyAppBarLayoutBehavior.this.Yi = true;
                        if (StickyAppBarLayoutBehavior.this.jhp != null) {
                            StickyAppBarLayoutBehavior.this.jhp.qt(StickyAppBarLayoutBehavior.this.Yi);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Yi) {
                    StickyAppBarLayoutBehavior.this.Yi = false;
                    if (StickyAppBarLayoutBehavior.this.jhp != null) {
                        StickyAppBarLayoutBehavior.this.jhp.qt(StickyAppBarLayoutBehavior.this.Yi);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jht != abs) {
                    StickyAppBarLayoutBehavior.this.jht = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.ax(f);
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

    public void cEj() {
        if (this.Yg != null) {
            this.Yg.setExpanded(true, true);
        }
    }

    public void cEk() {
        if (this.Yg != null) {
            this.Yg.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Yi;
    }

    public NestedScrollHeader cEl() {
        return this.jhr;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Yg != null && !this.Yj) {
            this.Yg.addOnOffsetChangedListener(this.Yh);
            this.Yj = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Yg != null && this.Yj) {
            this.Yg.removeOnOffsetChangedListener(this.Yh);
            this.Yj = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Yg == null) {
            this.Yg = appBarLayout;
            View findViewById = this.Yg.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.jhr = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Yg.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.jhs = (HomeTabBarView) findViewById2;
            }
            cEm();
        }
        if (this.Yg != null && !this.Yj) {
            this.Yg.addOnOffsetChangedListener(this.Yh);
            this.Yj = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cEm() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Yg instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Yg).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
