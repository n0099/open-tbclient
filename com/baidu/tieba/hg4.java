package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hg4 extends ve4<ng4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public kd4 d;
    @Nullable
    public kd4 e;

    @Override // com.baidu.tieba.ve4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ve4
    /* renamed from: u */
    public boolean e(ng4 ng4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ng4Var)) == null) ? ng4Var != null : invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hg4(kd4 kd4Var, vg4 vg4Var, @Nullable kd4 kd4Var2, @Nullable kd4 kd4Var3) {
        super(kd4Var, vg4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kd4Var, vg4Var, kd4Var2, kd4Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((kd4) objArr2[0], (vg4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = kd4Var2;
        this.e = kd4Var3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ve4
    /* renamed from: w */
    public ng4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return wi4.q(jSONObject);
        }
        return (ng4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ve4
    /* renamed from: v */
    public je4 s(ng4 ng4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ng4Var)) == null) {
            this.a.E();
            qi4.e(this.b.a(), ng4Var.a);
            kd4 kd4Var = this.a;
            if (kd4Var == this.d || kd4Var == this.e) {
                kd4Var = null;
            }
            ch4.c(ng4Var.b, kd4Var, this.d, this.e);
            return null;
        }
        return (je4) invokeL.objValue;
    }
}
