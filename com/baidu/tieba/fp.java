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
public final class fp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, dp<? extends ITaskModelData>> a;

    public fp() {
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
        mp mpVar = new mp(this);
        this.a.put(mpVar.b(), mpVar);
        ip ipVar = new ip(this);
        this.a.put(ipVar.b(), ipVar);
        np npVar = new np(this);
        this.a.put(npVar.c(), npVar);
        kp kpVar = new kp(this);
        this.a.put(kpVar.b(), kpVar);
        jp jpVar = new jp(this);
        this.a.put(jpVar.c(), jpVar);
        lp lpVar = new lp(this);
        this.a.put(lpVar.b(), lpVar);
        ep epVar = new ep(this);
        this.a.put(epVar.b(), epVar);
        cp cpVar = new cp(this);
        this.a.put(cpVar.c(), cpVar);
    }

    public final <T extends ITaskModelData> dp<? extends T> a(String str) {
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
                dp<? extends ITaskModelData> dpVar = this.a.get(str);
                if (dpVar != null) {
                    return (dp<? extends T>) dpVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (dp) invokeL.objValue;
    }
}
