package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class e extends Handler {
    final /* synthetic */ FileDownloader acC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FileDownloader fileDownloader) {
        this.acC = fileDownloader;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        String str;
        String str2;
        super.handleMessage(message);
        if (message.what == 900002) {
            if (message.arg2 > 0) {
                this.acC.progress = (int) ((message.arg1 * 100) / message.arg2);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / 1000));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / 1000));
                stringBuffer.append("K");
                this.acC.schedule = stringBuffer.toString();
                Context baseContext = this.acC.getBaseContext();
                i = this.acC.progress;
                str = this.acC.schedule;
                str2 = this.acC.mInfo;
                NotificationHelper.showProgressNotification(baseContext, 10, null, i, str, str2, true);
            }
        } else if (message.what == 1) {
            UtilHelper.install_apk(aj.wk().getApp(), (String) message.obj);
            this.acC.stopSelf();
        }
    }
}
