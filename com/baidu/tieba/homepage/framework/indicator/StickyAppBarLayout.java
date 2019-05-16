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
    private b gaW;
    private a gaX;

    /* loaded from: classes4.dex */
    public interface a {
        void la(boolean z);
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
            btI();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        btG();
    }

    private void btG() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof b) {
                this.gaW = (b) behavior;
            }
        }
    }

    public boolean btH() {
        if (this.gaW == null) {
            btG();
        }
        if (this.gaW != null) {
            if (isSticky() && ao.iE()) {
                btI();
            }
            this.gaW.btJ();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.gaW == null) {
            btG();
        }
        if (this.gaW != null) {
            return this.gaW.isSticky();
        }
        return false;
    }

    private void btI() {
        am amVar = new am("c13422");
        amVar.P("obj_type", 1);
        amVar.P("obj_locate", 1);
        TiebaStatic.log(amVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.gaX = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.gaX;
    }
}
