package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class h33 extends i33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.i33
    public d33 f(e33 e33Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e33Var)) == null) {
            return null;
        }
        return (d33) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i33
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, e33 e33Var, gd3 gd3Var, g92<f33> g92Var);

    /* loaded from: classes4.dex */
    public class a implements go1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e33 a;
        public final /* synthetic */ g92 b;
        public final /* synthetic */ h33 c;

        public a(h33 h33Var, e33 e33Var, g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h33Var, e33Var, g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h33Var;
            this.a = e33Var;
            this.b = g92Var;
        }

        @Override // com.baidu.tieba.go1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                f33 f33Var = new f33(this.a.f);
                f33Var.a = this.a.e;
                this.b.a(f33Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements nm3<gd3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u73 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ e33 c;
        public final /* synthetic */ g92 d;
        public final /* synthetic */ h33 e;

        public b(h33 h33Var, u73 u73Var, SwanAppActivity swanAppActivity, e33 e33Var, g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h33Var, u73Var, swanAppActivity, e33Var, g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h33Var;
            this.a = u73Var;
            this.b = swanAppActivity;
            this.c = e33Var;
            this.d = g92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(gd3 gd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gd3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, gd3Var, this.d);
            }
        }
    }

    public h33() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.i33
    public uz1 j(String str, e33 e33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, e33Var)) == null) {
            return new uz1(0);
        }
        return (uz1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.i33
    public uz1 m(e33 e33Var, g92<f33> g92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, e33Var, g92Var)) == null) {
            if (e33Var != null && !TextUtils.isEmpty(e33Var.a)) {
                if (g92Var == null) {
                    return new uz1(1001, "get fun page info, cb is null");
                }
                u73 q = t73.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, e33Var, g92Var));
                        return new uz1(1001, "not login");
                    }
                    o(e33Var, g92Var);
                    return new uz1(0);
                }
                return new uz1(1001, "get fun page info, master has dead");
            }
            return new uz1(1001, "get fun page info, provider appKey is empty");
        }
        return (uz1) invokeLL.objValue;
    }

    public final void o(e33 e33Var, g92<f33> g92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, e33Var, g92Var) == null) {
            m33.b("start get open data");
            u73 q = t73.K().q();
            SwanAppActivity w = q.w();
            gd3.B(w, g(), e33Var.a, true, h(), new b(this, q, w, e33Var, g92Var));
        }
    }
}
