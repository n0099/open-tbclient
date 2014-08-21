package com.baidu.tbadk.pluginArch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.download.DownloadData;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class l extends Handler {
    final /* synthetic */ i a;

    private l(i iVar) {
        this.a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(i iVar, l lVar) {
        this(iVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        DownloadData downloadData;
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        switch (message.what) {
            case 4:
                Bundle data = message.getData();
                if (data != null) {
                    DownloadData downloadData2 = (DownloadData) data.getSerializable("download_data");
                    jVar5 = this.a.e;
                    if (jVar5 != null) {
                        jVar6 = this.a.e;
                        jVar6.a(downloadData2);
                        return;
                    }
                    return;
                }
                return;
            case 5:
            default:
                return;
            case 6:
                Bundle data2 = message.getData();
                if (data2 != null && (downloadData = (DownloadData) data2.getSerializable("download_data")) != null) {
                    u.a("plugin_download", String.valueOf(data2.getInt("errorCode")) + "_" + data2.getString("errorMsg"), downloadData.getId());
                    jVar = this.a.e;
                    if (jVar != null) {
                        jVar2 = this.a.e;
                        jVar2.c(downloadData);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                Bundle data3 = message.getData();
                if (data3 != null) {
                    DownloadData downloadData3 = (DownloadData) data3.getSerializable("download_data");
                    u.a("plugin_download");
                    jVar3 = this.a.e;
                    if (jVar3 != null) {
                        jVar4 = this.a.e;
                        jVar4.b(downloadData3);
                    }
                    if (downloadData3 != null) {
                        d.a().a(downloadData3.getPath(), downloadData3.getId(), new m(this, downloadData3));
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
