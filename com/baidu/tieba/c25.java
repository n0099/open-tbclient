package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c25 implements mf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c25() {
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

    @Override // com.baidu.tieba.mf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new gw6());
            arrayList.add(new nj7());
            arrayList.add(new in7());
            arrayList.add(new a48());
            arrayList.add(new e48());
            arrayList.add(new i48());
            arrayList.add(new m48());
            arrayList.add(new q48());
            arrayList.add(new u48());
            arrayList.add(new y48());
            arrayList.add(new c58());
            arrayList.add(new mu9());
            arrayList.add(new ru9());
            arrayList.add(new wu9());
            arrayList.add(new esa());
            arrayList.add(new c2b());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
