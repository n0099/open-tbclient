package com.baidu.tbadk.pluginArch.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tbadk.pluginArch.d;
import com.baidu.tbadk.pluginArch.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RemoteSynchronousDataService extends Service {
    private Messenger mComingMessenger = new Messenger(new c(this, null));
    private List<Messenger> sendMessengers = new ArrayList();

    public void synchronousOperateForbidden(Message message) {
        Bundle data = message.getData();
        if (data != null) {
            String string = data.getString("pluginName");
            if (!TextUtils.isEmpty(string)) {
                n.a().b(string);
            }
        }
    }

    public void synchronousInstallPlugin(Message message) {
        d.a().b();
    }

    public void synchronousNetConfigs(Message message) {
        ConfigInfos configInfos;
        Bundle data = message.getData();
        if (data != null && (configInfos = (ConfigInfos) data.getSerializable("configinfos")) != null) {
            d.a().a(configInfos);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mComingMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.sendMessengers.clear();
    }
}
