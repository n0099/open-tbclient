package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class az2 extends yy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements bk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy2 a;
        public final /* synthetic */ x42 b;

        public a(az2 az2Var, wy2 wy2Var, x42 x42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az2Var, wy2Var, x42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy2Var;
            this.b = x42Var;
        }

        @Override // com.baidu.tieba.bk1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                dz2.b("obtain address failure, errCode = " + i);
                this.b.a(this.a);
            }
        }

        @Override // com.baidu.tieba.bk1
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                dz2.b("obtain address success");
                wy2 wy2Var = this.a;
                wy2Var.d = true;
                if (jSONObject != null) {
                    wy2Var.e = jSONObject.toString();
                }
                this.b.a(this.a);
            }
        }
    }

    public az2() {
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

    @Override // com.baidu.tieba.zy2
    public lv1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "mapp_choose_address" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginAddressFunPage" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yy2
    public void p(SwanAppActivity swanAppActivity, String str, vy2 vy2Var, x83 x83Var, x42<wy2> x42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, vy2Var, x83Var, x42Var) == null) {
            wy2 wy2Var = new wy2(vy2Var.f);
            wy2Var.a = vy2Var.e;
            if (x83Var != null && x83Var.j.a() != 10003) {
                dz2.b("obtain address detail");
                sm2.j0().a(swanAppActivity, str, str, new a(this, wy2Var, x42Var));
                return;
            }
            dz2.b("user denied");
            x42Var.a(wy2Var);
        }
    }
}
