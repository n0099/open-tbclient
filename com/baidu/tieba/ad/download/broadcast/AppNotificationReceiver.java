package com.baidu.tieba.ad.download.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tieba.ad.download.d;
/* loaded from: classes21.dex */
public class AppNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String extractPackageName;
        if (intent != null) {
            if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                String extractPackageName2 = extractPackageName(intent);
                if (extractPackageName2 != null) {
                    d.bMy().aF(context, extractPackageName2);
                }
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) && (extractPackageName = extractPackageName(intent)) != null) {
                d.bMy().aH(context, extractPackageName);
            }
        }
    }

    private String extractPackageName(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return null;
        }
        return data.getEncodedSchemeSpecificPart();
    }
}
