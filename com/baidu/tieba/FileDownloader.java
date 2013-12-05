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

    /* renamed from: a  reason: collision with root package name */
    private NotificationManager f1006a = null;
    private Notification b = null;
    private w c = null;
    private Handler d = new v(this);

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, FileDownloader.class);
        intent.putExtra("file", str2);
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
        this.f1006a = (NotificationManager) getSystemService("notification");
        this.b = a();
        if (this.f1006a == null) {
            stopSelf();
        }
    }

    public Notification a() {
        PendingIntent activity = PendingIntent.getActivity(TiebaApplication.h(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(TiebaApplication.h().getPackageName(), (int) R.layout.notify_item);
        notification.contentView.setProgressBar(R.id.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.d.removeMessages(900002);
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.f1006a != null) {
            this.f1006a.cancel(10);
            this.f1006a.cancel(14);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String a2;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("info");
            String stringExtra2 = intent.getStringExtra(SocialConstants.PARAM_URL);
            this.b.contentView.setTextViewText(R.id.info, stringExtra);
            this.b.contentView.setTextViewText(R.id.schedule, "0/0");
            if (intent.getStringExtra("file") != null) {
                a2 = intent.getStringExtra("file");
            } else {
                a2 = a(stringExtra2);
            }
            if (com.baidu.tieba.util.x.d(a2) != null) {
                this.d.sendMessageDelayed(this.d.obtainMessage(1, a2), 100L);
            } else if (this.c == null) {
                this.c = new w(this, stringExtra2, a2);
                this.c.execute(new String[0]);
                this.b.contentView.setProgressBar(R.id.progress, 100, 0, false);
                this.f1006a.notify(10, this.b);
            }
        }
        super.onStart(intent, i);
    }

    private String a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }
}
