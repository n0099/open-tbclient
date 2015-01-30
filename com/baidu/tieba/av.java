package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class av implements CustomMessageTask.CustomRunnable<AccountData> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<AccountData> customMessage) {
        com.baidu.tbadk.coreExtra.messageCenter.a.rY().av(true);
        com.baidu.tieba.tbadkCore.util.j.aiu();
        com.baidu.tbadk.browser.a.Q(TbadkCoreApplication.m255getInst());
        return null;
    }
}
