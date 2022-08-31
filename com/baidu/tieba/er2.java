package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class er2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? file.isDirectory() && TextUtils.isDigitsOnly(file.getName()) : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947743876, "Lcom/baidu/tieba/er2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947743876, "Lcom/baidu/tieba/er2;");
                return;
            }
        }
        a = kh1.a;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(wj2.g(), str);
        if (file.exists()) {
            if (a) {
                Log.d("PkgInfoExt", "clear all pkg info's ext ,appId - " + str);
            }
            File[] listFiles = file.listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                b(str, file2.getName());
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            String e = e(str, str2);
            if (TextUtils.isEmpty(e)) {
                return;
            }
            o93.a().edit().remove(e).apply();
            if (a) {
                Log.d("PkgInfoExt", "clear pkg info's ext , appId - " + str + ", version code - " + str2);
            }
        }
    }

    public static String c(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pMSAppInfo)) == null) ? d(pMSAppInfo.appId, pMSAppInfo.versionCode) : (String) invokeL.objValue;
    }

    public static String d(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j)) == null) ? e(str, String.valueOf(j)) : (String) invokeLJ.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return str + "_" + str2 + "_pkg_info_ext";
            } else if (a) {
                Log.e("PkgInfoExt", "#getExtKey appId or version code is empty");
                Log.d("PkgInfoExt", "#getExtKey appId=" + str + " version=" + str2);
                return null;
            } else {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String f(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                return "";
            }
            String c = c(pMSAppInfo);
            if (TextUtils.isEmpty(c)) {
                return "";
            }
            String string = o93.a().getString(c, "");
            if (a) {
                Log.d("PkgInfoExt", "appId - " + pMSAppInfo.appId + ", get pkg info' ext - " + string);
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public static void g(String str, JSONObject jSONObject, x94 x94Var, List<y94> list) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, str, jSONObject, x94Var, list) == null) {
            if (jSONObject == null) {
                if (a) {
                    Log.d("PkgInfoExt", "pkgObject from pms is null");
                }
            } else if (x94Var == null && list == null) {
                if (a) {
                    Log.d("PkgInfoExt", "pkg info's ext must has at lest one main or sub pkg");
                }
            } else {
                String str2 = null;
                if (x94Var != null) {
                    str = x94Var.g;
                    j = x94Var.i;
                    str2 = x94Var.p;
                } else if (list.size() > 0) {
                    y94 y94Var = list.get(0);
                    j = y94Var.i;
                    str2 = y94Var.s;
                } else {
                    j = -1;
                }
                if (str2 == null) {
                    if (a) {
                        Log.e("PkgInfoExt", "can not get ext from pkg ");
                    }
                } else if (!TextUtils.isEmpty(str) && j != -1) {
                    o93.a().edit().putString(d(str, j), str2).apply();
                } else if (a) {
                    Log.e("PkgInfoExt", "can not get appId and version code from pkg ");
                }
            }
        }
    }
}
