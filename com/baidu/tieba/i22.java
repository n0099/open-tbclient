package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i22 extends g22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "CheckAppInstallApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ i22 c;

        public a(i22 i22Var, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i22Var, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i22Var;
            this.a = jSONArray;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.b, this.c.D(this.a));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ i22 c;

        public b(i22 i22Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i22Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i22Var;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.b, this.c.B(this.a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i22(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean E(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                packageInfo = getContext().getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                h82.o("CheckAppInstallApi", str + " cannot be found");
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void C(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONArray, str) == null) {
            bo3.f().execute(new a(this, jSONArray, str));
        }
    }

    public final void z(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            bo3.f().execute(new b(this, str, str2));
        }
    }

    public h32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = false;
            q("#checkAppInstalled", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("name");
            JSONArray optJSONArray = jSONObject.optJSONArray("name");
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString) && optJSONArray == null) {
                h82.c("CheckAppInstallApi", "parameter error");
                return new h32(201, "parameter error");
            }
            if (optJSONArray == null) {
                z = true;
            }
            if (TextUtils.isEmpty(optString2)) {
                if (z) {
                    return B(optString);
                }
                return D(optJSONArray);
            }
            if (z) {
                z(optString, optString2);
            } else {
                C(optJSONArray, optString2);
            }
            return h32.f();
        }
        return (h32) invokeL.objValue;
    }

    public final h32 B(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                packageInfo = getContext().getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                h82.o("CheckAppInstallApi", str + " cannot be found");
                packageInfo = null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (packageInfo != null) {
                    jSONObject.put("hasApp", true);
                    jSONObject.put(PushService.APP_VERSION_NAME, packageInfo.versionName);
                    jSONObject.put(PushService.APP_VERSION_CODE, packageInfo.versionCode);
                } else {
                    jSONObject.put("hasApp", false);
                }
                return new h32(0, "success", jSONObject);
            } catch (JSONException e) {
                h82.d("CheckAppInstallApi", "internal error: " + e.getMessage(), e);
                return new h32(1001, "internal error: " + e.getMessage());
            }
        }
        return (h32) invokeL.objValue;
    }

    public final h32 D(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            JSONObject jSONObject = new JSONObject();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(string, E(string));
                    }
                } catch (JSONException e) {
                    h82.d("CheckAppInstallApi", "internal error: " + e.getMessage(), e);
                }
            }
            return new h32(0, "success", jSONObject);
        }
        return (h32) invokeL.objValue;
    }
}
