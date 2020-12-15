package com.baidu.tieba.ala.livecard;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.livecard.adapters.a;
import com.baidu.tieba.ala.livecard.adapters.c;
import com.baidu.tieba.ala.livecard.adapters.d;
import com.baidu.tieba.ala.livecard.adapters.e;
import com.baidu.tieba.ala.livecard.adapters.f;
import com.baidu.tieba.ala.livecard.adapters.g;
import com.baidu.tieba.ala.livecard.adapters.h;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ai;
/* loaded from: classes6.dex */
public class Static {
    static {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.ala.livecard.Static.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                        AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                        CustomMessage customMessage = (CustomMessage) customResponsedMessage.getOrginalMessage();
                        absDelegateAdapterList.add(new c(null, by.eJs, null));
                        absDelegateAdapterList.add(new h(null, by.eJr, null));
                        absDelegateAdapterList.add(new g(null, by.eJt, null));
                        absDelegateAdapterList.add(new a(null, com.baidu.tieba.tbadkCore.g.njy, null));
                        absDelegateAdapterList.add(new e(null, com.baidu.tieba.tbadkCore.h.njB, null));
                    }
                }
            });
            MessageManager.getInstance().registerListener(new CustomMessageListener(2003022) { // from class: com.baidu.tieba.ala.livecard.Static.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003022 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                        AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                        absDelegateAdapterList.add(new c(null, by.eJs, null));
                        absDelegateAdapterList.add(new f(null, by.eJr, null));
                        absDelegateAdapterList.add(new d(null, by.eJt, null));
                        absDelegateAdapterList.add(new f(null, com.baidu.tieba.tbadkCore.h.njB, null));
                    }
                }
            });
            MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_MODEL) { // from class: com.baidu.tieba.ala.livecard.Static.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof ah)) {
                        ah ahVar = (ah) customResponsedMessage.getData();
                        com.baidu.tieba.ala.livecard.models.a aVar = new com.baidu.tieba.ala.livecard.models.a();
                        aVar.setTag(ahVar.fzO);
                        ahVar.a(49, aVar);
                    }
                }
            });
            ai.cEj().Aj(49);
        }
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003390, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_FRS_NEGATIVE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        messageManager.registerTask(tbHttpMessageTask);
    }
}
