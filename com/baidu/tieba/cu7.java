package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class cu7 extends w65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cu7() {
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

    @Override // com.baidu.tieba.w65
    public void a(Context context, o65 data) {
        tv7 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示吧务管理弹窗失败：当前Activity非FrsActivity");
                m65.u("frsNewUserGuide");
                return;
            }
            FrsActivity frsActivity = (FrsActivity) context;
            if (frsActivity.x1() != null && frsActivity.x1().b0() != null) {
                jp7 x1 = frsActivity.x1();
                if (x1 != null && (b0 = x1.b0()) != null) {
                    b0.i();
                    return;
                }
                return;
            }
            YunDialogLog.getInstance().b("YunDialogManager", "展示吧务管理弹窗失败：tabController或guideHelper为空");
            m65.u("frsNewUserGuide");
        }
    }
}
