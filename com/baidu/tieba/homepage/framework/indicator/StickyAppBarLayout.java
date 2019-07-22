package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.t.ao;
@CoordinatorLayout.DefaultBehavior(b.class)
/* loaded from: classes4.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private b ggb;
    private a ggc;

    /* loaded from: classes4.dex */
    public interface a {
        void ll(boolean z);
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
        if (ao.iN()) {
            bvP();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bvN();
    }

    private void bvN() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof b) {
                this.ggb = (b) behavior;
            }
        }
    }

    public boolean bvO() {
        if (this.ggb == null) {
            bvN();
        }
        if (this.ggb != null) {
            if (isSticky() && ao.iN()) {
                bvP();
            }
            this.ggb.bvQ();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.ggb == null) {
            bvN();
        }
        if (this.ggb != null) {
            return this.ggb.isSticky();
        }
        return false;
    }

    private void bvP() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 1);
        anVar.P("obj_locate", 1);
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.ggc = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.ggc;
    }
}
