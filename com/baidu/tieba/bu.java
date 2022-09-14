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
/* loaded from: classes3.dex */
public final class bu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, zt<? extends ITaskModelData>> a;

    public bu() {
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
        iu iuVar = new iu(this);
        this.a.put(iuVar.b(), iuVar);
        eu euVar = new eu(this);
        this.a.put(euVar.b(), euVar);
        ju juVar = new ju(this);
        this.a.put(juVar.c(), juVar);
        gu guVar = new gu(this);
        this.a.put(guVar.b(), guVar);
        fu fuVar = new fu(this);
        this.a.put(fuVar.c(), fuVar);
        hu huVar = new hu(this);
        this.a.put(huVar.b(), huVar);
        au auVar = new au(this);
        this.a.put(auVar.b(), auVar);
        yt ytVar = new yt(this);
        this.a.put(ytVar.c(), ytVar);
    }

    public final <T extends ITaskModelData> zt<? extends T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                zt<? extends ITaskModelData> ztVar = this.a.get(str);
                if (ztVar != null) {
                    return (zt<? extends T>) ztVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (zt) invokeL.objValue;
    }
}
