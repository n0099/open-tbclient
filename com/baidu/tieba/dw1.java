package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.t52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dw1 extends cw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ q52 b;
        public final /* synthetic */ t52 c;
        public final /* synthetic */ t52.b d;
        public final /* synthetic */ dw1 e;

        public a(dw1 dw1Var, int i, q52 q52Var, t52 t52Var, t52.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw1Var, Integer.valueOf(i), q52Var, t52Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dw1Var;
            this.a = i;
            this.b = q52Var;
            this.c = t52Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    ui3.b(this.c, this.e.i(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dw1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void z() {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (c0 = k63.c0()) != null) {
            c0.B().I(c0.getAppId());
        }
    }

    public ly1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#hideModalPage", false);
            z();
            return A(1, "hideModalPage", 10);
        }
        return (ly1) invokeV.objValue;
    }

    public final ly1 A(int i, String str, int i2) {
        InterceptResult invokeCommon;
        kw2 t3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            qz2.b(uuid);
            t52 W = xr2.V().W();
            if (W == null) {
                k32.c("NavigateBackApi", "manager is null");
                return new ly1(1001, "manager is null");
            }
            int k = W.k();
            if (k == 1) {
                k32.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new ly1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            kw2 f = yc3.f(uuid, i);
            q52 m = W.m();
            if (m == null) {
                k32.c("NavigateBackApi", "slave container is null");
                return new ly1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                k32.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new ly1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                qz2.c(i2, uuid);
                t52.b i3 = W.i(str);
                i3.n(t52.i, t52.h);
                i3.h(i);
                ek3.a0(new a(this, k, m, W, i3));
                s52 o = W.o();
                if (o == null) {
                    t3 = null;
                } else {
                    t3 = o.t3();
                }
                pz2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                qz2.a(uuid, t3);
                if (!(W.m() instanceof s52)) {
                    k32.c("NavigateBackApi", "top fragment error");
                    yc3.i(f);
                    return new ly1(1001, "top fragment error");
                }
                s52 s52Var = (s52) W.m();
                if (s52Var != null) {
                    str2 = s52Var.A3();
                } else {
                    str2 = "";
                }
                return new ly1(0, t93.c(str2));
            }
        }
        return (ly1) invokeCommon.objValue;
    }

    public ly1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#navigateBack params=" + str, false);
            z();
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            return A(((JSONObject) t.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (ly1) invokeL.objValue;
    }
}
