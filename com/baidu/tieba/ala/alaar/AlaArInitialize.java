package com.baidu.tieba.ala.alaar;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.i;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.minivideo.arface.a;
import com.baidu.tieba.ala.alaar.messages.AntiContentHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.GetArStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.GetPicTxtStickerListHttpResponseMessage;
import com.baidu.tieba.ala.alaar.messages.SetPicTxtStickerHttpResponseMessage;
import com.baidu.tieba.ala.alaar.sticker.view.b;
import com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView;
/* loaded from: classes4.dex */
public class AlaArInitialize {
    private static Context sContext;

    static {
        bJZ();
        bKa();
        bJU();
        bJX();
        bJV();
        bJW();
        bJY();
        TbConfig.AR_SDK_VERSION = a.getVersion();
    }

    public static Context getContext() {
        return sContext;
    }

    public static void bJU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021158, TbConfig.SERVER_HOST + "liveserver/sys/anticontent");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(AntiContentHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void bJV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021156, TbConfig.SERVER_HOST + "liveserver/sys/getstreamerstickers");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetPicTxtStickerListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void bJW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021206, TbConfig.SERVER_ADDRESS + "ala/sticker/setLiveSticker");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(SetPicTxtStickerHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bJX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913125, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.alaar.AlaArInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.aa.a> run(CustomMessage<Context> customMessage) {
                if (customMessage.getData() != null) {
                    return new CustomResponsedMessage<>(2913125, new b(customMessage.getData()));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bJY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913177, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.alaar.AlaArInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<i> run(CustomMessage<Context> customMessage) {
                if (customMessage.getData() != null) {
                    return new CustomResponsedMessage<>(2913177, new com.baidu.tieba.ala.alaar.a.a(customMessage.getData()));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void bJZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021155, TbConfig.SERVER_HOST + "liveserver/sys/getstickers");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetArStickerListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bKa() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913176, new CustomMessageTask.CustomRunnable<com.baidu.live.ar.a>() { // from class: com.baidu.tieba.ala.alaar.AlaArInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ILiveMultiBeautyView> run(CustomMessage<com.baidu.live.ar.a> customMessage) {
                Context unused = AlaArInitialize.sContext = customMessage.getData().aCN.getPageActivity().getApplicationContext();
                return new CustomResponsedMessage<>(2913176, new AlaLiveMultiBeautyArView(customMessage.getData().aCN.getPageActivity()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
