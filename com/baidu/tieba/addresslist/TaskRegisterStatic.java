package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivityConfig;
import com.baidu.tieba.addresslist.im.newFriend.ResponsePassFriendMessage;
/* loaded from: classes3.dex */
public class TaskRegisterStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AddressListActivityConfig.class, AddressListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewFriendsActivityConfig.class, NewFriendsActivity.class);
        com.baidu.tieba.im.c.b(304101, ResponsePassFriendMessage.class, false);
        MessageManager.getInstance().addResponsedMessageRule(new c());
        CustomMessageTask customMessageTask = new CustomMessageTask(2001322, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.addresslist.TaskRegisterStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2001322, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2902090));
    }
}
