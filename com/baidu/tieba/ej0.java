package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ej0 implements lk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ej0() {
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
            arrayList.add(new hh0());
            arrayList.add(new ih0());
            arrayList.add(new jh0());
            arrayList.add(new kh0());
            arrayList.add(new lh0());
            arrayList.add(new mh0());
            arrayList.add(new oh0());
            arrayList.add(new ji0());
            arrayList.add(new rm0());
            arrayList.add(new op0());
            arrayList.add(new pp0());
            arrayList.add(new rp0());
            arrayList.add(new zp0());
            arrayList.add(new r51());
            arrayList.add(new f91());
            arrayList.add(new hb1());
            arrayList.add(new b66());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
