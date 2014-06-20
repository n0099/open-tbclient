package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2010016) {
            a.f().d();
            a.f().b((ImMessageCenterShowItemData) null);
            a.f().d((ImMessageCenterShowItemData) null);
            a.f().c((ImMessageCenterShowItemData) null);
            a.f().b(false, (com.baidu.tieba.im.a<Void>) null);
            BdSocketLinkService.startService(true, "clear cache");
        }
    }
}
