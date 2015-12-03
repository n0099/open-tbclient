package com.baidu.tieba.homepage.fragment.controller;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class s implements CustomMessageTask.CustomRunnable<Void> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
        if (customMessage == null) {
            return null;
        }
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "friend_feed_tip_show", true);
        return new CustomResponsedMessage<>(CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW);
    }
}
