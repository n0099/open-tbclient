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
public abstract class aq8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<bq8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public abstract cq8 dispatch(eq8 eq8Var, cq8 cq8Var);

    public abstract List<cq8> processNotification(String str, HashMap hashMap);

    public aq8() {
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

    public cq8 addObserver(String str, cq8 cq8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, cq8Var, z)) == null) {
            if (cq8Var == null) {
                cq8Var = new cq8();
            }
            if (this.mNotificationNameList.contains(str)) {
                cq8Var.n(false);
                cq8Var.s(true);
                List<bq8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                bq8 bq8Var = new bq8();
                bq8Var.e(cq8Var.c());
                bq8Var.d(z);
                bq8Var.f(cq8Var.e());
                list.add(bq8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return cq8Var;
        }
        return (cq8) invokeLLZ.objValue;
    }
}
