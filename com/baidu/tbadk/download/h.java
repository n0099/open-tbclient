package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ g XQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, Looper looper) {
        super(looper);
        this.XQ = gVar;
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
            downloadData = g.XN;
            if (downloadData != null) {
                downloadData2 = g.XN;
                downloadData2.setLength(message.arg1);
                downloadData3 = g.XN;
                downloadData3.setSize(message.arg2);
                downloadData4 = g.XN;
                downloadData4.setStatus(1);
                downloadData5 = g.XN;
                if (downloadData5.getCallback() != null) {
                    downloadData6 = g.XN;
                    f callback = downloadData6.getCallback();
                    downloadData7 = g.XN;
                    callback.a(downloadData7);
                }
            }
        }
    }
}
