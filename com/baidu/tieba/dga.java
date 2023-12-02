package com.baidu.tieba;

import com.baidu.tieba.pb.pb.push.PbReplyPushGuide;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class dga implements pf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dga() {
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
            arrayList.add(new n28());
            arrayList.add(new o28());
            arrayList.add(new p28());
            arrayList.add(new vi8());
            arrayList.add(new u69());
            arrayList.add(new v69());
            arrayList.add(new w69());
            arrayList.add(new x69());
            arrayList.add(new y69());
            arrayList.add(new z69());
            arrayList.add(new e5a());
            arrayList.add(new PbReplyPushGuide());
            arrayList.add(new f5a());
            arrayList.add(new g5a());
            arrayList.add(new flb());
            arrayList.add(new glb());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
