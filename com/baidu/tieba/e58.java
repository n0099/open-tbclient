package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.message.UpgradePopWindowMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e58 extends m15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e58() {
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

    @Override // com.baidu.tieba.m15
    public void a(@NonNull Context context, @NonNull a15 a15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, a15Var) == null) {
            if (!(context instanceof i25)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "FRS升级弹窗失败：获取到的IForumDialogExtSupport为空");
                YunDialogManager.unMarkShowingDialogName("frsUpgrade");
                return;
            }
            UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, TbadkCoreApplication.getInst().getCurrentPageContext(context));
            upgradePopWindowMessage.setFromPage("frs");
            MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
        }
    }
}
