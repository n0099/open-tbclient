package com.baidu.tieba;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jja;
import com.baidu.tieba.tracker.core.monitors.PageTraceMonitor;
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
public final class eja<R extends jja> extends PageTraceMonitor<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Fragment e;
    public final Function1<R, yia> f;

    public eja(Fragment fragment, Function1<? super R, yia> traceHolderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment, traceHolderFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(traceHolderFactory, "traceHolderFactory");
        this.e = fragment;
        this.f = traceHolderFactory;
    }

    @Override // com.baidu.tieba.fja
    public yia c(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return this.f.invoke(thisRef);
        }
        return (yia) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public Lifecycle g(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            try {
                Lifecycle lifecycle = this.e.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "fragment.lifecycle");
                return lifecycle;
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Fragment doesn 't have view associated with it or the view has been destroyed!", e);
            }
        }
        return (Lifecycle) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public void i(Pair<String, String>... params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            ija.b(this.e, (Pair[]) Arrays.copyOf(params, params.length));
        }
    }

    @Override // com.baidu.tieba.tracker.core.monitors.PageTraceMonitor
    public String h(R thisRef) {
        InterceptResult invokeL;
        Fragment parentFragment;
        jja jjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Fragment fragment = this.e;
            if (fragment != null && (parentFragment = fragment.getParentFragment()) != null) {
                if (parentFragment instanceof jja) {
                    jjaVar = (jja) parentFragment;
                } else {
                    jjaVar = null;
                }
                if (jjaVar != null) {
                    return jjaVar.getScene();
                }
            }
            return thisRef.getScene();
        }
        return (String) invokeL.objValue;
    }
}
