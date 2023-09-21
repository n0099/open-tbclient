package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.up5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fu7 extends g65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fu7() {
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

    @Override // com.baidu.tieba.g65
    public void a(@NonNull Context context, @NonNull u55 u55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, u55Var) == null) {
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示群聊引导弹窗失败：当前Activity非FrsActivity");
                YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
                return;
            }
            FrsFragment r1 = ((FrsActivity) context).r1();
            if (r1 == null) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示群聊引导弹窗失败：当前FrsFragment为空");
                YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
                return;
            }
            up5.b m4 = r1.m4();
            if (m4 == null) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示群聊引导弹窗失败：当前OptFragment为空");
                YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
            } else if (!m4.p1()) {
                r1.o5(true);
                YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
            }
        }
    }
}
