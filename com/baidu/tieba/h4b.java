package com.baidu.tieba;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l4b;
import com.baidu.tieba.tracker.core.monitors.PageTraceMonitor;
import com.baidu.tieba.tracker.ext.FragmentExtKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h4b<R extends l4b> extends PageTraceMonitor<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Fragment h;
    public final Function1<R, w3b> i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h4b(Fragment fragment, R thisRef, z3b traceType, Function1<? super R, w3b> traceHolderFactory) {
        super(thisRef, traceType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment, thisRef, traceType, traceHolderFactory};
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
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(traceType, "traceType");
        Intrinsics.checkNotNullParameter(traceHolderFactory, "traceHolderFactory");
        this.h = fragment;
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
                Intrinsics.checkNotNullExpressionValue(lifecycle, "fragment.lifecycle");
                return lifecycle;
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Fragment doesn 't have view associated with it or the view has been destroyed!", e);
            }
        }
        return (Lifecycle) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public void p(Pair<String, String>... params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            FragmentExtKt.a(this.h, (Pair[]) Arrays.copyOf(params, params.length));
        }
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public String o(R thisRef) {
        InterceptResult invokeL;
        l4b l4bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Fragment parentFragment = this.h.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment instanceof l4b) {
                    l4bVar = (l4b) parentFragment;
                } else {
                    l4bVar = null;
                }
                if (l4bVar != null) {
                    return l4bVar.z2();
                }
            }
            return thisRef.z2();
        }
        return (String) invokeL.objValue;
    }
}
