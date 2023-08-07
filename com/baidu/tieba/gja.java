package com.baidu.tieba;

import android.util.Log;
import com.baidu.tieba.tracker.Tracker;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class gja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Object obj, final String tid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, obj, tid) == null) {
            Intrinsics.checkNotNullParameter(obj, "<this>");
            Intrinsics.checkNotNullParameter(tid, "tid");
            final IEventNode b = wia.a.a(tid).b();
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append("\nonEvent：" + tid);
                for (IEventNode iEventNode = b; iEventNode != null; iEventNode = iEventNode.getNext()) {
                    sb.append("\nvalue = " + iEventNode);
                }
                sb.append("\n------------------------------------------------------");
                Log.d("lt-log", sb.toString());
                aja.b.a().c(new zia(tid, new Runnable() { // from class: com.baidu.tieba.fja
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            gja.b(tid, b);
                        }
                    }
                }));
                wia.a.b(tid);
            }
        }
    }

    public static final void b(String tid, IEventNode iEventNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tid, iEventNode) == null) {
            Intrinsics.checkNotNullParameter(tid, "$tid");
            Tracker.d.d(tid, iEventNode);
        }
    }
}
