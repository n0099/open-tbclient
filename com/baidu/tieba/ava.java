package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bva;
import com.baidu.tieba.eqa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ava implements bva.a<bqa> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bva a;

    public ava(bva bvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bvaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bvaVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.bva.a
    public void a(bqa bqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bqaVar) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", bqaVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.bva.a
    public void b(bqa bqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bqaVar) == null) {
            bqa bqaVar2 = bqaVar;
            LogPrinter.v("Update SerialSlotId:%s", bqaVar2.a);
            HashMap<String, gqa> hashMap = this.a.c;
            String str = bqaVar2.a;
            hashMap.put(str, new gqa(str, new nqa(this, bqaVar2)));
            eqa eqaVar = this.a.b;
            synchronized (eqaVar.a) {
                eqaVar.a(bqaVar2.a).add(new eqa.b(bqaVar2));
            }
        }
    }
}
