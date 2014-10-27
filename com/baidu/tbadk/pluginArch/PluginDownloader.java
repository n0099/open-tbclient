package com.baidu.tbadk.pluginArch;

import android.app.ActivityManager;
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
import android.text.TextUtils;
import com.baidu.adp.lib.g.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tbadk.pluginArch.service.PluginDownloadService;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class PluginDownloader {
    private static int SOURCE_TAG_VALUE = 0;
    private Callback mCallBack;
    private Context mContext;
    private String[] mDownloadNames;
    private Messenger mSendMessenger;
    private int mSourceTag;
    private boolean mInstallAfterDownload = true;
    private Messenger mReplyMessenger = new Messenger(new IncomingHandler(this, null));
    private ServiceConnection mServiceConnection = new DownloadServiceConnection(this, null);

    /* loaded from: classes.dex */
    public interface Callback {
        void downloadFail(DownloadData downloadData);

        void downloadSuccess(DownloadData downloadData);

        void installFinish(DownloadData downloadData, int i, String str);

        void processUpdate(DownloadData downloadData);
    }

    public boolean isInstallAfterDownload() {
        return this.mInstallAfterDownload;
    }

    public void setInstallAfterDownload(boolean z) {
        this.mInstallAfterDownload = z;
    }

    public PluginDownloader(Context context) {
        this.mContext = context;
        int i = SOURCE_TAG_VALUE;
        SOURCE_TAG_VALUE = i + 1;
        this.mSourceTag = i;
    }

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        private DownloadData data;

        private IncomingHandler() {
        }

        /* synthetic */ IncomingHandler(PluginDownloader pluginDownloader, IncomingHandler incomingHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            if (data != null) {
                this.data = (DownloadData) data.getSerializable("download_data");
                if (this.data != null && PluginDownloader.this.isFrom(this.data)) {
                    switch (message.what) {
                        case 4:
                            if (PluginDownloader.this.mCallBack != null) {
                                PluginDownloader.this.mCallBack.processUpdate(this.data);
                                return;
                            }
                            return;
                        case 5:
                        default:
                            return;
                        case 6:
                            int i = data.getInt("errorCode");
                            PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_DOWNLOAD, String.valueOf(i) + "_" + data.getString("errorMsg"), this.data.getId());
                            if (PluginDownloader.this.mCallBack != null) {
                                PluginDownloader.this.mCallBack.downloadFail(this.data);
                                return;
                            }
                            return;
                        case 7:
                            PluginLogger.logSuccess(PluginLogger.WORKFLOW_NODE_DOWNLOAD);
                            if (PluginDownloader.this.mCallBack != null) {
                                PluginDownloader.this.mCallBack.downloadSuccess(this.data);
                            }
                            if (PluginDownloader.this.mInstallAfterDownload && this.data != null) {
                                PluginCenter.getInstance().installPluginFromFile(this.data.getPath(), this.data.getId(), new InstallCallback() { // from class: com.baidu.tbadk.pluginArch.PluginDownloader.IncomingHandler.1
                                    @Override // com.baidu.tbadk.pluginArch.InstallCallback
                                    public void onFinish(int i2, String str) {
                                        BdLog.i("startDownload_install_" + IncomingHandler.this.data.getId() + "_" + i2 + "_" + str);
                                        if (PluginDownloader.this.mCallBack != null) {
                                            PluginDownloader.this.mCallBack.installFinish(IncomingHandler.this.data, i2, str);
                                        }
                                        if (i2 == 0) {
                                            RemoteSynchronousDataHelper.getInstance().startInstallPluginMsg();
                                        }
                                    }
                                });
                                return;
                            }
                            return;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class DownloadServiceConnection implements ServiceConnection {
        private DownloadServiceConnection() {
        }

        /* synthetic */ DownloadServiceConnection(PluginDownloader pluginDownloader, DownloadServiceConnection downloadServiceConnection) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            PluginDownloader.this.mSendMessenger = new Messenger(iBinder);
            BdLog.i("startDownload_connected");
            PluginDownloader.this.sendMsgConnect();
            if (PluginDownloader.this.mDownloadNames == null) {
                return;
            }
            PluginDownloader.this.sendMsgAdd(PluginDownloader.this.mDownloadNames);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            PluginDownloader.this.mSendMessenger = null;
            PluginDownloader.this.mDownloadNames = null;
        }
    }

    public void startForeground(ConfigInfos.PluginConfig pluginConfig, Callback callback) {
        if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.name)) {
            return;
        }
        startDownload(new String[]{pluginConfig.name}, callback);
    }

    public void startDownload(String[] strArr, Callback callback) {
        this.mCallBack = callback;
        if (this.mSendMessenger != null && isDownloadServiceStart()) {
            BdLog.i("startDownload_add");
            sendMsgAdd(strArr);
            return;
        }
        BdLog.i("startDownload_bind");
        this.mDownloadNames = strArr;
        i.a(this.mContext, new Intent(this.mContext, PluginDownloadService.class), this.mServiceConnection, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFrom(DownloadData downloadData) {
        return !TextUtils.isEmpty(downloadData.getTag()) && downloadData.getTag().equals(String.valueOf(this.mSourceTag));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: android.os.Bundle */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tbadk.download.DownloadData[], java.io.Serializable] */
    public void sendMsgAdd(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            ?? r2 = new DownloadData[length];
            for (int i = 0; i < length; i++) {
                r2[i] = configToDownloadData(PluginCenter.getInstance().getNetConfigInfo(strArr[i]));
            }
            BdLog.i("startDownload_add_msg");
            Message obtain = Message.obtain((Handler) null, 3);
            Bundle bundle = new Bundle();
            bundle.putSerializable("download_datas", r2);
            if (obtain != null) {
                obtain.setData(bundle);
                try {
                    this.mSendMessenger.send(obtain);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsgConnect() {
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = this.mReplyMessenger;
                this.mSendMessenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    public void cancelForeground() {
        if (this.mSendMessenger != null && isDownloadServiceStart()) {
            try {
                this.mSendMessenger.send(Message.obtain((Handler) null, 2));
            } catch (RemoteException e) {
                e.printStackTrace();
            } finally {
                i.a(this.mContext, this.mServiceConnection);
            }
        }
    }

    private DownloadData configToDownloadData(ConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig == null) {
            return null;
        }
        DownloadData downloadData = new DownloadData(pluginConfig.name, pluginConfig.newest.url);
        String str = String.valueOf(pluginConfig.name) + ".tbplugin";
        downloadData.setName(str);
        downloadData.setPath(String.valueOf(PluginFileHelper.downloadDir(pluginConfig.name).getAbsolutePath()) + File.separator + str);
        downloadData.setCheck(pluginConfig.newest.md5);
        downloadData.setTag(new StringBuilder(String.valueOf(this.mSourceTag)).toString());
        return downloadData;
    }

    private boolean isDownloadServiceStart() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningServices(100);
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
