package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class fr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<jr9> a;

    public fr9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public ArrayList<jr9> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final boolean b(ExcContent excContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, excContent)) == null) {
            long longValue = excContent.type.longValue();
            if (longValue == 2 || longValue == 0 || longValue == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void c(TbPageContext<?> tbPageContext, List<ExcContent> list) {
        mr9 mr9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, list) == null) && list != null && !list.isEmpty()) {
            loop0: while (true) {
                mr9Var = null;
                for (ExcContent excContent : list) {
                    if (excContent != null && excContent.type != null) {
                        if (b(excContent)) {
                            ir9 a = lr9.a(tbPageContext, excContent);
                            if (a == null) {
                                continue;
                            } else if (a.a()) {
                                if (mr9Var != null) {
                                    this.a.add(mr9Var);
                                }
                                this.a.add(a);
                            } else {
                                if (mr9Var == null) {
                                    mr9Var = new mr9();
                                }
                                mr9Var.c(a.b());
                            }
                        } else {
                            if (mr9Var != null) {
                                this.a.add(mr9Var);
                            }
                            this.a.add(lr9.b(excContent));
                        }
                    }
                }
                break loop0;
            }
            if (mr9Var != null) {
                this.a.add(mr9Var);
            }
        }
    }
}
