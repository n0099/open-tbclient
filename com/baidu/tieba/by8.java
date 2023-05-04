package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class by8 extends ay8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by8(xv5 xv5Var) {
        super(xv5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xv5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xv5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p(TbConfig.getContentLineSpace(), 1.0f);
        j(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        A(0);
        m(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        n(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        t(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        g(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        u(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        w(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        k(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        i(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
