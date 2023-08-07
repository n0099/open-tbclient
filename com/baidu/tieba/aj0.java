package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class aj0 implements ck1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aj0() {
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

    @Override // com.baidu.tieba.ck1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new dh0());
            arrayList.add(new eh0());
            arrayList.add(new fh0());
            arrayList.add(new gh0());
            arrayList.add(new hh0());
            arrayList.add(new ih0());
            arrayList.add(new kh0());
            arrayList.add(new fi0());
            arrayList.add(new nm0());
            arrayList.add(new kp0());
            arrayList.add(new lp0());
            arrayList.add(new sp0());
            arrayList.add(new v81());
            arrayList.add(new ya1());
            arrayList.add(new n46());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
