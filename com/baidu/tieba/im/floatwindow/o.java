package com.baidu.tieba.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class o {
    protected View aYV;
    private boolean abY = false;
    protected WindowManager aYW = (WindowManager) TbadkCoreApplication.m255getInst().getSystemService("window");
    protected WindowManager.LayoutParams aYX = NC();

    public abstract WindowManager.LayoutParams NC();

    public o(View view) {
        this.aYV = view;
    }

    public boolean ND() {
        return this.abY && this.aYV.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NE() {
        if (this.aYW != null && this.aYX != null && this.aYV.getParent() == null) {
            this.abY = true;
            this.aYW.addView(this.aYV, this.aYX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NF() {
        if (this.aYW != null && this.aYV.getParent() != null) {
            this.abY = false;
            this.aYW.removeView(this.aYV);
        }
    }
}
