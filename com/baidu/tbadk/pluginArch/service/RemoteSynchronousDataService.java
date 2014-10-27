package com.baidu.tbadk.pluginArch.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginForbiddenManager;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RemoteSynchronousDataService extends Service {
    private Messenger mComingMessenger = new Messenger(new IncomingHandler(this, null));
    private List<Messenger> sendMessengers = new ArrayList();

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        private IncomingHandler() {
        }

        /* synthetic */ IncomingHandler(RemoteSynchronousDataService remoteSynchronousDataService, IncomingHandler incomingHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    RemoteSynchronousDataService.this.sendMessengers.add(message.replyTo);
                    return;
                case 1:
                    RemoteSynchronousDataService.this.sendMessengers.remove(message.replyTo);
                    return;
                case 2:
                    BdLog.i("service----WHAT_OPERATE_FORBIDDEN");
                    RemoteSynchronousDataService.this.synchronousOperateForbidden(message);
                    return;
                case 3:
                    BdLog.i("service----WHAT_INSTALL_PLUGIN");
                    RemoteSynchronousDataService.this.synchronousInstallPlugin(message);
                    return;
                case 4:
                    BdLog.i("service----WHAT_NET_CONFIG");
                    RemoteSynchronousDataService.this.synchronousNetConfigs(message);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void synchronousOperateForbidden(Message message) {
        Bundle data = message.getData();
        if (data != null) {
            String string = data.getString("pluginName");
            if (!TextUtils.isEmpty(string)) {
                PluginForbiddenManager.getInstance().resetForbiddenConfig(string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void synchronousInstallPlugin(Message message) {
        PluginCenter.getInstance().resetLoad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void synchronousNetConfigs(Message message) {
        Bundle data = message.getData();
        if (data != null) {
            try {
                ConfigInfos configInfos = (ConfigInfos) data.getSerializable("configinfos");
                if (configInfos != null) {
                    PluginCenter.getInstance().setNetConfigInfos(configInfos);
                }
            } catch (Exception e) {
            }
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
