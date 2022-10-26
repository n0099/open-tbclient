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
/* loaded from: classes3.dex */
public class be4 extends sc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.sc4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be4(String str, hb4 hb4Var, se4 se4Var) {
        super(hb4Var, se4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, hb4Var, se4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((hb4) objArr2[0], (se4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: y */
    public he4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return tg4.g(this.d, jSONObject);
        }
        return (he4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: w */
    public boolean s(he4 he4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, he4Var, i)) == null) {
            if (he4Var != null) {
                r(he4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: v */
    public boolean f(he4 he4Var) {
        InterceptResult invokeL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, he4Var)) == null) {
            if (he4Var == null) {
                return false;
            }
            if (he4Var.a == null && (((list = he4Var.b) == null || list.isEmpty()) && he4Var.d == null && he4Var.f == null && he4Var.e == null)) {
                return false;
            }
            lc4 lc4Var = he4Var.a;
            if (lc4Var != null && !lc4Var.a()) {
                return false;
            }
            List<mc4> list2 = he4Var.b;
            if (list2 != null) {
                for (mc4 mc4Var : list2) {
                    if (!mc4Var.a()) {
                        return false;
                    }
                }
            }
            jc4 jc4Var = he4Var.d;
            if (jc4Var != null && !jc4Var.a()) {
                return false;
            }
            hc4 hc4Var = he4Var.f;
            if (hc4Var != null && !hc4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = he4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: x */
    public gc4 t(he4 he4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, he4Var)) == null) {
            this.a.E();
            ug4 ug4Var = new ug4();
            o(he4Var.a, ug4Var);
            p(he4Var.b, ug4Var);
            n(g(he4Var.c), ug4Var);
            m(he4Var.d, ug4Var);
            l(he4Var.f, ug4Var);
            r(he4Var.e);
            if (ug4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(ug4Var);
            xc4.b(he4Var, this.a);
            return null;
        }
        return (gc4) invokeL.objValue;
    }
}
