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
public final class i25 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947801629, "Lcom/baidu/tieba/i25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947801629, "Lcom/baidu/tieba/i25;");
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

        public final ApkDownloadInfoData a(eg0 eg0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eg0Var)) == null) {
                if (eg0Var != null && eg0Var.p != null) {
                    ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData();
                    apkDownloadInfoData.setApkIcon(eg0Var.p.g);
                    apkDownloadInfoData.setApkFile(eg0Var.h);
                    apkDownloadInfoData.setApkName(eg0Var.p.h);
                    apkDownloadInfoData.setStatus(eg0Var.c);
                    apkDownloadInfoData.setApkPackageName(eg0Var.d);
                    apkDownloadInfoData.setFinishDownloadTime(eg0Var.m);
                    apkDownloadInfoData.setAdDownloadBean(eg0Var);
                    apkDownloadInfoData.setNotificationShowCount(eg0Var.q.k);
                    if (apkDownloadInfoData.getApkFile() != null) {
                        apkDownloadInfoData.setApkPath(apkDownloadInfoData.getApkFile().getAbsolutePath());
                    }
                    apkDownloadInfoData.setItemSource(5);
                    apkDownloadInfoData.setDownloadUrl(eg0Var.g);
                    return apkDownloadInfoData;
                }
                return null;
            }
            return (ApkDownloadInfoData) invokeL.objValue;
        }

        public final ApkDownloadInfoData b(laa laaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, laaVar)) == null) {
                if (laaVar == null) {
                    return null;
                }
                TbDownloadManager tbDownloadManager = new TbDownloadManager();
                ItemData itemData = new ItemData();
                itemData.parseJson(laaVar.c());
                tbDownloadManager.w(itemData.mTbFileDownloaderType);
                DownloadData downloadData = new DownloadData(laaVar.r(), laaVar.d());
                ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData();
                apkDownloadInfoData.setApkIcon(itemData.mIconUrl);
                apkDownloadInfoData.setApkName(itemData.mTitle);
                apkDownloadInfoData.setApkPackageName(itemData.pkgName);
                apkDownloadInfoData.setFinishDownloadTime(laaVar.e());
                apkDownloadInfoData.setItemId((int) laaVar.f());
                apkDownloadInfoData.setTitle(laaVar.r());
                apkDownloadInfoData.setApkPath(tbDownloadManager.o(downloadData));
                apkDownloadInfoData.setApkFile(new File(apkDownloadInfoData.getApkPath()));
                apkDownloadInfoData.setNotificationShowCount(itemData.notificationShowCount);
                apkDownloadInfoData.setItemSource(laaVar.p());
                apkDownloadInfoData.setDownloadUrl(laaVar.d());
                return apkDownloadInfoData;
            }
            return (ApkDownloadInfoData) invokeL.objValue;
        }
    }
}
