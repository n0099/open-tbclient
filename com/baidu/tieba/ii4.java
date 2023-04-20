package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ii4 extends bh4<oi4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bh4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii4(qf4 qf4Var, bj4 bj4Var) {
        super(qf4Var, bj4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qf4Var, bj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qf4) objArr2[0], (bj4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh4
    /* renamed from: v */
    public pg4 e(String str, oi4 oi4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, oi4Var)) == null) {
            if (oi4Var != null && (i = oi4Var.a) != 0) {
                return new pg4(i, oi4Var.b);
            }
            return super.e(str, oi4Var);
        }
        return (pg4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh4
    /* renamed from: y */
    public oi4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return cl4.e(jSONObject);
        }
        return (oi4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.bh4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(oi4 oi4Var) {
        InterceptResult invokeL;
        List<wg4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, oi4Var)) == null) {
            if (oi4Var == null || (list = oi4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (wg4 wg4Var : oi4Var.c) {
                if (wg4Var == null || !wg4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            bj4 bj4Var = this.b;
            if ((bj4Var instanceof ui4) && ((ui4) bj4Var).f().size() != oi4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh4
    /* renamed from: x */
    public pg4 t(oi4 oi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, oi4Var)) == null) {
            this.a.E();
            dl4 dl4Var = new dl4();
            n(oi4Var.c, dl4Var);
            if (dl4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(dl4Var);
            gh4.f(oi4Var.c, this.a);
            return null;
        }
        return (pg4) invokeL.objValue;
    }
}
