package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.jja;
import com.baidu.tieba.tracker.core.data.AbsEventNode;
import com.baidu.tieba.tracker.core.data.ErrCode;
import com.baidu.tieba.tracker.core.data.TraceEventNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class fja<R extends jja> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public R a;
    public AbsEventNode b;
    public final Handler c;
    public final Runnable d;

    @MainThread
    public abstract AbsEventNode a(R r);

    @MainThread
    public abstract yia c(R r);

    public fja() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new Handler(Looper.getMainLooper());
        this.d = new Runnable() { // from class: com.baidu.tieba.cja
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    fja.d(fja.this);
                }
            }
        };
    }

    public static final void d(fja this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b(TuplesKt.to(StatConstants.KEY_EXT_ERR_CODE, ErrCode.TIME_OUT.getValue()));
        }
    }

    @MainThread
    public final void b(Pair<String, String>... params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.c.removeCallbacks(this.d);
            R r = this.a;
            if (r != null) {
                TraceEventNode traceEventNode = new TraceEventNode(r.getFrom(), r.getScene(), null, null, 12, null);
                traceEventNode.getTrackParams().putAll(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
                c(r).c(traceEventNode);
                hja.a(this, r.getTraceId());
            }
            this.a = null;
        }
    }

    @MainThread
    public final void f(Pair<String, String>... params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.c.removeCallbacks(this.d);
            R r = this.a;
            if (r != null) {
                TraceEventNode traceEventNode = new TraceEventNode(r.getFrom(), r.getScene(), null, null, 12, null);
                traceEventNode.getTrackParams().putAll(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
                c(r).c(traceEventNode);
                hja.a(this, r.getTraceId());
            }
            this.a = null;
        }
    }

    @MainThread
    public final AbsEventNode e(R thisRef, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, thisRef, j)) == null) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            this.a = thisRef;
            AbsEventNode absEventNode = this.b;
            if (absEventNode != null) {
                return absEventNode;
            }
            if (j > 0) {
                this.c.postDelayed(this.d, j);
            }
            AbsEventNode a = a(thisRef);
            c(thisRef).c(a);
            this.b = a;
            Intrinsics.checkNotNull(a);
            return a;
        }
        return (AbsEventNode) invokeLJ.objValue;
    }
}
