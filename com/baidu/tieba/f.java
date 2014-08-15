package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class f extends Handler {
    final /* synthetic */ FileDownloader a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FileDownloader fileDownloader) {
        this.a = fileDownloader;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        String str;
        super.handleMessage(message);
        if (message.what == 900002) {
            if (message.arg2 > 0) {
                this.a.progress = (int) ((message.arg1 * 100) / message.arg2);
                StringBuffer stringBuffer = new StringBuffer(20);
                stringBuffer.append(String.valueOf(message.arg1 / 1000));
                stringBuffer.append("K/");
                stringBuffer.append(String.valueOf(message.arg2 / 1000));
                stringBuffer.append("K");
                this.a.schedule = stringBuffer.toString();
                Context baseContext = this.a.getBaseContext();
                i = this.a.progress;
                str = this.a.schedule;
                com.baidu.tbadk.core.util.ap.a(baseContext, 10, (String) null, i, str, (String) null, true);
            }
        } else if (message.what == 1) {
            UtilHelper.install_apk(ai.c().d(), (String) message.obj);
            this.a.stopSelf();
        }
    }
}
