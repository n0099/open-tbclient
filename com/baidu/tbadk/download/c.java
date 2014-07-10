package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        DownloadData downloadData;
        DownloadData downloadData2;
        DownloadData downloadData3;
        DownloadData downloadData4;
        DownloadData downloadData5;
        DownloadData downloadData6;
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0) {
            downloadData = b.b;
            if (downloadData != null) {
                downloadData2 = b.b;
                downloadData2.setLength(message.arg1);
                downloadData3 = b.b;
                downloadData3.setSize(message.arg2);
                downloadData4 = b.b;
                if (downloadData4.getCallback() != null) {
                    downloadData5 = b.b;
                    a callback = downloadData5.getCallback();
                    downloadData6 = b.b;
                    callback.b(downloadData6);
                }
            }
        }
    }
}
