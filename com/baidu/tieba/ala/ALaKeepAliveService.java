package com.baidu.tieba.ala;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.base.BdBaseService;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ALaKeepAliveService extends BdBaseService {
    public static final String KEY_CONTENT_TEXT = "content_text";
    public static final String KEY_CONTENT_TITLE = "content_title";
    public static final String KEY_NOTIFICATION_ID = "notification_id";
    public static final String KEY_TICKER = "ticker";

    public static void startService(Context context, String str, String str2, String str3, int i) {
        if (context != null) {
            Intent intent = new Intent(context, ALaKeepAliveService.class);
            intent.setPackage(context.getPackageName());
            intent.putExtra(KEY_CONTENT_TITLE, str);
            intent.putExtra(KEY_CONTENT_TEXT, str2);
            intent.putExtra(KEY_TICKER, str3);
            if (i != 0) {
                intent.putExtra(KEY_NOTIFICATION_ID, i);
            }
            context.startService(intent);
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            startForeground(Integer.MAX_VALUE, new Notification());
        } else {
            String stringExtra = intent.getStringExtra(KEY_CONTENT_TITLE);
            String stringExtra2 = intent.getStringExtra(KEY_CONTENT_TEXT);
            String stringExtra3 = intent.getStringExtra(KEY_TICKER);
            int intExtra = intent.getIntExtra(KEY_NOTIFICATION_ID, Integer.MAX_VALUE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
            builder.setContentTitle(stringExtra).setContentText(stringExtra2).setSmallIcon(R.drawable.ic_icon_foreground).setTicker(stringExtra3);
            startForeground(intExtra, builder.build());
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
