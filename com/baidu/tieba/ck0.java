package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ck0 implements zk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ck0() {
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

    @Override // com.baidu.tieba.zk1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new fi0());
            arrayList.add(new gi0());
            arrayList.add(new hi0());
            arrayList.add(new ii0());
            arrayList.add(new ji0());
            arrayList.add(new ki0());
            arrayList.add(new mi0());
            arrayList.add(new hj0());
            arrayList.add(new pn0());
            arrayList.add(new kq0());
            arrayList.add(new lq0());
            arrayList.add(new rq0());
            arrayList.add(new s91());
            arrayList.add(new vb1());
            arrayList.add(new g76());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
