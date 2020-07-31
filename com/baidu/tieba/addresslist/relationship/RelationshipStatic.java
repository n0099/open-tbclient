package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes15.dex */
public class RelationshipStatic {
    public static String Tag = "tag";

    static {
        a(CmdConfigSocket.CMD_GET_ADDRESSLIST, ResponseGetAddressListMessage.class, false);
        a(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST, b.class);
        a(CmdConfigCustom.CMD_QUERY_CONTACT_LIST, c.class);
        a(CmdConfigCustom.CMD_INSERT_CONTACT, d.class);
        a(CmdConfigCustom.CMD_DELETE_CONTACT, d.class);
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.addresslist.relationship.RelationshipStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseOnlineMessage) && TbadkCoreApplication.getCurrentAccount() != null && !TbadkCoreApplication.getInst().checkInterrupt() && com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), true)) {
                    MessageManager.getInstance().sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
                }
            }
        });
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_GET_ADDRESSLIST) { // from class: com.baidu.tieba.addresslist.relationship.RelationshipStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                    a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), false);
                    new i(addressListData).execute(new Void[0]);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.addresslist.relationship.RelationshipStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                    ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                    if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                        com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                        aVar.yS(responseNewFriendUpdateUiMsg.getKey());
                        aVar.setQuanpin(responseNewFriendUpdateUiMsg.getQuanping());
                        aVar.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        aVar.setUserName(responseNewFriendUpdateUiMsg.getName());
                        aVar.es(responseNewFriendUpdateUiMsg.getPortrait());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_INSERT_CONTACT, aVar));
                    } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                        com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                        aVar2.setUserId(responseNewFriendUpdateUiMsg.getFriendId());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_CONTACT, aVar2));
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CLOSE_ALL_ACTIVITY) { // from class: com.baidu.tieba.addresslist.relationship.RelationshipStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2002014) {
                    h.bsZ();
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
