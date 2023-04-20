package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.ii5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fg7 extends l15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fg7() {
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

    @Override // com.baidu.tieba.l15
    public void a(@NonNull Context context, @NonNull c15 c15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, c15Var) == null) {
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前Activity非FrsActivity");
                a15.r("frsGroupChatGuide");
                return;
            }
            FrsFragment t1 = ((FrsActivity) context).t1();
            if (t1 == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前FrsFragment为空");
                a15.r("frsGroupChatGuide");
                return;
            }
            ii5.b M3 = t1.M3();
            if (M3 == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前OptFragment为空");
                a15.r("frsGroupChatGuide");
                return;
            }
            M3.U0();
            a15.l("frsGroupChatGuide");
        }
    }
}
