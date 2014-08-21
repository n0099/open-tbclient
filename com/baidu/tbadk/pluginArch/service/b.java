package com.baidu.tbadk.pluginArch.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.download.a {
    final /* synthetic */ PluginDownloadService a;

    private b(PluginDownloadService pluginDownloadService) {
        this.a = pluginDownloadService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(PluginDownloadService pluginDownloadService, b bVar) {
        this(pluginDownloadService);
    }

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData) {
        for (Messenger messenger : PluginDownloadService.access$0(this.a)) {
            Message obtain = Message.obtain(null, 4, null);
            if (obtain != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("download_data", downloadData);
                obtain.setData(bundle);
                try {
                    messenger.send(obtain);
                } catch (RemoteException e) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.download.a
    public boolean b(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.a
    public boolean c(DownloadData downloadData) {
        BdLog.i("startDownload_server_file_" + downloadData.getId());
        a(5, downloadData);
        return true;
    }

    @Override // com.baidu.tbadk.download.a
    public void d(DownloadData downloadData) {
        BdLog.i("startDownload_server_succeed_" + downloadData.getId());
        a(7, downloadData);
    }

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData, int i, String str) {
        BdLog.i("startDownload_server_fail_" + downloadData.getId() + "_" + str);
        a(6, downloadData, i, str);
    }

    private void a(int i, DownloadData downloadData) {
        for (Messenger messenger : PluginDownloadService.access$0(this.a)) {
            Message obtain = Message.obtain((Handler) null, i);
            if (obtain != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("download_data", downloadData);
                obtain.setData(bundle);
                try {
                    messenger.send(obtain);
                } catch (RemoteException e) {
                }
            }
        }
    }

    private void a(int i, DownloadData downloadData, int i2, String str) {
        for (Messenger messenger : PluginDownloadService.access$0(this.a)) {
            Message obtain = Message.obtain((Handler) null, i);
            if (obtain != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("download_data", downloadData);
                bundle.putInt("errorCode", i2);
                bundle.putString("errorMsg", str);
                obtain.setData(bundle);
                try {
                    messenger.send(obtain);
                } catch (RemoteException e) {
                }
            }
        }
    }
}
