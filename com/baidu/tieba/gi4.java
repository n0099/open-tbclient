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
public class gi4 extends zg4<mi4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zg4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi4(of4 of4Var, zi4 zi4Var) {
        super(of4Var, zi4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {of4Var, zi4Var};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zg4
    /* renamed from: v */
    public ng4 e(String str, mi4 mi4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, mi4Var)) == null) {
            if (mi4Var != null && (i = mi4Var.a) != 0) {
                return new ng4(i, mi4Var.b);
            }
            return super.e(str, mi4Var);
        }
        return (ng4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zg4
    /* renamed from: y */
    public mi4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return al4.e(jSONObject);
        }
        return (mi4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.zg4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(mi4 mi4Var) {
        InterceptResult invokeL;
        List<ug4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mi4Var)) == null) {
            if (mi4Var == null || (list = mi4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (ug4 ug4Var : mi4Var.c) {
                if (ug4Var == null || !ug4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            zi4 zi4Var = this.b;
            if ((zi4Var instanceof si4) && ((si4) zi4Var).f().size() != mi4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zg4
    /* renamed from: x */
    public ng4 t(mi4 mi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mi4Var)) == null) {
            this.a.E();
            bl4 bl4Var = new bl4();
            n(mi4Var.c, bl4Var);
            if (bl4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(bl4Var);
            eh4.f(mi4Var.c, this.a);
            return null;
        }
        return (ng4) invokeL.objValue;
    }
}
