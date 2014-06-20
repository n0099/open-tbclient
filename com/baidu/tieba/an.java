package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements CustomMessageTask.CustomRunnable<AccountData> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<AccountData> customMessage) {
        if (com.baidu.adp.lib.util.k.c()) {
            ai.a(customMessage.getData(), TbadkApplication.m252getInst());
            return null;
        } else if (ai.c() != null) {
            ai.c().b.post(new ao(this, customMessage));
            return null;
        } else {
            return null;
        }
    }
}
