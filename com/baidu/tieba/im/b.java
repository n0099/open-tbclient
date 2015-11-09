package com.baidu.tieba.im;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.l;
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
                com.baidu.tbadk.coreExtra.messageCenter.a.wM().c(new com.baidu.tbadk.coreExtra.d.e());
                com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgChat(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgAtme(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgFans(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgGiftNum(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgLiveVip(0);
                com.baidu.tbadk.coreExtra.messageCenter.a.wM().xe();
                m.Eu();
                l.Ul().TT();
                k.Uk().TT();
            }
            m.b(new c(this, isNull), new d(this));
        }
    }
}
