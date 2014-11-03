package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ d agQ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d dVar) {
        super(2001180);
        this.agQ = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.a.a aVar;
        int i;
        int i2;
        com.baidu.tieba.addresslist.a.a aVar2;
        com.baidu.tieba.addresslist.a.a aVar3;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            if (customResponsedMessage.getError() != 0) {
                this.agQ.showToast(customResponsedMessage.getErrorString());
                return;
            }
            this.agQ.agN = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
            aVar = this.agQ.agM;
            i = this.agQ.agN;
            aVar.dJ(i);
            i2 = this.agQ.agN;
            if (i2 > 0) {
                this.agQ.agO = false;
                aVar3 = this.agQ.agM;
                z = this.agQ.agO;
                aVar3.bj(z);
            }
            aVar2 = this.agQ.agM;
            aVar2.notifyDataSetChanged();
        }
    }
}
