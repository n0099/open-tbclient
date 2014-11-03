package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ g Rn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Rn = gVar;
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
            downloadData = g.Rk;
            if (downloadData != null) {
                downloadData2 = g.Rk;
                downloadData2.setLength(message.arg1);
                downloadData3 = g.Rk;
                downloadData3.setSize(message.arg2);
                downloadData4 = g.Rk;
                downloadData4.setStatus(1);
                downloadData5 = g.Rk;
                if (downloadData5.getCallback() != null) {
                    downloadData6 = g.Rk;
                    f callback = downloadData6.getCallback();
                    downloadData7 = g.Rk;
                    callback.onFileUpdateProgress(downloadData7);
                }
            }
        }
    }
}
