package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e92;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class d13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract qx1 b(JSONObject jSONObject);

    public abstract y03 f(z03 z03Var);

    public abstract String g();

    public abstract String h();

    public abstract qx1 j(String str, z03 z03Var);

    public abstract boolean k();

    public abstract qx1 m(z03 z03Var, b72<a13> b72Var);

    /* loaded from: classes5.dex */
    public class a implements e92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z03 a;
        public final /* synthetic */ b72 b;
        public final /* synthetic */ d13 c;

        public a(d13 d13Var, z03 z03Var, b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d13Var, z03Var, b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d13Var;
            this.a = z03Var;
            this.b = b72Var;
        }

        @Override // com.baidu.tieba.e92.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h13.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.e92.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.e92.b
        public void b(ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ih3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements k82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z03 a;
        public final /* synthetic */ b72 b;
        public final /* synthetic */ d13 c;

        public b(d13 d13Var, z03 z03Var, b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d13Var, z03Var, b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d13Var;
            this.a = z03Var;
            this.b = b72Var;
        }

        @Override // com.baidu.tieba.k82
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.k82
        public void b(int i, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public d13() {
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

    public final void c(z03 z03Var, String str, b72<a13> b72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z03Var, str, b72Var) == null) {
            h13.b("local has not main pkg, download fun page main pkg");
            rg4 rg4Var = new rg4(str, o53.K().k());
            rg4Var.q(0L);
            rg4Var.t(z03Var.c);
            rg4Var.d("3");
            zc4.c(rg4Var, new e92(str, new a(this, z03Var, b72Var)));
        }
    }

    public final void e(z03 z03Var, y03 y03Var, b72<a13> b72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, z03Var, y03Var, b72Var) == null) {
            h13.b("main pkg is exist, download fun page sub pkg");
            String str = y03Var.a;
            int i = y03Var.d;
            zc4.h(new ug4(str, i, n13.e(y03Var.c, y03Var.b), 0), new g92(str, String.valueOf(i), new b(this, z03Var, b72Var)));
        }
    }

    public final void d(z03 z03Var, boolean z, b72<a13> b72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{z03Var, Boolean.valueOf(z), b72Var}) == null) {
            if (z) {
                y03 f = f(z03Var);
                if (f != null && f.f) {
                    h13.b("payment fun page, download success, ready to jump");
                    j(f.c, z03Var);
                    return;
                }
                h13.b("payment fun page, download success, but not exist");
                a13 a13Var = new a13(z03Var.f);
                a13Var.a = z03Var.e;
                b72Var.a(a13Var);
                return;
            }
            h13.b("payment fun page, download failed");
            a13 a13Var2 = new a13(z03Var.f);
            a13Var2.a = z03Var.e;
            b72Var.a(a13Var2);
        }
    }

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP);
        }
        return invokeL.booleanValue;
    }

    public final qx1 l(z03 z03Var, b72<a13> b72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, z03Var, b72Var)) == null) {
            h13.b("open fun page start");
            if (z03Var != null && z03Var.a()) {
                qx1 b2 = b(z03Var.g);
                if (b2 != null) {
                    h13.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    h13.b("open payment fun page");
                    y03 f = f(z03Var);
                    if (f == null) {
                        return new qx1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        h13.b("payment fun page, " + z03Var.d + " mode");
                        if (i(z03Var.d)) {
                            if (f.e) {
                                e(z03Var, f, b72Var);
                            } else {
                                return new qx1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(z03Var, f, b72Var);
                        } else {
                            c(z03Var, f.a, b72Var);
                        }
                        h13.b("open fun page end");
                        return new qx1(0);
                    }
                    return j(f.c, z03Var);
                } else {
                    h13.b("open user info or choose address fun page");
                    return m(z03Var, b72Var);
                }
            }
            h13.b("params parse fail");
            return new qx1(202, "params parse fail");
        }
        return (qx1) invokeLL.objValue;
    }
}
