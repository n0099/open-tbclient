package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t53;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a83 extends z73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a83(s53 s53Var) {
        super(s53Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s53Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s53) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.z73
    public void I(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && M() && (str2 = this.d) != null && str2.equals(str)) {
            o53 K = o53.K();
            if (!K.E()) {
                return;
            }
            if (K.q().o0()) {
                K.n("flag_finish_activity", "flag_remove_task");
                return;
            }
            ih3 ih3Var = new ih3();
            ih3Var.k(10L);
            ih3Var.i(2107L);
            ih3Var.d("app forbidden");
            v53.z0(md4.i().u(str), wo2.c(), K.q().X(), false, null, ih3Var);
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (p53.c0() != null && this.b != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ik3
    /* renamed from: N */
    public void a(t53.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (b23.J(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.b = aVar.i("ipc_forbidden_flag", 1);
                this.d = aVar.o("mAppId", o53.K().getAppId());
            }
            if (b23.J(aVar.D(), "swan_kill_to_client")) {
                o53.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
