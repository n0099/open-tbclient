package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayout;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes2.dex */
public class StickyAppBarLayoutBehavior extends AppBarLayout.Behavior {
    private AppBarLayout ZS;
    AppBarLayout.OnOffsetChangedListener ZT;
    private boolean ZU;
    private boolean ZV;
    private NestedScrollHeader kbA;
    private HomeTabBarView kbB;
    private float kbC;
    private StickyAppBarLayout.a kby;
    private View mLine;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.kby = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(float f) {
        if (this.kbB != null) {
            this.kbB.aK(f);
        }
        if (this.kbA != null) {
            this.kbA.aK(1.0f - f);
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
        this.ZU = false;
        this.ZV = false;
        this.kbC = -1.0f;
        this.ZT = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.ZU) {
                        StickyAppBarLayoutBehavior.this.ZU = true;
                        if (StickyAppBarLayoutBehavior.this.kby != null) {
                            StickyAppBarLayoutBehavior.this.kby.rV(StickyAppBarLayoutBehavior.this.ZU);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.ZU) {
                    StickyAppBarLayoutBehavior.this.ZU = false;
                    if (StickyAppBarLayoutBehavior.this.kby != null) {
                        StickyAppBarLayoutBehavior.this.kby.rV(StickyAppBarLayoutBehavior.this.ZU);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.kbC != abs) {
                    StickyAppBarLayoutBehavior.this.kbC = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aL(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZU = false;
        this.ZV = false;
        this.kbC = -1.0f;
        this.ZT = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.ZU) {
                        StickyAppBarLayoutBehavior.this.ZU = true;
                        if (StickyAppBarLayoutBehavior.this.kby != null) {
                            StickyAppBarLayoutBehavior.this.kby.rV(StickyAppBarLayoutBehavior.this.ZU);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.ZU) {
                    StickyAppBarLayoutBehavior.this.ZU = false;
                    if (StickyAppBarLayoutBehavior.this.kby != null) {
                        StickyAppBarLayoutBehavior.this.kby.rV(StickyAppBarLayoutBehavior.this.ZU);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.kbC != abs) {
                    StickyAppBarLayoutBehavior.this.kbC = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aL(f);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        setDragCallback(new AppBarLayout.Behavior.DragCallback() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.2
            @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return false;
            }
        });
    }

    public void cRT() {
        if (this.ZS != null) {
            this.ZS.setExpanded(true, true);
        }
    }

    public void cRU() {
        if (this.ZS != null) {
            this.ZS.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.ZU;
    }

    public NestedScrollHeader cRV() {
        return this.kbA;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.ZS != null && !this.ZV) {
            this.ZS.addOnOffsetChangedListener(this.ZT);
            this.ZV = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.ZS != null && this.ZV) {
            this.ZS.removeOnOffsetChangedListener(this.ZT);
            this.ZV = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.ZS == null) {
            this.ZS = appBarLayout;
            View findViewById = this.ZS.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.kbA = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.ZS.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.kbB = (HomeTabBarView) findViewById2;
            }
            this.mLine = this.ZS.findViewById(R.id.divider_line);
            cRW();
        }
        if (this.ZS != null && !this.ZV) {
            this.ZS.addOnOffsetChangedListener(this.ZT);
            this.ZV = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cRW() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.ZS instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.ZS).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
