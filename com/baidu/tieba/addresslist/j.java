package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ e azm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(e eVar) {
        super(2001180);
        this.azm = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.a.a aVar;
        int i;
        com.baidu.tieba.addresslist.a.a aVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            if (customResponsedMessage.getError() != 0) {
                this.azm.showToast(customResponsedMessage.getErrorString());
                return;
            }
            this.azm.azk = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
            aVar = this.azm.azh;
            i = this.azm.azk;
            aVar.ez(i);
            aVar2 = this.azm.azh;
            aVar2.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
        }
    }
}
