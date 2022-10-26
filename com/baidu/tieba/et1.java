package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.v22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class et1 extends dt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ s22 b;
        public final /* synthetic */ v22 c;
        public final /* synthetic */ v22.b d;
        public final /* synthetic */ et1 e;

        public a(et1 et1Var, int i, s22 s22Var, v22 v22Var, v22.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et1Var, Integer.valueOf(i), s22Var, v22Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = et1Var;
            this.a = i;
            this.b = s22Var;
            this.c = v22Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    wf3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et1(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        m33 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = m33.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public mv1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (mv1) invokeV.objValue;
    }

    public mv1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                return mv1Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (mv1) invokeL.objValue;
    }

    public final mv1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        mt2 m3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            sw2.b(uuid);
            v22 V = zo2.U().V();
            if (V == null) {
                m02.c("NavigateBackApi", "manager is null");
                return new mv1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                m02.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new mv1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            mt2 f = aa3.f(uuid, i);
            s22 m = V.m();
            if (m == null) {
                m02.c("NavigateBackApi", "slave container is null");
                return new mv1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                m02.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new mv1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                sw2.c(i2, uuid);
                v22.b i3 = V.i(str);
                i3.n(v22.i, v22.h);
                i3.h(i);
                gh3.a0(new a(this, k, m, V, i3));
                u22 o = V.o();
                if (o == null) {
                    m3 = null;
                } else {
                    m3 = o.m3();
                }
                rw2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                sw2.a(uuid, m3);
                if (!(V.m() instanceof u22)) {
                    m02.c("NavigateBackApi", "top fragment error");
                    aa3.i(f);
                    return new mv1(1001, "top fragment error");
                }
                u22 u22Var = (u22) V.m();
                if (u22Var != null) {
                    str2 = u22Var.t3();
                } else {
                    str2 = "";
                }
                return new mv1(0, v63.c(str2));
            }
        }
        return (mv1) invokeCommon.objValue;
    }
}
