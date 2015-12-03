package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
/* loaded from: classes.dex */
public class TaskRegisterStatic {
    static {
        com.baidu.tieba.im.e.b(304101, ResponsePassFriendMessage.class, false);
        MessageManager.getInstance().addResponsedMessageRule(new h());
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ADDRESS_LIST_RES_TOOL, new n());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS));
    }
}
