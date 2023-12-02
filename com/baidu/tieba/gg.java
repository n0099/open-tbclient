package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.nps.utils.SourceData;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class gg {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public static boolean c;
    public static gg d;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ug a;

    /* loaded from: classes6.dex */
    public class a implements x91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.x91
        public void onProgress(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            }
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

        @Override // com.baidu.tieba.x91
        public void onResult(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && BdBaseApplication.getInst().isDebugMode()) {
                BdLog.e("Plug-in predownload status{\"code\": " + i + ", \"msg\": " + str + "}");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448305357, "Lcom/baidu/tieba/gg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448305357, "Lcom/baidu/tieba/gg;");
                return;
            }
        }
        d = new gg();
    }

    public gg() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !c && ug.n()) {
            c = true;
            NPSPackageManager.getInstance().downloadAllBundles();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || b) {
            return;
        }
        b = true;
        NPSPackageManager.getInstance().fetchBundleInfo();
    }

    public static gg f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return d;
        }
        return (gg) invokeV.objValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            a();
        }
    }

    public RequestParams.Channel d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h();
            return this.a.l();
        }
        return (RequestParams.Channel) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == null) {
                return "0";
            }
            return this.a.m();
        }
        return (String) invokeV.objValue;
    }

    public ug g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            h();
            return this.a;
        }
        return (ug) invokeV.objValue;
    }

    public final synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new ug();
                }
            }
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            if (str != null && str.trim().length() != 0) {
                SourceData sourceData = new SourceData();
                sourceData.source = "";
                NPSPackageManager.getInstance().preDownload(str, new a(), 1, sourceData);
            } else if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.e("PackageName of Plug-in is null.");
            }
        }
    }

    @NonNull
    public List<BundleInfo> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, BundleInfoGroup> entry : NPSPackageManager.getInstance().getAllBundleGroup().entrySet()) {
                BundleInfoGroup value = entry.getValue();
                BundleInfo bundleByType = value.getBundleByType(3);
                if (bundleByType == null) {
                    bundleByType = value.getBundleByType(2);
                }
                if (bundleByType != null) {
                    arrayList.add(bundleByType);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
