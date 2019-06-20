package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.t.ao;
@CoordinatorLayout.DefaultBehavior(b.class)
/* loaded from: classes4.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private b gaZ;
    private a gba;

    /* loaded from: classes4.dex */
    public interface a {
        void lb(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        init();
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (ao.iE()) {
            btM();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        btK();
    }

    private void btK() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof b) {
                this.gaZ = (b) behavior;
            }
        }
    }

    public boolean btL() {
        if (this.gaZ == null) {
            btK();
        }
        if (this.gaZ != null) {
            if (isSticky() && ao.iE()) {
                btM();
            }
            this.gaZ.btN();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.gaZ == null) {
            btK();
        }
        if (this.gaZ != null) {
            return this.gaZ.isSticky();
        }
        return false;
    }

    private void btM() {
        am amVar = new am("c13422");
        amVar.P("obj_type", 1);
        amVar.P("obj_locate", 1);
        TiebaStatic.log(amVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.gba = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.gba;
    }
}
