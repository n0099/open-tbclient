package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes11.dex */
public final class b {
    private static Boolean gtz;

    public static boolean fU(Context context) {
        SensorManager sensorManager;
        if (gtz != null) {
            return gtz.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        gtz = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return gtz.booleanValue();
    }
}
