package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class c {
    private FrsActivity bET;
    private com.baidu.tieba.frs.i.p bHa;
    private b bOn;
    private boolean bOo = false;
    private View mRootView;

    public boolean YY() {
        return this.bOo && !YZ();
    }

    public void dJ(boolean z) {
        this.bOo = z;
    }

    private boolean YZ() {
        return this.bOn != null && this.bOn.Db();
    }

    public c(FrsActivity frsActivity, View view, com.baidu.tieba.frs.i.p pVar) {
        this.bET = frsActivity;
        this.mRootView = view;
        this.bHa = pVar;
    }

    public void Za() {
        if (this.bOn == null && this.bET != null) {
            this.bOn = new b(this.bET.getPageContext().getPageActivity());
        }
        if (this.mRootView != null && this.bOn != null) {
            this.bOn.L(this.mRootView);
            this.bOn.Dh().setOnTouchListener(new d(this));
        }
    }

    public void Zb() {
        if (this.bOn != null && this.mRootView != null) {
            this.bOn.K(this.mRootView);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bOn != null) {
            this.bOn.onChangeSkinType(i);
        }
    }

    public void onDestroy() {
        Zb();
    }
}
