package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class a {
    private c eCe;
    private String eCf;

    public a(String str) {
        this.eCf = str;
    }

    public void bhW() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.eCe == null) {
                this.eCe = new c();
            }
            this.eCe.start();
        }
    }

    public void bhX() {
        if (this.eCe != null && Build.VERSION.SDK_INT >= 16) {
            this.eCe.stop();
            ap(this.eCf, this.eCe.getFps());
        }
    }

    private void ap(String str, int i) {
        int intValue;
        if (!ar.isEmpty(str) && i > 0 && !TbSingleton.getInstance().isAnimFpsComputed(str) && (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) < 5) {
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
