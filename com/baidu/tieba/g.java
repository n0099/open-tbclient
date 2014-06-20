package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
class g extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FileDownloader a;
    private com.baidu.tbadk.core.util.an b = null;
    private volatile boolean c = false;
    private final String d;
    private final String e;

    public g(FileDownloader fileDownloader, String str, String str2) {
        this.a = fileDownloader;
        this.d = str;
        this.e = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        File e;
        Handler handler;
        Boolean bool = false;
        while (!this.c) {
            try {
                this.b = new com.baidu.tbadk.core.util.an(this.d);
                handler = this.a.handler;
                bool = Boolean.valueOf(this.b.a(String.valueOf(this.e) + ".tmp", handler, TbConfig.NET_MSG_GETLENTH));
                if (bool.booleanValue() || this.b.d() == -2) {
                    break;
                } else if (!this.b.a().b().c()) {
                    try {
                        Thread.sleep(10000L);
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
            }
        }
        if (bool.booleanValue()) {
            com.baidu.tbadk.core.util.x.j(this.e);
            File d = com.baidu.tbadk.core.util.x.d(String.valueOf(this.e) + ".tmp");
            if (d != null && (e = com.baidu.tbadk.core.util.x.e(this.e)) != null) {
                d.renameTo(e);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.mDowndingTask = null;
        this.c = true;
        if (this.b != null) {
            this.b.g();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        NotificationManager notificationManager2;
        Handler handler;
        Handler handler2;
        super.onPostExecute(bool);
        this.a.mDowndingTask = null;
        if (bool.booleanValue()) {
            notificationManager2 = this.a.mNotificationManager;
            notificationManager2.cancel(10);
            handler = this.a.handler;
            handler2 = this.a.handler;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.e), 100L);
            return;
        }
        notification = this.a.mNotify;
        if (notification != null) {
            notification2 = this.a.mNotify;
            notification2.contentView.setTextViewText(v.info, this.a.getString(y.error_sd_error));
            notification3 = this.a.mNotify;
            notification3.flags = 16;
            notificationManager = this.a.mNotificationManager;
            notification4 = this.a.mNotify;
            notificationManager.notify(10, notification4);
        }
        this.a.stopSelf();
    }
}
