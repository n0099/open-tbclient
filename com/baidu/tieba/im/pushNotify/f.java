package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestGetGroupInfoMessage;
import com.baidu.tieba.im.util.h;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ d boO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.boO = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo imMessageCenterPojo;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016014 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestGetGroupInfoMessage(Long.valueOf(com.baidu.adp.lib.g.c.c(imMessageCenterPojo.getGid(), 0L))));
            }
            com.baidu.tieba.im.b.b.Ug().a(com.baidu.adp.lib.g.c.c(imMessageCenterPojo.getGid(), 0L), h.ah(imMessageCenterPojo.getPulled_msgId()), 0L, true, imMessageCenterPojo.getCustomGroupType());
        }
    }
}
