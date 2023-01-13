package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g78 extends f78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g78(io5 io5Var) {
        super(io5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
