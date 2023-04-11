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
public class hi4 extends ah4<ni4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ah4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hi4(pf4 pf4Var, aj4 aj4Var) {
        super(pf4Var, aj4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pf4Var, aj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((pf4) objArr2[0], (aj4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4
    /* renamed from: v */
    public og4 e(String str, ni4 ni4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ni4Var)) == null) {
            if (ni4Var != null && (i = ni4Var.a) != 0) {
                return new og4(i, ni4Var.b);
            }
            return super.e(str, ni4Var);
        }
        return (og4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4
    /* renamed from: y */
    public ni4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return bl4.e(jSONObject);
        }
        return (ni4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.ah4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(ni4 ni4Var) {
        InterceptResult invokeL;
        List<vg4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ni4Var)) == null) {
            if (ni4Var == null || (list = ni4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (vg4 vg4Var : ni4Var.c) {
                if (vg4Var == null || !vg4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            aj4 aj4Var = this.b;
            if ((aj4Var instanceof ti4) && ((ti4) aj4Var).f().size() != ni4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4
    /* renamed from: x */
    public og4 t(ni4 ni4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ni4Var)) == null) {
            this.a.E();
            cl4 cl4Var = new cl4();
            n(ni4Var.c, cl4Var);
            if (cl4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(cl4Var);
            fh4.f(ni4Var.c, this.a);
            return null;
        }
        return (og4) invokeL.objValue;
    }
}
