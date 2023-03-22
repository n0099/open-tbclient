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
public abstract class g33 extends h33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.h33
    public c33 f(d33 d33Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d33Var)) == null) {
            return null;
        }
        return (c33) invokeL.objValue;
    }

    @Override // com.baidu.tieba.h33
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, d33 d33Var, fd3 fd3Var, f92<e33> f92Var);

    /* loaded from: classes4.dex */
    public class a implements fo1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d33 a;
        public final /* synthetic */ f92 b;
        public final /* synthetic */ g33 c;

        public a(g33 g33Var, d33 d33Var, f92 f92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g33Var, d33Var, f92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g33Var;
            this.a = d33Var;
            this.b = f92Var;
        }

        @Override // com.baidu.tieba.fo1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                e33 e33Var = new e33(this.a.f);
                e33Var.a = this.a.e;
                this.b.a(e33Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements mm3<fd3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ d33 c;
        public final /* synthetic */ f92 d;
        public final /* synthetic */ g33 e;

        public b(g33 g33Var, t73 t73Var, SwanAppActivity swanAppActivity, d33 d33Var, f92 f92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g33Var, t73Var, swanAppActivity, d33Var, f92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g33Var;
            this.a = t73Var;
            this.b = swanAppActivity;
            this.c = d33Var;
            this.d = f92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(fd3 fd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fd3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, fd3Var, this.d);
            }
        }
    }

    public g33() {
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

    @Override // com.baidu.tieba.h33
    public tz1 j(String str, d33 d33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, d33Var)) == null) {
            return new tz1(0);
        }
        return (tz1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.h33
    public tz1 m(d33 d33Var, f92<e33> f92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, d33Var, f92Var)) == null) {
            if (d33Var != null && !TextUtils.isEmpty(d33Var.a)) {
                if (f92Var == null) {
                    return new tz1(1001, "get fun page info, cb is null");
                }
                t73 q = s73.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, d33Var, f92Var));
                        return new tz1(1001, "not login");
                    }
                    o(d33Var, f92Var);
                    return new tz1(0);
                }
                return new tz1(1001, "get fun page info, master has dead");
            }
            return new tz1(1001, "get fun page info, provider appKey is empty");
        }
        return (tz1) invokeLL.objValue;
    }

    public final void o(d33 d33Var, f92<e33> f92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, d33Var, f92Var) == null) {
            l33.b("start get open data");
            t73 q = s73.K().q();
            SwanAppActivity w = q.w();
            fd3.B(w, g(), d33Var.a, true, h(), new b(this, q, w, d33Var, f92Var));
        }
    }
}
