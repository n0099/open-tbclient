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
public abstract class at8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<bt8>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public abstract ct8 dispatch(et8 et8Var, ct8 ct8Var);

    public abstract List<ct8> processNotification(String str, HashMap hashMap);

    public at8() {
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

    public ct8 addObserver(String str, ct8 ct8Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, ct8Var, z)) == null) {
            if (ct8Var == null) {
                ct8Var = new ct8();
            }
            if (this.mNotificationNameList.contains(str)) {
                ct8Var.n(false);
                ct8Var.s(true);
                List<bt8> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                bt8 bt8Var = new bt8();
                bt8Var.e(ct8Var.c());
                bt8Var.d(z);
                bt8Var.f(ct8Var.e());
                list.add(bt8Var);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return ct8Var;
        }
        return (ct8) invokeLLZ.objValue;
    }
}
