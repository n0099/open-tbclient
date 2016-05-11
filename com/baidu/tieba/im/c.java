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
                com.baidu.tbadk.coreExtra.messageCenter.a.xi().c(new com.baidu.tbadk.coreExtra.d.e());
                com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgLiveVip(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.xi().xA();
                t.FA();
                l.aeD().aem();
                com.baidu.tieba.im.db.k.aeC().aem();
            }
            t.b(new d(this, isNull), new e(this));
        }
    }
}
