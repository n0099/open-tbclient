package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.searchbox.download.apkcheck.FkApkInfoSearchRequestKt;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
/* loaded from: classes6.dex */
public class i65 extends e65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i65() {
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

    @Override // com.baidu.tieba.e65
    public void a(@NonNull Context context, @NonNull v55 v55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, v55Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = v55Var.a("is_force_update");
            clientUpdateInfo.mStatus = v55Var.a("status");
            clientUpdateInfo.mReverson = v55Var.a("reverson");
            clientUpdateInfo.mContentUrl = v55Var.a("content_url");
            clientUpdateInfo.mVercode = v55Var.a("version_code");
            clientUpdateInfo.mVername = v55Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = v55Var.a("download_url");
            clientUpdateInfo.mChangelog = v55Var.a("change_log");
            clientUpdateInfo.mSize = v55Var.a("size");
            clientUpdateInfo.mPackageName = v55Var.a("package_name");
            clientUpdateInfo.mSign = v55Var.a("sign");
            clientUpdateInfo.mProdline = v55Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = v55Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = v55Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = v55Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = v55Var.a("patch_size");
            clientUpdateInfo.mIconUrl = v55Var.a("icon_url");
            clientUpdateInfo.mSname = v55Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = v55Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, v55Var.a("apk_md5_rsa"))));
        }
    }
}
