package com.baidu.tieba.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class o {
    protected View aXA;
    private boolean abE = false;
    protected WindowManager aXB = (WindowManager) TbadkCoreApplication.m255getInst().getSystemService("window");
    protected WindowManager.LayoutParams aXC = Nl();

    public abstract WindowManager.LayoutParams Nl();

    public o(View view) {
        this.aXA = view;
    }

    public boolean Nm() {
        return this.abE && this.aXA.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nn() {
        if (this.aXB != null && this.aXC != null && this.aXA.getParent() == null) {
            this.abE = true;
            this.aXB.addView(this.aXA, this.aXC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void No() {
        if (this.aXB != null && this.aXA.getParent() != null) {
            this.abE = false;
            this.aXB.removeView(this.aXA);
        }
    }
}
