package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iq1;
import com.baidu.tieba.o53;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z, String str);
    }

    /* loaded from: classes6.dex */
    public static class a implements iq1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ b b;

        public a(Context context, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = bVar;
        }

        @Override // com.baidu.tieba.iq1.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    k32.c("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    this.b.a(false, this.a.getString(R.string.obfuscated_res_0x7f0f0144));
                    return;
                }
                k32.c("DeveloperAuthenticateHelper", "Authentication Success");
                this.b.a(true, "");
            }
        }

        @Override // com.baidu.tieba.iq1.b
        public void b(Exception exc) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                k32.d("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getString(R.string.obfuscated_res_0x7f0f0144));
                if (TextUtils.isEmpty(message)) {
                    str = "";
                } else {
                    str = "\n" + message;
                }
                sb.append(str);
                this.b.a(false, sb.toString());
            }
        }
    }

    public static void a(@NonNull k63 k63Var, @NonNull Context context, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, k63Var, context, bVar) == null) {
            ym1.b(k63Var.P(), new a(context, bVar));
        }
    }

    public static void b(Context context, @StringRes int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i, str) == null) {
            o53.a aVar = new o53.a(context);
            aVar.U(i);
            aVar.x(str);
            aVar.n(new sl3());
            aVar.O(R.string.obfuscated_res_0x7f0f0151, null);
            aVar.X();
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            b(context, R.string.obfuscated_res_0x7f0f018a, str);
        }
    }
}
