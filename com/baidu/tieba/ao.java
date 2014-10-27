package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements CustomMessageTask.CustomRunnable<AccountData> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<AccountData> customMessage) {
        if (com.baidu.adp.lib.util.m.fu()) {
            aj.a(customMessage.getData(), TbadkApplication.m251getInst());
            return null;
        } else if (aj.wk() != null) {
            aj.wk().handler.post(new ap(this, customMessage));
            return null;
        } else {
            return null;
        }
    }
}
