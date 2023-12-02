package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class f25 implements pf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.pf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new kw6());
            arrayList.add(new rj7());
            arrayList.add(new mn7());
            arrayList.add(new e48());
            arrayList.add(new i48());
            arrayList.add(new m48());
            arrayList.add(new q48());
            arrayList.add(new u48());
            arrayList.add(new y48());
            arrayList.add(new c58());
            arrayList.add(new g58());
            arrayList.add(new qu9());
            arrayList.add(new vu9());
            arrayList.add(new av9());
            arrayList.add(new dsa());
            arrayList.add(new b2b());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
