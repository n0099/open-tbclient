package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cq9;
import com.baidu.tieba.fl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class bq9 implements cq9.a<cl9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ cq9 a;

    public bq9(cq9 cq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cq9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.cq9.a
    public void a(cl9 cl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cl9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", cl9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.cq9.a
    public void b(cl9 cl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cl9Var) == null) {
            cl9 cl9Var2 = cl9Var;
            LogPrinter.v("Update SerialSlotId:%s", cl9Var2.a);
            HashMap<String, hl9> hashMap = this.a.c;
            String str = cl9Var2.a;
            hashMap.put(str, new hl9(str, new ol9(this, cl9Var2)));
            fl9 fl9Var = this.a.b;
            synchronized (fl9Var.a) {
                fl9Var.a(cl9Var2.a).add(new fl9.b(cl9Var2));
            }
        }
    }
}
