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
    private AppBarLayout XP;
    AppBarLayout.OnOffsetChangedListener XQ;
    private boolean XR;
    private boolean XS;
    private StickyAppBarLayout.a iSs;
    private NestedScrollHeader iSu;
    private HomeTabBarView iSv;
    private float iSw;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.iSs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(float f) {
        if (this.iSv != null) {
            this.iSv.aq(f);
        }
        if (this.iSu != null) {
            this.iSu.aq(1.0f - f);
        }
    }

    public StickyAppBarLayoutBehavior() {
        this.XR = false;
        this.XS = false;
        this.iSw = -1.0f;
        this.XQ = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.XR) {
                        StickyAppBarLayoutBehavior.this.XR = true;
                        if (StickyAppBarLayoutBehavior.this.iSs != null) {
                            StickyAppBarLayoutBehavior.this.iSs.pN(StickyAppBarLayoutBehavior.this.XR);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.XR) {
                    StickyAppBarLayoutBehavior.this.XR = false;
                    if (StickyAppBarLayoutBehavior.this.iSs != null) {
                        StickyAppBarLayoutBehavior.this.iSs.pN(StickyAppBarLayoutBehavior.this.XR);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.iSw != abs) {
                    StickyAppBarLayoutBehavior.this.iSw = abs;
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
        this.XR = false;
        this.XS = false;
        this.iSw = -1.0f;
        this.XQ = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.XR) {
                        StickyAppBarLayoutBehavior.this.XR = true;
                        if (StickyAppBarLayoutBehavior.this.iSs != null) {
                            StickyAppBarLayoutBehavior.this.iSs.pN(StickyAppBarLayoutBehavior.this.XR);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.XR) {
                    StickyAppBarLayoutBehavior.this.XR = false;
                    if (StickyAppBarLayoutBehavior.this.iSs != null) {
                        StickyAppBarLayoutBehavior.this.iSs.pN(StickyAppBarLayoutBehavior.this.XR);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.iSw != abs) {
                    StickyAppBarLayoutBehavior.this.iSw = abs;
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

    public void cAC() {
        if (this.XP != null) {
            this.XP.setExpanded(true, true);
        }
    }

    public void cAD() {
        if (this.XP != null) {
            this.XP.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.XR;
    }

    public NestedScrollHeader cAE() {
        return this.iSu;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.XP != null && !this.XS) {
            this.XP.addOnOffsetChangedListener(this.XQ);
            this.XS = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.XP != null && this.XS) {
            this.XP.removeOnOffsetChangedListener(this.XQ);
            this.XS = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.XP == null) {
            this.XP = appBarLayout;
            View findViewById = this.XP.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.iSu = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.XP.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.iSv = (HomeTabBarView) findViewById2;
            }
            cAF();
        }
        if (this.XP != null && !this.XS) {
            this.XP.addOnOffsetChangedListener(this.XQ);
            this.XS = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cAF() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.XP instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.XP).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
