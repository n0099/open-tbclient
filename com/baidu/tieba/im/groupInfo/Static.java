package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tieba.im.message.MemoryUpdateHeadNameMessage;
import com.baidu.tieba.im.message.RequestGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* loaded from: classes3.dex */
public class Static {
    static {
        MessageManager.getInstance().registerListener(103004, new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupInfo.Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                ResponseGroupInfoMessage responseGroupInfoMessage;
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103004 && (responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage) != null && responseGroupInfoMessage.getData() != null) {
                    ResponseGroupInfoLocalMessage.a data = responseGroupInfoMessage.getData();
                    if (data.getGroup() != null) {
                        MemoryUpdateHeadNameMessage.a aVar = new MemoryUpdateHeadNameMessage.a();
                        aVar.customGroupType = 1;
                        aVar.id = String.valueOf(data.getGroup().getGroupId());
                        aVar.name = data.getGroup().getName();
                        aVar.head = data.getGroup().getPortrait();
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryUpdateHeadNameMessage(aVar));
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001280) { // from class: com.baidu.tieba.im.groupInfo.Static.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (longValue != 0) {
                        RequestGroupInfoMessage requestGroupInfoMessage = new RequestGroupInfoMessage();
                        LocalViewSize.ImageSize yH = LocalViewSize.yF().yH();
                        LocalViewSize.ImageSize yI = LocalViewSize.yF().yI();
                        requestGroupInfoMessage.setBigHeight(yI.height);
                        requestGroupInfoMessage.setBigWidth(yI.width);
                        requestGroupInfoMessage.setSmallHeight(yH.height);
                        requestGroupInfoMessage.setSmallWidth(yH.width);
                        requestGroupInfoMessage.setGroupId(longValue);
                        MessageManager.getInstance().sendMessage(requestGroupInfoMessage);
                    }
                }
            }
        });
    }
}
