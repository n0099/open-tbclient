package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class eg4 extends ve4<kg4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.ve4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eg4(String str, kd4 kd4Var, vg4 vg4Var) {
        super(kd4Var, vg4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, kd4Var, vg4Var};
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
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ve4
    /* renamed from: x */
    public kg4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return wi4.g(this.d, jSONObject);
        }
        return (kg4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ve4
    /* renamed from: v */
    public boolean r(kg4 kg4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, kg4Var, i)) == null) {
            if (kg4Var != null) {
                q(kg4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ve4
    /* renamed from: u */
    public boolean e(kg4 kg4Var) {
        InterceptResult invokeL;
        List<pe4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kg4Var)) == null) {
            if (kg4Var == null) {
                return false;
            }
            if (kg4Var.a == null && (((list = kg4Var.b) == null || list.isEmpty()) && kg4Var.d == null && kg4Var.f == null && kg4Var.e == null)) {
                return false;
            }
            oe4 oe4Var = kg4Var.a;
            if (oe4Var != null && !oe4Var.a()) {
                return false;
            }
            List<pe4> list2 = kg4Var.b;
            if (list2 != null) {
                for (pe4 pe4Var : list2) {
                    if (!pe4Var.a()) {
                        return false;
                    }
                }
            }
            me4 me4Var = kg4Var.d;
            if (me4Var != null && !me4Var.a()) {
                return false;
            }
            ke4 ke4Var = kg4Var.f;
            if (ke4Var != null && !ke4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = kg4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ve4
    /* renamed from: w */
    public je4 s(kg4 kg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, kg4Var)) == null) {
            this.a.E();
            xi4 xi4Var = new xi4();
            n(kg4Var.a, xi4Var);
            o(kg4Var.b, xi4Var);
            m(f(kg4Var.c), xi4Var);
            l(kg4Var.d, xi4Var);
            k(kg4Var.f, xi4Var);
            q(kg4Var.e);
            if (xi4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(xi4Var);
            af4.b(kg4Var, this.a);
            return null;
        }
        return (je4) invokeL.objValue;
    }
}
