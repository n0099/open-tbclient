package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements CustomMessageTask.CustomRunnable<AccountData> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<AccountData> customMessage) {
        if (k.fH()) {
            a.xn().xr();
            return null;
        } else if (TbadkCoreApplication.m9getInst() != null) {
            TbadkCoreApplication.m9getInst().handler.post(new e(this));
            return null;
        } else {
            return null;
        }
    }
}
