package com.baidu.tieba.frs;

import c.a.d.o.e.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class AbsDelegateAdapterList extends LinkedList<a<?, ?>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5256036611896007456L;
    public transient /* synthetic */ FieldHolder $fh;

    public AbsDelegateAdapterList() {
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
}
