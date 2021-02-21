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
    private AppBarLayout ZM;
    AppBarLayout.OnOffsetChangedListener ZN;
    private boolean ZO;
    private boolean ZP;
    private StickyAppBarLayout.a keJ;
    private NestedScrollHeader keL;
    private HomeTabBarView keM;
    private float keN;
    private View mLine;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.keJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(float f) {
        if (this.keM != null) {
            this.keM.aN(f);
        }
        if (this.keL != null) {
            this.keL.aN(1.0f - f);
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
        this.ZO = false;
        this.ZP = false;
        this.keN = -1.0f;
        this.ZN = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.ZO) {
                        StickyAppBarLayoutBehavior.this.ZO = true;
                        if (StickyAppBarLayoutBehavior.this.keJ != null) {
                            StickyAppBarLayoutBehavior.this.keJ.sd(StickyAppBarLayoutBehavior.this.ZO);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.ZO) {
                    StickyAppBarLayoutBehavior.this.ZO = false;
                    if (StickyAppBarLayoutBehavior.this.keJ != null) {
                        StickyAppBarLayoutBehavior.this.keJ.sd(StickyAppBarLayoutBehavior.this.ZO);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.keN != abs) {
                    StickyAppBarLayoutBehavior.this.keN = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aO(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZO = false;
        this.ZP = false;
        this.keN = -1.0f;
        this.ZN = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.ZO) {
                        StickyAppBarLayoutBehavior.this.ZO = true;
                        if (StickyAppBarLayoutBehavior.this.keJ != null) {
                            StickyAppBarLayoutBehavior.this.keJ.sd(StickyAppBarLayoutBehavior.this.ZO);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.ZO) {
                    StickyAppBarLayoutBehavior.this.ZO = false;
                    if (StickyAppBarLayoutBehavior.this.keJ != null) {
                        StickyAppBarLayoutBehavior.this.keJ.sd(StickyAppBarLayoutBehavior.this.ZO);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.keN != abs) {
                    StickyAppBarLayoutBehavior.this.keN = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aO(f);
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

    public void cQf() {
        if (this.ZM != null) {
            this.ZM.setExpanded(true, true);
        }
    }

    public void cQg() {
        if (this.ZM != null) {
            this.ZM.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.ZO;
    }

    public NestedScrollHeader cQh() {
        return this.keL;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.ZM != null && !this.ZP) {
            this.ZM.addOnOffsetChangedListener(this.ZN);
            this.ZP = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.ZM != null && this.ZP) {
            this.ZM.removeOnOffsetChangedListener(this.ZN);
            this.ZP = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.ZM == null) {
            this.ZM = appBarLayout;
            View findViewById = this.ZM.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.keL = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.ZM.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.keM = (HomeTabBarView) findViewById2;
            }
            this.mLine = this.ZM.findViewById(R.id.divider_line);
            cQi();
        }
        if (this.ZM != null && !this.ZP) {
            this.ZM.addOnOffsetChangedListener(this.ZN);
            this.ZP = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cQi() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.ZM instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.ZM).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
