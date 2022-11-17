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
public abstract class bq8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<cq8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public abstract dq8 dispatch(fq8 fq8Var, dq8 dq8Var);

    public abstract List<dq8> processNotification(String str, HashMap hashMap);

    public bq8() {
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

    public dq8 addObserver(String str, dq8 dq8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, dq8Var, z)) == null) {
            if (dq8Var == null) {
                dq8Var = new dq8();
            }
            if (this.mNotificationNameList.contains(str)) {
                dq8Var.n(false);
                dq8Var.s(true);
                List<cq8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                cq8 cq8Var = new cq8();
                cq8Var.e(dq8Var.c());
                cq8Var.d(z);
                cq8Var.f(dq8Var.e());
                list.add(cq8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return dq8Var;
        }
        return (dq8) invokeLLZ.objValue;
    }
}
