package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gs3 implements fs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hs3 a;
    public boolean b;

    public gs3(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        c(context);
    }

    @Override // com.baidu.tieba.fs3
    public void a() {
        hs3 hs3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b && (hs3Var = this.a) != null && hs3Var.b()) {
            this.b = false;
            this.a.c(6, "", new int[0]);
            this.a.c(3, "", new int[0]);
            this.a.c(12, "", new int[0]);
            this.a.c(9, "", new int[0]);
        }
    }

    @Override // com.baidu.tieba.fs3
    public void b(int i) {
        hs3 hs3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && !this.b && (hs3Var = this.a) != null && hs3Var.b() && this.a.c(12, "", new int[0]) == 0) {
            this.b = true;
            this.a.c(5, "", new int[0]);
            this.a.c(2, "", new int[0]);
            this.a.c(11, "", new int[0]);
            this.a.c(8, "", new int[0]);
            this.a.c(39, "", new int[0]);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.a == null) {
            this.a = hs3.a(context);
        }
    }
}
