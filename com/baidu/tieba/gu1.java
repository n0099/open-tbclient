package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.is1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gu1 extends fu1 {
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

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "StorageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements is1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu1 a;

        public a(gu1 gu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu1Var;
        }

        @Override // com.baidu.tieba.is1.a
        public fw1 a(f43 f43Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, f43Var, jSONObject, str)) == null) {
                String Q = gu1.Q(jSONObject);
                if (Q == null) {
                    return new fw1(202);
                }
                if (ob3.b(Q)) {
                    return new fw1(1001, "exceed storage key max length");
                }
                String P = gu1.P(jSONObject);
                if (P == null) {
                    return new fw1(202);
                }
                if (ob3.c(P)) {
                    return new fw1(1001, "exceed storage item max length");
                }
                if (this.a.N(f43Var, Q, P)) {
                    return new fw1(1003, "exceed storage max length");
                }
                gu1 gu1Var = this.a;
                gu1Var.q("#setStorageImpl dataKey=" + Q + " dataValue=" + P, false);
                this.a.F(f43Var).putString(Q, P);
                this.a.X();
                return fw1.f();
            }
            return (fw1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements is1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu1 a;

        public b(gu1 gu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu1Var;
        }

        @Override // com.baidu.tieba.is1.a
        public fw1 a(f43 f43Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, f43Var, jSONObject, str)) != null) {
                return (fw1) invokeLLL.objValue;
            }
            this.a.q("#clearStorageImpl clear", false);
            this.a.F(f43Var).edit().clear().apply();
            this.a.X();
            return fw1.f();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements is1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu1 a;

        public c(gu1 gu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu1Var;
        }

        @Override // com.baidu.tieba.is1.a
        public fw1 a(f43 f43Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, f43Var, jSONObject, str)) == null) {
                String Q = gu1.Q(jSONObject);
                if (Q == null) {
                    return new fw1(202);
                }
                gu1 gu1Var = this.a;
                gu1Var.q("#removeStorageImpl dataKey=" + Q, false);
                this.a.F(f43Var).remove(Q);
                this.a.X();
                return fw1.f();
            }
            return (fw1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements is1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu1 a;

        public d(gu1 gu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu1Var;
        }

        @Override // com.baidu.tieba.is1.a
        public fw1 a(f43 f43Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, f43Var, jSONObject, str)) == null) {
                String Q = gu1.Q(jSONObject);
                if (Q == null) {
                    return new fw1(202);
                }
                JSONObject O = gu1.O(this.a.F(f43Var).getString(Q, null));
                if (O == null) {
                    return new fw1(202, "JSONException");
                }
                return new fw1(0, O);
            }
            return (fw1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements is1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(gu1 gu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.is1.a
        public fw1 a(f43 f43Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, f43Var, jSONObject, str)) == null) {
                ob3 f0 = f43Var.f0();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SavedStateHandle.KEYS, new JSONArray((Collection) f0.g().a()));
                    jSONObject2.put("currentSize", f0.e() / 1024);
                    jSONObject2.put("limitSize", f0.n() / 1024);
                    return new fw1(0, jSONObject2);
                } catch (JSONException unused) {
                    return new fw1(202, "JSONException");
                }
            }
            return (fw1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ is1.a b;
        public final /* synthetic */ f43 c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ gu1 e;

        public f(gu1 gu1Var, String str, is1.a aVar, f43 f43Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu1Var, str, aVar, f43Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gu1Var;
            this.a = str;
            this.b = aVar;
            this.c = f43Var;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gu1 gu1Var = this.e;
                String str = this.a;
                gu1Var.d(str, this.b.a(this.c, this.d, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gu1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
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

    public fw1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            q("#setStorage", false);
            if (str != null && str.length() > 3145728) {
                return new fw1(1001, "exceed storage item max length");
            }
            return V(str, true);
        }
        return (fw1) invokeL.objValue;
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

    public fw1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getStorage", false);
            return E(str, true);
        }
        return (fw1) invokeL.objValue;
    }

    public hk4 F(@NonNull f43 f43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f43Var)) == null) {
            return f43Var.f0().g();
        }
        return (hk4) invokeL.objValue;
    }

    public fw1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getStorageInfoAsync", false);
            return I(str, true);
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            q("#getStorageSync", false);
            return E(str, false);
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            q("#removeStorage", false);
            return S(str, true);
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            q("#removeStorageSync", false);
            return S(str, false);
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            q("#setStorageSync", false);
            return V(str, false);
        }
        return (fw1) invokeL.objValue;
    }

    public boolean N(@Nullable f43 f43Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, f43Var, str, str2)) == null) {
            if (f43Var == null) {
                return false;
            }
            return f43Var.f0().m(str, str2);
        }
        return invokeLLL.booleanValue;
    }

    public fw1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#clearStorage", false);
            return B(null, true);
        }
        return (fw1) invokeV.objValue;
    }

    public fw1 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#clearStorageSync", false);
            return B(null, false);
        }
        return (fw1) invokeV.objValue;
    }

    public fw1 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q("#getStorageInfo", false);
            return I(null, true);
        }
        return (fw1) invokeV.objValue;
    }

    public fw1 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            q("#getStorageInfoSync", false);
            return I(null, false);
        }
        return (fw1) invokeV.objValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            bg3.h.update();
        }
    }

    public fw1 B(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            return L(str, z, new b(this));
        }
        return (fw1) invokeLZ.objValue;
    }

    public fw1 E(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return L(str, z, new d(this));
        }
        return (fw1) invokeLZ.objValue;
    }

    public fw1 I(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            return L(str, z, new e(this));
        }
        return (fw1) invokeLZ.objValue;
    }

    public fw1 S(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            return L(str, z, new c(this));
        }
        return (fw1) invokeLZ.objValue;
    }

    public final fw1 V(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, str, z)) == null) {
            return L(str, z, new a(this));
        }
        return (fw1) invokeLZ.objValue;
    }

    public final fw1 L(@Nullable String str, boolean z, @NonNull is1.a aVar) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            f43 M = f43.M();
            if (M() && M == null) {
                return new fw1(1001, "swan app is null");
            }
            if (TextUtils.isEmpty(str)) {
                return aVar.a(M, new JSONObject(), null);
            }
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (z) {
                str2 = jSONObject.optString("cb");
            } else {
                str2 = null;
            }
            if (z && !TextUtils.isEmpty(str2)) {
                zg3.k(new f(this, str2, aVar, M, jSONObject), "StorageApi");
                return fw1.f();
            }
            return aVar.a(M, jSONObject, null);
        }
        return (fw1) invokeCommon.objValue;
    }
}
