package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.f02;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d22 extends c22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "StorageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements f02.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;

        public a(d22 d22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d22Var;
        }

        @Override // com.baidu.tieba.f02.a
        public c42 a(cc3 cc3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cc3Var, jSONObject, str)) == null) {
                String Q = d22.Q(jSONObject);
                if (Q == null) {
                    return new c42(202);
                }
                if (lj3.b(Q)) {
                    return new c42(1001, "exceed storage key max length");
                }
                String P = d22.P(jSONObject);
                if (P == null) {
                    return new c42(202);
                }
                if (lj3.c(P)) {
                    return new c42(1001, "exceed storage item max length");
                }
                if (this.a.N(cc3Var, Q, P)) {
                    return new c42(1003, "exceed storage max length");
                }
                d22 d22Var = this.a;
                d22Var.q("#setStorageImpl dataKey=" + Q + " dataValue=" + P, false);
                this.a.F(cc3Var).putString(Q, P);
                this.a.X();
                return c42.f();
            }
            return (c42) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f02.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;

        public b(d22 d22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d22Var;
        }

        @Override // com.baidu.tieba.f02.a
        public c42 a(cc3 cc3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, cc3Var, jSONObject, str)) != null) {
                return (c42) invokeLLL.objValue;
            }
            this.a.q("#clearStorageImpl clear", false);
            this.a.F(cc3Var).edit().clear().apply();
            this.a.X();
            return c42.f();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f02.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;

        public c(d22 d22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d22Var;
        }

        @Override // com.baidu.tieba.f02.a
        public c42 a(cc3 cc3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cc3Var, jSONObject, str)) == null) {
                String Q = d22.Q(jSONObject);
                if (Q == null) {
                    return new c42(202);
                }
                d22 d22Var = this.a;
                d22Var.q("#removeStorageImpl dataKey=" + Q, false);
                this.a.F(cc3Var).remove(Q);
                this.a.X();
                return c42.f();
            }
            return (c42) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f02.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d22 a;

        public d(d22 d22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d22Var;
        }

        @Override // com.baidu.tieba.f02.a
        public c42 a(cc3 cc3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cc3Var, jSONObject, str)) == null) {
                String Q = d22.Q(jSONObject);
                if (Q == null) {
                    return new c42(202);
                }
                JSONObject O = d22.O(this.a.F(cc3Var).getString(Q, null));
                if (O == null) {
                    return new c42(202, "JSONException");
                }
                return new c42(0, O);
            }
            return (c42) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements f02.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(d22 d22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f02.a
        public c42 a(cc3 cc3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cc3Var, jSONObject, str)) == null) {
                lj3 f0 = cc3Var.f0();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SavedStateHandle.KEYS, new JSONArray((Collection) f0.g().a()));
                    jSONObject2.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, f0.e() / 1024);
                    jSONObject2.put("limitSize", f0.n() / 1024);
                    return new c42(0, jSONObject2);
                } catch (JSONException unused) {
                    return new c42(202, "JSONException");
                }
            }
            return (c42) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ f02.a b;
        public final /* synthetic */ cc3 c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ d22 e;

        public f(d22 d22Var, String str, f02.a aVar, cc3 cc3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d22Var, str, aVar, cc3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = d22Var;
            this.a = str;
            this.b = aVar;
            this.c = cc3Var;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d22 d22Var = this.e;
                String str = this.a;
                d22Var.d(str, this.b.a(this.c, this.d, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d22(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static JSONObject O(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("key")) {
                        jSONObject.remove("key");
                    }
                    return jSONObject;
                } catch (JSONException unused) {
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str == null) {
                str = "";
            }
            try {
                jSONObject2.put("data", str);
                return jSONObject2;
            } catch (JSONException unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public c42 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            q("#setStorage", false);
            if (str != null && str.length() > 3145728) {
                return new c42(1001, "exceed storage item max length");
            }
            return V(str, true);
        }
        return (c42) invokeL.objValue;
    }

    @Nullable
    public static String P(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject.isNull("data")) {
                return null;
            }
            return jSONObject.optString("data");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String Q(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject.isNull("key")) {
                return null;
            }
            return jSONObject.optString("key");
        }
        return (String) invokeL.objValue;
    }

    public c42 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getStorage", false);
            return E(str, true);
        }
        return (c42) invokeL.objValue;
    }

    public es4 F(@NonNull cc3 cc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cc3Var)) == null) {
            return cc3Var.f0().g();
        }
        return (es4) invokeL.objValue;
    }

    public c42 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getStorageInfoAsync", false);
            return I(str, true);
        }
        return (c42) invokeL.objValue;
    }

    public c42 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            q("#getStorageSync", false);
            return E(str, false);
        }
        return (c42) invokeL.objValue;
    }

    public c42 R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            q("#removeStorage", false);
            return S(str, true);
        }
        return (c42) invokeL.objValue;
    }

    public c42 T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            q("#removeStorageSync", false);
            return S(str, false);
        }
        return (c42) invokeL.objValue;
    }

    public c42 W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            q("#setStorageSync", false);
            return V(str, false);
        }
        return (c42) invokeL.objValue;
    }

    public boolean N(@Nullable cc3 cc3Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, cc3Var, str, str2)) == null) {
            if (cc3Var == null) {
                return false;
            }
            return cc3Var.f0().m(str, str2);
        }
        return invokeLLL.booleanValue;
    }

    public c42 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#clearStorage", false);
            return B(null, true);
        }
        return (c42) invokeV.objValue;
    }

    public c42 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#clearStorageSync", false);
            return B(null, false);
        }
        return (c42) invokeV.objValue;
    }

    public c42 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q("#getStorageInfo", false);
            return I(null, true);
        }
        return (c42) invokeV.objValue;
    }

    public c42 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            q("#getStorageInfoSync", false);
            return I(null, false);
        }
        return (c42) invokeV.objValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            yn3.h.update();
        }
    }

    public c42 B(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            return L(str, z, new b(this));
        }
        return (c42) invokeLZ.objValue;
    }

    public c42 E(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return L(str, z, new d(this));
        }
        return (c42) invokeLZ.objValue;
    }

    public c42 I(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            return L(str, z, new e(this));
        }
        return (c42) invokeLZ.objValue;
    }

    public c42 S(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            return L(str, z, new c(this));
        }
        return (c42) invokeLZ.objValue;
    }

    public final c42 V(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, str, z)) == null) {
            return L(str, z, new a(this));
        }
        return (c42) invokeLZ.objValue;
    }

    public final c42 L(@Nullable String str, boolean z, @NonNull f02.a aVar) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            cc3 M = cc3.M();
            if (M() && M == null) {
                return new c42(1001, "swan app is null");
            }
            if (TextUtils.isEmpty(str)) {
                return aVar.a(M, new JSONObject(), null);
            }
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (z) {
                str2 = jSONObject.optString("cb");
            } else {
                str2 = null;
            }
            if (z && !TextUtils.isEmpty(str2)) {
                wo3.k(new f(this, str2, aVar, M, jSONObject), "StorageApi");
                return c42.f();
            }
            return aVar.a(M, jSONObject, null);
        }
        return (c42) invokeCommon.objValue;
    }
}
