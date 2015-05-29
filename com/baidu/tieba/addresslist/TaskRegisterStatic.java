package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
/* loaded from: classes.dex */
public class TaskRegisterStatic {
    static {
        com.baidu.tieba.im.e.b(304101, ResponsePassFriendMessage.class, false);
        MessageManager.getInstance().addResponsedMessageRule(new l());
        CustomMessageTask customMessageTask = new CustomMessageTask(2001329, new u());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
