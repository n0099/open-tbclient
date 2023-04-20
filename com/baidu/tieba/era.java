package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fra;
import com.baidu.tieba.ima;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class era implements fra.a<fma> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ fra a;

    public era(fra fraVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fraVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fraVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.fra.a
    public void a(fma fmaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fmaVar) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", fmaVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.fra.a
    public void b(fma fmaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fmaVar) == null) {
            fma fmaVar2 = fmaVar;
            LogPrinter.v("Update SerialSlotId:%s", fmaVar2.a);
            HashMap<String, kma> hashMap = this.a.c;
            String str = fmaVar2.a;
            hashMap.put(str, new kma(str, new rma(this, fmaVar2)));
            ima imaVar = this.a.b;
            synchronized (imaVar.a) {
                imaVar.a(fmaVar2.a).add(new ima.b(fmaVar2));
            }
        }
    }
}
