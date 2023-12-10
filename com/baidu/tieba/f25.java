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
            arrayList.add(new sj7());
            arrayList.add(new nn7());
            arrayList.add(new f48());
            arrayList.add(new j48());
            arrayList.add(new n48());
            arrayList.add(new r48());
            arrayList.add(new v48());
            arrayList.add(new z48());
            arrayList.add(new d58());
            arrayList.add(new h58());
            arrayList.add(new ru9());
            arrayList.add(new wu9());
            arrayList.add(new bv9());
            arrayList.add(new esa());
            arrayList.add(new c2b());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
