package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.bu;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestGroupInfoMessage;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ f bhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, int i) {
        super(i);
        this.bhr = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo imMessageCenterPojo;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016014 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                RequestGroupInfoMessage requestGroupInfoMessage = new RequestGroupInfoMessage();
                requestGroupInfoMessage.setGroupId(com.baidu.adp.lib.g.c.a(imMessageCenterPojo.getGid(), 0L));
                MessageManager.getInstance().sendMessage(requestGroupInfoMessage);
            }
            com.baidu.tieba.im.c.b.Qv().b(com.baidu.adp.lib.g.c.a(imMessageCenterPojo.getGid(), 0L), bu.G(imMessageCenterPojo.getPulled_msgId()), 0L);
        }
    }
}
