package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class j extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
            a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), false);
            new m(addressListData).execute(new Void[0]);
        }
    }
}
