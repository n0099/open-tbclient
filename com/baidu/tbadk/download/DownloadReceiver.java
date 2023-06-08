package com.baidu.tbadk.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.ym9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class DownloadReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_CANCEL_DOWNLOAD = "action_cancel_download";
    public static final String ACTION_PAUSE_DOWNLOAD = "action_pause_download";
    public static final String DOWNLOAD_DATA = "download_data";
    public transient /* synthetic */ FieldHolder $fh;

    public DownloadReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DownloadData downloadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || (downloadData = (DownloadData) intent.getSerializableExtra(DOWNLOAD_DATA)) == null) {
            return;
        }
        int p = ym9.p(downloadData);
        if (ACTION_PAUSE_DOWNLOAD.equals(intent.getAction())) {
            if (downloadData.getDownloadStaticsData() != null) {
                downloadData.getDownloadStaticsData().setDa_range_nt("1");
            }
            if (p == 7) {
                downloadData.setStatus(5);
                ym9.n().E(downloadData.getId(), downloadData.getUrl(), downloadData.getName(), downloadData.getPosition(), downloadData.getNotifyId(), downloadData.getTag(), downloadData.isNeedInvokeApk(), downloadData.isForceDownload(), downloadData.isNeedNotify(), downloadData.getApp_icon(), downloadData.getDownloadStaticsData(), downloadData.getUser_name());
                ym9.n().A(downloadData);
            } else if (p == 1 || p == 5) {
                downloadData.setStatus(4);
                ym9.n().g(downloadData.getUrl(), downloadData.getId(), true);
                ym9.n().v(downloadData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
        } else if (ACTION_CANCEL_DOWNLOAD.equals(intent.getAction())) {
            ym9.n().i(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016483, downloadData));
        }
    }
}
