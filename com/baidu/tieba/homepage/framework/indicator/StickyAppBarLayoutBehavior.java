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
    private AppBarLayout Zj;
    AppBarLayout.OnOffsetChangedListener Zk;
    private boolean Zl;
    private boolean Zm;
    private StickyAppBarLayout.a jOk;
    private NestedScrollHeader jOm;
    private HomeTabBarView jOn;
    private float jOo;
    private View mLine;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.jOk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(float f) {
        if (this.jOn != null) {
            this.jOn.aI(f);
        }
        if (this.jOm != null) {
            this.jOm.aI(1.0f - f);
        }
        if (this.mLine != null && f <= 1.0f && f >= 0.0f) {
            if (f == 0.0f) {
                this.mLine.setVisibility(8);
                return;
            }
            this.mLine.setVisibility(0);
            this.mLine.setAlpha(f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.Zl = false;
        this.Zm = false;
        this.jOo = -1.0f;
        this.Zk = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Zl) {
                        StickyAppBarLayoutBehavior.this.Zl = true;
                        if (StickyAppBarLayoutBehavior.this.jOk != null) {
                            StickyAppBarLayoutBehavior.this.jOk.ry(StickyAppBarLayoutBehavior.this.Zl);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Zl) {
                    StickyAppBarLayoutBehavior.this.Zl = false;
                    if (StickyAppBarLayoutBehavior.this.jOk != null) {
                        StickyAppBarLayoutBehavior.this.jOk.ry(StickyAppBarLayoutBehavior.this.Zl);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jOo != abs) {
                    StickyAppBarLayoutBehavior.this.jOo = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aJ(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zl = false;
        this.Zm = false;
        this.jOo = -1.0f;
        this.Zk = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Zl) {
                        StickyAppBarLayoutBehavior.this.Zl = true;
                        if (StickyAppBarLayoutBehavior.this.jOk != null) {
                            StickyAppBarLayoutBehavior.this.jOk.ry(StickyAppBarLayoutBehavior.this.Zl);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Zl) {
                    StickyAppBarLayoutBehavior.this.Zl = false;
                    if (StickyAppBarLayoutBehavior.this.jOk != null) {
                        StickyAppBarLayoutBehavior.this.jOk.ry(StickyAppBarLayoutBehavior.this.Zl);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jOo != abs) {
                    StickyAppBarLayoutBehavior.this.jOo = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aJ(f);
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

    public void cOM() {
        if (this.Zj != null) {
            this.Zj.setExpanded(true, true);
        }
    }

    public void cON() {
        if (this.Zj != null) {
            this.Zj.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Zl;
    }

    public NestedScrollHeader cOO() {
        return this.jOm;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Zj != null && !this.Zm) {
            this.Zj.addOnOffsetChangedListener(this.Zk);
            this.Zm = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Zj != null && this.Zm) {
            this.Zj.removeOnOffsetChangedListener(this.Zk);
            this.Zm = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Zj == null) {
            this.Zj = appBarLayout;
            View findViewById = this.Zj.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.jOm = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Zj.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.jOn = (HomeTabBarView) findViewById2;
            }
            this.mLine = this.Zj.findViewById(R.id.divider_line);
            cOP();
        }
        if (this.Zj != null && !this.Zm) {
            this.Zj.addOnOffsetChangedListener(this.Zk);
            this.Zm = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cOP() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Zj instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Zj).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
