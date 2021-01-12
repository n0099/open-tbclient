package com.baidu.tbadk.p;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
/* loaded from: classes.dex */
public class a {
    public static boolean dP(Context context) {
        try {
            return NotificationManagerCompat.from(context.getApplicationContext()).areNotificationsEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
