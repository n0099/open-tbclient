package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ d aoY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d dVar) {
        super(2001180);
        this.aoY = dVar;
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
                this.aoY.showToast(customResponsedMessage.getErrorString());
                return;
            }
            this.aoY.aoV = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
            aVar = this.aoY.aoU;
            i = this.aoY.aoV;
            aVar.ej(i);
            i2 = this.aoY.aoV;
            if (i2 > 0) {
                this.aoY.aoW = false;
                aVar3 = this.aoY.aoU;
                z = this.aoY.aoW;
                aVar3.bk(z);
            }
            aVar2 = this.aoY.aoU;
            aVar2.notifyDataSetChanged();
        }
    }
}
