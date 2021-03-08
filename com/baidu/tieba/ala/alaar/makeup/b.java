package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes10.dex */
public final class b {
    private static Boolean gty;

    public static boolean fQ(Context context) {
        SensorManager sensorManager;
        if (gty != null) {
            return gty.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        gty = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return gty.booleanValue();
    }
}
