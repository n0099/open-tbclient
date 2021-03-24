package com.baidu.tbadk.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.i0.r2.x.e;
/* loaded from: classes3.dex */
public class DownloadReceiver extends BroadcastReceiver {
    public static final String ACTION_CANCEL_DOWNLOAD = "action_cancel_download";
    public static final String ACTION_PAUSE_DOWNLOAD = "action_pause_download";
    public static final String DOWNLOAD_DATA = "download_data";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DownloadData downloadData = (DownloadData) intent.getSerializableExtra("download_data");
        if (downloadData == null) {
            return;
        }
        int p = e.p(downloadData);
        if ("action_pause_download".equals(intent.getAction())) {
            if (downloadData.getDownloadStaticsData() != null) {
                downloadData.getDownloadStaticsData().setDa_range_nt("1");
            }
            if (p == 7) {
                downloadData.setStatus(5);
                e.n().E(downloadData.getId(), downloadData.getUrl(), downloadData.getName(), downloadData.getPosition(), downloadData.getNotifyId(), downloadData.getTag(), downloadData.isNeedInvokeApk(), downloadData.isForceDownload(), downloadData.isNeedNotify(), downloadData.getApp_icon(), downloadData.getDownloadStaticsData(), downloadData.getUser_name());
                e.n().A(downloadData);
            } else if (p == 1 || p == 5) {
                downloadData.setStatus(4);
                e.n().g(downloadData.getUrl(), downloadData.getId(), true);
                e.n().v(downloadData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
        } else if ("action_cancel_download".equals(intent.getAction())) {
            e.n().i(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016483, downloadData));
        }
    }
}
