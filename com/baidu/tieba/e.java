package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class e extends Handler {
    final /* synthetic */ FileDownloader acH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FileDownloader fileDownloader) {
        this.acH = fileDownloader;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        String str;
        String str2;
        super.handleMessage(message);
        if (message.what == 900002) {
            if (message.arg2 > 0) {
                this.acH.progress = (int) ((message.arg1 * 100) / message.arg2);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / 1000));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / 1000));
                stringBuffer.append("K");
                this.acH.schedule = stringBuffer.toString();
                Context baseContext = this.acH.getBaseContext();
                i = this.acH.progress;
                str = this.acH.schedule;
                str2 = this.acH.mInfo;
                NotificationHelper.showProgressNotification(baseContext, 10, null, i, str, str2, true);
            }
        } else if (message.what == 1) {
            UtilHelper.install_apk(aj.wm().getApp(), (String) message.obj);
            this.acH.stopSelf();
        }
    }
}
