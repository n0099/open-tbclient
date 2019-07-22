package com.baidu.tbadk.p.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class a {
    private c cBa;
    private String cBb;

    public a(String str) {
        this.cBb = str;
    }

    public void avB() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.cBa == null) {
                this.cBa = new c();
            }
            this.cBa.start();
        }
    }

    public void avC() {
        if (this.cBa != null && Build.VERSION.SDK_INT >= 16) {
            this.cBa.stop();
            aa(this.cBb, this.cBa.getFps());
        }
    }

    private void aa(String str, int i) {
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
