package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.unified.DownloadInfoData;
import com.baidu.searchbox.download.unified.DownloadParams;
import com.baidu.searchbox.download.unified.DownloadUnifiedManager;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.EventControlInfoForResume;
import com.baidu.searchbox.download.unified.EventControlInfoForStart;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cv6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cv6 a;
    public static volatile DownloadUnifiedManager b;
    public transient /* synthetic */ FieldHolder $fh;

    public cv6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b = DownloadUnifiedManager.getInstance();
    }

    public static cv6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (cv6.class) {
                    if (a == null) {
                        a = new cv6();
                    }
                }
            }
            return a;
        }
        return (cv6) invokeV.objValue;
    }

    public void a(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uri) == null) {
            b.deleteDownload(uri);
        }
    }

    public void c(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri) == null) {
            b.pauseDownload(uri);
        }
    }

    public DownloadInfoData d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            return b.queryDownloadInfoData(uri);
        }
        return (DownloadInfoData) invokeL.objValue;
    }

    public void e(Context context, String str, Uri uri, IDownloadListener iDownloadListener, EventControlInfoForResume eventControlInfoForResume, EventCallback eventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, uri, iDownloadListener, eventControlInfoForResume, eventCallback}) == null) {
            b.resumeDownload(context, str, uri, iDownloadListener, eventControlInfoForResume, eventCallback);
        }
    }

    public void f(Context context, String str, DownloadParams downloadParams, IDownloadListener iDownloadListener, EventControlInfoForStart eventControlInfoForStart, EventCallback eventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, downloadParams, iDownloadListener, eventControlInfoForStart, eventCallback}) == null) {
            b.startDownload(context, str, downloadParams, iDownloadListener, eventControlInfoForStart, eventCallback);
        }
    }
}
