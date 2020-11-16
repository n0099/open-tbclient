package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivityConfig;
import com.baidu.tieba.addresslist.im.newFriend.ResponsePassFriendMessage;
import com.baidu.tieba.im.c;
/* loaded from: classes20.dex */
public class TaskRegisterStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(AddressListActivityConfig.class, AddressListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewFriendsActivityConfig.class, NewFriendsActivity.class);
        c.b(CmdConfigSocket.CMD_PASS_NEW_FRIEND, ResponsePassFriendMessage.class, false);
        MessageManager.getInstance().addResponsedMessageRule(new b());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ADDRESS_LIST_RES_TOOL, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.addresslist.TaskRegisterStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ADDRESS_LIST_RES_TOOL, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
