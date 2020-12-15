package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes4.dex */
public final class b {
    private static Boolean gja;

    public static boolean fA(Context context) {
        SensorManager sensorManager;
        if (gja != null) {
            return gja.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        gja = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return gja.booleanValue();
    }
}
