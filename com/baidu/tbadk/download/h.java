package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ g Rj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Rj = gVar;
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
            downloadData = g.Rg;
            if (downloadData != null) {
                downloadData2 = g.Rg;
                downloadData2.setLength(message.arg1);
                downloadData3 = g.Rg;
                downloadData3.setSize(message.arg2);
                downloadData4 = g.Rg;
                downloadData4.setStatus(1);
                downloadData5 = g.Rg;
                if (downloadData5.getCallback() != null) {
                    downloadData6 = g.Rg;
                    f callback = downloadData6.getCallback();
                    downloadData7 = g.Rg;
                    callback.onFileUpdateProgress(downloadData7);
                }
            }
        }
    }
}
