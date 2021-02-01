package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes11.dex */
public final class b {
    private static Boolean grB;

    public static boolean fR(Context context) {
        SensorManager sensorManager;
        if (grB != null) {
            return grB.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        grB = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return grB.booleanValue();
    }
}
