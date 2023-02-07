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
public final class cu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, au<? extends ITaskModelData>> a;

    public cu() {
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
        ju juVar = new ju(this);
        this.a.put(juVar.b(), juVar);
        fu fuVar = new fu(this);
        this.a.put(fuVar.b(), fuVar);
        ku kuVar = new ku(this);
        this.a.put(kuVar.c(), kuVar);
        hu huVar = new hu(this);
        this.a.put(huVar.b(), huVar);
        gu guVar = new gu(this);
        this.a.put(guVar.c(), guVar);
        iu iuVar = new iu(this);
        this.a.put(iuVar.b(), iuVar);
        bu buVar = new bu(this);
        this.a.put(buVar.b(), buVar);
        zt ztVar = new zt(this);
        this.a.put(ztVar.c(), ztVar);
    }

    public final <T extends ITaskModelData> au<? extends T> a(String str) {
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
                au<? extends ITaskModelData> auVar = this.a.get(str);
                if (auVar != null) {
                    return (au<? extends T>) auVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (au) invokeL.objValue;
    }
}
