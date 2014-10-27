package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class m extends com.baidu.adp.framework.listener.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
            a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), false);
            new p(addressListData).execute(new Void[0]);
        }
    }
}
