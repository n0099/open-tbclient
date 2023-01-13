package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h1a;
import com.baidu.tieba.kw9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class g1a implements h1a.a<hw9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ h1a a;

    public g1a(h1a h1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h1aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h1aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.h1a.a
    public void a(hw9 hw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hw9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", hw9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.h1a.a
    public void b(hw9 hw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hw9Var) == null) {
            hw9 hw9Var2 = hw9Var;
            LogPrinter.v("Update SerialSlotId:%s", hw9Var2.a);
            HashMap<String, mw9> hashMap = this.a.c;
            String str = hw9Var2.a;
            hashMap.put(str, new mw9(str, new tw9(this, hw9Var2)));
            kw9 kw9Var = this.a.b;
            synchronized (kw9Var.a) {
                kw9Var.a(hw9Var2.a).add(new kw9.b(hw9Var2));
            }
        }
    }
}
