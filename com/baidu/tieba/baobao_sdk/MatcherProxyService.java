package com.baidu.tieba.baobao_sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
/* loaded from: classes.dex */
public class MatcherProxyService extends Service {
    private static final String BAOBAO_PAGE_NAME = "cn.myhug.baobao.sdk.MatcherActivity";
    public static final int PLUGIN_CHECK_RESULT = 0;
    public static final int PLUGIN_LOADED_FAILED = 2;
    public static final int PLUGIN_LOADED_SUCCEED = 1;
    private Messenger mClient;
    private Messenger mMessenger;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mMessenger == null) {
            this.mMessenger = new Messenger(new IncomingHandler(this, null));
        }
        return this.mMessenger.getBinder();
    }

    /* loaded from: classes.dex */
    private class IncomingHandler extends Handler {
        private IncomingHandler() {
        }

        /* synthetic */ IncomingHandler(MatcherProxyService matcherProxyService, IncomingHandler incomingHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            if (message != null) {
                MatcherProxyService.this.mClient = message.replyTo;
                try {
                    Class.forName(MatcherProxyService.BAOBAO_PAGE_NAME);
                    z = true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    z = false;
                }
                try {
                    if (MatcherProxyService.this.mClient != null) {
                        MatcherProxyService.this.mClient.send(Message.obtain(null, 0, z ? 1 : 2, 0));
                    }
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
