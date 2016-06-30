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
                com.baidu.tbadk.coreExtra.messageCenter.a.xn().c(new com.baidu.tbadk.coreExtra.d.e());
                com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgLiveVip(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xn().xF();
                t.FJ();
                l.amU().amD();
                com.baidu.tieba.im.db.k.amT().amD();
            }
            t.b(new d(this, isNull), new e(this));
        }
    }
}
