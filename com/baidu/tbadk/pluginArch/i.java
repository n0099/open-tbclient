package com.baidu.tbadk.pluginArch;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tbadk.pluginArch.service.PluginDownloadService;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private Context a;
    private Messenger b;
    private Messenger c = new Messenger(new l(this, null));
    private ServiceConnection d = new k(this, null);
    private j e;
    private String[] f;

    public i(Context context) {
        this.a = context;
    }

    public void a(ConfigInfos.PluginConfig pluginConfig, j jVar) {
        if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.name)) {
            return;
        }
        a(new String[]{pluginConfig.name}, jVar);
    }

    public void a(String[] strArr, j jVar) {
        this.e = jVar;
        if (this.b != null && c()) {
            BdLog.i("startDownload_add");
            a(strArr);
            return;
        }
        BdLog.i("startDownload_bind");
        this.f = strArr;
        this.a.bindService(new Intent(this.a, PluginDownloadService.class), this.d, 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: android.os.Bundle */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tbadk.download.DownloadData[], java.io.Serializable] */
    public void a(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            ?? r2 = new DownloadData[length];
            for (int i = 0; i < length; i++) {
                r2[i] = a(d.a().b(strArr[i]));
            }
            BdLog.i("startDownload_add_msg");
            Message obtain = Message.obtain((Handler) null, 3);
            Bundle bundle = new Bundle();
            bundle.putSerializable("download_datas", r2);
            if (obtain != null) {
                obtain.setData(bundle);
                try {
                    this.b.send(obtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void b() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.c;
                this.b.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    public void a() {
        if (this.b != null && c()) {
            try {
                try {
                    this.b.send(Message.obtain((Handler) null, 2));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    try {
                        this.a.unbindService(this.d);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } finally {
                try {
                    this.a.unbindService(this.d);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private DownloadData a(ConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig == null) {
            return null;
        }
        DownloadData downloadData = new DownloadData(pluginConfig.name, pluginConfig.newest.url);
        String str = String.valueOf(pluginConfig.name) + ".tbplugin";
        downloadData.setName(str);
        downloadData.setPath(String.valueOf(n.g(pluginConfig.name).getAbsolutePath()) + File.separator + str);
        return downloadData;
    }

    private boolean c() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) this.a.getSystemService("activity")).getRunningServices(100);
        if (runningServices != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo != null && runningServiceInfo.service != null && PluginDownloadService.class.getName().equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
