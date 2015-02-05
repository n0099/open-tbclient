package com.baidu.tieba.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends o {
    private long aYK;
    private Point aYQ;
    protected final int aYR;
    private n aYS;
    private boolean aYT;
    private int ayg;

    public l(View view) {
        super(view);
        this.aYT = true;
        this.ayg = 0;
        this.aYR = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst());
        this.aYQ = new Point();
        this.aYV.setOnTouchListener(new m(this));
        this.ayg = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m255getInst());
        if (this.ayg == 0) {
            this.ayg = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.aYT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, int i2) {
        this.aYK = SystemClock.elapsedRealtime();
        this.aYQ.x = i;
        this.aYQ.y = i2;
        if (this.aYS != null) {
            this.aYS.T(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i, int i2) {
        W(this.aYQ.x + i, (i2 - this.aYQ.y) - this.ayg);
        if (this.aYS != null) {
            this.aYS.S(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ny() {
        if (this.aYS != null) {
            if (SystemClock.elapsedRealtime() - this.aYK > 200) {
                this.aYS.Ny();
            } else {
                this.aYS.Nz();
            }
        }
    }

    public void a(n nVar) {
        this.aYS = nVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.o
    public WindowManager.LayoutParams NC() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void V(int i, int i2) {
        if (this.aYX != null) {
            if (i >= 0) {
                this.aYX.x = i;
            }
            if (i2 >= 0) {
                this.aYX.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(int i, int i2) {
        if (this.aYX != null) {
            int i3 = this.aYR - i;
            if (i3 >= 0) {
                this.aYX.x = i3;
            }
            if (i2 >= 0) {
                this.aYX.y = i2;
            }
            if (this.aYW != null && this.aYV.getParent() != null) {
                this.aYW.updateViewLayout(this.aYV, this.aYX);
            }
        }
    }
}
