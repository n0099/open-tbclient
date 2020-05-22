package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.c.j;
import com.baidu.live.c.l;
import com.baidu.live.c.r;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.message.AlaGetWishListResponseMessage;
import com.baidu.tieba.ala.message.AlaUpdateWishListResponseMessage;
/* loaded from: classes3.dex */
public class AlaHostWishInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.c.class, AlaChooseGiftActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(r.class, AlaWishListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(j.class, AlaLiveAddWishActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(l.class, AlaLiveWishListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.d.class, AlaDeleteWishActivity.class);
        boS();
        boT();
        boU();
        boV();
        boW();
    }

    public static void boS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913149, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaHostWishInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.i.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913149, new com.baidu.tieba.ala.livewishlist.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void boT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021165, TbConfig.SERVER_HOST + "liveserver/wishlist/getwishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaGetWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void boU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021168, TbConfig.SERVER_HOST + "liveserver/wishlist/updatewishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaUpdateWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void boV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021169, TbConfig.SERVER_HOST + "liveserver/wishlist/updatewishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaUpdateWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void boW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021170, TbConfig.SERVER_HOST + "liveserver/wishlist/updatewishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AlaUpdateWishListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
