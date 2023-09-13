package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ku0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fu0 implements ku0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vx0 a;

    /* loaded from: classes5.dex */
    public class a implements vx0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(fu0 fu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vx0
        @NonNull
        public wx0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new ex0();
            }
            return (wx0) invokeV.objValue;
        }
    }

    public fu0() {
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

    @Override // com.baidu.tieba.ku0.a
    public ku0 a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i)) == null) {
            return new mu0(new g01(this.a, context));
        }
        return (ku0) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.ku0.a
    public ku0 b(Context context, int i, @Nullable lu0 lu0Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i, lu0Var)) == null) {
            if (lu0Var == null) {
                lu0Var = lu0.b;
            }
            int i2 = lu0Var.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return new mu0(new au0(this.a, context));
                    }
                    return new mu0(new zt0(this.a, context));
                }
                return new mu0(new yt0(this.a, context));
            }
            return new mu0(new au0(this.a, context));
        }
        return (ku0) invokeLIL.objValue;
    }
}
