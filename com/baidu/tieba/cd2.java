package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zc2 a;

    /* loaded from: classes5.dex */
    public class a implements zi2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zi2 a;

        public a(cd2 cd2Var, zi2 zi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd2Var, zi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zi2Var;
        }

        @Override // com.baidu.tieba.zi2
        public void a(pi2 pi2Var) {
            zi2 zi2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pi2Var) == null) && (zi2Var = this.a) != null) {
                zi2Var.a(pi2Var);
            }
        }
    }

    public cd2() {
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
        this.a = new zc2(o82.d().getPath(), o82.b);
    }

    public pi2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zc2 zc2Var = this.a;
            if (zc2Var != null) {
                return zc2Var.d();
            }
            return null;
        }
        return (pi2) invokeV.objValue;
    }

    public void b() {
        zc2 zc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (zc2Var = this.a) != null) {
            zc2Var.e();
            this.a = null;
        }
    }

    public void c(zi2 zi2Var) {
        zc2 zc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zi2Var) == null) && (zc2Var = this.a) != null) {
            zc2Var.f(new a(this, zi2Var));
        }
    }
}
