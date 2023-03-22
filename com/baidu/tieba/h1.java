package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h1 extends y0<h5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public String c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x0
    /* renamed from: f */
    public k6<s0> a(String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, t2Var, aVar)) == null) {
            return null;
        }
        return (k6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: g */
    public void c(w0 w0Var, String str, t2 t2Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, w0Var, str, t2Var, aVar) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends u0<h5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public String c;
        public boolean d;
        public String e;
        public String f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(b1 b1Var) {
        super(b1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ".vert";
        this.c = ".frag";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: h */
    public h5 d(w0 w0Var, String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        t2 b;
        String o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, w0Var, str, t2Var, aVar)) == null) {
            String str3 = null;
            if (aVar != null) {
                String str4 = aVar.b;
                if (str4 == null) {
                    str4 = null;
                }
                str2 = aVar.c;
                if (str2 == null) {
                    str2 = null;
                }
                str3 = str4;
            } else {
                str2 = null;
            }
            if (str3 == null && str.endsWith(this.c)) {
                str3 = str.substring(0, str.length() - this.c.length()) + this.b;
            }
            if (str2 == null && str.endsWith(this.b)) {
                str2 = str.substring(0, str.length() - this.b.length()) + this.c;
            }
            if (str3 == null) {
                b = t2Var;
            } else {
                b = b(str3);
            }
            if (str2 != null) {
                t2Var = b(str2);
            }
            String o2 = b.o();
            if (b.equals(t2Var)) {
                o = o2;
            } else {
                o = t2Var.o();
            }
            if (aVar != null) {
                if (aVar.e != null) {
                    o2 = aVar.e + o2;
                }
                if (aVar.f != null) {
                    o = aVar.f + o;
                }
            }
            h5 h5Var = new h5(o2, o);
            if ((aVar == null || aVar.d) && !h5Var.o()) {
                w0Var.p().b("ShaderProgram " + str + " failed to compile:\n" + h5Var.l());
            }
            return h5Var;
        }
        return (h5) invokeLLLL.objValue;
    }
}
