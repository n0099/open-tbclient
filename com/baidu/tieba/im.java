package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.ApsConstants;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class im {
    public static /* synthetic */ Interceptable $ic;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public IPackageGetCallback a;
    public volatile ResultData b;
    public volatile ErrorInfo c;
    public RequestParams.Channel d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448307465, "Lcom/baidu/tieba/im;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448307465, "Lcom/baidu/tieba/im;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IPackageGetCallback a;
        public final /* synthetic */ im b;

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onDegradeData(DegradeData degradeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            }
        }

        public a(im imVar, IPackageGetCallback iPackageGetCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imVar, iPackageGetCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = imVar;
            this.a = iPackageGetCallback;
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onFetchError(ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) == null) {
                this.b.n(errorInfo, this.a);
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                this.b.o(resultData, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im a;

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onDegradeData(DegradeData degradeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            }
        }

        public b(im imVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imVar;
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onFetchError(ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) == null) {
                synchronized (this.a) {
                    this.a.c = errorInfo;
                    this.a.p();
                }
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                synchronized (this.a) {
                    boolean unused = im.e = true;
                    this.a.b = resultData;
                    this.a.p();
                }
            }
        }
    }

    public im() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return e;
        }
        return invokeV.booleanValue;
    }

    public final PackageInfo h(IBundleInfo iBundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iBundleInfo)) == null) {
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.channelId = ApsConstants.TYPE_ANDROID_PLUGIN;
            packageInfo.packageName = iBundleInfo.getPackageName();
            packageInfo.md5 = iBundleInfo.getMd5();
            packageInfo.downloadUrl = iBundleInfo.getDownloadUrl();
            packageInfo.isSilence = 1;
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public void k(List list, IPackageGetCallback iPackageGetCallback) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, iPackageGetCallback) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                synchronized (this) {
                    this.a = iPackageGetCallback;
                    p();
                }
                return;
            }
            j(list, iPackageGetCallback);
        }
    }

    public final void n(ErrorInfo errorInfo, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, errorInfo, iPackageGetCallback) == null) {
            iPackageGetCallback.onBundleInfoGetFail(errorInfo.code, errorInfo.errorMsg);
        }
    }

    public final void o(ResultData resultData, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, resultData, iPackageGetCallback) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(resultData.addList);
            arrayList.addAll(resultData.updateList);
            iPackageGetCallback.onBundleInfoGetSuccess(g(arrayList));
        }
    }

    public final List g(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new sl((PackageInfo) it.next()));
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void i(IBundleInfo iBundleInfo, String str, int i, IPackageDownloadCallback iPackageDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, iBundleInfo, str, i, iPackageDownloadCallback) == null) {
            PackageInfo h = h(iBundleInfo);
            h.filePath = str;
            DownloadOptions downloadOptions = new DownloadOptions();
            downloadOptions.saveToDb = false;
            if (i == 49) {
                if (BdNetTypeUtil.isWifiNet()) {
                    PmsManager.getInstance().download(h, downloadOptions, new tl(iPackageDownloadCallback));
                    return;
                } else {
                    iPackageDownloadCallback.onPackageDownloadFail(h.packageName, -1, "no wifi");
                    return;
                }
            }
            PmsManager.getInstance().download(h, downloadOptions, new tl(iPackageDownloadCallback));
        }
    }

    public final void j(List list, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, iPackageGetCallback) == null) {
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(ApsConstants.RUN_TYPE_ANDROID_PLUGIN);
            RequestParams.Channel channel = new RequestParams.Channel();
            channel.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((IBundleInfo) it.next()).getPackageName());
            }
            channel.setPackageNames(arrayList);
            channel.setCallback(new a(this, iPackageGetCallback));
            requestParams.addChannel(channel);
            PmsManager.getInstance().execute(requestParams);
        }
    }

    public RequestParams.Channel l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequestParams.Channel channel = this.d;
            if (channel != null) {
                return channel;
            }
            RequestParams.Channel channel2 = new RequestParams.Channel();
            this.d = channel2;
            channel2.setFetchAllPackages(true);
            this.d.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
            this.d.setCallback(new b(this));
            return this.d;
        }
        return (RequestParams.Channel) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.a == null) {
            return;
        }
        if (this.c != null) {
            n(this.c, this.a);
            this.a = null;
            this.c = null;
        } else if (this.b != null) {
            o(this.b, this.a);
            this.a = null;
            this.b = null;
        }
    }
}
