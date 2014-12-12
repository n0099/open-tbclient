package com.baidu.tieba.im.floatwindow;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends o {
    private long aXp;
    private Point aXv;
    protected final int aXw;
    private n aXx;
    private boolean aXy;
    private int axj;

    public l(View view) {
        super(view);
        this.aXy = true;
        this.axj = 0;
        this.aXw = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst());
        this.aXv = new Point();
        this.aXA.setOnTouchListener(new m(this));
        this.axj = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m255getInst());
        if (this.axj == 0) {
            this.axj = 25;
        }
    }

    public void setTouchable(boolean z) {
        this.aXy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, int i2) {
        this.aXp = SystemClock.elapsedRealtime();
        this.aXv.x = i;
        this.aXv.y = i2;
        if (this.aXx != null) {
            this.aXx.R(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, int i2) {
        U(this.aXv.x + i, (i2 - this.aXv.y) - this.axj);
        if (this.aXx != null) {
            this.aXx.Q(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        if (this.aXx != null) {
            if (SystemClock.elapsedRealtime() - this.aXp > 200) {
                this.aXx.Nh();
            } else {
                this.aXx.Ni();
            }
        }
    }

    public void a(n nVar) {
        this.aXx = nVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.o
    public WindowManager.LayoutParams Nl() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 53;
        layoutParams.flags |= 8;
        layoutParams.format = 1;
        return layoutParams;
    }

    public void T(int i, int i2) {
        if (this.aXC != null) {
            if (i >= 0) {
                this.aXC.x = i;
            }
            if (i2 >= 0) {
                this.aXC.y = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(int i, int i2) {
        if (this.aXC != null) {
            int i3 = this.aXw - i;
            if (i3 >= 0) {
                this.aXC.x = i3;
            }
            if (i2 >= 0) {
                this.aXC.y = i2;
            }
            if (this.aXB != null && this.aXA.getParent() != null) {
                this.aXB.updateViewLayout(this.aXA, this.aXC);
            }
        }
    }
}
