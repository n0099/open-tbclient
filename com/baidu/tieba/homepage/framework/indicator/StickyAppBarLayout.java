package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.t.ao;
@CoordinatorLayout.DefaultBehavior(b.class)
/* loaded from: classes4.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private b giK;
    private a giL;

    /* loaded from: classes4.dex */
    public interface a {
        void lo(boolean z);
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
            bwQ();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bwO();
    }

    private void bwO() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof b) {
                this.giK = (b) behavior;
            }
        }
    }

    public boolean bwP() {
        if (this.giK == null) {
            bwO();
        }
        if (this.giK != null) {
            if (isSticky() && ao.iN() && this.giK.bwS() != null && this.giK.bwS().getVisibility() == 0) {
                bwQ();
            }
            this.giK.bwR();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.giK == null) {
            bwO();
        }
        if (this.giK != null) {
            return this.giK.isSticky();
        }
        return false;
    }

    private void bwQ() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 1);
        anVar.P("obj_locate", 1);
        anVar.P("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.giL = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.giL;
    }
}
