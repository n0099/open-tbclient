package com.baidu.tieba.im;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
            boolean isNull = StringUtils.isNull(((AccountData) customResponsedMessage.getData()).getAccount());
            if (!isNull) {
                com.baidu.tbadk.coreExtra.messageCenter.a.yK().c(new com.baidu.tbadk.coreExtra.c.e());
                com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgLiveVip(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.yK().zc();
                t.GV();
                l.apQ().apy();
                com.baidu.tieba.im.db.k.apP().apy();
            }
            t.b(new d(this, isNull), new e(this));
        }
    }
}
