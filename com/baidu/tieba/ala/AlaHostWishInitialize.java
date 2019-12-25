package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.c.i;
import com.baidu.live.c.k;
import com.baidu.live.c.q;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class AlaHostWishInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.c.class, AlaChooseGiftActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(q.class, AlaWishListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(i.class, AlaLiveAddWishActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(k.class, AlaLiveWishListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.d.class, AlaDeleteWishActivity.class);
        aYL();
    }

    public static void aYL() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913144, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaHostWishInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.h.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913144, new com.baidu.tieba.ala.livewishlist.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
