package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.t.ao;
@CoordinatorLayout.DefaultBehavior(b.class)
/* loaded from: classes4.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private b gii;
    private a gij;

    /* loaded from: classes4.dex */
    public interface a {
        void lc(boolean z);
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
        if (ao.isOn()) {
            btV();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        btT();
    }

    private void btT() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof b) {
                this.gii = (b) behavior;
            }
        }
    }

    public boolean btU() {
        if (this.gii == null) {
            btT();
        }
        if (this.gii != null) {
            if (isSticky() && ao.isOn() && this.gii.btX() != null && this.gii.btX().getVisibility() == 0) {
                btV();
            }
            this.gii.btW();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.gii == null) {
            btT();
        }
        if (this.gii != null) {
            return this.gii.isSticky();
        }
        return false;
    }

    private void btV() {
        an anVar = new an("c13422");
        anVar.O("obj_type", 1);
        anVar.O("obj_locate", 1);
        anVar.O(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.gij = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.gij;
    }
}
