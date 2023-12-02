package com.baidu.tieba;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l4b;
import com.baidu.tieba.tracker.core.monitors.PageTraceMonitor;
import com.baidu.tieba.z3b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f4b<R extends l4b> extends PageTraceMonitor<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity h;
    public final Function1<R, w3b> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f4b(FragmentActivity activity, R thisRef, Function1<? super R, w3b> traceHolderFactory) {
        super(thisRef, z3b.c.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, thisRef, traceHolderFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((l4b) objArr2[0], (z3b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(traceHolderFactory, "traceHolderFactory");
        this.h = activity;
        this.i = traceHolderFactory;
    }

    @Override // com.baidu.tieba.i4b
    public w3b d(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return this.i.invoke(thisRef);
        }
        return (w3b) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public Lifecycle n(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            try {
                Lifecycle lifecycle = this.h.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "activity.lifecycle");
                return lifecycle;
            } catch (IllegalStateException unused) {
                throw new IllegalStateException("Activity doesn 't have view associated with it or the view has been destroyed!");
            }
        }
        return (Lifecycle) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public String o(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return thisRef.z2();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public void p(Pair<String, String>... params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            k4b.a(this.h, (Pair[]) Arrays.copyOf(params, params.length));
        }
    }
}
