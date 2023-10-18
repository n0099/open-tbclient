package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bp7 extends o05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bp7() {
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

    @Override // com.baidu.tieba.o05
    public void a(Context context, c05 data) {
        tq7 Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧务管理弹窗失败：当前Activity非FrsActivity");
                YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
                return;
            }
            FrsActivity frsActivity = (FrsActivity) context;
            if (frsActivity.w1() != null && frsActivity.w1().Z() != null) {
                pk7 w1 = frsActivity.w1();
                if (w1 != null && (Z = w1.Z()) != null) {
                    Z.i();
                    return;
                }
                return;
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧务管理弹窗失败：tabController或guideHelper为空");
            YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
        }
    }
}
