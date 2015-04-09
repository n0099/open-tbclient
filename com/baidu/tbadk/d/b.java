package com.baidu.tbadk.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a aqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aqr = aVar;
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
            bdFileDownloadData = a.aqp;
            if (bdFileDownloadData != null) {
                bdFileDownloadData2 = a.aqp;
                bdFileDownloadData2.setLength(message.arg1);
                bdFileDownloadData3 = a.aqp;
                bdFileDownloadData3.setSize(message.arg2);
                bdFileDownloadData4 = a.aqp;
                if (bdFileDownloadData4.getCallback() != null) {
                    bdFileDownloadData5 = a.aqp;
                    com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback = bdFileDownloadData5.getCallback();
                    bdFileDownloadData6 = a.aqp;
                    callback.e(bdFileDownloadData6);
                }
            }
        }
    }
}
