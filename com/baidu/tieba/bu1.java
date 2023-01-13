package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.s32;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bu1 extends au1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ms1
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
        public final /* synthetic */ p32 b;
        public final /* synthetic */ s32 c;
        public final /* synthetic */ s32.b d;
        public final /* synthetic */ bu1 e;

        public a(bu1 bu1Var, int i, p32 p32Var, s32 s32Var, s32.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu1Var, Integer.valueOf(i), p32Var, s32Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bu1Var;
            this.a = i;
            this.b = p32Var;
            this.c = s32Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    tg3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu1(@NonNull ks1 ks1Var) {
        super(ks1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ks1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        j43 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && (b0 = j43.b0()) != null) {
            b0.B().I(b0.getAppId());
        }
    }

    public jw1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (jw1) invokeV.objValue;
    }

    public jw1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<jw1, JSONObject> s = s(str);
            jw1 jw1Var = (jw1) s.first;
            if (!jw1Var.isSuccess()) {
                return jw1Var;
            }
            return z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (jw1) invokeL.objValue;
    }

    public final jw1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        ju2 m3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            px2.b(uuid);
            s32 V = wp2.U().V();
            if (V == null) {
                j12.c("NavigateBackApi", "manager is null");
                return new jw1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                j12.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new jw1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            ju2 f = xa3.f(uuid, i);
            p32 m = V.m();
            if (m == null) {
                j12.c("NavigateBackApi", "slave container is null");
                return new jw1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                j12.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new jw1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                px2.c(i2, uuid);
                s32.b i3 = V.i(str);
                i3.n(s32.i, s32.h);
                i3.h(i);
                di3.a0(new a(this, k, m, V, i3));
                r32 o = V.o();
                if (o == null) {
                    m3 = null;
                } else {
                    m3 = o.m3();
                }
                ox2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                px2.a(uuid, m3);
                if (!(V.m() instanceof r32)) {
                    j12.c("NavigateBackApi", "top fragment error");
                    xa3.i(f);
                    return new jw1(1001, "top fragment error");
                }
                r32 r32Var = (r32) V.m();
                if (r32Var != null) {
                    str2 = r32Var.t3();
                } else {
                    str2 = "";
                }
                return new jw1(0, s73.c(str2));
            }
        }
        return (jw1) invokeCommon.objValue;
    }
}
