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
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().c(new com.baidu.tbadk.coreExtra.c.h());
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgLiveVip(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().wb();
                l.OR();
                n.RB().Rj();
                com.baidu.tieba.im.db.m.RA().Rj();
            }
            l.a(new c(this, isNull), new d(this));
        }
    }
}
