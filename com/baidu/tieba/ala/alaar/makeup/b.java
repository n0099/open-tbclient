package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes4.dex */
public final class b {
    private static Boolean gbg;

    public static boolean eU(Context context) {
        SensorManager sensorManager;
        if (gbg != null) {
            return gbg.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        gbg = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return gbg.booleanValue();
    }
}
