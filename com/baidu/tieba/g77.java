package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardOriginCardUiStateKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g77 extends m77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z67 d;
    public final h77 e;
    public final o77 f;
    public final e77 g;
    public final a77 h;
    public final String i;
    public final u97 j;
    public final Function2<Context, g77, Unit> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947746914, "Lcom/baidu/tieba/g77;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947746914, "Lcom/baidu/tieba/g77;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public g77(z67 cardAbstractUiState, h77 h77Var, o77 o77Var, e77 e77Var, a77 a77Var, String schema, u97 statData, Function2<? super Context, ? super g77, Unit> onCardClick) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {cardAbstractUiState, h77Var, o77Var, e77Var, a77Var, schema, statData, onCardClick};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Function2) objArr2[0], (Function1) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(cardAbstractUiState, "cardAbstractUiState");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(statData, "statData");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        this.d = cardAbstractUiState;
        this.e = h77Var;
        this.f = o77Var;
        this.g = e77Var;
        this.h = a77Var;
        this.i = schema;
        this.j = statData;
        this.k = onCardClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g77(z67 z67Var, h77 h77Var, o77 o77Var, e77 e77Var, a77 a77Var, String str, u97 u97Var, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z67Var, h77Var, o77Var, e77Var, a77Var, str, u97Var, r9);
        Function2 function22;
        Function2 function23;
        if ((i & 128) != 0) {
            function23 = CardOriginCardUiStateKt.a;
            function22 = function23;
        } else {
            function22 = function2;
        }
    }

    public final z67 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (z67) invokeV.objValue;
    }

    public final a77 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (a77) invokeV.objValue;
    }

    public final e77 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (e77) invokeV.objValue;
    }

    public final h77 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (h77) invokeV.objValue;
    }

    public final o77 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (o77) invokeV.objValue;
    }

    public final Function2<Context, g77, Unit> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.k;
        }
        return (Function2) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final u97 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.j;
        }
        return (u97) invokeV.objValue;
    }
}
