package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class go8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap mAsyncCallBackMethodList;
    public HashSet mNotificationNameList;

    public abstract io8 dispatch(ko8 ko8Var, io8 io8Var);

    public abstract List processNotification(String str, HashMap hashMap);

    public go8() {
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

    public io8 addObserver(String str, io8 io8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, io8Var, z)) == null) {
            if (io8Var == null) {
                io8Var = new io8();
            }
            if (this.mNotificationNameList.contains(str)) {
                io8Var.n(false);
                io8Var.s(true);
                List list = (List) this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList();
                }
                ho8 ho8Var = new ho8();
                ho8Var.e(io8Var.c());
                ho8Var.d(z);
                ho8Var.f(io8Var.e());
                list.add(ho8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return io8Var;
        }
        return (io8) invokeLLZ.objValue;
    }
}
