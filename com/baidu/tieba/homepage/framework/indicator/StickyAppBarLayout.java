package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes6.dex */
public class StickyAppBarLayout extends AppBarLayout {
    private StickyAppBarLayoutBehavior gUK;
    private a gUL;

    /* loaded from: classes6.dex */
    public interface a {
        void mp(boolean z);
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
        if (MissionEntranceSwitch.isOn()) {
            bLh();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bLf();
    }

    private void bLf() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.gUK = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean bLg() {
        if (this.gUK == null) {
            bLf();
        }
        if (this.gUK != null) {
            if (isSticky() && MissionEntranceSwitch.isOn() && this.gUK.bLj() != null && this.gUK.bLj().getVisibility() == 0) {
                bLh();
            }
            this.gUK.bLi();
            return true;
        }
        return false;
    }

    public boolean isSticky() {
        if (this.gUK == null) {
            bLf();
        }
        if (this.gUK != null) {
            return this.gUK.isSticky();
        }
        return false;
    }

    private void bLh() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 1);
        anVar.Z("obj_locate", 1);
        anVar.Z(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }

    public void setOnHeaderStickyListener(a aVar) {
        this.gUL = aVar;
    }

    public a getOnHeaderStickyListener() {
        return this.gUL;
    }
}
