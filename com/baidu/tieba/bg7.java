package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.component.uistate.CardStaggeredVideoUiStateKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bg7 extends z47 implements oa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b57 g;
    public final y47 h;
    public final aj7 i;
    public final boolean j;
    public final boolean k;
    public final String l;
    public final Function2<Context, bg7, Unit> m;
    public final Function2<Context, l67, Unit> n;
    public final Function2<Context, bg7, Unit> o;
    public final Function2<Context, bg7, Unit> p;
    public boolean q;
    public boolean r;
    public WeakReference<cg7> s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg7(b57 videoUiState, y47 y47Var, aj7 authorData, boolean z, boolean z2, String str, String str2, Function2<? super Context, ? super bg7, Unit> onCommentClick, Function2<? super Context, ? super l67, Unit> onTagClick, Map<String, String> businessInfo, Map<String, String> logInfo, Function2<? super Context, ? super bg7, Unit> onManageClick, Function2<? super Context, ? super bg7, Unit> onSelectClick) {
        super(businessInfo, logInfo, null, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoUiState, y47Var, authorData, Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, onCommentClick, onTagClick, businessInfo, logInfo, onManageClick, onSelectClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Map) objArr2[0], (Map) objArr2[1], (Function2) objArr2[2], (Function1) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(videoUiState, "videoUiState");
        Intrinsics.checkNotNullParameter(authorData, "authorData");
        Intrinsics.checkNotNullParameter(onCommentClick, "onCommentClick");
        Intrinsics.checkNotNullParameter(onTagClick, "onTagClick");
        Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
        Intrinsics.checkNotNullParameter(logInfo, "logInfo");
        Intrinsics.checkNotNullParameter(onManageClick, "onManageClick");
        Intrinsics.checkNotNullParameter(onSelectClick, "onSelectClick");
        this.g = videoUiState;
        this.h = y47Var;
        this.i = authorData;
        this.j = z;
        this.k = z2;
        this.l = str;
        this.m = onCommentClick;
        this.n = onTagClick;
        this.o = onManageClick;
        this.p = onSelectClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ bg7(b57 b57Var, y47 y47Var, aj7 aj7Var, boolean z, boolean z2, String str, String str2, Function2 function2, Function2 function22, Map map, Map map2, Function2 function23, Function2 function24, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(b57Var, y47Var, aj7Var, r7, r8, str, str2, r11, r12, map, map2, r15, r16);
        boolean z3;
        boolean z4;
        Function2 function25;
        Function2 function26;
        Function2 function27;
        Function2 function28;
        Function2 function29;
        Function2 function210;
        Function2 function211;
        Function2 function212;
        if ((i & 8) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 16) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if ((i & 128) != 0) {
            function212 = CardStaggeredVideoUiStateKt.c;
            function25 = function212;
        } else {
            function25 = function2;
        }
        if ((i & 256) != 0) {
            function211 = CardStaggeredVideoUiStateKt.d;
            function26 = function211;
        } else {
            function26 = function22;
        }
        if ((i & 2048) != 0) {
            function210 = CardStaggeredVideoUiStateKt.a;
            function27 = function210;
        } else {
            function27 = function23;
        }
        if ((i & 4096) != 0) {
            function29 = CardStaggeredVideoUiStateKt.b;
            function28 = function29;
        } else {
            function28 = function24;
        }
    }

    @Override // com.baidu.tieba.oa7
    public void d(Object event) {
        WeakReference<cg7> weakReference;
        cg7 cg7Var;
        cg7 cg7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof x57) {
                x57 x57Var = (x57) event;
                if (this.q != x57Var.a()) {
                    boolean a = x57Var.a();
                    this.q = a;
                    if (!a) {
                        this.r = false;
                    }
                    WeakReference<cg7> weakReference2 = this.s;
                    if (weakReference2 != null && (cg7Var2 = weakReference2.get()) != null) {
                        cg7Var2.a(this);
                    }
                }
            }
            if ((event instanceof tj7) && (weakReference = this.s) != null && (cg7Var = weakReference.get()) != null) {
                cg7Var.a(this);
            }
        }
    }

    public final aj7 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return (aj7) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public final Function2<Context, bg7, Unit> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<Context, bg7, Unit> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<Context, bg7, Unit> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.p;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<Context, l67, Unit> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return (Function2) invokeV.objValue;
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final y47 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (y47) invokeV.objValue;
    }

    public final b57 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (b57) invokeV.objValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public final boolean z() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            List<h87> e = this.i.e();
            if (e != null && !e.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            return !z;
        }
        return invokeV.booleanValue;
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.r = z;
        }
    }

    public final void y(WeakReference<cg7> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, weakReference) == null) {
            this.s = weakReference;
        }
    }
}
