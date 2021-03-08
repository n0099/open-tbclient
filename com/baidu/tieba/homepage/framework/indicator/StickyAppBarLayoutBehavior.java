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
    private AppBarLayout abf;
    AppBarLayout.OnOffsetChangedListener abg;
    private boolean abh;
    private boolean abi;
    private StickyAppBarLayout.a kgL;
    private NestedScrollHeader kgN;
    private HomeTabBarView kgO;
    private float kgP;
    private View mLine;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.kgL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(float f) {
        if (this.kgO != null) {
            this.kgO.aR(f);
        }
        if (this.kgN != null) {
            this.kgN.aR(1.0f - f);
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
        this.abh = false;
        this.abi = false;
        this.kgP = -1.0f;
        this.abg = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.abh) {
                        StickyAppBarLayoutBehavior.this.abh = true;
                        if (StickyAppBarLayoutBehavior.this.kgL != null) {
                            StickyAppBarLayoutBehavior.this.kgL.sd(StickyAppBarLayoutBehavior.this.abh);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.abh) {
                    StickyAppBarLayoutBehavior.this.abh = false;
                    if (StickyAppBarLayoutBehavior.this.kgL != null) {
                        StickyAppBarLayoutBehavior.this.kgL.sd(StickyAppBarLayoutBehavior.this.abh);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.kgP != abs) {
                    StickyAppBarLayoutBehavior.this.kgP = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aS(f);
                    }
                }
            }
        };
        init();
    }

    public StickyAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abh = false;
        this.abi = false;
        this.kgP = -1.0f;
        this.abg = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.abh) {
                        StickyAppBarLayoutBehavior.this.abh = true;
                        if (StickyAppBarLayoutBehavior.this.kgL != null) {
                            StickyAppBarLayoutBehavior.this.kgL.sd(StickyAppBarLayoutBehavior.this.abh);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.abh) {
                    StickyAppBarLayoutBehavior.this.abh = false;
                    if (StickyAppBarLayoutBehavior.this.kgL != null) {
                        StickyAppBarLayoutBehavior.this.kgL.sd(StickyAppBarLayoutBehavior.this.abh);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.kgP != abs) {
                    StickyAppBarLayoutBehavior.this.kgP = abs;
                    if (totalScrollRange > 0.0f) {
                        if (abs != 0.0f) {
                            if (abs >= totalScrollRange) {
                                f = 1.0f;
                            } else {
                                f = abs / totalScrollRange;
                            }
                        }
                        StickyAppBarLayoutBehavior.this.aS(f);
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

    public void cQm() {
        if (this.abf != null) {
            this.abf.setExpanded(true, true);
        }
    }

    public void cQn() {
        if (this.abf != null) {
            this.abf.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.abh;
    }

    public NestedScrollHeader cQo() {
        return this.kgN;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.abf != null && !this.abi) {
            this.abf.addOnOffsetChangedListener(this.abg);
            this.abi = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.abf != null && this.abi) {
            this.abf.removeOnOffsetChangedListener(this.abg);
            this.abi = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.abf == null) {
            this.abf = appBarLayout;
            View findViewById = this.abf.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.kgN = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.abf.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.kgO = (HomeTabBarView) findViewById2;
            }
            this.mLine = this.abf.findViewById(R.id.divider_line);
            cQp();
        }
        if (this.abf != null && !this.abi) {
            this.abf.addOnOffsetChangedListener(this.abg);
            this.abi = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cQp() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.abf instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.abf).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
