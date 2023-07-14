package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g75 extends w65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g75() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final void b(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, dialogInterface) == null) {
            m65.u("userIcon");
        }
    }

    @Override // com.baidu.tieba.w65
    public void a(Context context, o65 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!PollingModel.z0()) {
                m65.u("userIcon");
                return;
            }
            x9a x9aVar = new x9a();
            x9aVar.f(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.q65
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        g75.b(dialogInterface);
                    }
                }
            });
            x9aVar.d(TbSingleton.getInstance().getIconPopData());
            m65.n("userIcon");
        }
    }
}
