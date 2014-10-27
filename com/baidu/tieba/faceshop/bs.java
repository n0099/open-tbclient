package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bs extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.b.a.b bVar;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2009502 && customResponsedMessage.getData() != null) {
            FaceshopStatic.auP = (com.baidu.tbadk.b.a.b) customResponsedMessage.getData();
            bVar = FaceshopStatic.auP;
            ((com.baidu.tbadk.b.a.b) customResponsedMessage.getData()).a(new bt(this, bVar.getContext(), cb.face_store, by.icon_more_store, cb.face_store_tip, 4));
        }
    }
}
