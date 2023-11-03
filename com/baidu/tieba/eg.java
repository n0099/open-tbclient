package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DownloadCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class eg implements DownloadCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IPackageDownloadCallback a;

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onBulkDownloaded(List<PackageInfo> list, List<PackageInfo> list2, List<PackageInfo> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, list3) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadCancel(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadPause(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, packageInfo) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadResume(PackageInfo packageInfo, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{packageInfo, Long.valueOf(j), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadStart(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, packageInfo) == null) {
        }
    }

    public eg(IPackageDownloadCallback iPackageDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iPackageDownloadCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iPackageDownloadCallback;
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, packageInfo, errorInfo) == null) {
            this.a.onPackageDownloadFail(packageInfo.packageName, errorInfo.code, errorInfo.errorMsg);
            pg.b(packageInfo.packageName, 1, packageInfo.version);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, packageInfo, errorInfo) == null) {
            this.a.onPackageDownloadSuccess(packageInfo.packageName, packageInfo.filePath);
            pg.b(packageInfo.packageName, 0, packageInfo.version);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DownloadCallback
    public void onDownloadProgress(PackageInfo packageInfo, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{packageInfo, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.a.onProgress(j, j2);
        }
    }
}
