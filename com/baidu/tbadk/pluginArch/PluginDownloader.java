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
    private Callback mCallBack;
    private Context mContext;
    private String[] mDownloadNames;
    private Messenger mSendMessenger;
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
    }

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        private IncomingHandler() {
        }

        /* synthetic */ IncomingHandler(PluginDownloader pluginDownloader, IncomingHandler incomingHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DownloadData downloadData;
            switch (message.what) {
                case 4:
                    Bundle data = message.getData();
                    if (data != null) {
                        DownloadData downloadData2 = (DownloadData) data.getSerializable("download_data");
                        if (PluginDownloader.this.mCallBack != null) {
                            PluginDownloader.this.mCallBack.processUpdate(downloadData2);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                default:
                    return;
                case 6:
                    Bundle data2 = message.getData();
                    if (data2 != null && (downloadData = (DownloadData) data2.getSerializable("download_data")) != null) {
                        PluginLogger.logFailure(PluginLogger.WORKFLOW_NODE_DOWNLOAD, String.valueOf(data2.getInt("errorCode")) + "_" + data2.getString("errorMsg"), downloadData.getId());
                        if (PluginDownloader.this.mCallBack != null) {
                            PluginDownloader.this.mCallBack.downloadFail(downloadData);
                            return;
                        }
                        return;
                    }
                    return;
                case 7:
                    Bundle data3 = message.getData();
                    if (data3 != null) {
                        final DownloadData downloadData3 = (DownloadData) data3.getSerializable("download_data");
                        PluginLogger.logSuccess(PluginLogger.WORKFLOW_NODE_DOWNLOAD);
                        if (PluginDownloader.this.mCallBack != null) {
                            PluginDownloader.this.mCallBack.downloadSuccess(downloadData3);
                        }
                        if (PluginDownloader.this.mInstallAfterDownload && downloadData3 != null) {
                            PluginCenter.getInstance().installPluginFromFile(downloadData3.getPath(), downloadData3.getId(), new InstallCallback() { // from class: com.baidu.tbadk.pluginArch.PluginDownloader.IncomingHandler.1
                                @Override // com.baidu.tbadk.pluginArch.InstallCallback
                                public void onFinish(int i, String str) {
                                    BdLog.i("startDownload_install_" + downloadData3.getId() + "_" + i + "_" + str);
                                    if (PluginDownloader.this.mCallBack != null) {
                                        PluginDownloader.this.mCallBack.installFinish(downloadData3, i, str);
                                    }
                                    if (i == 0) {
                                        RemoteSynchronousDataHelper.getInstance().startInstallPluginMsg();
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
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
