package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class a {
    private c eIt;
    private String eIu;

    public a(String str) {
        this.eIu = str;
    }

    public void blH() {
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.eIt == null) {
                this.eIt = new c();
            }
            this.eIt.start();
        }
    }

    public void blI() {
        if (this.eIt != null && Build.VERSION.SDK_INT >= 16) {
            this.eIt.stop();
            aq(this.eIu, this.eIt.getFps());
        }
    }

    private void aq(String str, int i) {
        int intValue;
        if (!as.isEmpty(str) && i > 0 && !TbSingleton.getInstance().isAnimFpsComputed(str) && (intValue = TbSingleton.getInstance().getAnimAvgFpsCount(str).intValue()) < 5) {
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
