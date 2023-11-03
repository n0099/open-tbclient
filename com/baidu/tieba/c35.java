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
/* loaded from: classes5.dex */
public final class c35 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623844, "Lcom/baidu/tieba/c35;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623844, "Lcom/baidu/tieba/c35;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
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

        public final ApkDownloadInfoData a(vg0 vg0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vg0Var)) == null) {
                if (vg0Var != null && vg0Var.p != null) {
                    ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData();
                    apkDownloadInfoData.setApkIcon(vg0Var.p.g);
                    apkDownloadInfoData.setApkFile(vg0Var.h);
                    apkDownloadInfoData.setApkName(vg0Var.p.h);
                    apkDownloadInfoData.setStatus(vg0Var.c);
                    apkDownloadInfoData.setApkPackageName(vg0Var.d);
                    apkDownloadInfoData.setFinishDownloadTime(vg0Var.m);
                    apkDownloadInfoData.setAdDownloadBean(vg0Var);
                    apkDownloadInfoData.setNotificationShowCount(vg0Var.q.k);
                    if (apkDownloadInfoData.getApkFile() != null) {
                        apkDownloadInfoData.setApkPath(apkDownloadInfoData.getApkFile().getAbsolutePath());
                    }
                    apkDownloadInfoData.setItemSource(5);
                    apkDownloadInfoData.setDownloadUrl(vg0Var.g);
                    return apkDownloadInfoData;
                }
                return null;
            }
            return (ApkDownloadInfoData) invokeL.objValue;
        }

        public final ApkDownloadInfoData b(qna qnaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qnaVar)) == null) {
                if (qnaVar == null) {
                    return null;
                }
                TbDownloadManager tbDownloadManager = new TbDownloadManager();
                ItemData itemData = new ItemData();
                itemData.parseJson(qnaVar.c());
                tbDownloadManager.w(itemData.mTbFileDownloaderType);
                DownloadData downloadData = new DownloadData(qnaVar.r(), qnaVar.d());
                ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData();
                apkDownloadInfoData.setApkIcon(itemData.mIconUrl);
                apkDownloadInfoData.setApkName(itemData.mTitle);
                apkDownloadInfoData.setApkPackageName(itemData.pkgName);
                apkDownloadInfoData.setFinishDownloadTime(qnaVar.e());
                apkDownloadInfoData.setItemId((int) qnaVar.f());
                apkDownloadInfoData.setTitle(qnaVar.r());
                apkDownloadInfoData.setApkPath(tbDownloadManager.o(downloadData));
                apkDownloadInfoData.setApkFile(new File(apkDownloadInfoData.getApkPath()));
                apkDownloadInfoData.setNotificationShowCount(itemData.notificationShowCount);
                apkDownloadInfoData.setItemSource(qnaVar.p());
                apkDownloadInfoData.setDownloadUrl(qnaVar.d());
                return apkDownloadInfoData;
            }
            return (ApkDownloadInfoData) invokeL.objValue;
        }
    }
}
