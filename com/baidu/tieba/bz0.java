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
public class bz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends ap0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cz0 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(cz0 cz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cz0Var;
        }

        @Override // com.baidu.tieba.yo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                az0.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.zo0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zo0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                az0.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable cz0 cz0Var) {
        e11 e11Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, cz0Var) == null) && cz0Var != null && !TextUtils.isEmpty(cz0Var.d())) {
            hp0 hp0Var = new hp0();
            hp0Var.l(cz0Var.d());
            hp0Var.g(3000);
            hp0Var.c();
            if (!TextUtils.isEmpty(cz0Var.e)) {
                hp0Var.d("User-Agent", cz0Var.e);
            } else {
                hp0Var.d("User-Agent", gf0.e());
            }
            oo0.b().a().a(hp0Var, new a(cz0Var));
            if (x01.a && (e11Var = (e11) w01.a().a(e11.class)) != null) {
                e11Var.b(new y01("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        e11 e11Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        hp0 hp0Var = new hp0();
        hp0Var.l(str);
        hp0Var.g(3000);
        hp0Var.d("User-Agent", gf0.e());
        hp0Var.c();
        oo0.b().a().a(hp0Var, null);
        if (x01.a && (e11Var = (e11) w01.a().a(e11.class)) != null) {
            e11Var.b(new y01("计费", "", "并行计费"));
        }
    }
}
