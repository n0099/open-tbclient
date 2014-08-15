package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* loaded from: classes.dex */
class k extends com.baidu.adp.framework.listener.d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseOnlineMessage) && TbadkApplication.getCurrentAccount() != null && com.baidu.tbadk.core.sharedPref.b.a().a("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), true)) {
            MessageManager.getInstance().sendMessage(new RequestGetAddressListMessage(304001));
        }
    }
}
