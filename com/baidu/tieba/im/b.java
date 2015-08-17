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
                com.baidu.tbadk.coreExtra.messageCenter.a.wT().c(new com.baidu.tbadk.coreExtra.c.f());
                com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgLiveVip(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wT().xl();
                l.QD();
                com.baidu.tieba.im.db.l.Tk().SS();
                com.baidu.tieba.im.db.k.Tj().SS();
            }
            l.a(new c(this, isNull), new d(this));
        }
    }
}
