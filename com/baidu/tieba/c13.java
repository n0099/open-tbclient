package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class c13 extends d13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.d13
    public y03 f(z03 z03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, z03Var)) == null) {
            return null;
        }
        return (y03) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d13
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, z03 z03Var, bb3 bb3Var, b72<a13> b72Var);

    /* loaded from: classes5.dex */
    public class a implements cm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z03 a;
        public final /* synthetic */ b72 b;
        public final /* synthetic */ c13 c;

        public a(c13 c13Var, z03 z03Var, b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c13Var, z03Var, b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c13Var;
            this.a = z03Var;
            this.b = b72Var;
        }

        @Override // com.baidu.tieba.cm1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                a13 a13Var = new a13(this.a.f);
                a13Var.a = this.a.e;
                this.b.a(a13Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ik3<bb3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p53 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ z03 c;
        public final /* synthetic */ b72 d;
        public final /* synthetic */ c13 e;

        public b(c13 c13Var, p53 p53Var, SwanAppActivity swanAppActivity, z03 z03Var, b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c13Var, p53Var, swanAppActivity, z03Var, b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c13Var;
            this.a = p53Var;
            this.b = swanAppActivity;
            this.c = z03Var;
            this.d = b72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(bb3 bb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bb3Var) == null) {
                this.e.p(this.b, this.a.P(), this.c, bb3Var, this.d);
            }
        }
    }

    public c13() {
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

    @Override // com.baidu.tieba.d13
    public qx1 j(String str, z03 z03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z03Var)) == null) {
            return new qx1(0);
        }
        return (qx1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d13
    public qx1 m(z03 z03Var, b72<a13> b72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, z03Var, b72Var)) == null) {
            if (z03Var != null && !TextUtils.isEmpty(z03Var.a)) {
                if (b72Var == null) {
                    return new qx1(1001, "get fun page info, cb is null");
                }
                p53 q = o53.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, z03Var, b72Var));
                        return new qx1(1001, "not login");
                    }
                    o(z03Var, b72Var);
                    return new qx1(0);
                }
                return new qx1(1001, "get fun page info, master has dead");
            }
            return new qx1(1001, "get fun page info, provider appKey is empty");
        }
        return (qx1) invokeLL.objValue;
    }

    public final void o(z03 z03Var, b72<a13> b72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, z03Var, b72Var) == null) {
            h13.b("start get open data");
            p53 q = o53.K().q();
            SwanAppActivity w = q.w();
            bb3.B(w, g(), z03Var.a, true, h(), new b(this, q, w, z03Var, b72Var));
        }
    }
}
