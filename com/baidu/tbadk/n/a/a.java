package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class a {
    private c eeZ;
    private String efa;

    public a(String str) {
        this.efa = str;
    }

    public void aZF() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.eeZ == null) {
                this.eeZ = new c();
            }
            this.eeZ.start();
        }
    }

    public void aZG() {
        if (this.eeZ != null && Build.VERSION.SDK_INT >= 16) {
            this.eeZ.stop();
            ao(this.efa, this.eeZ.getFps());
        }
    }

    private void ao(String str, int i) {
        int intValue;
        if (!aq.isEmpty(str) && i > 0 && !TbSingleton.getInstance().isAnimFpsComputed(str) && (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) < 5) {
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
