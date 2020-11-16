package com.baidu.tieba.ala.live;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityConfig;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityOpaqueConfig;
import com.baidu.live.tbadk.core.data.PayChannelData;
import com.baidu.live.tbadk.pay.channel.interfaces.IChannelPayController;
/* loaded from: classes4.dex */
public class AlaSdkWalletInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PayWalletActivityConfig.class, AlaSdkWalletActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PayWalletActivityOpaqueConfig.class, AlaSdkWalletOpaqueActivity.class);
        bTR();
    }

    private static void bTR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913197, new CustomMessageTask.CustomRunnable<PayChannelData>() { // from class: com.baidu.tieba.ala.live.AlaSdkWalletInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<IChannelPayController> run(CustomMessage<PayChannelData> customMessage) {
                Log.d(IChannelPayController.TAG, "-->registerChannelPayTask run");
                return new CustomResponsedMessage<>(2913197, new a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        Log.d(IChannelPayController.TAG, "-->registerChannelPayTask");
    }
}
