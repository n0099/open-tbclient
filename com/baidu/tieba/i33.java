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
public abstract class i33 extends j33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.j33
    public e33 f(f33 f33Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f33Var)) == null) {
            return null;
        }
        return (e33) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j33
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, f33 f33Var, hd3 hd3Var, h92<g33> h92Var);

    /* loaded from: classes4.dex */
    public class a implements ho1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f33 a;
        public final /* synthetic */ h92 b;
        public final /* synthetic */ i33 c;

        public a(i33 i33Var, f33 f33Var, h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i33Var, f33Var, h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i33Var;
            this.a = f33Var;
            this.b = h92Var;
        }

        @Override // com.baidu.tieba.ho1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.c.o(this.a, this.b);
                    return;
                }
                g33 g33Var = new g33(this.a.f);
                g33Var.a = this.a.e;
                this.b.a(g33Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements om3<hd3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v73 a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ f33 c;
        public final /* synthetic */ h92 d;
        public final /* synthetic */ i33 e;

        public b(i33 i33Var, v73 v73Var, SwanAppActivity swanAppActivity, f33 f33Var, h92 h92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i33Var, v73Var, swanAppActivity, f33Var, h92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i33Var;
            this.a = v73Var;
            this.b = swanAppActivity;
            this.c = f33Var;
            this.d = h92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(hd3 hd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hd3Var) == null) {
                this.e.p(this.b, this.a.O(), this.c, hd3Var, this.d);
            }
        }
    }

    public i33() {
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

    @Override // com.baidu.tieba.j33
    public vz1 j(String str, f33 f33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f33Var)) == null) {
            return new vz1(0);
        }
        return (vz1) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.j33
    public vz1 m(f33 f33Var, h92<g33> h92Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, f33Var, h92Var)) == null) {
            if (f33Var != null && !TextUtils.isEmpty(f33Var.a)) {
                if (h92Var == null) {
                    return new vz1(1001, "get fun page info, cb is null");
                }
                v73 q = u73.K().q();
                SwanAppActivity w = q.w();
                if (w != null && !w.isFinishing()) {
                    if (!q.N().e(q)) {
                        q.N().f(w, null, new a(this, f33Var, h92Var));
                        return new vz1(1001, "not login");
                    }
                    o(f33Var, h92Var);
                    return new vz1(0);
                }
                return new vz1(1001, "get fun page info, master has dead");
            }
            return new vz1(1001, "get fun page info, provider appKey is empty");
        }
        return (vz1) invokeLL.objValue;
    }

    public final void o(f33 f33Var, h92<g33> h92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, f33Var, h92Var) == null) {
            n33.b("start get open data");
            v73 q = u73.K().q();
            SwanAppActivity w = q.w();
            hd3.B(w, g(), f33Var.a, true, h(), new b(this, q, w, f33Var, h92Var));
        }
    }
}
