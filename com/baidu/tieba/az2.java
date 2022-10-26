package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class az2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract mv1 b(JSONObject jSONObject);

    public abstract vy2 f(wy2 wy2Var);

    public abstract String g();

    public abstract String h();

    public abstract mv1 j(String str, wy2 wy2Var);

    public abstract boolean k();

    public abstract mv1 m(wy2 wy2Var, y42 y42Var);

    /* loaded from: classes3.dex */
    public class a implements b72.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy2 a;
        public final /* synthetic */ y42 b;
        public final /* synthetic */ az2 c;

        public a(az2 az2Var, wy2 wy2Var, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az2Var, wy2Var, y42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = az2Var;
            this.a = wy2Var;
            this.b = y42Var;
        }

        @Override // com.baidu.tieba.b72.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ez2.b("payment fun page, your pkg is latest");
            }
        }

        @Override // com.baidu.tieba.b72.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.b72.b
        public void b(ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy2 a;
        public final /* synthetic */ y42 b;
        public final /* synthetic */ az2 c;

        public b(az2 az2Var, wy2 wy2Var, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az2Var, wy2Var, y42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = az2Var;
            this.a = wy2Var;
            this.b = y42Var;
        }

        @Override // com.baidu.tieba.h62
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, true, this.b);
            }
        }

        @Override // com.baidu.tieba.h62
        public void b(int i, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ff3Var) == null) {
                this.c.d(this.a, false, this.b);
            }
        }
    }

    public az2() {
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

    public final void c(wy2 wy2Var, String str, y42 y42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wy2Var, str, y42Var) == null) {
            ez2.b("local has not main pkg, download fun page main pkg");
            oe4 oe4Var = new oe4(str, l33.K().k());
            oe4Var.q(0L);
            oe4Var.t(wy2Var.c);
            oe4Var.d("3");
            wa4.c(oe4Var, new b72(str, new a(this, wy2Var, y42Var)));
        }
    }

    public final void e(wy2 wy2Var, vy2 vy2Var, y42 y42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, wy2Var, vy2Var, y42Var) == null) {
            ez2.b("main pkg is exist, download fun page sub pkg");
            String str = vy2Var.a;
            int i = vy2Var.d;
            wa4.h(new re4(str, i, kz2.e(vy2Var.c, vy2Var.b), 0), new d72(str, String.valueOf(i), new b(this, wy2Var, y42Var)));
        }
    }

    public final void d(wy2 wy2Var, boolean z, y42 y42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{wy2Var, Boolean.valueOf(z), y42Var}) == null) {
            if (z) {
                vy2 f = f(wy2Var);
                if (f != null && f.f) {
                    ez2.b("payment fun page, download success, ready to jump");
                    j(f.c, wy2Var);
                    return;
                }
                ez2.b("payment fun page, download success, but not exist");
                xy2 xy2Var = new xy2(wy2Var.f);
                xy2Var.a = wy2Var.e;
                y42Var.a(xy2Var);
                return;
            }
            ez2.b("payment fun page, download failed");
            xy2 xy2Var2 = new xy2(wy2Var.f);
            xy2Var2.a = wy2Var.e;
            y42Var.a(xy2Var2);
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

    public final mv1 l(wy2 wy2Var, y42 y42Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, wy2Var, y42Var)) == null) {
            ez2.b("open fun page start");
            if (wy2Var != null && wy2Var.a()) {
                mv1 b2 = b(wy2Var.g);
                if (b2 != null) {
                    ez2.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    ez2.b("open payment fun page");
                    vy2 f = f(wy2Var);
                    if (f == null) {
                        return new mv1(1001, "fun page not exists");
                    }
                    if (!f.f) {
                        ez2.b("payment fun page, " + wy2Var.d + " mode");
                        if (i(wy2Var.d)) {
                            if (f.e) {
                                e(wy2Var, f, y42Var);
                            } else {
                                return new mv1(1001, "fun page not exists");
                            }
                        } else if (f.e) {
                            e(wy2Var, f, y42Var);
                        } else {
                            c(wy2Var, f.a, y42Var);
                        }
                        ez2.b("open fun page end");
                        return new mv1(0);
                    }
                    return j(f.c, wy2Var);
                } else {
                    ez2.b("open user info or choose address fun page");
                    return m(wy2Var, y42Var);
                }
            }
            ez2.b("params parse fail");
            return new mv1(202, "params parse fail");
        }
        return (mv1) invokeLL.objValue;
    }
}
