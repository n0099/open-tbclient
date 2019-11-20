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
    private b ghq;
    private a ghr;

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
            btT();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        btR();
    }

    private void btR() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof b) {
                this.ghq = (b) behavior;
            }
        }
    }

    public boolean btS() {
        if (this.ghq == null) {
            btR();
        }
        if (this.ghq != null) {
            if (isSticky() && ao.isOn() && this.ghq.btV() != null && this.ghq.btV().getVisibility() == 0) {
                btT();
            }
            this.ghq.btU();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.ghq == null) {
            btR();
        }
        if (this.ghq != null) {
            return this.ghq.isSticky();
        }
        return false;
    }

    private void btT() {
        an anVar = new an("c13422");
        anVar.O("obj_type", 1);
        anVar.O("obj_locate", 1);
        anVar.O(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.ghr = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.ghr;
    }
}
