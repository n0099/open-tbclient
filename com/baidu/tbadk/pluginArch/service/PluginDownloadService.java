package com.baidu.tbadk.pluginArch.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bm;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PluginDownloadService extends Service {
    public static final int MSG_ADD = 3;
    public static final int MSG_CONNECT_CLIENT = 1;
    public static final int MSG_DISCONNECT_CLIENT = 2;
    public static final int MSG_FAILED = 6;
    public static final int MSG_FINISH = 5;
    public static final int MSG_SUCCEED = 7;
    public static final int MSG_UPDATE = 4;
    private Messenger mMessenger = new Messenger(new a(this, null));
    private List<Messenger> mClients = new ArrayList();
    private com.baidu.tbadk.download.a mFileDownloadCallBack = new b(this, null);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bm.class, PluginDownloadService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mClients.clear();
        super.onDestroy();
    }
}
