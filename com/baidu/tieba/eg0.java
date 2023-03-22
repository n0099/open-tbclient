package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.dg0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes4.dex */
public class eg0 extends rh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.rh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "dlink" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements dg0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh0 a;
        public final /* synthetic */ vh0 b;
        public final /* synthetic */ eg0 c;

        public a(eg0 eg0Var, zh0 zh0Var, vh0 vh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg0Var, zh0Var, vh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eg0Var;
            this.a = zh0Var;
            this.b = vh0Var;
        }

        @Override // com.baidu.tieba.dg0.c
        public void onResult(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                eg0 eg0Var = this.c;
                zh0 zh0Var = this.a;
                vh0 vh0Var = this.b;
                if (z) {
                    i = 0;
                } else {
                    i = 1001;
                }
                eg0Var.c(zh0Var, vh0Var, i, z);
            }
        }
    }

    public eg0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.rh0
    public boolean b(@NonNull Context context, @NonNull vh0 vh0Var, @Nullable Map<String, Object> map, @Nullable zh0 zh0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vh0Var, map, zh0Var)) == null) {
            super.b(context, vh0Var, map, zh0Var);
            new dg0().g(context, vh0Var.d(), new a(this, zh0Var, vh0Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
