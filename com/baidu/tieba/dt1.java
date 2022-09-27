package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.u22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dt1 extends ct1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ r22 b;
        public final /* synthetic */ u22 c;
        public final /* synthetic */ u22.b d;
        public final /* synthetic */ dt1 e;

        public a(dt1 dt1Var, int i, r22 r22Var, u22 u22Var, u22.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt1Var, Integer.valueOf(i), r22Var, u22Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dt1Var;
            this.a = i;
            this.b = r22Var;
            this.c = u22Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    vf3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        l33 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (b0 = l33.b0()) == null) {
            return;
        }
        b0.B().I(b0.getAppId());
    }

    public lv1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (lv1) invokeV.objValue;
    }

    public lv1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            return !lv1Var.isSuccess() ? lv1Var : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final lv1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            rw2.b(uuid);
            u22 V = yo2.U().V();
            if (V == null) {
                l02.c("NavigateBackApi", "manager is null");
                return new lv1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                l02.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new lv1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            lt2 f = z93.f(uuid, i);
            r22 m = V.m();
            if (m == null) {
                l02.c("NavigateBackApi", "slave container is null");
                return new lv1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                l02.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new lv1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                rw2.c(i2, uuid);
                u22.b i3 = V.i(str);
                i3.n(u22.i, u22.h);
                i3.h(i);
                fh3.a0(new a(this, k, m, V, i3));
                t22 o = V.o();
                lt2 m3 = o == null ? null : o.m3();
                qw2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                rw2.a(uuid, m3);
                if (!(V.m() instanceof t22)) {
                    l02.c("NavigateBackApi", "top fragment error");
                    z93.i(f);
                    return new lv1(1001, "top fragment error");
                }
                t22 t22Var = (t22) V.m();
                return new lv1(0, u63.c(t22Var != null ? t22Var.t3() : ""));
            }
        }
        return (lv1) invokeCommon.objValue;
    }
}
