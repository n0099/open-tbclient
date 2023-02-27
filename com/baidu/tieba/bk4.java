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
public class bk4 extends si4<hk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.si4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk4(String str, hh4 hh4Var, sk4 sk4Var) {
        super(hh4Var, sk4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, hh4Var, sk4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((hh4) objArr2[0], (sk4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.si4
    /* renamed from: y */
    public hk4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return tm4.g(this.d, jSONObject);
        }
        return (hk4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.si4
    /* renamed from: w */
    public boolean s(hk4 hk4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, hk4Var, i)) == null) {
            if (hk4Var != null) {
                r(hk4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.si4
    /* renamed from: v */
    public boolean f(hk4 hk4Var) {
        InterceptResult invokeL;
        List<mi4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hk4Var)) == null) {
            if (hk4Var == null) {
                return false;
            }
            if (hk4Var.a == null && (((list = hk4Var.b) == null || list.isEmpty()) && hk4Var.d == null && hk4Var.f == null && hk4Var.e == null)) {
                return false;
            }
            li4 li4Var = hk4Var.a;
            if (li4Var != null && !li4Var.a()) {
                return false;
            }
            List<mi4> list2 = hk4Var.b;
            if (list2 != null) {
                for (mi4 mi4Var : list2) {
                    if (!mi4Var.a()) {
                        return false;
                    }
                }
            }
            ji4 ji4Var = hk4Var.d;
            if (ji4Var != null && !ji4Var.a()) {
                return false;
            }
            hi4 hi4Var = hk4Var.f;
            if (hi4Var != null && !hi4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = hk4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.si4
    /* renamed from: x */
    public gi4 t(hk4 hk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hk4Var)) == null) {
            this.a.E();
            um4 um4Var = new um4();
            o(hk4Var.a, um4Var);
            p(hk4Var.b, um4Var);
            n(g(hk4Var.c), um4Var);
            m(hk4Var.d, um4Var);
            l(hk4Var.f, um4Var);
            r(hk4Var.e);
            if (um4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(um4Var);
            xi4.b(hk4Var, this.a);
            return null;
        }
        return (gi4) invokeL.objValue;
    }
}
