package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class fv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, hv7> a;
    public hv7 b;
    public long c;

    public fv7() {
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
        this.a = new LinkedHashMap();
    }

    public final void a(hv7 handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, handler) == null) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (handler.c()) {
                this.b = handler;
            }
            this.a.put(handler.d(), handler);
        }
    }

    public final void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.c = j;
        }
    }

    public final void b(AbilityItem abilityItem, BaseMsg baseMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abilityItem, baseMsg) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            hv7 hv7Var = this.b;
            if (hv7Var != null) {
                hv7Var.b(abilityItem, baseMsg);
            }
        }
    }

    public final void c(AbilityItem abilityItem, BaseMsg baseMsg) {
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, abilityItem, baseMsg) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            try {
                hv7 hv7Var = this.a.get(abilityItem.getType());
                if (hv7Var != null) {
                    hv7Var.b(abilityItem, baseMsg);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    b(abilityItem, baseMsg);
                }
            } catch (Exception e) {
                vu7.g("ability_handle_exception", this.c, e);
            }
        }
    }
}
