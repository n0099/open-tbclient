package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ds9;
import com.baidu.tieba.gn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class cs9 implements ds9.a<dn9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ds9 a;

    public cs9(ds9 ds9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ds9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ds9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.ds9.a
    public void a(dn9 dn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dn9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", dn9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.ds9.a
    public void b(dn9 dn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dn9Var) == null) {
            dn9 dn9Var2 = dn9Var;
            LogPrinter.v("Update SerialSlotId:%s", dn9Var2.a);
            HashMap<String, in9> hashMap = this.a.c;
            String str = dn9Var2.a;
            hashMap.put(str, new in9(str, new pn9(this, dn9Var2)));
            gn9 gn9Var = this.a.b;
            synchronized (gn9Var.a) {
                gn9Var.a(dn9Var2.a).add(new gn9.b(dn9Var2));
            }
        }
    }
}
