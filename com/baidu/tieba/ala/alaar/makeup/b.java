package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes11.dex */
public final class b {
    private static Boolean grP;

    public static boolean fR(Context context) {
        SensorManager sensorManager;
        if (grP != null) {
            return grP.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        grP = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return grP.booleanValue();
    }
}
