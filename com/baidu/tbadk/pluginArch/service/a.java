package com.baidu.tbadk.pluginArch.service;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ PluginDownloadService a;

    private a(PluginDownloadService pluginDownloadService) {
        this.a = pluginDownloadService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(PluginDownloadService pluginDownloadService, a aVar) {
        this(pluginDownloadService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object[] objArr;
        boolean z;
        com.baidu.tbadk.download.a aVar;
        List list;
        List list2;
        switch (message.what) {
            case 1:
                BdLog.i("startDownload_server_connect");
                list2 = this.a.mClients;
                list2.add(message.replyTo);
                return;
            case 2:
                BdLog.i("startDownload_server_disconnect");
                list = this.a.mClients;
                list.remove(message.replyTo);
                return;
            case 3:
                BdLog.i("startDownload_server_add");
                Bundle data = message.getData();
                if (data != null && (objArr = (Object[]) data.getSerializable("download_datas")) != null) {
                    for (Object obj : objArr) {
                        if (obj instanceof DownloadData) {
                            DownloadData downloadData = (DownloadData) obj;
                            Iterator<DownloadData> it = com.baidu.tbadk.download.b.a().b().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    DownloadData next = it.next();
                                    if (next != null && next.getId() != null && next.getId().equals(downloadData.getId())) {
                                        z = true;
                                    }
                                } else {
                                    z = false;
                                }
                            }
                            if (!z) {
                                BdLog.i("startDownload_server_add" + downloadData.getId());
                                aVar = this.a.mFileDownloadCallBack;
                                downloadData.setCallback(aVar);
                                com.baidu.tbadk.download.b.a().a(downloadData);
                            }
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
