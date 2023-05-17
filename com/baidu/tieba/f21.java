package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends cs0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g21 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(g21 g21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g21Var;
        }

        @Override // com.baidu.tieba.as0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                e21.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.bs0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bs0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                e21.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable g21 g21Var) {
        f41 f41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, g21Var) == null) && g21Var != null && !TextUtils.isEmpty(g21Var.d())) {
            js0 js0Var = new js0();
            js0Var.l(g21Var.d());
            js0Var.g(3000);
            js0Var.c();
            if (!TextUtils.isEmpty(g21Var.e)) {
                js0Var.d("User-Agent", g21Var.e);
            } else {
                js0Var.d("User-Agent", bj0.e());
            }
            qr0.b().a().a(js0Var, new a(g21Var));
            if (z31.a && (f41Var = (f41) y31.a().a(f41.class)) != null) {
                f41Var.b(new a41("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        f41 f41Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        js0 js0Var = new js0();
        js0Var.l(str);
        js0Var.g(3000);
        js0Var.d("User-Agent", bj0.e());
        js0Var.c();
        qr0.b().a().a(js0Var, null);
        if (z31.a && (f41Var = (f41) y31.a().a(f41.class)) != null) {
            f41Var.b(new a41("计费", "", "并行计费"));
        }
    }
}
