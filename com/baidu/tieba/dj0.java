package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class dj0 implements kk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dj0() {
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

    @Override // com.baidu.tieba.kk1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new gh0());
            arrayList.add(new hh0());
            arrayList.add(new ih0());
            arrayList.add(new jh0());
            arrayList.add(new kh0());
            arrayList.add(new lh0());
            arrayList.add(new nh0());
            arrayList.add(new ii0());
            arrayList.add(new qm0());
            arrayList.add(new np0());
            arrayList.add(new op0());
            arrayList.add(new qp0());
            arrayList.add(new yp0());
            arrayList.add(new q51());
            arrayList.add(new e91());
            arrayList.add(new gb1());
            arrayList.add(new c66());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
