package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g60 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] g;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public boolean b;
    public Set<String> c;
    public String d;
    public Context e;
    public int f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947745736, "Lcom/baidu/tieba/g60;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947745736, "Lcom/baidu/tieba/g60;");
                return;
            }
        }
        g = new byte[]{77, 73, 78, 71};
    }

    public g60() {
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

    public Set<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (Set) invokeV.objValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.longValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public static String[] b(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, signatureArr)) == null) {
            int length = signatureArr.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = f50.c(signatureArr[i].toByteArray());
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public static boolean g(String[] strArr, String[] strArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, strArr, strArr2)) == null) {
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                return false;
            }
            HashSet hashSet = new HashSet();
            for (String str : strArr) {
                hashSet.add(str);
            }
            HashSet hashSet2 = new HashSet();
            for (String str2 : strArr2) {
                hashSet2.add(str2);
            }
            return hashSet.equals(hashSet2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean j(String str, Context context, JSONObject jSONObject, Set<String> set) throws JSONException, PackageManager.NameNotFoundException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context, jSONObject, set)) == null) {
            JSONArray jSONArray = jSONObject.getJSONArray("sigs");
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArray.getString(i);
            }
            String[] b = b(context.getPackageManager().getPackageInfo(str, 64).signatures);
            if (b != null && b.length > 0) {
                Collections.addAll(set, b);
            }
            return g(strArr, b);
        }
        return invokeLLLL.booleanValue;
    }

    public void a(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, context) == null) {
            this.d = str;
            this.e = context;
        }
    }

    public final void e(Bundle bundle, r40 r40Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bundle, r40Var) == null) {
            try {
                if (r40Var == null) {
                    this.f |= 16;
                    return;
                }
                String string = bundle.getString("helios_data");
                if (TextUtils.isEmpty(string)) {
                    this.f |= 1;
                    return;
                }
                String string2 = bundle.getString("helios_sf");
                if (TextUtils.isEmpty(string2)) {
                    this.f |= 2;
                    return;
                }
                byte[] decode = Base64.decode(string.getBytes(IMAudioTransRequest.CHARSET), 1);
                for (int i = 0; i < decode.length; i++) {
                    decode[i] = (byte) (decode[i] ^ g[i % g.length]);
                }
                JSONObject jSONObject = new JSONObject(new String(decode));
                if (!i(jSONObject)) {
                    return;
                }
                HashSet hashSet = new HashSet();
                this.c = hashSet;
                if (!j(this.d, this.e, jSONObject, hashSet)) {
                    this.f |= 4;
                } else if (Arrays.equals(g50.a(Base64.decode(string2, 0), r40Var), f50.b(decode))) {
                    this.a = jSONObject.getLong("priority");
                    this.b = true;
                } else {
                    this.f |= 8;
                }
            } catch (Exception e) {
                this.f |= 256;
                Log.getStackTraceString(e);
            }
        }
    }

    public void f(r40 r40Var, boolean z) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ActivityInfo activityInfo;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, r40Var, z) == null) {
            PackageManager packageManager = this.e.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(this.d, 2);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo != null && (activityInfoArr = packageInfo.receivers) != null && activityInfoArr.length > 0) {
                for (ActivityInfo activityInfo2 : activityInfoArr) {
                    if ("com.baidu.helios.DummyProvider".equals(activityInfo2.name)) {
                        try {
                            activityInfo = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128);
                        } catch (PackageManager.NameNotFoundException unused2) {
                            activityInfo = null;
                        }
                        if (activityInfo != null && (bundle = activityInfo.metaData) != null && bundle.containsKey("helios") && z) {
                            e(bundle, r40Var);
                        }
                    }
                }
            }
        }
    }

    public final boolean i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            e50 e50Var = new e50();
            e50Var.b(jSONObject.optLong("flags"));
            String optString = jSONObject.optString("package", "");
            long a = e50Var.a(7L);
            if (optString.equals("") && a != 4) {
                this.f |= 64;
                return false;
            }
            if (a == 0) {
                if (!optString.equals(this.d)) {
                    this.f |= 32;
                    return false;
                }
            } else if (a == 1) {
                String str = this.d;
                if (str == null || !str.startsWith(optString)) {
                    this.f |= 32;
                    return false;
                }
            } else if (a == 2) {
                try {
                    if (!Pattern.compile(optString).matcher(this.d).matches()) {
                        this.f |= 32;
                        return false;
                    }
                } catch (Exception unused) {
                    this.f |= 128;
                    return false;
                }
            } else if (a == 4) {
                return true;
            } else {
                this.f |= 64;
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
