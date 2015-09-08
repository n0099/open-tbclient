package com.baidu.tieba.im;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
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
                com.baidu.tbadk.coreExtra.messageCenter.a.wZ().c(new com.baidu.tbadk.coreExtra.c.f());
                com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgLiveVip(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xr();
                l.QF();
                com.baidu.tieba.im.db.l.Tm().SU();
                com.baidu.tieba.im.db.k.Tl().SU();
            }
            l.a(new c(this, isNull), new d(this));
        }
    }
}
