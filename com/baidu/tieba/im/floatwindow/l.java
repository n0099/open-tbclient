package com.baidu.tieba.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends o {
    private long aYL;
    private Point aYR;
    protected final int aYS;
    private n aYT;
    private boolean aYU;
    private int ayj;

    public l(View view) {
        super(view);
        this.aYU = true;
        this.ayj = 0;
        this.aYS = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst());
        this.aYR = new Point();
        this.aYW.setOnTouchListener(new m(this));
        this.ayj = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m255getInst());
        if (this.ayj == 0) {
            this.ayj = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.aYU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, int i2) {
        this.aYL = SystemClock.elapsedRealtime();
        this.aYR.x = i;
        this.aYR.y = i2;
        if (this.aYT != null) {
            this.aYT.S(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, int i2) {
        V(this.aYR.x + i, (i2 - this.aYR.y) - this.ayj);
        if (this.aYT != null) {
            this.aYT.R(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND() {
        if (this.aYT != null) {
            if (SystemClock.elapsedRealtime() - this.aYL > 200) {
                this.aYT.ND();
            } else {
                this.aYT.NE();
            }
        }
    }

    public void a(n nVar) {
        this.aYT = nVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.o
    public WindowManager.LayoutParams NH() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void U(int i, int i2) {
        if (this.aYY != null) {
            if (i >= 0) {
                this.aYY.x = i;
            }
            if (i2 >= 0) {
                this.aYY.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(int i, int i2) {
        if (this.aYY != null) {
            int i3 = this.aYS - i;
            if (i3 >= 0) {
                this.aYY.x = i3;
            }
            if (i2 >= 0) {
                this.aYY.y = i2;
            }
            if (this.aYX != null && this.aYW.getParent() != null) {
                this.aYX.updateViewLayout(this.aYW, this.aYY);
            }
        }
    }
}
