package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d65 implements h65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d65() {
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

    @Override // com.baidu.tieba.h65
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
            oj8 n = oj8.n();
            if (i == 3) {
                n.v(downloadData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
            } else {
                n.B(downloadData);
            }
            e65.a(downloadData);
            oj8.n().y(downloadData);
        }
    }

    @Override // com.baidu.tieba.h65
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
        e65.c(downloadData);
        NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
        oj8.n().y(downloadData);
        if (downloadData.isNeedInvokeApk()) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        }
    }

    @Override // com.baidu.tieba.h65
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

    @Override // com.baidu.tieba.h65
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

    @Override // com.baidu.tieba.h65
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
        oj8.n().C(downloadData);
        oj8.n().y(downloadData);
    }
}
