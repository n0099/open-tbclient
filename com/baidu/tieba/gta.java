package com.baidu.tieba;

import com.baidu.tieba.ora;
import com.baidu.tieba.sra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class gta<T> implements ora.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final sra.c<T> a;

    public gta(sra.c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
    }

    public void call(ura<? super T> uraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uraVar) == null) {
            eta etaVar = new eta(uraVar);
            uraVar.b(etaVar);
            this.a.call(etaVar);
        }
    }

    @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ura) ((ura) obj));
    }
}
