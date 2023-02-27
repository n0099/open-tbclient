package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.v82;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ez1 extends dz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.px1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ s82 b;
        public final /* synthetic */ v82 c;
        public final /* synthetic */ v82.b d;
        public final /* synthetic */ ez1 e;

        public a(ez1 ez1Var, int i, s82 s82Var, v82 v82Var, v82.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ez1Var, Integer.valueOf(i), s82Var, v82Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ez1Var;
            this.a = i;
            this.b = s82Var;
            this.c = v82Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.E0) {
                    wl3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez1(@NonNull nx1 nx1Var) {
        super(nx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        m93 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = m93.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public m12 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (m12) invokeV.objValue;
    }

    public m12 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (m12) invokeL.objValue;
    }

    public final m12 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        mz2 m3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            s23.b(uuid);
            v82 V = zu2.U().V();
            if (V == null) {
                m62.c("NavigateBackApi", "manager is null");
                return new m12(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                m62.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new m12(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            mz2 f = ag3.f(uuid, i);
            s82 m = V.m();
            if (m == null) {
                m62.c("NavigateBackApi", "slave container is null");
                return new m12(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.E0) {
                m62.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new m12(1001, "hideModalPage api can only work after showModalPage");
            } else {
                s23.c(i2, uuid);
                v82.b i3 = V.i(str);
                i3.n(v82.i, v82.h);
                i3.h(i);
                gn3.a0(new a(this, k, m, V, i3));
                u82 o = V.o();
                if (o == null) {
                    m3 = null;
                } else {
                    m3 = o.m3();
                }
                r23.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                s23.a(uuid, m3);
                if (!(V.m() instanceof u82)) {
                    m62.c("NavigateBackApi", "top fragment error");
                    ag3.i(f);
                    return new m12(1001, "top fragment error");
                }
                u82 u82Var = (u82) V.m();
                if (u82Var != null) {
                    str2 = u82Var.t3();
                } else {
                    str2 = "";
                }
                return new m12(0, vc3.c(str2));
            }
        }
        return (m12) invokeCommon.objValue;
    }
}
