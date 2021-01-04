package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class a {
    private c fNf;
    private String fNg;

    public a(String str) {
        this.fNg = str;
    }

    public void bHQ() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.fNf == null) {
                this.fNf = new c();
            }
            this.fNf.start();
        }
    }

    public void bHR() {
        if (this.fNf != null && Build.VERSION.SDK_INT >= 16) {
            this.fNf.stop();
            ay(this.fNg, this.fNf.getFps());
        }
    }

    private void ay(String str, int i) {
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
