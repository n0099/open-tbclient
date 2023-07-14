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
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.pangle.plugin.Plugin;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d73 extends yz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Plugin.TAG : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SwanInvokeFunPageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements hd2<g73> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d73 a;

        public a(d73 d73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hd2
        /* renamed from: b */
        public void a(g73 g73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g73Var) != null) {
                return;
            }
            this.a.C(g73Var);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hd2<g73> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d73 a;

        public b(d73 d73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hd2
        /* renamed from: b */
        public void a(g73 g73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g73Var) != null) {
                return;
            }
            this.a.C(g73Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements hd2<g73> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d73 a;

        public c(d73 d73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d73Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hd2
        /* renamed from: b */
        public void a(g73 g73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g73Var) != null) {
                return;
            }
            this.a.C(g73Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d73(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public v32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#invokePluginPayment", false);
            f73 B = B(str);
            if (B.b()) {
                n73.b(B.toString());
                return B.i;
            }
            return new l73().l(B, new c(this));
        }
        return (v32) invokeL.objValue;
    }

    public v32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#invokePluginChooseAddress", false);
            f73 B = B(str);
            if (B.b()) {
                n73.b(B.toString());
                return B.i;
            }
            return new k73().l(B, new b(this));
        }
        return (v32) invokeL.objValue;
    }

    public v32 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            f73 B = B(str);
            if (B.b()) {
                n73.b(B.toString());
                return B.i;
            }
            return new m73().l(B, new a(this));
        }
        return (v32) invokeL.objValue;
    }

    public final f73 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            f73 f73Var = new f73();
            Pair<v32, JSONObject> s = s(str);
            f73Var.i = (v32) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return f73Var;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                f73Var.i = new v32(201, "pluginProvider is empty");
                return f73Var;
            }
            wk4 g = t73.g(optString);
            if (g != null) {
                String str2 = g.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        f73Var.i = new v32(201, "providerRootPath is empty");
                        return f73Var;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        f73Var.i = new v32(201, "slaveId is empty");
                        return f73Var;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        f73Var.i = new v32(201, "componentId is empty");
                        return f73Var;
                    }
                    String str3 = "release";
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    if (!TextUtils.isEmpty(optString5)) {
                        str3 = optString5;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(WebChromeClient.KEY_ARG_ARRAY);
                    String optString6 = jSONObject.optString("cb");
                    f73Var.a = str2;
                    f73Var.b = optString;
                    f73Var.c = optString2;
                    f73Var.d = str3;
                    f73Var.e = optString3;
                    f73Var.f = optString4;
                    f73Var.g = optJSONObject;
                    f73Var.h = optString6;
                    return f73Var;
                }
            }
            f73Var.i = new v32(201, "pluginProvider exchange for truth app key，but empty");
            return f73Var;
        }
        return (f73) invokeL.objValue;
    }

    public final void C(g73 g73Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g73Var) == null) && g73Var != null) {
            g73Var.b();
        }
    }
}
