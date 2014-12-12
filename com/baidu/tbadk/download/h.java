package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ g Xk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Xk = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        DownloadData downloadData;
        DownloadData downloadData2;
        DownloadData downloadData3;
        DownloadData downloadData4;
        DownloadData downloadData5;
        DownloadData downloadData6;
        DownloadData downloadData7;
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0) {
            downloadData = g.Xh;
            if (downloadData != null) {
                downloadData2 = g.Xh;
                downloadData2.setLength(message.arg1);
                downloadData3 = g.Xh;
                downloadData3.setSize(message.arg2);
                downloadData4 = g.Xh;
                downloadData4.setStatus(1);
                downloadData5 = g.Xh;
                if (downloadData5.getCallback() != null) {
                    downloadData6 = g.Xh;
                    f callback = downloadData6.getCallback();
                    downloadData7 = g.Xh;
                    callback.a(downloadData7);
                }
            }
        }
    }
}
