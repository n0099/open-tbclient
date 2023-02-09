package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u6a;
import com.baidu.tieba.x1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e2a implements u6a.a<w1a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ u6a a;

    public e2a(u6a u6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u6aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = u6aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.u6a.a
    public void a(w1a w1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w1aVar) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", w1aVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.u6a.a
    public void b(w1a w1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w1aVar) == null) {
            w1a w1aVar2 = w1aVar;
            LogPrinter.v("Update SlotId:%s", w1aVar2.a);
            HashMap<String, z1a> hashMap = this.a.c;
            String str = w1aVar2.a;
            hashMap.put(str, new z1a(str, new c2a(this, w1aVar2)));
            x1a x1aVar = this.a.b;
            synchronized (x1aVar.a) {
                x1aVar.a(w1aVar2.a).add(new x1a.a(w1aVar2));
            }
        }
    }
}
