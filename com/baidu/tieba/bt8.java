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
/* loaded from: classes3.dex */
public abstract class bt8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<ct8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public abstract dt8 dispatch(ft8 ft8Var, dt8 dt8Var);

    public abstract List<dt8> processNotification(String str, HashMap hashMap);

    public bt8() {
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

    public dt8 addObserver(String str, dt8 dt8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, dt8Var, z)) == null) {
            if (dt8Var == null) {
                dt8Var = new dt8();
            }
            if (this.mNotificationNameList.contains(str)) {
                dt8Var.n(false);
                dt8Var.s(true);
                List<ct8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                ct8 ct8Var = new ct8();
                ct8Var.e(dt8Var.c());
                ct8Var.d(z);
                ct8Var.f(dt8Var.e());
                list.add(ct8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return dt8Var;
        }
        return (dt8) invokeLLZ.objValue;
    }
}
