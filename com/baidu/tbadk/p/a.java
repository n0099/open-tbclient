package com.baidu.tbadk.p;

import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;
/* loaded from: classes2.dex */
public class a {
    public static boolean cM(Context context) {
        try {
            return NotificationManagerCompat.from(context.getApplicationContext()).areNotificationsEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
