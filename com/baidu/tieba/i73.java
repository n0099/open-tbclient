package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class i73 extends j73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.j73
    public e73 f(f73 f73Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f73Var)) == null) {
            return null;
        }
        return (e73) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j73
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, f73 f73Var, hh3 hh3Var, hd2<g73> hd2Var);

    /* loaded from: classes6.dex */
    public class a implements hs1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f73 a;
        public final /* synthetic */ hd2 b;
        public final /* synthetic */ i73 c;

        public a(i73 i73Var, f73 f73Var, hd2 hd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i73Var, f73Var, hd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i73Var;
            this.a = f73Var;
            this.b = hd2Var;
        }

        @Override // com.baidu.tieba.hs1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                g73 g73Var = new g73(this.a.f);
                g73Var.a = this.a.e;
                this.b.a(g73Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements oq3<hh3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb3 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ f73 c;
        public final /* synthetic */ hd2 d;
        public final /* synthetic */ i73 e;

        public b(i73 i73Var, vb3 vb3Var, SwanAppActivity swanAppActivity, f73 f73Var, hd2 hd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i73Var, vb3Var, swanAppActivity, f73Var, hd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i73Var;
            this.a = vb3Var;
            this.b = swanAppActivity;
            this.c = f73Var;
            this.d = hd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(hh3 hh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, hh3Var, this.d);
            }
        }
    }

    public i73() {
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

    @Override // com.baidu.tieba.j73
    public v32 j(String str, f73 f73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f73Var)) == null) {
            return new v32(0);
        }
        return (v32) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.j73
    public v32 m(f73 f73Var, hd2<g73> hd2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, f73Var, hd2Var)) == null) {
            if (f73Var != null && !TextUtils.isEmpty(f73Var.a)) {
                if (hd2Var == null) {
                    return new v32(1001, "get fun page info, cb is null");
                }
                vb3 q = ub3.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, f73Var, hd2Var));
                        return new v32(1001, "not login");
                    }
                    o(f73Var, hd2Var);
                    return new v32(0);
                }
                return new v32(1001, "get fun page info, master has dead");
            }
            return new v32(1001, "get fun page info, provider appKey is empty");
        }
        return (v32) invokeLL.objValue;
    }

    public final void o(f73 f73Var, hd2<g73> hd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, f73Var, hd2Var) == null) {
            n73.b("start get open data");
            vb3 q = ub3.K().q();
            SwanAppActivity w = q.w();
            hh3.B(w, g(), f73Var.a, true, h(), new b(this, q, w, f73Var, hd2Var));
        }
    }
}
