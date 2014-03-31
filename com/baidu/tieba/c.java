package com.baidu.tieba;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
final class c extends Handler {
    final /* synthetic */ FileDownloader a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FileDownloader fileDownloader) {
        this.a = fileDownloader;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        super.handleMessage(message);
        if (message.what == 900002) {
            notification = this.a.b;
            if (notification != null && message.arg2 > 0) {
                notification2 = this.a.b;
                notification2.contentView.setProgressBar(com.baidu.tieba.a.h.progress, 100, (int) ((message.arg1 * 100) / message.arg2), false);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / LocationClientOption.MIN_SCAN_SPAN));
                stringBuffer.append("K");
                notification3 = this.a.b;
                notification3.contentView.setTextViewText(com.baidu.tieba.a.h.schedule, stringBuffer);
                notificationManager = this.a.a;
                notification4 = this.a.b;
                notificationManager.notify(10, notification4);
            }
        } else if (message.what == 1) {
            r.c();
            UtilHelper.b(r.d(), (String) message.obj);
            this.a.stopSelf();
        }
    }
}
