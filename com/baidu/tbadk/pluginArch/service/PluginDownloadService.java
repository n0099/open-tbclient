package com.baidu.tbadk.pluginArch.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PluginDownloadServiceConfig;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.f;
import com.baidu.tbadk.download.g;
import java.util.ArrayList;
import java.util.Iterator;
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
    private Messenger mMessenger = new Messenger(new IncomingHandler(this, null));
    private List<Messenger> mClients = new ArrayList();
    private f mFileDownloadCallBack = new PluginDownloadCallback(this, null);

    static {
        TbadkApplication.m251getInst().RegisterIntent(PluginDownloadServiceConfig.class, PluginDownloadService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    /* loaded from: classes.dex */
    class PluginDownloadCallback implements f {
        private PluginDownloadCallback() {
        }

        /* synthetic */ PluginDownloadCallback(PluginDownloadService pluginDownloadService, PluginDownloadCallback pluginDownloadCallback) {
            this();
        }

        @Override // com.baidu.tbadk.download.f
        public void onFileUpdateProgress(DownloadData downloadData) {
            for (Messenger messenger : PluginDownloadService.this.mClients) {
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

        @Override // com.baidu.tbadk.download.f
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }

        @Override // com.baidu.tbadk.download.f
        public boolean onFileDownloaded(DownloadData downloadData) {
            BdLog.i("startDownload_server_file_" + downloadData.getId());
            sendMsg(5, downloadData);
            return true;
        }

        @Override // com.baidu.tbadk.download.f
        public void onFileDownloadSucceed(DownloadData downloadData) {
            BdLog.i("startDownload_server_succeed_" + downloadData.getId());
            sendMsg(7, downloadData);
        }

        @Override // com.baidu.tbadk.download.f
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            BdLog.i("startDownload_server_fail_" + downloadData.getId() + "_" + str);
            sendFailMsg(6, downloadData, i, str);
        }

        private void sendMsg(int i, DownloadData downloadData) {
            for (Messenger messenger : PluginDownloadService.this.mClients) {
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

        private void sendFailMsg(int i, DownloadData downloadData, int i2, String str) {
            for (Messenger messenger : PluginDownloadService.this.mClients) {
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

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        private IncomingHandler() {
        }

        /* synthetic */ IncomingHandler(PluginDownloadService pluginDownloadService, IncomingHandler incomingHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object[] objArr;
            boolean z;
            switch (message.what) {
                case 1:
                    BdLog.i("startDownload_server_connect");
                    PluginDownloadService.this.mClients.add(message.replyTo);
                    return;
                case 2:
                    BdLog.i("startDownload_server_disconnect");
                    PluginDownloadService.this.mClients.remove(message.replyTo);
                    return;
                case 3:
                    BdLog.i("startDownload_server_add");
                    Bundle data = message.getData();
                    if (data != null && (objArr = (Object[]) data.getSerializable("download_datas")) != null) {
                        for (Object obj : objArr) {
                            if (obj instanceof DownloadData) {
                                DownloadData downloadData = (DownloadData) obj;
                                Iterator<DownloadData> it = g.rk().rm().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        DownloadData next = it.next();
                                        if (next != null && next.getId() != null && next.getId().equals(downloadData.getId())) {
                                            z = true;
                                        }
                                    } else {
                                        z = false;
                                    }
                                }
                                if (!z) {
                                    BdLog.i("startDownload_server_add" + downloadData.getId());
                                    downloadData.setCallback(PluginDownloadService.this.mFileDownloadCallBack);
                                    g.rk().e(downloadData);
                                }
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mClients.clear();
        super.onDestroy();
    }
}
