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
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g57 extends v47 implements ka7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y77 g;
    public List<a87> h;
    public List<a87> i;
    public List<a87> j;
    public final Function1<g57, Unit> k;
    public final Function2<Context, g57, Unit> l;
    public final Function2<g57, Boolean, Unit> m;
    public final Function2<Context, y77, Boolean> n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947744992, "Lcom/baidu/tieba/g57;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947744992, "Lcom/baidu/tieba/g57;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public g57(y77 data, List<a87> commentStatDataList, List<a87> shareStatDataList, List<a87> praiseStatDataList, Map<String, String> businessInfoMap, Map<String, String> logInfoMap, Function1<? super g57, Unit> onShareClick, Function2<? super Context, ? super g57, Unit> onCommentClick, Function2<? super g57, ? super Boolean, Unit> onPraiseClick, Function2<? super Context, ? super y77, Boolean> onManageClick) {
        super(businessInfoMap, logInfoMap, null, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {data, commentStatDataList, shareStatDataList, praiseStatDataList, businessInfoMap, logInfoMap, onShareClick, onCommentClick, onPraiseClick, onManageClick};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Map) objArr2[0], (Map) objArr2[1], (Function2) objArr2[2], (Function1) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(commentStatDataList, "commentStatDataList");
        Intrinsics.checkNotNullParameter(shareStatDataList, "shareStatDataList");
        Intrinsics.checkNotNullParameter(praiseStatDataList, "praiseStatDataList");
        Intrinsics.checkNotNullParameter(businessInfoMap, "businessInfoMap");
        Intrinsics.checkNotNullParameter(logInfoMap, "logInfoMap");
        Intrinsics.checkNotNullParameter(onShareClick, "onShareClick");
        Intrinsics.checkNotNullParameter(onCommentClick, "onCommentClick");
        Intrinsics.checkNotNullParameter(onPraiseClick, "onPraiseClick");
        Intrinsics.checkNotNullParameter(onManageClick, "onManageClick");
        this.g = data;
        this.h = commentStatDataList;
        this.i = shareStatDataList;
        this.j = praiseStatDataList;
        this.k = onShareClick;
        this.l = onCommentClick;
        this.m = onPraiseClick;
        this.n = onManageClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g57(y77 y77Var, List list, List list2, List list3, Map map, Map map2, Function1 function1, Function2 function2, Function2 function22, Function2 function23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(y77Var, r4, r5, r6, map, map2, r9, r10, r11, r12);
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Function1 function12;
        Function2 function24;
        Function2 function25;
        Function2 function26;
        Function2 function27;
        Function2 function28;
        Function2 function29;
        Function1 function13;
        if ((i & 2) != 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        if ((i & 4) != 0) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = list2;
        }
        if ((i & 8) != 0) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = list3;
        }
        if ((i & 64) != 0) {
            function13 = SocialUiStateKt.a;
            function12 = function13;
        } else {
            function12 = function1;
        }
        if ((i & 128) != 0) {
            function29 = SocialUiStateKt.b;
            function24 = function29;
        } else {
            function24 = function2;
        }
        if ((i & 256) != 0) {
            function28 = SocialUiStateKt.c;
            function25 = function28;
        } else {
            function25 = function22;
        }
        if ((i & 512) != 0) {
            function27 = SocialUiStateKt.d;
            function26 = function27;
        } else {
            function26 = function23;
        }
    }

    @Override // com.baidu.tieba.ka7
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.g.d(event);
        }
    }

    public final void t(List<a87> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.h = list;
        }
    }

    public final void u(List<a87> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.j = list;
        }
    }

    public final void v(List<a87> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.i = list;
        }
    }

    public final List<a87> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public final y77 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (y77) invokeV.objValue;
    }

    public final Function2<Context, g57, Unit> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.l;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<Context, y77, Boolean> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<g57, Boolean, Unit> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function1<g57, Unit> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k;
        }
        return (Function1) invokeV.objValue;
    }

    public final List<a87> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.j;
        }
        return (List) invokeV.objValue;
    }

    public final List<a87> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }
}
