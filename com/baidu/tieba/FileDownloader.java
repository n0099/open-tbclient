package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FileDownloader extends Service {
    private NotificationManager a = null;
    private Notification b = null;
    private n c = null;
    private Handler d = new m(this);

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, FileDownloader.class);
        intent.putExtra("file", (String) null);
        intent.putExtra(SocialConstants.PARAM_URL, str);
        intent.putExtra("info", str3);
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = (NotificationManager) getSystemService("notification");
        PendingIntent activity = PendingIntent.getActivity(TiebaApplication.g().b(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(TiebaApplication.g().b().getPackageName(), (int) R.layout.notify_item);
        notification.contentView.setProgressBar(R.id.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        this.b = notification;
        if (this.a == null) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.d.removeMessages(900002);
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.a != null) {
            this.a.cancel(10);
            this.a.cancel(14);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String str;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("info");
            String stringExtra2 = intent.getStringExtra(SocialConstants.PARAM_URL);
            this.b.contentView.setTextViewText(R.id.info, stringExtra);
            this.b.contentView.setTextViewText(R.id.schedule, "0/0");
            if (intent.getStringExtra("file") != null) {
                str = intent.getStringExtra("file");
            } else if (stringExtra2 == null || stringExtra2.length() == 0) {
                str = null;
            } else {
                String[] split = (stringExtra2.contains("?") ? stringExtra2.substring(0, stringExtra2.indexOf("?")) : stringExtra2).split("/");
                str = split[split.length - 1];
            }
            if (com.baidu.tieba.util.af.d(str) != null) {
                this.d.sendMessageDelayed(this.d.obtainMessage(1, str), 100L);
            } else if (this.c == null) {
                this.c = new n(this, stringExtra2, str);
                this.c.execute(new String[0]);
                this.b.contentView.setProgressBar(R.id.progress, 100, 0, false);
                this.a.notify(10, this.b);
            }
        }
        super.onStart(intent, i);
    }
}
