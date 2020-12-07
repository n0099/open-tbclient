package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class a {
    private c fDA;
    private String fDB;

    public a(String str) {
        this.fDB = str;
    }

    public void bFv() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.fDA == null) {
                this.fDA = new c();
            }
            this.fDA.start();
        }
    }

    public void bFw() {
        if (this.fDA != null && Build.VERSION.SDK_INT >= 16) {
            this.fDA.stop();
            aw(this.fDB, this.fDA.getFps());
        }
    }

    private void aw(String str, int i) {
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
