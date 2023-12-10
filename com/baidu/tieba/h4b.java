package com.baidu.tieba;

import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m4b;
import com.baidu.tieba.tracker.core.data.AbsEventNode;
import com.baidu.tieba.tracker.core.data.TraceEventNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h4b<R extends m4b> extends j4b<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function1<R, x3b> h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h4b(R obj, a4b traceType, Function1<? super R, x3b> traceHolderFactory) {
        super(obj, traceType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, traceType, traceHolderFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((m4b) objArr2[0], (a4b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(traceType, "traceType");
        Intrinsics.checkNotNullParameter(traceHolderFactory, "traceHolderFactory");
        this.h = traceHolderFactory;
    }

    @Override // com.baidu.tieba.j4b
    @MainThread
    public AbsEventNode a(R thisRef, a4b traceType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, thisRef, traceType)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(traceType, "traceType");
            return new TraceEventNode(thisRef.z2(), thisRef.l2(), traceType);
        }
        return (AbsEventNode) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.j4b
    public x3b d(R thisRef) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thisRef)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            return this.h.invoke(thisRef);
        }
        return (x3b) invokeL.objValue;
    }
}
