package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.feed.widget.uistate.PersonAttentionUiStateKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class da7 extends f87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w57 c;
    public final String d;
    public Function1<? super a67, Unit> e;
    public final Function2<da7, TbPageContext<?>, Unit> f;
    public final Function3<da7, TbPageContext<?>, Object, Unit> g;

    @JvmOverloads
    public da7(w57 personAttentionData, String str, Function1<? super a67, Unit> onStat, Function2<? super da7, ? super TbPageContext<?>, Unit> onAttentionClick, Function3<? super da7, ? super TbPageContext<?>, Object, Unit> registerAttentionListener) {
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

    public /* synthetic */ da7(w57 w57Var, String str, Function1 function1, Function2 function2, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(w57Var, str, (i & 4) != 0 ? PersonAttentionUiStateKt.c : function1, (i & 8) != 0 ? PersonAttentionUiStateKt.c() : function2, (i & 16) != 0 ? PersonAttentionUiStateKt.b : function3);
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final Function2<da7, TbPageContext<?>, Unit> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (Function2) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.baidu.tieba.a67, kotlin.Unit>, kotlin.jvm.functions.Function1<com.baidu.tieba.a67, kotlin.Unit> */
    public final Function1<a67, Unit> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (Function1) invokeV.objValue;
    }

    public final w57 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (w57) invokeV.objValue;
    }

    public final Function3<da7, TbPageContext<?>, Object, Unit> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (Function3) invokeV.objValue;
    }
}
