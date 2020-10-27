package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes4.dex */
public final class b {
    private static Boolean fVp;

    public static boolean eU(Context context) {
        boolean z;
        if (fVp != null) {
            return fVp.booleanValue();
        }
        if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null) {
            z = true;
        } else {
            z = false;
        }
        fVp = Boolean.valueOf(z);
        return fVp.booleanValue();
    }
}
