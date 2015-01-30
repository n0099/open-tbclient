package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class at implements CustomMessageTask.CustomRunnable<AccountData> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<AccountData> customMessage) {
        if (com.baidu.adp.lib.util.l.ft()) {
            ao.a(customMessage.getData(), TbadkApplication.getInst().getApp());
            return null;
        } else if (ao.AP() != null) {
            ao.AP().handler.post(new au(this, customMessage));
            return null;
        } else {
            return null;
        }
    }
}
