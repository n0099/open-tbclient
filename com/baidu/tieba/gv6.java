package com.baidu.tieba;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public class gv6 implements ev6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ev6 a;
    public final Map<Integer, ev6> b;

    public gv6(ev6 defaultRenderer, Pair<Integer, ? extends ev6>... renderers) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultRenderer, renderers};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(defaultRenderer, "defaultRenderer");
        Intrinsics.checkNotNullParameter(renderers, "renderers");
        this.a = defaultRenderer;
        this.b = MapsKt__MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(renderers, renderers.length));
    }

    @Override // com.baidu.tieba.ev6
    public qv6 a(it6 item, iv6 displayer, ct6 config) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, displayer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            ev6 ev6Var = this.b.get(Integer.valueOf(c(item)));
            if (ev6Var == null) {
                ev6Var = this.a;
            }
            return ev6Var.a(item, displayer, config);
        }
        return (qv6) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ev6
    public void b(it6 item, Canvas canvas, iv6 displayer, ct6 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            ev6 ev6Var = this.b.get(Integer.valueOf(c(item)));
            if (ev6Var == null) {
                ev6Var = this.a;
            }
            ev6Var.b(item, canvas, displayer, config);
        }
    }

    public int c(it6 item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().g();
        }
        return invokeL.intValue;
    }
}
