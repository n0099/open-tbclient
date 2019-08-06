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
    private b ggR;
    private a ggS;

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
            bwc();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bwa();
    }

    private void bwa() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof b) {
                this.ggR = (b) behavior;
            }
        }
    }

    public boolean bwb() {
        if (this.ggR == null) {
            bwa();
        }
        if (this.ggR != null) {
            if (isSticky() && ao.iN() && this.ggR.bwe() != null && this.ggR.bwe().getVisibility() == 0) {
                bwc();
            }
            this.ggR.bwd();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.ggR == null) {
            bwa();
        }
        if (this.ggR != null) {
            return this.ggR.isSticky();
        }
        return false;
    }

    private void bwc() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 1);
        anVar.P("obj_locate", 1);
        anVar.P("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.ggS = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.ggS;
    }
}
