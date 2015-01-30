package com.baidu.tieba.im.floatwindow;

import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public abstract class o {
    protected View aYW;
    private boolean acb = false;
    protected WindowManager aYX = (WindowManager) TbadkCoreApplication.m255getInst().getSystemService("window");
    protected WindowManager.LayoutParams aYY = NH();

    public abstract WindowManager.LayoutParams NH();

    public o(View view) {
        this.aYW = view;
    }

    public boolean NI() {
        return this.acb && this.aYW.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NJ() {
        if (this.aYX != null && this.aYY != null && this.aYW.getParent() == null) {
            this.acb = true;
            this.aYX.addView(this.aYW, this.aYY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NK() {
        if (this.aYX != null && this.aYW.getParent() != null) {
            this.acb = false;
            this.aYX.removeView(this.aYW);
        }
    }
}
