package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes4.dex */
public final class b {
    private static Boolean gaN;

    public static boolean eU(Context context) {
        SensorManager sensorManager;
        if (gaN != null) {
            return gaN.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        gaN = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return gaN.booleanValue();
    }
}
