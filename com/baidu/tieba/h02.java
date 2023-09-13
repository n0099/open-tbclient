package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "TabBarApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ h02 d;

        public a(h02 h02Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h02Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = h02Var;
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tm3 z = h02.z();
                if (z == null) {
                    h82.c("TabBarApi", "tabBarViewController is null");
                    this.d.d(this.a, new h32(1001));
                    return;
                }
                if (this.b) {
                    j = z.r(this.c);
                } else {
                    j = z.j(this.c);
                }
                if (!j) {
                    StringBuilder sb = new StringBuilder();
                    if (this.b) {
                        str = "open";
                    } else {
                        str = "close";
                    }
                    sb.append(str);
                    sb.append("bottom bar fail");
                    h82.c("TabBarApi", sb.toString());
                    this.d.d(this.a, new h32(1001));
                }
                this.d.d(this.a, new h32(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h02(@NonNull iz1 iz1Var) {
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

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            qa2 U = uw2.T().U();
            if (U != null && U.o() != null && U.o().g2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static tm3 z() {
        InterceptResult invokeV;
        pa2 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            qa2 U = uw2.T().U();
            if (U != null && (l = U.l()) != null) {
                return l.x3();
            }
            return null;
        }
        return (tm3) invokeV.objValue;
    }

    public final h32 A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                h82.c("TabBarApi", "fail not TabBar page");
                return new h32(1001, "fail not TabBar page");
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h82.c("TabBarApi", "callback is null");
                return new h32(1001, "callback is null");
            }
            bp3.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return h32.f();
        }
        return (h32) invokeLZ.objValue;
    }

    public h32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (h32) invokeL.objValue;
    }

    public h32 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (h32) invokeL.objValue;
    }

    public h32 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            if (B()) {
                h82.c("TabBarApi", "fail not TabBar page");
                return new h32(1001, "fail not TabBar page");
            }
            tm3 z = z();
            if (z == null) {
                h82.c("TabBarApi", "tabBarViewController is null");
                return new h32(1001, "tabBarViewController is null");
            } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                h82.c("TabBarApi", "set tab bar item fail");
                return new h32(1001, "set tab bar item fail");
            } else {
                return h32.f();
            }
        }
        return (h32) invokeL.objValue;
    }

    public h32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            int optInt = ((JSONObject) s.second).optInt("index");
            if (B()) {
                h82.c("TabBarApi", "fail not TabBar page");
                return new h32(1001, "fail not TabBar page");
            }
            tm3 z = z();
            if (z == null) {
                h82.c("TabBarApi", "tabBarViewController is null");
                return new h32(1001, "tabBarViewController is null");
            } else if (!z.k(optInt)) {
                h82.c("TabBarApi", "close red dot fail");
                return new h32(1001, "close red dot fail");
            } else {
                return h32.f();
            }
        }
        return (h32) invokeL.objValue;
    }
}
