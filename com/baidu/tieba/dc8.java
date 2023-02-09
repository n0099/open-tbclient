package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dc8 extends cc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc8(ts5 ts5Var) {
        super(ts5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ts5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ts5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
