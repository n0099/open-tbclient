package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ir0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g11 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(g11 g11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g11Var;
        }

        @Override // com.baidu.tieba.gr0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                e11.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.hr0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                e11.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable g11 g11Var) {
        f31 f31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, g11Var) == null) && g11Var != null && !TextUtils.isEmpty(g11Var.d())) {
            if (!g11Var.c()) {
                b(g11Var.d());
                return;
            }
            pr0 pr0Var = new pr0();
            pr0Var.l(g11Var.d());
            pr0Var.g(3000);
            pr0Var.d("User-Agent", ej0.e());
            pr0Var.c();
            wq0.b().a().a(pr0Var, new a(g11Var));
            if (z21.a && (f31Var = (f31) y21.a().a(f31.class)) != null) {
                f31Var.b(new a31("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        f31 f31Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        pr0 pr0Var = new pr0();
        pr0Var.l(str);
        pr0Var.g(3000);
        pr0Var.d("User-Agent", ej0.e());
        pr0Var.c();
        wq0.b().a().a(pr0Var, null);
        if (z21.a && (f31Var = (f31) y21.a().a(f31.class)) != null) {
            f31Var.b(new a31("计费", "", "并行计费"));
        }
    }
}
