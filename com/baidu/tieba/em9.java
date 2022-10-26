package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uq9;
import com.baidu.tieba.xl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class em9 implements uq9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ uq9 a;

    public em9(uq9 uq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uq9Var;
    }

    @Override // com.baidu.tieba.uq9.a
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", ((wl9) obj).a);
        }
    }

    @Override // com.baidu.tieba.uq9.a
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            wl9 wl9Var = (wl9) obj;
            LogPrinter.v("Update SlotId:%s", wl9Var.a);
            HashMap hashMap = this.a.c;
            String str = wl9Var.a;
            hashMap.put(str, new zl9(str, new cm9(this, wl9Var)));
            xl9 xl9Var = this.a.b;
            synchronized (xl9Var.a) {
                xl9Var.a(wl9Var.a).add(new xl9.a(wl9Var));
            }
        }
    }
}
