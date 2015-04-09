package com.baidu.tieba.im;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.im.db.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
            boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
            if (!isNull) {
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().c(new com.baidu.tbadk.coreExtra.c.h());
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vr();
                l.NC();
                n.Qm().PU();
                com.baidu.tieba.im.db.m.Ql().PU();
            }
            l.a(new c(this, isNull), new d(this));
        }
    }
}
