package com.baidu.tieba;

import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.TypeCastException;
/* loaded from: classes6.dex */
public final class gp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ep<? extends ITaskModelData>> a;

    public gp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        np npVar = new np(this);
        this.a.put(npVar.b(), npVar);
        jp jpVar = new jp(this);
        this.a.put(jpVar.b(), jpVar);
        op opVar = new op(this);
        this.a.put(opVar.c(), opVar);
        lp lpVar = new lp(this);
        this.a.put(lpVar.b(), lpVar);
        kp kpVar = new kp(this);
        this.a.put(kpVar.c(), kpVar);
        mp mpVar = new mp(this);
        this.a.put(mpVar.b(), mpVar);
        fp fpVar = new fp(this);
        this.a.put(fpVar.b(), fpVar);
        dp dpVar = new dp(this);
        this.a.put(dpVar.c(), dpVar);
    }

    public final <T extends ITaskModelData> ep<? extends T> a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ep<? extends ITaskModelData> epVar = this.a.get(str);
                if (epVar != null) {
                    return (ep<? extends T>) epVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (ep) invokeL.objValue;
    }
}
