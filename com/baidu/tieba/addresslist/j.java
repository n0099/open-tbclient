package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ e azl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(e eVar) {
        super(2001180);
        this.azl = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.a.a aVar;
        int i;
        com.baidu.tieba.addresslist.a.a aVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            if (customResponsedMessage.getError() != 0) {
                this.azl.showToast(customResponsedMessage.getErrorString());
                return;
            }
            this.azl.azj = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
            aVar = this.azl.azg;
            i = this.azl.azj;
            aVar.ez(i);
            aVar2 = this.azl.azg;
            aVar2.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
        }
    }
}
