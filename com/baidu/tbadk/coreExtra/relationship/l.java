package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class l extends com.baidu.adp.framework.listener.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
            a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            com.baidu.tbadk.core.sharedPref.b.a().c("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), false);
            new o(addressListData).execute(new Void[0]);
        }
    }
}
