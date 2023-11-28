package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.q52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class aw1 extends zv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lu1
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
        public final /* synthetic */ n52 b;
        public final /* synthetic */ q52 c;
        public final /* synthetic */ q52.b d;
        public final /* synthetic */ aw1 e;

        public a(aw1 aw1Var, int i, n52 n52Var, q52 q52Var, q52.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw1Var, Integer.valueOf(i), n52Var, q52Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = aw1Var;
            this.a = i;
            this.b = n52Var;
            this.c = q52Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    ri3.b(this.c, this.e.i(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw1(@NonNull ju1 ju1Var) {
        super(ju1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ju1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void z() {
        h63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (c0 = h63.c0()) != null) {
            c0.B().I(c0.getAppId());
        }
    }

    public iy1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r("#hideModalPage", false);
            z();
            return A(1, "hideModalPage", 10);
        }
        return (iy1) invokeV.objValue;
    }

    public final iy1 A(int i, String str, int i2) {
        InterceptResult invokeCommon;
        hw2 t3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            nz2.b(uuid);
            q52 W = ur2.V().W();
            if (W == null) {
                h32.c("NavigateBackApi", "manager is null");
                return new iy1(1001, "manager is null");
            }
            int k = W.k();
            if (k == 1) {
                h32.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new iy1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            hw2 f = vc3.f(uuid, i);
            n52 m = W.m();
            if (m == null) {
                h32.c("NavigateBackApi", "slave container is null");
                return new iy1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                h32.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new iy1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                nz2.c(i2, uuid);
                q52.b i3 = W.i(str);
                i3.n(q52.i, q52.h);
                i3.h(i);
                bk3.a0(new a(this, k, m, W, i3));
                p52 o = W.o();
                if (o == null) {
                    t3 = null;
                } else {
                    t3 = o.t3();
                }
                mz2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                nz2.a(uuid, t3);
                if (!(W.m() instanceof p52)) {
                    h32.c("NavigateBackApi", "top fragment error");
                    vc3.i(f);
                    return new iy1(1001, "top fragment error");
                }
                p52 p52Var = (p52) W.m();
                if (p52Var != null) {
                    str2 = p52Var.A3();
                } else {
                    str2 = "";
                }
                return new iy1(0, q93.c(str2));
            }
        }
        return (iy1) invokeCommon.objValue;
    }

    public iy1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#navigateBack params=" + str, false);
            z();
            Pair<iy1, JSONObject> t = t(str);
            iy1 iy1Var = (iy1) t.first;
            if (!iy1Var.isSuccess()) {
                return iy1Var;
            }
            return A(((JSONObject) t.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (iy1) invokeL.objValue;
    }
}
