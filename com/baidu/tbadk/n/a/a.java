package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class a {
    private c dAI;
    private String dAJ;

    public a(String str) {
        this.dAJ = str;
    }

    public void aPa() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.dAI == null) {
                this.dAI = new c();
            }
            this.dAI.start();
        }
    }

    public void aPb() {
        if (this.dAI != null && Build.VERSION.SDK_INT >= 16) {
            this.dAI.stop();
            ah(this.dAJ, this.dAI.getFps());
        }
    }

    private void ah(String str, int i) {
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
