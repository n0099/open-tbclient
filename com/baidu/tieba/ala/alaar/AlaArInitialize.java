package com.baidu.tieba.ala.alaar;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.f;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.w.a;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.GetArStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.GetPicTxtStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.view.b;
import com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView;
/* loaded from: classes3.dex */
public class AlaArInitialize {
    static {
        bkd();
        bke();
        bjZ();
        bkb();
        bka();
        bkc();
    }

    public static void bjZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021158, TbConfig.SERVER_HOST + "liveserver/sys/anticontent");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AntiContentHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void bka() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021156, TbConfig.SERVER_HOST + "liveserver/sys/getstreamerstickers");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetPicTxtStickerListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bkb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913125, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.alaar.AlaArInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a> run(CustomMessage<Context> customMessage) {
                if (customMessage.getData() != null) {
                    return new CustomResponsedMessage<>(2913125, new b(customMessage.getData()));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bkc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913177, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.alaar.AlaArInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<f> run(CustomMessage<Context> customMessage) {
                if (customMessage.getData() != null) {
                    return new CustomResponsedMessage<>(2913177, new com.baidu.tieba.ala.alaar.a.a(customMessage.getData()));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void bkd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021155, TbConfig.SERVER_HOST + "liveserver/sys/getstickers");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetArStickerListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bke() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913176, new CustomMessageTask.CustomRunnable<com.baidu.live.ar.a>() { // from class: com.baidu.tieba.ala.alaar.AlaArInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ILiveMultiBeautyView> run(CustomMessage<com.baidu.live.ar.a> customMessage) {
                return new CustomResponsedMessage<>(2913176, new AlaLiveMultiBeautyArView(customMessage.getData().anM.getPageActivity()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
