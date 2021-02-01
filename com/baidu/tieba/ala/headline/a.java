package com.baidu.tieba.ala.headline;

import java.math.RoundingMode;
import java.text.NumberFormat;
/* loaded from: classes11.dex */
public class a {
    public static String fs(long j) {
        if (j >= 100000000) {
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(3);
            numberInstance.setRoundingMode(RoundingMode.HALF_UP);
            numberInstance.setGroupingUsed(false);
            return numberInstance.format(((float) j) / 1.0E8f) + "亿";
        } else if (j >= 10000) {
            NumberFormat numberInstance2 = NumberFormat.getNumberInstance();
            numberInstance2.setMaximumFractionDigits(2);
            numberInstance2.setRoundingMode(RoundingMode.HALF_UP);
            numberInstance2.setGroupingUsed(false);
            return numberInstance2.format(((float) j) / 10000.0f) + "万";
        } else {
            return j + "";
        }
    }
}
