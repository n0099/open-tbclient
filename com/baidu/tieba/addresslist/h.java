package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d dVar) {
        super(2001180);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.a.a aVar;
        int i;
        int i2;
        com.baidu.tieba.addresslist.a.a aVar2;
        com.baidu.tieba.addresslist.a.a aVar3;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            if (customResponsedMessage.getError() != 0) {
                this.a.b(customResponsedMessage.getErrorString());
                return;
            }
            this.a.n = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
            aVar = this.a.m;
            i = this.a.n;
            aVar.a(i);
            i2 = this.a.n;
            if (i2 > 0) {
                this.a.o = false;
                aVar3 = this.a.m;
                z = this.a.o;
                aVar3.a(z);
            }
            aVar2 = this.a.m;
            aVar2.notifyDataSetChanged();
        }
    }
}
