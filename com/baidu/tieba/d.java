package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ak;
import java.io.File;
/* loaded from: classes.dex */
final class d extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ FileDownloader a;
    private ak b = null;
    private volatile boolean c = false;
    private final String d;
    private final String e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Boolean a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        NotificationManager notificationManager2;
        Handler handler;
        Handler handler2;
        Boolean bool2 = bool;
        super.a((d) bool2);
        this.a.c = null;
        if (bool2.booleanValue()) {
            notificationManager2 = this.a.a;
            notificationManager2.cancel(10);
            handler = this.a.d;
            handler2 = this.a.d;
            handler.sendMessageDelayed(handler2.obtainMessage(1, this.e), 100L);
            return;
        }
        notification = this.a.b;
        if (notification != null) {
            notification2 = this.a.b;
            notification2.contentView.setTextViewText(com.baidu.tieba.a.h.info, this.a.getString(com.baidu.tieba.a.k.error_sd_error));
            notification3 = this.a.b;
            notification3.flags = 16;
            notificationManager = this.a.a;
            notification4 = this.a.b;
            notificationManager.notify(10, notification4);
        }
        this.a.stopSelf();
    }

    public d(FileDownloader fileDownloader, String str, String str2) {
        this.a = fileDownloader;
        this.d = str;
        this.e = str2;
    }

    private Boolean a() {
        File e;
        Handler handler;
        Boolean bool = false;
        while (!this.c) {
            try {
                this.b = new ak(this.d);
                handler = this.a.d;
                bool = Boolean.valueOf(this.b.a(String.valueOf(this.e) + ".tmp", handler, 900002));
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
            com.baidu.tbadk.core.util.w.j(this.e);
            File d = com.baidu.tbadk.core.util.w.d(String.valueOf(this.e) + ".tmp");
            if (d != null && (e = com.baidu.tbadk.core.util.w.e(this.e)) != null) {
                d.renameTo(e);
            }
        }
        return bool;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.a.c = null;
        this.c = true;
        if (this.b != null) {
            this.b.g();
        }
    }
}
