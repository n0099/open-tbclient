package com.baidu.tieba.ad.download.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import d.a.j0.o.d.d;
/* loaded from: classes4.dex */
public class AppNotificationReceiver extends BroadcastReceiver {
    private String extractPackageName(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return null;
        }
        return data.getEncodedSchemeSpecificPart();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String extractPackageName;
        if (intent == null) {
            return;
        }
        if (PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
            String extractPackageName2 = extractPackageName(intent);
            if (extractPackageName2 != null) {
                d.c().d(context, extractPackageName2);
            }
        } else if (!PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction()) || (extractPackageName = extractPackageName(intent)) == null) {
        } else {
            d.c().p(context, extractPackageName);
        }
    }
}
