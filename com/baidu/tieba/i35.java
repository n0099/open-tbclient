package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes6.dex */
public final class i35 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802590, "Lcom/baidu/tieba/i35;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802590, "Lcom/baidu/tieba/i35;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final ApkDownloadInfoData a(wg0 wg0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wg0Var)) == null) {
                if (wg0Var != null && wg0Var.p != null) {
                    ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData();
                    apkDownloadInfoData.setApkIcon(wg0Var.p.g);
                    apkDownloadInfoData.setApkFile(wg0Var.h);
                    apkDownloadInfoData.setApkName(wg0Var.p.h);
                    apkDownloadInfoData.setStatus(wg0Var.c);
                    apkDownloadInfoData.setApkPackageName(wg0Var.d);
                    apkDownloadInfoData.setFinishDownloadTime(wg0Var.m);
                    apkDownloadInfoData.setAdDownloadBean(wg0Var);
                    apkDownloadInfoData.setNotificationShowCount(wg0Var.q.k);
                    if (apkDownloadInfoData.getApkFile() != null) {
                        apkDownloadInfoData.setApkPath(apkDownloadInfoData.getApkFile().getAbsolutePath());
                    }
                    apkDownloadInfoData.setItemSource(5);
                    apkDownloadInfoData.setDownloadUrl(wg0Var.g);
                    return apkDownloadInfoData;
                }
                return null;
            }
            return (ApkDownloadInfoData) invokeL.objValue;
        }

        public final ApkDownloadInfoData b(ksa ksaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksaVar)) == null) {
                if (ksaVar == null) {
                    return null;
                }
                TbDownloadManager tbDownloadManager = new TbDownloadManager();
                ItemData itemData = new ItemData();
                itemData.parseJson(ksaVar.c());
                tbDownloadManager.w(itemData.mTbFileDownloaderType);
                DownloadData downloadData = new DownloadData(ksaVar.t(), ksaVar.d());
                ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData();
                apkDownloadInfoData.setApkIcon(itemData.mIconUrl);
                apkDownloadInfoData.setApkName(itemData.mTitle);
                apkDownloadInfoData.setApkPackageName(itemData.pkgName);
                apkDownloadInfoData.setFinishDownloadTime(ksaVar.f());
                apkDownloadInfoData.setItemId((int) ksaVar.g());
                apkDownloadInfoData.setTitle(ksaVar.t());
                apkDownloadInfoData.setApkPath(tbDownloadManager.o(downloadData));
                apkDownloadInfoData.setApkFile(new File(apkDownloadInfoData.getApkPath()));
                apkDownloadInfoData.setNotificationShowCount(itemData.notificationShowCount);
                apkDownloadInfoData.setItemSource(ksaVar.r());
                apkDownloadInfoData.setDownloadUrl(ksaVar.d());
                return apkDownloadInfoData;
            }
            return (ApkDownloadInfoData) invokeL.objValue;
        }
    }
}
