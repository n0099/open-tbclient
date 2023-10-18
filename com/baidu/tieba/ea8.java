package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ea8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, fa8> a;
    public fa8 b;
    public long c;

    @JvmOverloads
    public final void c(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, abilityItem, baseItem) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            e(this, abilityItem, baseItem, null, 4, null);
        }
    }

    public ea8() {
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

    public static /* synthetic */ void e(ea8 ea8Var, AbilityItem abilityItem, BaseItem baseItem, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        ea8Var.d(abilityItem, baseItem, obj);
    }

    public final void a(fa8 handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, handler) == null) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            if (handler.c()) {
                this.b = handler;
            }
            for (String str : handler.e()) {
                this.a.put(str, handler);
            }
        }
    }

    public final void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abilityItem, baseItem) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            fa8 fa8Var = this.b;
            if (fa8Var != null) {
                fa8Var.b(abilityItem, baseItem, null);
            }
        }
    }

    @JvmOverloads
    public final void d(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        Unit unit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            try {
                fa8 fa8Var = this.a.get(abilityItem.getType());
                if (fa8Var != null) {
                    fa8Var.b(abilityItem, baseItem, obj);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    b(abilityItem, baseItem);
                }
            } catch (Exception e) {
                na8.g("ability_handle_exception", this.c, e);
            }
        }
    }

    public final void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.c = j;
        }
    }
}
