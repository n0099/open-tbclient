package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dw3 implements sv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;
    public ew3 b;
    public boolean c;

    public dw3(@NonNull Context context) {
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
        c(context);
    }

    @Override // com.baidu.tieba.sv3
    public void b(int i) {
        ew3 ew3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && !this.c && (ew3Var = this.b) != null && ew3Var.c()) {
            this.c = true;
            this.b.e(i, this.a);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && this.b == null) {
            this.b = ew3.b(context);
            d();
        }
    }

    @Override // com.baidu.tieba.sv3
    public void a() {
        ew3 ew3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c && (ew3Var = this.b) != null && ew3Var.c()) {
            this.c = false;
            this.b.f();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.a != null) {
            return;
        }
        yv3 f = fw3.f();
        if (f.a <= 4) {
            this.a = new int[]{1082130432, 4095, 1082146816, 4095, 1098907648, 4095, 1098956800, 0, 1077936128, 1};
        } else if (f.h && f.d()) {
            this.a = new int[]{1082130688, 4095, 1082147072, 4095, 1082130432, 4095, 1082146816, 4095, 1082130944, 4095, 1082147328, 4095, 1098907648, 4095, 1115734016, 4095, 1115750400, 4095, 1115766784, 4095, 1098956800, 0, 1077936128, 1};
        } else {
            this.a = new int[]{1082130688, 4095, 1082147072, 4095, 1082130432, 4095, 1082146816, 4095, 1098907648, 4095, 1098956800, 0, 1077936128, 1};
        }
    }
}
