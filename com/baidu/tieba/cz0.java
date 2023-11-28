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
public class cz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends bp0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dz0 a;

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }

        public a(dz0 dz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dz0Var;
        }

        @Override // com.baidu.tieba.zo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.c()) {
                bz0.e(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.baidu.tieba.ap0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ap0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) && this.a.c()) {
                bz0.e(this.a.a(i, "success"));
            }
        }
    }

    public static void a(@Nullable dz0 dz0Var) {
        f11 f11Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, dz0Var) == null) && dz0Var != null && !TextUtils.isEmpty(dz0Var.d())) {
            ip0 ip0Var = new ip0();
            ip0Var.l(dz0Var.d());
            ip0Var.g(3000);
            ip0Var.c();
            if (!TextUtils.isEmpty(dz0Var.e)) {
                ip0Var.d("User-Agent", dz0Var.e);
            } else {
                ip0Var.d("User-Agent", hf0.e());
            }
            po0.b().a().a(ip0Var, new a(dz0Var));
            if (y01.a && (f11Var = (f11) x01.a().a(f11.class)) != null) {
                f11Var.b(new z01("计费", "", "并行计费"));
            }
        }
    }

    public static void b(@Nullable String str) {
        f11 f11Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ip0 ip0Var = new ip0();
        ip0Var.l(str);
        ip0Var.g(3000);
        ip0Var.d("User-Agent", hf0.e());
        ip0Var.c();
        po0.b().a().a(ip0Var, null);
        if (y01.a && (f11Var = (f11) x01.a().a(f11.class)) != null) {
            f11Var.b(new z01("计费", "", "并行计费"));
        }
    }
}
