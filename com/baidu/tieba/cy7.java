package com.baidu.tieba;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cy7 extends by7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy7(kl5 kl5Var) {
        super(kl5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kl5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kl5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
