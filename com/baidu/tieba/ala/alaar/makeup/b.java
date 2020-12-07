package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes4.dex */
public final class b {
    private static Boolean giY;

    public static boolean fA(Context context) {
        SensorManager sensorManager;
        if (giY != null) {
            return giY.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        giY = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return giY.booleanValue();
    }
}
