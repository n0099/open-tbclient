package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ci5 implements gi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ci5() {
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

    @Override // com.baidu.tieba.gi5
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
            x3a n = x3a.n();
            if (i == 3) {
                n.v(downloadData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
            } else {
                n.B(downloadData);
            }
            di5.a(downloadData);
            x3a.n().y(downloadData);
        }
    }

    @Override // com.baidu.tieba.gi5
    public void onFileDownloadSucceed(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) != null) || downloadData == null) {
            return;
        }
        String[] tag = downloadData.getTag();
        if (tag != null && tag.length == 3) {
            String str = tag[0];
            String str2 = tag[1];
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "dl_game_success", "click", 1, "dev_id", downloadData.getId(), "ref_id", str, "is_detail", tag[2], "ref_type", str2);
        }
        di5.c(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        x3a.n().y(downloadData);
        if (downloadData.isNeedInvokeApk()) {
            AdApkInstallHelper.a(z3a.m(downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX), downloadData);
        }
    }

    @Override // com.baidu.tieba.gi5
    public boolean onFileDownloaded(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            downloadData.setStatusMsg(null);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.gi5
    public boolean onPreDownload(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
            if (downloadData == null) {
                return false;
            }
            downloadData.setStatusMsg(null);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.gi5
    public void onFileUpdateProgress(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, downloadData) != null) || downloadData == null) {
            return;
        }
        SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        long j = sharedPreferences.getLong(downloadData.getId(), 0L);
        if (j <= 1 || (downloadData.getSize() > 1 && j != downloadData.getSize())) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(downloadData.getId(), downloadData.getSize());
            edit.commit();
        }
        x3a.n().C(downloadData);
        x3a.n().y(downloadData);
    }
}
