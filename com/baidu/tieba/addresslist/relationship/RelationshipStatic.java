package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes3.dex */
public class RelationshipStatic {
    static {
        a(304001, ResponseGetAddressListMessage.class, false);
        a(2001178, b.class);
        a(2001184, c.class);
        a(2001179, d.class);
        a(2001180, d.class);
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.addresslist.relationship.RelationshipStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseOnlineMessage) && TbadkCoreApplication.getCurrentAccount() != null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    MessageManager.getInstance().sendMessage(new RequestGetAddressListMessage(304001));
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(304001) { // from class: com.baidu.tieba.addresslist.relationship.RelationshipStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), false);
                    new i(addressListData).execute(new Void[0]);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001174) { // from class: com.baidu.tieba.addresslist.relationship.RelationshipStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                    ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                    if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                        com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                        aVar.gH(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.gG(responseNewFriendUpdateUiMsg.getPortrait());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001179, aVar));
                    } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                        com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                        aVar2.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001180, aVar2));
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2002014) { // from class: com.baidu.tieba.addresslist.relationship.RelationshipStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2002014) {
                    h.VJ();
                }
            }
        });
    }

    private static void a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tieba.im.c.b(i, cls, z);
    }

    private static void a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        com.baidu.tieba.im.c.b(i, cls);
    }
}
