package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class a {
    private c fMj;
    private String fMk;

    public a(String str) {
        this.fMk = str;
    }

    public void bEv() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.fMj == null) {
                this.fMj = new c();
            }
            this.fMj.start();
        }
    }

    public void bEw() {
        if (this.fMj != null && Build.VERSION.SDK_INT >= 16) {
            this.fMj.stop();
            aA(this.fMk, this.fMj.getFps());
        }
    }

    private void aA(String str, int i) {
        int intValue;
        if (!au.isEmpty(str) && i > 0 && !TbSingleton.getInstance().isAnimFpsComputed(str) && (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) < 5) {
            int i2 = intValue + 1;
            int intValue2 = TbSingleton.getInstance().getAnimAvgFps(str).intValue();
            if (intValue2 > 0) {
                i = ((intValue2 * (i2 - 1)) + i) / i2;
            }
            TbSingleton.getInstance().setAnimAvgFps(str, i);
            TbSingleton.getInstance().setAnimAvgFpsCount(str, i2);
            if (i2 >= 5) {
                TbSingleton.getInstance().setAnimComputedFps(str, i);
                b.log();
            }
        }
    }
}
