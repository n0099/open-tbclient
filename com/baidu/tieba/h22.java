package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aw2;
import com.baidu.tieba.ig3;
import com.baidu.tieba.qg3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h22 extends c22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "DesktopShortcutApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ db3 b;
        public final /* synthetic */ h22 c;

        public a(h22 h22Var, String str, db3 db3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, str, db3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h22Var;
            this.a = str;
            this.b = db3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    int b = gg3Var.b();
                    this.c.d(this.a, new d32(b, bg3.f(b)));
                    return;
                }
                if (h22.f) {
                    Log.d("DesktopShortcutApi", "start add to desktop");
                }
                this.c.A(this.b.w(), this.b);
                this.c.d(this.a, new d32(0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qg3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.qg3.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            h22.C(i);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771745, "Lcom/baidu/tieba/h22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771745, "Lcom/baidu/tieba/h22;");
                return;
            }
        }
        f = nr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h22(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            gi3 gi3Var = new gi3();
            cb3 K = cb3.K();
            String appId = K.getAppId();
            String n = wh3.n(K.k());
            gi3Var.f = appId;
            gi3Var.b = "api";
            gi3Var.a = n;
            gi3Var.e = "addshortcut";
            aw2.a W = K.q().W();
            if (W != null) {
                gi3Var.c = W.T();
            }
            gi3Var.a("appid", appId);
            gi3Var.a("resultstate", Integer.valueOf(i));
            mh3.b(gi3Var);
        }
    }

    public final void A(@NonNull Context context, @NonNull db3 db3Var) {
        aw2.a Y;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, db3Var) != null) || (Y = db3Var.Y()) == null) {
            return;
        }
        qg3.k(context, Y, new b(this));
    }

    public d32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#addToDesktop", false);
            if (f) {
                Log.d("DesktopShortcutApi", "#addToDesktop params = " + str);
            }
            Pair<d32, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((d32) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new d32(202, "cb is empty");
                }
                db3 b0 = db3.b0();
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    return new d32(1001, "the context is not an activity");
                }
                b0.e0().g(context, "scope_add_to_desktop", new a(this, optString, b0));
                return d32.f();
            }
            return (d32) s.first;
        }
        return (d32) invokeL.objValue;
    }
}
