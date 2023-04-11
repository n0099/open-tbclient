package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.hi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class eg7 extends k15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public eg7() {
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

    @Override // com.baidu.tieba.k15
    public void a(@NonNull Context context, @NonNull b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, b15Var) == null) {
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前Activity非FrsActivity");
                z05.r("frsGroupChatGuide");
                return;
            }
            FrsFragment t1 = ((FrsActivity) context).t1();
            if (t1 == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前FrsFragment为空");
                z05.r("frsGroupChatGuide");
                return;
            }
            hi5.b M3 = t1.M3();
            if (M3 == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前OptFragment为空");
                z05.r("frsGroupChatGuide");
                return;
            }
            M3.U0();
            z05.l("frsGroupChatGuide");
        }
    }
}
