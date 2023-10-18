package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ae0 implements ue1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ae0() {
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

    @Override // com.baidu.tieba.ue1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new dc0());
            arrayList.add(new ec0());
            arrayList.add(new fc0());
            arrayList.add(new gc0());
            arrayList.add(new hc0());
            arrayList.add(new ic0());
            arrayList.add(new kc0());
            arrayList.add(new fd0());
            arrayList.add(new nh0());
            arrayList.add(new kk0());
            arrayList.add(new lk0());
            arrayList.add(new nk0());
            arrayList.add(new vk0());
            arrayList.add(new d01());
            arrayList.add(new r31());
            arrayList.add(new t51());
            arrayList.add(new l06());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
