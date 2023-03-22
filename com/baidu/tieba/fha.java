package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gha;
import com.baidu.tieba.jca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class fha implements gha.a<gca> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ gha a;

    public fha(gha ghaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ghaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ghaVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.gha.a
    public void a(gca gcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gcaVar) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", gcaVar.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.gha.a
    public void b(gca gcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gcaVar) == null) {
            gca gcaVar2 = gcaVar;
            LogPrinter.v("Update SerialSlotId:%s", gcaVar2.a);
            HashMap<String, lca> hashMap = this.a.c;
            String str = gcaVar2.a;
            hashMap.put(str, new lca(str, new sca(this, gcaVar2)));
            jca jcaVar = this.a.b;
            synchronized (jcaVar.a) {
                jcaVar.a(gcaVar2.a).add(new jca.b(gcaVar2));
            }
        }
    }
}
