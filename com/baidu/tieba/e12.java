package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.gz1;
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
public class e12 extends d12 {
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

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "StorageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements gz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e12 a;

        public a(e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e12Var;
        }

        @Override // com.baidu.tieba.gz1.a
        public d32 a(db3 db3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, db3Var, jSONObject, str)) == null) {
                String Q = e12.Q(jSONObject);
                if (Q == null) {
                    return new d32(202);
                }
                if (mi3.b(Q)) {
                    return new d32(1001, "exceed storage key max length");
                }
                String P = e12.P(jSONObject);
                if (P == null) {
                    return new d32(202);
                }
                if (mi3.c(P)) {
                    return new d32(1001, "exceed storage item max length");
                }
                if (this.a.N(db3Var, Q, P)) {
                    return new d32(1003, "exceed storage max length");
                }
                e12 e12Var = this.a;
                e12Var.q("#setStorageImpl dataKey=" + Q + " dataValue=" + P, false);
                this.a.F(db3Var).putString(Q, P);
                this.a.X();
                return d32.f();
            }
            return (d32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e12 a;

        public b(e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e12Var;
        }

        @Override // com.baidu.tieba.gz1.a
        public d32 a(db3 db3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048576, this, db3Var, jSONObject, str)) != null) {
                return (d32) invokeLLL.objValue;
            }
            this.a.q("#clearStorageImpl clear", false);
            this.a.F(db3Var).edit().clear().apply();
            this.a.X();
            return d32.f();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements gz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e12 a;

        public c(e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e12Var;
        }

        @Override // com.baidu.tieba.gz1.a
        public d32 a(db3 db3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, db3Var, jSONObject, str)) == null) {
                String Q = e12.Q(jSONObject);
                if (Q == null) {
                    return new d32(202);
                }
                e12 e12Var = this.a;
                e12Var.q("#removeStorageImpl dataKey=" + Q, false);
                this.a.F(db3Var).remove(Q);
                this.a.X();
                return d32.f();
            }
            return (d32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements gz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e12 a;

        public d(e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e12Var;
        }

        @Override // com.baidu.tieba.gz1.a
        public d32 a(db3 db3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, db3Var, jSONObject, str)) == null) {
                String Q = e12.Q(jSONObject);
                if (Q == null) {
                    return new d32(202);
                }
                JSONObject O = e12.O(this.a.F(db3Var).getString(Q, null));
                if (O == null) {
                    return new d32(202, "JSONException");
                }
                return new d32(0, O);
            }
            return (d32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements gz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(e12 e12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.gz1.a
        public d32 a(db3 db3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, db3Var, jSONObject, str)) == null) {
                mi3 f0 = db3Var.f0();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SavedStateHandle.KEYS, new JSONArray((Collection) f0.g().a()));
                    jSONObject2.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, f0.e() / 1024);
                    jSONObject2.put("limitSize", f0.n() / 1024);
                    return new d32(0, jSONObject2);
                } catch (JSONException unused) {
                    return new d32(202, "JSONException");
                }
            }
            return (d32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ gz1.a b;
        public final /* synthetic */ db3 c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ e12 e;

        public f(e12 e12Var, String str, gz1.a aVar, db3 db3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e12Var, str, aVar, db3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = e12Var;
            this.a = str;
            this.b = aVar;
            this.c = db3Var;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e12 e12Var = this.e;
                String str = this.a;
                e12Var.d(str, this.b.a(this.c, this.d, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e12(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
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

    public d32 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            q("#setStorage", false);
            if (str != null && str.length() > 3145728) {
                return new d32(1001, "exceed storage item max length");
            }
            return V(str, true);
        }
        return (d32) invokeL.objValue;
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

    public d32 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getStorage", false);
            return E(str, true);
        }
        return (d32) invokeL.objValue;
    }

    public fr4 F(@NonNull db3 db3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, db3Var)) == null) {
            return db3Var.f0().g();
        }
        return (fr4) invokeL.objValue;
    }

    public d32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getStorageInfoAsync", false);
            return I(str, true);
        }
        return (d32) invokeL.objValue;
    }

    public d32 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            q("#getStorageSync", false);
            return E(str, false);
        }
        return (d32) invokeL.objValue;
    }

    public d32 R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            q("#removeStorage", false);
            return S(str, true);
        }
        return (d32) invokeL.objValue;
    }

    public d32 T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            q("#removeStorageSync", false);
            return S(str, false);
        }
        return (d32) invokeL.objValue;
    }

    public d32 W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            q("#setStorageSync", false);
            return V(str, false);
        }
        return (d32) invokeL.objValue;
    }

    public boolean N(@Nullable db3 db3Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, db3Var, str, str2)) == null) {
            if (db3Var == null) {
                return false;
            }
            return db3Var.f0().m(str, str2);
        }
        return invokeLLL.booleanValue;
    }

    public d32 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#clearStorage", false);
            return B(null, true);
        }
        return (d32) invokeV.objValue;
    }

    public d32 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#clearStorageSync", false);
            return B(null, false);
        }
        return (d32) invokeV.objValue;
    }

    public d32 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q("#getStorageInfo", false);
            return I(null, true);
        }
        return (d32) invokeV.objValue;
    }

    public d32 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            q("#getStorageInfoSync", false);
            return I(null, false);
        }
        return (d32) invokeV.objValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            zm3.h.update();
        }
    }

    public d32 B(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            return L(str, z, new b(this));
        }
        return (d32) invokeLZ.objValue;
    }

    public d32 E(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
            return L(str, z, new d(this));
        }
        return (d32) invokeLZ.objValue;
    }

    public d32 I(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            return L(str, z, new e(this));
        }
        return (d32) invokeLZ.objValue;
    }

    public d32 S(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            return L(str, z, new c(this));
        }
        return (d32) invokeLZ.objValue;
    }

    public final d32 V(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, str, z)) == null) {
            return L(str, z, new a(this));
        }
        return (d32) invokeLZ.objValue;
    }

    public final d32 L(@Nullable String str, boolean z, @NonNull gz1.a aVar) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            db3 M = db3.M();
            if (M() && M == null) {
                return new d32(1001, "swan app is null");
            }
            if (TextUtils.isEmpty(str)) {
                return aVar.a(M, new JSONObject(), null);
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (z) {
                str2 = jSONObject.optString("cb");
            } else {
                str2 = null;
            }
            if (z && !TextUtils.isEmpty(str2)) {
                xn3.k(new f(this, str2, aVar, M, jSONObject), "StorageApi");
                return d32.f();
            }
            return aVar.a(M, jSONObject, null);
        }
        return (d32) invokeCommon.objValue;
    }
}
