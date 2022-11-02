package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends dr0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b11 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(b11 b11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b11Var;
        }

        @Override // com.baidu.tieba.br0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                z01.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.cr0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cr0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                z01.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable b11 b11Var) {
        a31 a31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, b11Var) == null) && b11Var != null && !TextUtils.isEmpty(b11Var.d())) {
            if (!b11Var.c()) {
                b(b11Var.d());
                return;
            }
            kr0 kr0Var = new kr0();
            kr0Var.l(b11Var.d());
            kr0Var.g(3000);
            kr0Var.d("User-Agent", zi0.e());
            kr0Var.c();
            rq0.b().a().a(kr0Var, new a(b11Var));
            if (u21.a && (a31Var = (a31) t21.a().a(a31.class)) != null) {
                a31Var.b(new v21("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        a31 a31Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        kr0 kr0Var = new kr0();
        kr0Var.l(str);
        kr0Var.g(3000);
        kr0Var.d("User-Agent", zi0.e());
        kr0Var.c();
        rq0.b().a().a(kr0Var, null);
        if (u21.a && (a31Var = (a31) t21.a().a(a31.class)) != null) {
            a31Var.b(new v21("计费", "", "并行计费"));
        }
    }
}
