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
/* loaded from: classes4.dex */
public class ii4 extends zg4<oi4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.zg4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii4(String str, of4 of4Var, zi4 zi4Var) {
        super(of4Var, zi4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, of4Var, zi4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((of4) objArr2[0], (zi4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zg4
    /* renamed from: y */
    public oi4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return al4.g(this.d, jSONObject);
        }
        return (oi4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zg4
    /* renamed from: w */
    public boolean s(oi4 oi4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, oi4Var, i)) == null) {
            if (oi4Var != null) {
                r(oi4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zg4
    /* renamed from: v */
    public boolean f(oi4 oi4Var) {
        InterceptResult invokeL;
        List<tg4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, oi4Var)) == null) {
            if (oi4Var == null) {
                return false;
            }
            if (oi4Var.a == null && (((list = oi4Var.b) == null || list.isEmpty()) && oi4Var.d == null && oi4Var.f == null && oi4Var.e == null)) {
                return false;
            }
            sg4 sg4Var = oi4Var.a;
            if (sg4Var != null && !sg4Var.a()) {
                return false;
            }
            List<tg4> list2 = oi4Var.b;
            if (list2 != null) {
                for (tg4 tg4Var : list2) {
                    if (!tg4Var.a()) {
                        return false;
                    }
                }
            }
            qg4 qg4Var = oi4Var.d;
            if (qg4Var != null && !qg4Var.a()) {
                return false;
            }
            og4 og4Var = oi4Var.f;
            if (og4Var != null && !og4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = oi4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zg4
    /* renamed from: x */
    public ng4 t(oi4 oi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, oi4Var)) == null) {
            this.a.E();
            bl4 bl4Var = new bl4();
            o(oi4Var.a, bl4Var);
            p(oi4Var.b, bl4Var);
            n(g(oi4Var.c), bl4Var);
            m(oi4Var.d, bl4Var);
            l(oi4Var.f, bl4Var);
            r(oi4Var.e);
            if (bl4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(bl4Var);
            eh4.b(oi4Var, this.a);
            return null;
        }
        return (ng4) invokeL.objValue;
    }
}
