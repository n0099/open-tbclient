package com.baidu.tbadk.o.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class a {
    private c crB;
    private String crC;

    public a(String str) {
        this.crC = str;
    }

    public void apt() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.crB == null) {
                this.crB = new c();
            }
            this.crB.start();
        }
    }

    public void apu() {
        if (this.crB != null && Build.VERSION.SDK_INT >= 16) {
            this.crB.stop();
            ae(this.crC, this.crB.getFps());
        }
    }

    private void ae(String str, int i) {
        int intValue;
        if (!ap.isEmpty(str) && i > 0 && !TbSingleton.getInstance().isAnimFpsComputed(str) && (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) < 5) {
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
