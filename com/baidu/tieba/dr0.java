package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ir0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class dr0 implements ir0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tu0 a;

    /* loaded from: classes3.dex */
    public class a implements tu0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dr0 dr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tu0
        @NonNull
        public uu0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new cu0() : (uu0) invokeV.objValue;
        }
    }

    public dr0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
    }

    @Override // com.baidu.tieba.ir0.a
    public ir0 a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i)) == null) ? new kr0(new ex0(this.a, context)) : (ir0) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.ir0.a
    public ir0 b(Context context, int i, @Nullable jr0 jr0Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i, jr0Var)) == null) {
            if (jr0Var == null) {
                jr0Var = jr0.b;
            }
            int i2 = jr0Var.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return new kr0(new yq0(this.a, context));
                    }
                    return new kr0(new xq0(this.a, context));
                }
                return new kr0(new wq0(this.a, context));
            }
            return new kr0(new yq0(this.a, context));
        }
        return (ir0) invokeLIL.objValue;
    }
}
