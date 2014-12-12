package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.o;
/* loaded from: classes.dex */
class d implements g<Integer> {
    final /* synthetic */ b aPE;
    private final /* synthetic */ boolean aPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, boolean z) {
        this.aPE = bVar;
        this.aPF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: b */
    public void onReturnDataInUI(Integer num) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005018, null));
        if (!this.aPF) {
            com.baidu.tbadk.coreExtra.messageCenter.a.rI().c(new com.baidu.tbadk.coreExtra.c.h());
            com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgChat(0);
            com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgAtme(0);
            com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgFans(0);
            com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgGiftNum(0);
            com.baidu.tbadk.coreExtra.messageCenter.a.rI().rZ();
            i.JI();
            o.MO().Mr();
            n.MN().Mr();
        }
    }
}
