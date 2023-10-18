package com.baidu.tieba;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fa0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static ga0 b = null;
    public static ma0 c = null;
    public static Context d = null;
    public static byte[] e = null;
    public static JSONObject f = null;
    public static JSONObject g = null;
    public static boolean h = true;
    public static String i = "live";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        void onProgress(int i, int i2);

        void onResult(boolean z, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947757268, "Lcom/baidu/tieba/fa0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947757268, "Lcom/baidu/tieba/fa0;");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            Log.e("DuAr_DuController", "ar->" + str);
        }
    }

    public static void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            l(context, "10000", "2288883fb087c4a37fbaf12bce65916e", "");
        }
    }

    public static void q(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, aVar) == null) {
            ta0.e().k(aVar);
        }
    }

    public static void r(ma0 ma0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, ma0Var) == null) {
            c = ma0Var;
        }
    }

    public static void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            i = str;
        }
    }

    public static void t(ga0 ga0Var) {
        File f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, ga0Var) == null) {
            b = ga0Var;
            if (ga0Var == null && (f2 = ta0.e().f()) != null) {
                b = new ga0(f2.getAbsolutePath());
            }
        }
    }

    public static void u(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65557, null, file) != null) || file == null) {
            return;
        }
        ga0 ga0Var = b;
        if (ga0Var == null) {
            ga0Var = new ga0(file.getAbsolutePath());
        }
        t(ga0Var);
    }

    public static void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            h = z;
            u(ta0.e().f());
        }
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return e;
        }
        return (byte[]) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d;
        }
        return (Context) invokeV.objValue;
    }

    public static ma0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c;
        }
        return (ma0) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return i;
        }
        return (String) invokeV.objValue;
    }

    public static synchronized ka0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            synchronized (fa0.class) {
                if (g != null && g.length() > 0) {
                    return ka0.b(g);
                }
                return null;
            }
        }
        return (ka0) invokeV.objValue;
    }

    public static ga0 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return b;
        }
        return (ga0) invokeV.objValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return ea0.a0();
        }
        return invokeV.intValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return ea0.b0();
        }
        return (String) invokeV.objValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return ta0.e().h();
        }
        return invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return h;
        }
        return invokeV.booleanValue;
    }

    public static DefaultParams e(EGLContext eGLContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, eGLContext)) == null) {
            String g2 = ga0.g();
            if (n()) {
                a("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + g2);
            }
            DefaultParams defaultParams = new DefaultParams();
            defaultParams.setFaceAlgoModelPath(g2);
            JSONObject jSONObject = f;
            if (jSONObject != null && jSONObject.length() > 0) {
                defaultParams.setGradingConfig(f);
            }
            if (eGLContext != null) {
                defaultParams.setUseTextureIO(true);
                defaultParams.setShareContext(eGLContext);
            }
            JSONObject jSONObject2 = f;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                defaultParams.setGradingConfig(f);
                if (n()) {
                    a("getDuMixDefaultParams  " + f.toString());
                }
            }
            return defaultParams;
        }
        return (DefaultParams) invokeL.objValue;
    }

    public static void l(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, str, str2, str3) == null) {
            m(context, str, str2, str3, null);
        }
    }

    @Deprecated
    public static void m(Context context, String str, String str2, String str3, ga0 ga0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65549, null, context, str, str2, str3, ga0Var) == null) {
            if (n()) {
                a("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
            }
            d = context.getApplicationContext();
            DuMixARConfig.setAppId(str);
            DuMixARConfig.setAPIKey(str2);
            DuMixARConfig.setSecretKey(str3);
            qa0.d().i(d);
            t(ga0Var);
        }
    }
}
