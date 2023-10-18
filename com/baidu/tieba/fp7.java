package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fp7 extends o05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fp7() {
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
    public void a(@NonNull Context context, @NonNull c05 c05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, c05Var) == null) {
            if (TbSingleton.getInstance().getFrsResponseData() == null) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧内屏蔽弹窗失败：当前没有FRS吧数据");
                YunDialogManager.unMarkShowingDialogName("frsShield");
            } else if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧内屏蔽弹窗失败：当前Activity非FrsActivity");
                YunDialogManager.unMarkShowingDialogName("frsShield");
            } else {
                FrsFragment r1 = ((FrsActivity) context).r1();
                if (!nq7.d(TbSingleton.getInstance().getFrsResponseData(), r1)) {
                    r1.p5(true);
                    YunDialogManager.unMarkShowingDialogName("frsShield");
                }
            }
        }
    }
}
