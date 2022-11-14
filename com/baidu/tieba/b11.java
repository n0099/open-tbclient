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
public class b11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends er0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c11 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(c11 c11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c11Var;
        }

        @Override // com.baidu.tieba.cr0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                a11.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.dr0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dr0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                a11.b(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable c11 c11Var) {
        b31 b31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, c11Var) == null) && c11Var != null && !TextUtils.isEmpty(c11Var.d())) {
            if (!c11Var.c()) {
                b(c11Var.d());
                return;
            }
            lr0 lr0Var = new lr0();
            lr0Var.l(c11Var.d());
            lr0Var.g(3000);
            lr0Var.d("User-Agent", aj0.e());
            lr0Var.c();
            sq0.b().a().a(lr0Var, new a(c11Var));
            if (v21.a && (b31Var = (b31) u21.a().a(b31.class)) != null) {
                b31Var.b(new w21("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        b31 b31Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        lr0 lr0Var = new lr0();
        lr0Var.l(str);
        lr0Var.g(3000);
        lr0Var.d("User-Agent", aj0.e());
        lr0Var.c();
        sq0.b().a().a(lr0Var, null);
        if (v21.a && (b31Var = (b31) u21.a().a(b31.class)) != null) {
            b31Var.b(new w21("计费", "", "并行计费"));
        }
    }
}
