package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b73 extends ze2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hd2<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final mj4<wk4> g;

    /* loaded from: classes5.dex */
    public class a extends af2<b73> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b73 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b73 b73Var, b73 b73Var2) {
            super(b73Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b73Var, b73Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ze2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b73Var;
        }

        @Override // com.baidu.tieba.af2
        public void r(@NonNull wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wk4Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.baidu.tieba.af2
        public void u(wk4 wk4Var, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wk4Var, on3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public b73(String str, String str2, long j, hd2<Boolean> hd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), hd2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, this);
        this.c = hd2Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.baidu.tieba.qj4
    public void G(dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dp4Var) == null) {
            super.G(dp4Var);
        }
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        wk4 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pk4Var) == null) {
            super.C(pk4Var);
            if (pk4Var != null) {
                if (pk4Var.a == 1010 && (p = c73.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    sj4.i().x(p);
                }
                n73.b("fetch plugin error: " + pk4Var.toString());
            } else {
                n73.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.qj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            n73.b("fetch plugin success");
        }
    }

    @Override // com.baidu.tieba.qj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            n73.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.qj4
    public mj4<wk4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (mj4) invokeV.objValue;
    }
}
