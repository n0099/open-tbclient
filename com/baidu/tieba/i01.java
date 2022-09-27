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
public class i01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends lq0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j01 a;

        public a(j01 j01Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j01Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j01Var;
        }

        @Override // com.baidu.tieba.jq0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                h01.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.kq0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kq0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                h01.b(this.a.a(i, "success"));
            }
        }

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    public static void a(@Nullable j01 j01Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, j01Var) == null) || j01Var == null || TextUtils.isEmpty(j01Var.d())) {
            return;
        }
        if (!j01Var.c()) {
            b(j01Var.d());
            return;
        }
        sq0 sq0Var = new sq0();
        sq0Var.k(j01Var.d());
        sq0Var.g(3000);
        sq0Var.d("User-Agent", zi0.e());
        sq0Var.c();
        zp0.b().a().a(sq0Var, new a(j01Var));
    }

    public static void b(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        sq0 sq0Var = new sq0();
        sq0Var.k(str);
        sq0Var.g(3000);
        sq0Var.d("User-Agent", zi0.e());
        sq0Var.c();
        zp0.b().a().a(sq0Var, null);
    }
}
