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
/* loaded from: classes5.dex */
public class a75 extends w65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a75() {
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

    @Override // com.baidu.tieba.w65
    public void a(@NonNull Context context, @NonNull o65 o65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, o65Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = o65Var.a("is_force_update");
            clientUpdateInfo.mStatus = o65Var.a("status");
            clientUpdateInfo.mReverson = o65Var.a("reverson");
            clientUpdateInfo.mContentUrl = o65Var.a("content_url");
            clientUpdateInfo.mVercode = o65Var.a("version_code");
            clientUpdateInfo.mVername = o65Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = o65Var.a("download_url");
            clientUpdateInfo.mChangelog = o65Var.a("change_log");
            clientUpdateInfo.mSize = o65Var.a("size");
            clientUpdateInfo.mPackageName = o65Var.a("package_name");
            clientUpdateInfo.mSign = o65Var.a("sign");
            clientUpdateInfo.mProdline = o65Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = o65Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = o65Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = o65Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = o65Var.a("patch_size");
            clientUpdateInfo.mIconUrl = o65Var.a("icon_url");
            clientUpdateInfo.mSname = o65Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = o65Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, o65Var.a("apk_md5_rsa"))));
        }
    }
}
