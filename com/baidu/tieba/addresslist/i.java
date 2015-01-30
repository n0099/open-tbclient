package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ d apb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d dVar) {
        super(2001180);
        this.apb = dVar;
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
                this.apb.showToast(customResponsedMessage.getErrorString());
                return;
            }
            this.apb.aoY = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
            aVar = this.apb.aoX;
            i = this.apb.aoY;
            aVar.ej(i);
            i2 = this.apb.aoY;
            if (i2 > 0) {
                this.apb.aoZ = false;
                aVar3 = this.apb.aoX;
                z = this.apb.aoZ;
                aVar3.bk(z);
            }
            aVar2 = this.apb.aoX;
            aVar2.notifyDataSetChanged();
        }
    }
}
