package com.baidu.tbadk.pluginArch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.download.DownloadData;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ h a;

    private k(h hVar) {
        this.a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(h hVar, k kVar) {
        this(hVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        DownloadData downloadData;
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        i iVar6;
        switch (message.what) {
            case 4:
                Bundle data = message.getData();
                if (data != null) {
                    DownloadData downloadData2 = (DownloadData) data.getSerializable("download_data");
                    iVar5 = this.a.e;
                    if (iVar5 != null) {
                        iVar6 = this.a.e;
                        iVar6.a(downloadData2);
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
                    t.a("plugin_download", String.valueOf(data2.getInt("errorCode")) + "_" + data2.getString("errorMsg"), downloadData.getId());
                    iVar = this.a.e;
                    if (iVar != null) {
                        iVar2 = this.a.e;
                        iVar2.c(downloadData);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                Bundle data3 = message.getData();
                if (data3 != null) {
                    DownloadData downloadData3 = (DownloadData) data3.getSerializable("download_data");
                    t.a("plugin_download");
                    iVar3 = this.a.e;
                    if (iVar3 != null) {
                        iVar4 = this.a.e;
                        iVar4.b(downloadData3);
                    }
                    if (downloadData3 != null) {
                        d.a().a(downloadData3.getPath(), downloadData3.getId(), new l(this, downloadData3));
                        return;
                    }
                    return;
                }
                return;
        }
    }
}
