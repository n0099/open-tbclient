package com.baidu.tbadk.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a ahE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ahE = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        BdFileDownloadData bdFileDownloadData;
        BdFileDownloadData bdFileDownloadData2;
        BdFileDownloadData bdFileDownloadData3;
        BdFileDownloadData bdFileDownloadData4;
        BdFileDownloadData bdFileDownloadData5;
        BdFileDownloadData bdFileDownloadData6;
        super.handleMessage(message);
        if (message.what == 900002 && message.arg2 > 0) {
            bdFileDownloadData = a.ahC;
            if (bdFileDownloadData != null) {
                bdFileDownloadData2 = a.ahC;
                bdFileDownloadData2.setLength(message.arg1);
                bdFileDownloadData3 = a.ahC;
                bdFileDownloadData3.setSize(message.arg2);
                bdFileDownloadData4 = a.ahC;
                if (bdFileDownloadData4.getCallback() != null) {
                    bdFileDownloadData5 = a.ahC;
                    com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback = bdFileDownloadData5.getCallback();
                    bdFileDownloadData6 = a.ahC;
                    callback.e(bdFileDownloadData6);
                }
            }
        }
    }
}
