package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ d aog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d dVar) {
        super(2001180);
        this.aog = dVar;
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
                this.aog.showToast(customResponsedMessage.getErrorString());
                return;
            }
            this.aog.aod = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
            aVar = this.aog.aoc;
            i = this.aog.aod;
            aVar.ed(i);
            i2 = this.aog.aod;
            if (i2 > 0) {
                this.aog.aoe = false;
                aVar3 = this.aog.aoc;
                z = this.aog.aoe;
                aVar3.bi(z);
            }
            aVar2 = this.aog.aoc;
            aVar2.notifyDataSetChanged();
        }
    }
}
