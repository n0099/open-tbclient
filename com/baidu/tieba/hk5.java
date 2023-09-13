package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.editortools.local.view.LocalInputContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hk5 extends ej5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LocalInputContainer t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk5(Context context, yj5 yj5Var) {
        super(context, (String) null, 36);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, yj5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(context, yj5Var);
        this.m = this.t;
        this.o = false;
        this.n = 3;
        this.p = new int[]{24, 3};
    }

    public final void g(Context context, yj5 yj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, yj5Var) == null) {
            LocalInputContainer localInputContainer = new LocalInputContainer(context);
            this.t = localInputContainer;
            localInputContainer.e(yj5Var);
        }
    }
}
