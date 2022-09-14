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
/* loaded from: classes4.dex */
public final class he0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static ie0 b = null;
    public static oe0 c = null;
    public static Context d = null;
    public static byte[] e = null;
    public static JSONObject f = null;
    public static JSONObject g = null;
    public static boolean h = true;
    public static String i = "live";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface a {
        void onProgress(int i, int i2);

        void onResult(boolean z, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947820694, "Lcom/baidu/tieba/he0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947820694, "Lcom/baidu/tieba/he0;");
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            Log.e("DuAr_DuController", "ar->" + str);
        }
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? e : (byte[]) invokeV.objValue;
    }

    public static oe0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c : (oe0) invokeV.objValue;
    }

    public static DefaultParams d(EGLContext eGLContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eGLContext)) == null) {
            String g2 = ie0.g();
            if (m()) {
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
                if (m()) {
                    a("getDuMixDefaultParams  " + f.toString());
                }
            }
            return defaultParams;
        }
        return (DefaultParams) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? i : (String) invokeV.objValue;
    }

    public static synchronized me0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (he0.class) {
                if (g == null || g.length() <= 0) {
                    return null;
                }
                return me0.b(g);
            }
        }
        return (me0) invokeV.objValue;
    }

    public static ie0 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? b : (ie0) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d : (Context) invokeV.objValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? ge0.a0() : invokeV.intValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? ge0.b0() : (String) invokeV.objValue;
    }

    public static void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            k(context, "10000", "2288883fb087c4a37fbaf12bce65916e", "");
        }
    }

    public static void k(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, str, str2, str3) == null) {
            l(context, str, str2, str3, null);
        }
    }

    @Deprecated
    public static void l(Context context, String str, String str2, String str3, ie0 ie0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65549, null, context, str, str2, str3, ie0Var) == null) {
            if (m()) {
                a("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
            }
            d = context.getApplicationContext();
            DuMixARConfig.setAppId(str);
            DuMixARConfig.setAPIKey(str2);
            DuMixARConfig.setSecretKey(str3);
            se0.d().i(d);
            s(ie0Var);
        }
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? ve0.e().h() : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? h : invokeV.booleanValue;
    }

    public static void p(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, aVar) == null) {
            ve0.e().k(aVar);
        }
    }

    public static void q(oe0 oe0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, oe0Var) == null) {
            c = oe0Var;
        }
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            i = str;
        }
    }

    public static void s(ie0 ie0Var) {
        File f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, ie0Var) == null) {
            b = ie0Var;
            if (ie0Var != null || (f2 = ve0.e().f()) == null) {
                return;
            }
            b = new ie0(f2.getAbsolutePath());
        }
    }

    public static void t(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, file) == null) || file == null) {
            return;
        }
        ie0 ie0Var = b;
        if (ie0Var == null) {
            ie0Var = new ie0(file.getAbsolutePath());
        }
        s(ie0Var);
    }

    public static void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, null, z) == null) {
            h = z;
            t(ve0.e().f());
        }
    }
}
