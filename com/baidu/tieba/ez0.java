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
public class ez0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends dp0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz0 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(fz0 fz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz0Var;
        }

        @Override // com.baidu.tieba.bp0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                dz0.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.cp0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cp0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                dz0.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable fz0 fz0Var) {
        h11 h11Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, fz0Var) == null) && fz0Var != null && !TextUtils.isEmpty(fz0Var.d())) {
            kp0 kp0Var = new kp0();
            kp0Var.l(fz0Var.d());
            kp0Var.g(3000);
            kp0Var.c();
            if (!TextUtils.isEmpty(fz0Var.e)) {
                kp0Var.d("User-Agent", fz0Var.e);
            } else {
                kp0Var.d("User-Agent", hf0.e());
            }
            ro0.b().a().a(kp0Var, new a(fz0Var));
            if (a11.a && (h11Var = (h11) z01.a().a(h11.class)) != null) {
                h11Var.b(new b11("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        h11 h11Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        kp0 kp0Var = new kp0();
        kp0Var.l(str);
        kp0Var.g(3000);
        kp0Var.d("User-Agent", hf0.e());
        kp0Var.c();
        ro0.b().a().a(kp0Var, null);
        if (a11.a && (h11Var = (h11) z01.a().a(h11.class)) != null) {
            h11Var.b(new b11("计费", "", "并行计费"));
        }
    }
}
