package com.baidu.tbadk.coreExtra.service;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
/* loaded from: classes.dex */
public class LocationReportService extends BdBaseService {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UpdateInfoServiceConfig(this)));
    }
}
