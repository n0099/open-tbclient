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
public class b65 extends x55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b65() {
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

    @Override // com.baidu.tieba.x55
    public void a(@NonNull Context context, @NonNull p55 p55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, p55Var) == null) {
            ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
            clientUpdateInfo.mIsForceUpdate = p55Var.a("is_force_update");
            clientUpdateInfo.mStatus = p55Var.a("status");
            clientUpdateInfo.mReverson = p55Var.a("reverson");
            clientUpdateInfo.mContentUrl = p55Var.a("content_url");
            clientUpdateInfo.mVercode = p55Var.a("version_code");
            clientUpdateInfo.mVername = p55Var.a(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
            clientUpdateInfo.mDownurl = p55Var.a("download_url");
            clientUpdateInfo.mChangelog = p55Var.a("change_log");
            clientUpdateInfo.mSize = p55Var.a("size");
            clientUpdateInfo.mPackageName = p55Var.a("package_name");
            clientUpdateInfo.mSign = p55Var.a("sign");
            clientUpdateInfo.mProdline = p55Var.a("prod_line");
            clientUpdateInfo.mSignMd5 = p55Var.a(FkApkInfoSearchRequestKt.PARAMS_KEY_SIGN_MD5);
            clientUpdateInfo.mApkMd5 = p55Var.a("apk_md5");
            clientUpdateInfo.mPatchDownUrl = p55Var.a("patch_download_url");
            clientUpdateInfo.mPatchSize = p55Var.a("patch_size");
            clientUpdateInfo.mIconUrl = p55Var.a("icon_url");
            clientUpdateInfo.mSname = p55Var.a(DownloadCenterFunConstants.DOWNLOAD_MARKET_SNAME);
            clientUpdateInfo.mUpdateTime = p55Var.a("update_time");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), clientUpdateInfo, p55Var.a("apk_md5_rsa"))));
        }
    }
}
