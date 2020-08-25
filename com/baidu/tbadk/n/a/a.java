package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes2.dex */
public class a {
    private c eSZ;
    private String eTa;

    public a(String str) {
        this.eTa = str;
    }

    public void buu() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.eSZ == null) {
                this.eSZ = new c();
            }
            this.eSZ.start();
        }
    }

    public void buv() {
        if (this.eSZ != null && Build.VERSION.SDK_INT >= 16) {
            this.eSZ.stop();
            at(this.eTa, this.eSZ.getFps());
        }
    }

    private void at(String str, int i) {
        int intValue;
        if (!at.isEmpty(str) && i > 0 && !TbSingleton.getInstance().isAnimFpsComputed(str) && (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) < 5) {
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
