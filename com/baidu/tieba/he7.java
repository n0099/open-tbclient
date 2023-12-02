package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.feed.widget.uistate.PersonAttentionUiStateKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class he7 extends pb7 implements oa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final v77 c;
    public final String d;
    public Function1<? super e87, Unit> e;
    public final Function2<he7, TbPageContext<?>, Unit> f;
    public final Function3<he7, TbPageContext<?>, Object, Unit> g;

    @JvmOverloads
    public he7(v77 personAttentionData, String str, Function1<? super e87, Unit> onStat, Function2<? super he7, ? super TbPageContext<?>, Unit> onAttentionClick, Function3<? super he7, ? super TbPageContext<?>, Object, Unit> registerAttentionListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personAttentionData, str, onStat, onAttentionClick, registerAttentionListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(personAttentionData, "personAttentionData");
        Intrinsics.checkNotNullParameter(onStat, "onStat");
        Intrinsics.checkNotNullParameter(onAttentionClick, "onAttentionClick");
        Intrinsics.checkNotNullParameter(registerAttentionListener, "registerAttentionListener");
        this.c = personAttentionData;
        this.d = str;
        this.e = onStat;
        this.f = onAttentionClick;
        this.g = registerAttentionListener;
    }

    public /* synthetic */ he7(v77 v77Var, String str, Function1 function1, Function2 function2, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(v77Var, str, (i & 4) != 0 ? PersonAttentionUiStateKt.c : function1, (i & 8) != 0 ? PersonAttentionUiStateKt.a : function2, (i & 16) != 0 ? PersonAttentionUiStateKt.b : function3);
    }

    @Override // com.baidu.tieba.oa7
    public void d(Object event) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof UpdateAttentionMessage.UpdateAttentionData) {
                UpdateAttentionMessage.UpdateAttentionData updateAttentionData = (UpdateAttentionMessage.UpdateAttentionData) event;
                if (Intrinsics.areEqual(updateAttentionData.toUid, this.c.e())) {
                    this.c.g(updateAttentionData.isAttention);
                    this.c.h(updateAttentionData.status);
                    d77 a = x67.a.a("tb.feed_home_reco_user_state");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (this.c.f()) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    linkedHashMap.put("is_like", str);
                    linkedHashMap.put("like_status", String.valueOf(this.c.b()));
                    if (a != null) {
                        a.a(this.c.e(), linkedHashMap);
                    }
                }
            }
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final Function2<he7, TbPageContext<?>, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Function2) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.baidu.tieba.e87, kotlin.Unit>, kotlin.jvm.functions.Function1<com.baidu.tieba.e87, kotlin.Unit> */
    public final Function1<e87, Unit> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (Function1) invokeV.objValue;
    }

    public final v77 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (v77) invokeV.objValue;
    }

    public final Function3<he7, TbPageContext<?>, Object, Unit> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (Function3) invokeV.objValue;
    }
}
