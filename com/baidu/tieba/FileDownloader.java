package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class FileDownloader extends Service {
    public static final int FILE_EXIST = 1;
    private static final String TAG_FILE = "file";
    private static final String TAG_INFO = "info";
    private static final String TAG_URL = "url";
    private NotificationManager mNotificationManager = null;
    private Notification mNotify = null;
    private g mDowndingTask = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler handler = new f(this);

    public static void download(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, FileDownloader.class);
        intent.putExtra(TAG_FILE, str2);
        intent.putExtra(TAG_URL, str);
        intent.putExtra(TAG_INFO, str3);
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        this.mNotify = getUpdateNotification();
        if (this.mNotificationManager == null) {
            stopSelf();
        }
    }

    public Notification getUpdateNotification() {
        PendingIntent activity = PendingIntent.getActivity(ai.c().d(), 0, new Intent(), 0);
        Notification notification = new Notification(17301633, null, System.currentTimeMillis());
        notification.contentView = new RemoteViews(ai.c().d().getPackageName(), w.notify_item);
        notification.contentView.setProgressBar(v.progress, 100, 0, false);
        notification.contentIntent = activity;
        notification.flags = 32;
        return notification;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeMessages(TbConfig.NET_MSG_GETLENTH);
        if (this.mDowndingTask != null) {
            this.mDowndingTask.cancel();
        }
        if (this.mNotificationManager != null) {
            this.mNotificationManager.cancel(10);
            this.mNotificationManager.cancel(14);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        String fileOfUrl;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(TAG_INFO);
            String stringExtra2 = intent.getStringExtra(TAG_URL);
            this.mNotify.contentView.setTextViewText(v.info, stringExtra);
            this.mNotify.contentView.setTextViewText(v.schedule, "0/0");
            if (intent.getStringExtra(TAG_FILE) != null) {
                fileOfUrl = intent.getStringExtra(TAG_FILE);
            } else {
                fileOfUrl = getFileOfUrl(stringExtra2);
            }
            if (com.baidu.tbadk.core.util.x.d(fileOfUrl) != null) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, fileOfUrl), 100L);
            } else if (this.mDowndingTask == null) {
                this.mDowndingTask = new g(this, stringExtra2, fileOfUrl);
                this.mDowndingTask.execute(new String[0]);
                this.mNotify.contentView.setProgressBar(v.progress, 100, 0, false);
                this.mNotificationManager.notify(10, this.mNotify);
            }
        }
        super.onStart(intent, i);
    }

    private String getFileOfUrl(String str) {
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
