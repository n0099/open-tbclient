package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class d58 implements q48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r48 a;
    public p48 b;

    public d58(r48 r48Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r48Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = r48Var;
        this.b = new c58(this);
    }

    @Override // com.baidu.tieba.q48
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            p48 p48Var = this.b;
            if (p48Var != null) {
                return p48Var.a(bdUniqueId, str, str2, str3);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.q48
    public boolean b(int i, b58 b58Var) {
        InterceptResult invokeIL;
        r48 r48Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, b58Var)) == null) {
            if (b58Var != null && (r48Var = this.a) != null) {
                r48Var.setData(b58Var.getDataList());
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.q48
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            r48 r48Var = this.a;
            if (r48Var != null) {
                r48Var.a(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.q48
    public void setData(List<cn> list) {
        r48 r48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && (r48Var = this.a) != null) {
            r48Var.setData(list);
        }
    }
}
