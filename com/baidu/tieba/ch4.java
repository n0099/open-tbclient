package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ch4 extends qf4<ih4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public fe4 d;
    @Nullable
    public fe4 e;

    @Override // com.baidu.tieba.qf4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: u */
    public boolean e(ih4 ih4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ih4Var)) == null) ? ih4Var != null : invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch4(fe4 fe4Var, qh4 qh4Var, @Nullable fe4 fe4Var2, @Nullable fe4 fe4Var3) {
        super(fe4Var, qh4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fe4Var, qh4Var, fe4Var2, fe4Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((fe4) objArr2[0], (qh4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = fe4Var2;
        this.e = fe4Var3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: w */
    public ih4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return rj4.q(jSONObject);
        }
        return (ih4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: v */
    public ef4 s(ih4 ih4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ih4Var)) == null) {
            this.a.E();
            lj4.e(this.b.a(), ih4Var.a);
            fe4 fe4Var = this.a;
            if (fe4Var == this.d || fe4Var == this.e) {
                fe4Var = null;
            }
            xh4.c(ih4Var.b, fe4Var, this.d, this.e);
            return null;
        }
        return (ef4) invokeL.objValue;
    }
}
