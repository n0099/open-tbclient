package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        boolean bU;
        if (customMessage != null) {
            int cmd = customMessage.getCmd();
            if (customMessage.getData() != null && (cmd == 2001179 || cmd == 2001180)) {
                com.baidu.tbadk.coreExtra.relationship.a aVar = (com.baidu.tbadk.coreExtra.relationship.a) customMessage.getData();
                if (cmd == 2001179) {
                    bU = f.aDH().c(aVar);
                } else {
                    bU = f.aDH().bU(aVar.getUserId());
                }
                if (!bU) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
                }
            }
        }
        return null;
    }
}
