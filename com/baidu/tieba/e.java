package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class e extends Handler {
    final /* synthetic */ FileDownloader akW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FileDownloader fileDownloader) {
        this.akW = fileDownloader;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        String str;
        String str2;
        super.handleMessage(message);
        if (message.what == 900002) {
            if (message.arg2 > 0) {
                this.akW.progress = (int) ((message.arg1 * 100) / message.arg2);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / 1000));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / 1000));
                stringBuffer.append("K");
                this.akW.schedule = stringBuffer.toString();
                Context baseContext = this.akW.getBaseContext();
                i = this.akW.progress;
                str = this.akW.schedule;
                str2 = this.akW.mInfo;
                NotificationHelper.showProgressNotification(baseContext, 10, null, i, str, str2, true);
            }
        } else if (message.what == 1) {
            UtilHelper.install_apk(TbadkCoreApplication.m255getInst().getApp(), (String) message.obj);
            this.akW.stopSelf();
        }
    }
}
