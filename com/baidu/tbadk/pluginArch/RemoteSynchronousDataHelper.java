package com.baidu.tbadk.pluginArch;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.g.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tbadk.pluginArch.service.RemoteSynchronousDataService;
/* loaded from: classes.dex */
public class RemoteSynchronousDataHelper {
    public static final int WHAT_CONNECT = 0;
    public static final int WHAT_DISCONNECT = 1;
    public static final int WHAT_INSTALL_PLUGIN = 3;
    public static final int WHAT_NET_CONFIG = 4;
    public static final int WHAT_OPERATE_FORBIDDEN = 2;
    private static RemoteSynchronousDataHelper mInstance;
    private ConfigInfos configInfos;
    private Messenger mSendMessenger;
    private String pluginName;
    private int sendType;
    private Messenger mReplyMessenger = new Messenger(new IncomingHandler(this, null));
    private Connection mConnection = new Connection(this, null);
    private Context mContext = TbadkApplication.m251getInst().getApplicationContext();

    private RemoteSynchronousDataHelper() {
    }

    public static synchronized RemoteSynchronousDataHelper getInstance() {
        RemoteSynchronousDataHelper remoteSynchronousDataHelper;
        synchronized (RemoteSynchronousDataHelper.class) {
            if (mInstance == null) {
                mInstance = new RemoteSynchronousDataHelper();
            }
            remoteSynchronousDataHelper = mInstance;
        }
        return remoteSynchronousDataHelper;
    }

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        private IncomingHandler() {
        }

        /* synthetic */ IncomingHandler(RemoteSynchronousDataHelper remoteSynchronousDataHelper, IncomingHandler incomingHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Connection implements ServiceConnection {
        private Connection() {
        }

        /* synthetic */ Connection(RemoteSynchronousDataHelper remoteSynchronousDataHelper, Connection connection) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BdLog.i("Connected");
            RemoteSynchronousDataHelper.this.mSendMessenger = new Messenger(iBinder);
            RemoteSynchronousDataHelper.this.sendConnect();
            if (RemoteSynchronousDataHelper.this.sendType != 2) {
                if (RemoteSynchronousDataHelper.this.sendType != 3) {
                    if (RemoteSynchronousDataHelper.this.sendType != 4 || RemoteSynchronousDataHelper.this.configInfos == null) {
                        return;
                    }
                    RemoteSynchronousDataHelper.this.sendNetConfigMsg(RemoteSynchronousDataHelper.this.configInfos);
                    RemoteSynchronousDataHelper.this.sendType = -1;
                    RemoteSynchronousDataHelper.this.configInfos = null;
                    RemoteSynchronousDataHelper.this.close();
                    return;
                }
                RemoteSynchronousDataHelper.this.sendInstallPluginMsg();
                RemoteSynchronousDataHelper.this.sendType = -1;
                RemoteSynchronousDataHelper.this.close();
            } else if (RemoteSynchronousDataHelper.this.pluginName == null) {
            } else {
                RemoteSynchronousDataHelper.this.sendOperateForbiddenMsg(RemoteSynchronousDataHelper.this.pluginName);
                RemoteSynchronousDataHelper.this.sendType = -1;
                RemoteSynchronousDataHelper.this.pluginName = null;
                RemoteSynchronousDataHelper.this.close();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            RemoteSynchronousDataHelper.this.mSendMessenger = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConnect() {
        Message obtain = Message.obtain((Handler) null, 0);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.mSendMessenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    private void sendDisConnect() {
        if (this.mSendMessenger != null) {
            Message obtain = Message.obtain((Handler) null, 1);
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.mSendMessenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    public void start() {
        i.a(this.mContext, new Intent(this.mContext, RemoteSynchronousDataService.class), this.mConnection, 1);
    }

    public void close() {
        sendDisConnect();
        BdLog.i(LoginActivityConfig.CLOSE);
        if (this.mSendMessenger != null) {
            i.a(this.mContext, this.mConnection);
        }
    }

    public void startOperateForbiddenMsg(String str) {
        if (str != null) {
            this.sendType = 2;
            this.pluginName = str;
            start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOperateForbiddenMsg(String str) {
        Message obtain = Message.obtain((Handler) null, 2);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                Bundle bundle = new Bundle();
                bundle.putString("pluginName", str);
                obtain.setData(bundle);
                this.mSendMessenger.send(obtain);
                BdLog.i("send-WHAT_OPERATE_FORBIDDEN");
            } catch (RemoteException e) {
            }
        }
    }

    public void startInstallPluginMsg() {
        this.sendType = 3;
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInstallPluginMsg() {
        Message obtain = Message.obtain((Handler) null, 3);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.mSendMessenger.send(obtain);
                BdLog.i("send-WHAT_INSTALL_PLUGIN");
            } catch (RemoteException e) {
            }
        }
    }

    public void startNetConfigMsg(ConfigInfos configInfos) {
        if (configInfos != null) {
            this.sendType = 4;
            this.configInfos = configInfos;
            start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNetConfigMsg(ConfigInfos configInfos) {
        Message obtain = Message.obtain((Handler) null, 4);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                Bundle bundle = new Bundle();
                bundle.putSerializable("configinfos", configInfos);
                obtain.setData(bundle);
                this.mSendMessenger.send(obtain);
                BdLog.i("send-WHAT_NET_CONFIG");
            } catch (RemoteException e) {
            }
        }
    }
}
