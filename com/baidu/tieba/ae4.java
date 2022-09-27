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
public class ae4 extends rc4<ge4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae4(String str, gb4 gb4Var, re4 re4Var) {
        super(gb4Var, re4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, gb4Var, re4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((gb4) objArr2[0], (re4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    @Override // com.baidu.tieba.rc4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: v */
    public boolean f(ge4 ge4Var) {
        InterceptResult invokeL;
        List<lc4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ge4Var)) == null) {
            if (ge4Var == null) {
                return false;
            }
            if (ge4Var.a == null && (((list = ge4Var.b) == null || list.isEmpty()) && ge4Var.d == null && ge4Var.f == null && ge4Var.e == null)) {
                return false;
            }
            kc4 kc4Var = ge4Var.a;
            if (kc4Var == null || kc4Var.a()) {
                List<lc4> list2 = ge4Var.b;
                if (list2 != null) {
                    for (lc4 lc4Var : list2) {
                        if (!lc4Var.a()) {
                            return false;
                        }
                    }
                }
                ic4 ic4Var = ge4Var.d;
                if (ic4Var == null || ic4Var.a()) {
                    gc4 gc4Var = ge4Var.f;
                    if (gc4Var == null || gc4Var.a()) {
                        PMSAppInfo pMSAppInfo = ge4Var.e;
                        return pMSAppInfo == null || pMSAppInfo.checkValid();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: w */
    public boolean s(ge4 ge4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, ge4Var, i)) == null) {
            if (ge4Var != null) {
                r(ge4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: x */
    public fc4 t(ge4 ge4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ge4Var)) == null) {
            this.a.E();
            tg4 tg4Var = new tg4();
            o(ge4Var.a, tg4Var);
            p(ge4Var.b, tg4Var);
            n(g(ge4Var.c), tg4Var);
            m(ge4Var.d, tg4Var);
            l(ge4Var.f, tg4Var);
            r(ge4Var.e);
            if (tg4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(tg4Var);
            wc4.b(ge4Var, this.a);
            return null;
        }
        return (fc4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: y */
    public ge4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? sg4.g(this.d, jSONObject) : (ge4) invokeL.objValue;
    }
}
