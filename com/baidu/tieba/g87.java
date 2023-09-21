package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.SocialUiStateKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g87 extends v77 implements xb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ca7 d;
    public List<ea7> e;
    public List<ea7> f;
    public List<ea7> g;
    public final Function2<ca7, List<ea7>, Unit> h;
    public final Function3<Context, ca7, List<ea7>, Unit> i;
    public final Function2<ca7, List<ea7>, Unit> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947747875, "Lcom/baidu/tieba/g87;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947747875, "Lcom/baidu/tieba/g87;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public g87(ca7 data, List<ea7> commentStatDataList, List<ea7> shareStatDataList, List<ea7> praiseStatDataList, Function2<? super ca7, ? super List<ea7>, Unit> onShareClick, Function3<? super Context, ? super ca7, ? super List<ea7>, Unit> onCommentClick, Function2<? super ca7, ? super List<ea7>, Unit> onPraiseClick) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {data, commentStatDataList, shareStatDataList, praiseStatDataList, onShareClick, onCommentClick, onPraiseClick};
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
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(commentStatDataList, "commentStatDataList");
        Intrinsics.checkNotNullParameter(shareStatDataList, "shareStatDataList");
        Intrinsics.checkNotNullParameter(praiseStatDataList, "praiseStatDataList");
        Intrinsics.checkNotNullParameter(onShareClick, "onShareClick");
        Intrinsics.checkNotNullParameter(onCommentClick, "onCommentClick");
        Intrinsics.checkNotNullParameter(onPraiseClick, "onPraiseClick");
        this.d = data;
        this.e = commentStatDataList;
        this.f = shareStatDataList;
        this.g = praiseStatDataList;
        this.h = onShareClick;
        this.i = onCommentClick;
        this.j = onPraiseClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g87(ca7 ca7Var, List list, List list2, List list3, Function2 function2, Function3 function3, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ca7Var, r0, r1, r2, r3, r4, r5);
        List list4;
        List list5;
        List list6;
        Function2 function23;
        Function3 function32;
        Function2 function24;
        if ((i & 2) != 0) {
            list4 = new ArrayList();
        } else {
            list4 = list;
        }
        if ((i & 4) != 0) {
            list5 = new ArrayList();
        } else {
            list5 = list2;
        }
        if ((i & 8) != 0) {
            list6 = new ArrayList();
        } else {
            list6 = list3;
        }
        if ((i & 16) != 0) {
            function23 = SocialUiStateKt.a;
        } else {
            function23 = function2;
        }
        if ((i & 32) != 0) {
            function32 = SocialUiStateKt.b;
        } else {
            function32 = function3;
        }
        if ((i & 64) != 0) {
            function24 = SocialUiStateKt.c;
        } else {
            function24 = function22;
        }
    }

    @Override // com.baidu.tieba.xb7
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.d.d(event);
        }
    }

    public final void o(List<ea7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.e = list;
        }
    }

    public final void p(List<ea7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.g = list;
        }
    }

    public final void q(List<ea7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.f = list;
        }
    }

    public final List<ea7> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public final ca7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (ca7) invokeV.objValue;
    }

    public final Function3<Context, ca7, List<ea7>, Unit> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (Function3) invokeV.objValue;
    }

    public final Function2<ca7, List<ea7>, Unit> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<ca7, List<ea7>, Unit> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (Function2) invokeV.objValue;
    }

    public final List<ea7> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public final List<ea7> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }
}
