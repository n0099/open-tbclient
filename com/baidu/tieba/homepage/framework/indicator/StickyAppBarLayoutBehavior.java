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
    private AppBarLayout ZQ;
    AppBarLayout.OnOffsetChangedListener ZR;
    private boolean ZS;
    private boolean ZT;
    private StickyAppBarLayout.a jWT;
    private NestedScrollHeader jWV;
    private HomeTabBarView jWW;
    private float jWX;
    private View mLine;

    public void setOnHeaderStickyListener(StickyAppBarLayout.a aVar) {
        this.jWT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(float f) {
        if (this.jWW != null) {
            this.jWW.aK(f);
        }
        if (this.jWV != null) {
            this.jWV.aK(1.0f - f);
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
        this.ZS = false;
        this.ZT = false;
        this.jWX = -1.0f;
        this.ZR = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.ZS) {
                        StickyAppBarLayoutBehavior.this.ZS = true;
                        if (StickyAppBarLayoutBehavior.this.jWT != null) {
                            StickyAppBarLayoutBehavior.this.jWT.rR(StickyAppBarLayoutBehavior.this.ZS);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.ZS) {
                    StickyAppBarLayoutBehavior.this.ZS = false;
                    if (StickyAppBarLayoutBehavior.this.jWT != null) {
                        StickyAppBarLayoutBehavior.this.jWT.rR(StickyAppBarLayoutBehavior.this.ZS);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jWX != abs) {
                    StickyAppBarLayoutBehavior.this.jWX = abs;
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
        this.ZS = false;
        this.ZT = false;
        this.jWX = -1.0f;
        this.ZR = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.homepage.framework.indicator.StickyAppBarLayoutBehavior.1
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float f = 0.0f;
                float totalScrollRange = appBarLayout.getTotalScrollRange();
                float abs = Math.abs(i);
                if (abs >= totalScrollRange) {
                    if (!StickyAppBarLayoutBehavior.this.ZS) {
                        StickyAppBarLayoutBehavior.this.ZS = true;
                        if (StickyAppBarLayoutBehavior.this.jWT != null) {
                            StickyAppBarLayoutBehavior.this.jWT.rR(StickyAppBarLayoutBehavior.this.ZS);
                        }
                    }
                } else if (StickyAppBarLayoutBehavior.this.ZS) {
                    StickyAppBarLayoutBehavior.this.ZS = false;
                    if (StickyAppBarLayoutBehavior.this.jWT != null) {
                        StickyAppBarLayoutBehavior.this.jWT.rR(StickyAppBarLayoutBehavior.this.ZS);
                    }
                }
                if (StickyAppBarLayoutBehavior.this.jWX != abs) {
                    StickyAppBarLayoutBehavior.this.jWX = abs;
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

    public void cOb() {
        if (this.ZQ != null) {
            this.ZQ.setExpanded(true, true);
        }
    }

    public void cOc() {
        if (this.ZQ != null) {
            this.ZQ.setExpanded(false, true);
        }
    }

    public boolean isSticky() {
        return this.ZS;
    }

    public NestedScrollHeader cOd() {
        return this.jWV;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        if (this.ZQ != null && !this.ZT) {
            this.ZQ.addOnOffsetChangedListener(this.ZR);
            this.ZT = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        if (this.ZQ != null && this.ZT) {
            this.ZQ.removeOnOffsetChangedListener(this.ZR);
            this.ZT = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        if (this.ZQ == null) {
            this.ZQ = appBarLayout;
            View findViewById = this.ZQ.findViewById(R.id.home_nested_header);
            if (findViewById instanceof NestedScrollHeader) {
                this.jWV = (NestedScrollHeader) findViewById;
            }
            View findViewById2 = this.ZQ.findViewById(R.id.home_tab_bar_view);
            if (findViewById2 instanceof HomeTabBarView) {
                this.jWW = (HomeTabBarView) findViewById2;
            }
            this.mLine = this.ZQ.findViewById(R.id.divider_line);
            cOe();
        }
        if (this.ZQ != null && !this.ZT) {
            this.ZQ.addOnOffsetChangedListener(this.ZR);
            this.ZT = true;
        }
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    public void cOe() {
        StickyAppBarLayout.a onHeaderStickyListener;
        if ((this.ZQ instanceof StickyAppBarLayout) && (onHeaderStickyListener = ((StickyAppBarLayout) this.ZQ).getOnHeaderStickyListener()) != null) {
            setOnHeaderStickyListener(onHeaderStickyListener);
        }
    }
}
