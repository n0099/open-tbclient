package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class h65 implements lk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h65() {
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

    @Override // com.baidu.tieba.lk1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new nz6());
            arrayList.add(new au7());
            arrayList.add(new eu7());
            arrayList.add(new iu7());
            arrayList.add(new mu7());
            arrayList.add(new qu7());
            arrayList.add(new uu7());
            arrayList.add(new yu7());
            arrayList.add(new cv7());
            arrayList.add(new qh9());
            arrayList.add(new vh9());
            arrayList.add(new ai9());
            arrayList.add(new ola());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
