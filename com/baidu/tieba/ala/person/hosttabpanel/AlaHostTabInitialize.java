package com.baidu.tieba.ala.person.hosttabpanel;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.liveroom.d.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.person.hosttabpanel.message.AlaNewHostTabHttpResponseMessage;
/* loaded from: classes4.dex */
public class AlaHostTabInitialize {
    static {
        registerTask();
        bOo();
    }

    private static void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021076, TbConfig.SERVER_ADDRESS + "ala/user/getUserInfoWithRecord");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaNewHostTabHttpResponseMessage.class);
        MessageManager.getInstance().unRegisterTask(1021076);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bOo() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.person.hosttabpanel.AlaHostTabInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof a)) {
                    a aVar = (a) customResponsedMessage.getData();
                    if (aVar.aYG != null && aVar.aYG.context != null) {
                        aVar.a(new com.baidu.tieba.ala.person.hosttabpanel.d.a((TbPageContext) IScrollableHelper.getBbPageContext(aVar.aYG.context)));
                    }
                }
            }
        });
    }
}
