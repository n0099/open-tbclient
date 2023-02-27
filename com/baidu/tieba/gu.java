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
/* loaded from: classes4.dex */
public final class gu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, eu<? extends ITaskModelData>> a;

    public gu() {
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
        nu nuVar = new nu(this);
        this.a.put(nuVar.b(), nuVar);
        ju juVar = new ju(this);
        this.a.put(juVar.b(), juVar);
        ou ouVar = new ou(this);
        this.a.put(ouVar.c(), ouVar);
        lu luVar = new lu(this);
        this.a.put(luVar.b(), luVar);
        ku kuVar = new ku(this);
        this.a.put(kuVar.c(), kuVar);
        mu muVar = new mu(this);
        this.a.put(muVar.b(), muVar);
        fu fuVar = new fu(this);
        this.a.put(fuVar.b(), fuVar);
        du duVar = new du(this);
        this.a.put(duVar.c(), duVar);
    }

    public final <T extends ITaskModelData> eu<? extends T> a(String str) {
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
                eu<? extends ITaskModelData> euVar = this.a.get(str);
                if (euVar != null) {
                    return (eu<? extends T>) euVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (eu) invokeL.objValue;
    }
}
