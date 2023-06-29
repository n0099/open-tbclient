package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.xo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gp7 extends n65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gp7() {
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

    @Override // com.baidu.tieba.n65
    public void a(@NonNull Context context, @NonNull f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, f65Var) == null) {
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前Activity非FrsActivity");
                d65.s("frsGroupChatGuide");
                return;
            }
            FrsFragment v1 = ((FrsActivity) context).v1();
            if (v1 == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前FrsFragment为空");
                d65.s("frsGroupChatGuide");
                return;
            }
            xo5.b O3 = v1.O3();
            if (O3 == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前OptFragment为空");
                d65.s("frsGroupChatGuide");
            } else if (!O3.Y0()) {
                d65.s("frsGroupChatGuide");
            }
        }
    }
}
