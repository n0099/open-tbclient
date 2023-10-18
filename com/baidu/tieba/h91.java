package com.baidu.tieba;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class h91 {
    public static /* synthetic */ Interceptable $ic;
    public static h91 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778441, "Lcom/baidu/tieba/h91;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778441, "Lcom/baidu/tieba/h91;");
                return;
            }
        }
        a = new h91();
    }

    public h91() {
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

    public static h91 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (h91) invokeV.objValue;
    }

    public Bundle c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return a(ca1.b(), "download_all", null, null);
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return a(ca1.b(), "fetch", null, null);
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return a(ca1.b(), "presetinfo", null, null);
        }
        return (Bundle) invokeV.objValue;
    }

    public final Bundle a(Uri uri, String str, String str2, Bundle bundle) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, uri, str, str2, bundle)) == null) {
            try {
                return ContextHolder.getApplicationContext().getContentResolver().call(uri, str, str2, bundle);
            } catch (IllegalArgumentException e) {
                if (u91.a()) {
                    e.printStackTrace();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt(Constant.TAG.RET_CODE, 56);
                return bundle2;
            }
        }
        return (Bundle) invokeLLLL.objValue;
    }

    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            a(ca1.b(), "cleardeprecated", null, bundle);
        }
    }

    public Bundle d(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundleInfo)) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return a(b, "downloadBackground", null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle e(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundleInfo)) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return a(b, "download", null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle m(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bundleInfo)) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return a(b, "installonly", null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle n(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bundleInfo)) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return a(b, "localinstall", null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public Bundle o(BundleInfo bundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bundleInfo)) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            return a(b, "presetinstallsingle", null, bundle);
        }
        return (Bundle) invokeL.objValue;
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.TAG.PARAM_PKG_NAME, str);
            a(b, "record", null, bundle);
        }
    }

    public void s(BundleInfo bundleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundleInfo) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            ContextHolder.getApplicationContext().getContentResolver().call(b, "resettype", (String) null, bundle);
        }
    }

    public Map<String, BundleInfoGroup> g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(ca1.b(), null, "", null, null);
            Map<String, BundleInfoGroup> u = u(BundleInfo.toBundleInfoList(query), j);
            try {
                query.close();
            } catch (Exception unused) {
            }
            return u;
        }
        return (Map) invokeJ.objValue;
    }

    public List<BundleInfo> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(ca1.b(), null, "pkg_name = ? ", new String[]{str}, null);
            List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(query);
            try {
                query.close();
            } catch (Exception unused) {
            }
            return bundleInfoList;
        }
        return (List) invokeL.objValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.TAG.PARAM_PKG_NAME, str);
            Bundle a2 = a(b, ApkCheckUBCManagerKt.PAGE, null, bundle);
            if (a2 == null || a2.getInt(Constant.TAG.PARAM_PKG_STUS, -1) != 47) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public BundleInfoGroup i(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j)) == null) {
            Cursor query = ContextHolder.getApplicationContext().getContentResolver().query(ca1.b(), null, "pkg_name = ? ", new String[]{str}, null);
            BundleInfoGroup t = t(BundleInfo.toBundleInfoList(query), j);
            try {
                query.close();
            } catch (Exception unused) {
            }
            return t;
        }
        return (BundleInfoGroup) invokeLJ.objValue;
    }

    public Bundle l(BundleInfo bundleInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, bundleInfo, z)) == null) {
            Uri b = ca1.b();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.TAG.PARAM_VALUE, BundleInfo.toContentValues(bundleInfo));
            bundle.putBoolean(Constant.TAG.PARAM_MULTI_BUNDLE_ENABLE, z);
            return a(b, "install", null, bundle);
        }
        return (Bundle) invokeLZ.objValue;
    }

    public void r(boolean z, ContentObserver contentObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z, contentObserver) == null) {
            ContextHolder.getApplicationContext().getContentResolver().registerContentObserver(ca1.b(), z, contentObserver);
        }
    }

    public final BundleInfoGroup t(List<BundleInfo> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, list, j)) == null) {
            BundleInfoGroup bundleInfoGroup = new BundleInfoGroup(j);
            for (BundleInfo bundleInfo : list) {
                bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
            }
            return bundleInfoGroup;
        }
        return (BundleInfoGroup) invokeLJ.objValue;
    }

    public final Map<String, BundleInfoGroup> u(List<BundleInfo> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048595, this, list, j)) == null) {
            HashMap hashMap = new HashMap();
            if (list == null) {
                return null;
            }
            for (BundleInfo bundleInfo : list) {
                BundleInfoGroup bundleInfoGroup = (BundleInfoGroup) hashMap.get(bundleInfo.getPackageName());
                if (bundleInfoGroup == null) {
                    bundleInfoGroup = new BundleInfoGroup(j);
                    hashMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
                }
                bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
            }
            return hashMap;
        }
        return (Map) invokeLJ.objValue;
    }
}
