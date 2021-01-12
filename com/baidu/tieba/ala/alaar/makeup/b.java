package com.baidu.tieba.ala.alaar.makeup;

import android.content.Context;
import android.hardware.SensorManager;
/* loaded from: classes10.dex */
public final class b {
    private static Boolean goS;

    public static boolean fS(Context context) {
        SensorManager sensorManager;
        if (goS != null) {
            return goS.booleanValue();
        }
        if (context == null || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null) {
            return false;
        }
        goS = Boolean.valueOf(sensorManager.getDefaultSensor(4) != null);
        return goS.booleanValue();
    }
}
