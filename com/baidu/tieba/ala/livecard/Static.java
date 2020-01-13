package com.baidu.tieba.ala.livecard;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.livecard.adapters.a;
import com.baidu.tieba.ala.livecard.adapters.c;
import com.baidu.tieba.ala.livecard.adapters.d;
import com.baidu.tieba.ala.livecard.adapters.e;
import com.baidu.tieba.ala.livecard.adapters.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.g;
/* loaded from: classes2.dex */
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
                        absDelegateAdapterList.add(new c(null, bj.cNx, null));
                        absDelegateAdapterList.add(new f(null, bj.cNw, null));
                        absDelegateAdapterList.add(new e(null, bj.cNy, null));
                        absDelegateAdapterList.add(new a(null, com.baidu.tieba.tbadkCore.f.kdd, null));
                        absDelegateAdapterList.add(new d(null, g.kdg, null));
                    }
                }
            });
            MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_MODEL) { // from class: com.baidu.tieba.ala.livecard.Static.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof z)) {
                        z zVar = (z) customResponsedMessage.getData();
                        com.baidu.tieba.ala.livecard.models.a aVar = new com.baidu.tieba.ala.livecard.models.a();
                        aVar.setTag(zVar.dxg);
                        zVar.a(49, aVar);
                    }
                }
            });
            aa.bDZ().sU(49);
        }
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003390, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_FRS_NEGATIVE_URL);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        messageManager.registerTask(tbHttpMessageTask);
    }
}
