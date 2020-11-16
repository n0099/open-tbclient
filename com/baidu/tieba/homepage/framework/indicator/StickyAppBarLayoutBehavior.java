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
/* loaded from: classes21.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private AppBarLayout Ym;
    AppBarLayout.OnOffsetChangedListener Yn;
    private boolean Yo;
    private boolean Yp;
    private StickyAppBarLayout.a jAG;
    private NestedScrollHeader jAI;
    private HomeTabBarView jAJ;
    private float jAK;
    private View mLine;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.jAG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(float f) {
        if (this.jAJ != null) {
            this.jAJ.aH(f);
        }
        if (this.jAI != null) {
            this.jAI.aH(1.0f - f);
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
        this.Yo = false;
        this.Yp = false;
        this.jAK = -1.0f;
        this.Yn = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Yo) {
                        StickyAppBarLayoutBehavior.this.Yo = true;
                        if (StickyAppBarLayoutBehavior.this.jAG != null) {
                            StickyAppBarLayoutBehavior.this.jAG.qX(StickyAppBarLayoutBehavior.this.Yo);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Yo) {
                    StickyAppBarLayoutBehavior.this.Yo = false;
                    if (StickyAppBarLayoutBehavior.this.jAG != null) {
                        StickyAppBarLayoutBehavior.this.jAG.qX(StickyAppBarLayoutBehavior.this.Yo);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jAK != abs) {
                    StickyAppBarLayoutBehavior.this.jAK = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aI(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yo = false;
        this.Yp = false;
        this.jAK = -1.0f;
        this.Yn = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.Yo) {
                        StickyAppBarLayoutBehavior.this.Yo = true;
                        if (StickyAppBarLayoutBehavior.this.jAG != null) {
                            StickyAppBarLayoutBehavior.this.jAG.qX(StickyAppBarLayoutBehavior.this.Yo);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.Yo) {
                    StickyAppBarLayoutBehavior.this.Yo = false;
                    if (StickyAppBarLayoutBehavior.this.jAG != null) {
                        StickyAppBarLayoutBehavior.this.jAG.qX(StickyAppBarLayoutBehavior.this.Yo);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jAK != abs) {
                    StickyAppBarLayoutBehavior.this.jAK = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aI(f);
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

    public void cJw() {
        if (this.Ym != null) {
            this.Ym.setExpanded(true, true);
        }
    }

    public void cJx() {
        if (this.Ym != null) {
            this.Ym.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.Yo;
    }

    public NestedScrollHeader cJy() {
        return this.jAI;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.Ym != null && !this.Yp) {
            this.Ym.addOnOffsetChangedListener(this.Yn);
            this.Yp = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.Ym != null && this.Yp) {
            this.Ym.removeOnOffsetChangedListener(this.Yn);
            this.Yp = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.Ym == null) {
            this.Ym = appBarLayout;
            View findViewById = this.Ym.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.jAI = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.Ym.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.jAJ = (HomeTabBarView) findViewById2;
            }
            this.mLine = this.Ym.findViewById(R.id.divider_line);
            cJz();
        }
        if (this.Ym != null && !this.Yp) {
            this.Ym.addOnOffsetChangedListener(this.Yn);
            this.Yp = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cJz() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.Ym instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.Ym).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
