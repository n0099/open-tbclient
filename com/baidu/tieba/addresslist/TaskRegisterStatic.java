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
import d.b.j0.e1.c;
import d.b.j0.q.b;
/* loaded from: classes4.dex */
public class TaskRegisterStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<>(2001322, new d.b.j0.q.a());
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(AddressListActivityConfig.class, AddressListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewFriendsActivityConfig.class, NewFriendsActivity.class);
        c.b(304101, ResponsePassFriendMessage.class, false);
        MessageManager.getInstance().addResponsedMessageRule(new b());
        CustomMessageTask customMessageTask = new CustomMessageTask(2001322, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
