package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        boolean K;
        if (customMessage != null) {
            int cmd = customMessage.getCmd();
            if (customMessage.getData() != null && (cmd == 2001183 || cmd == 2001184)) {
                com.baidu.tbadk.coreExtra.relationship.a aVar = (com.baidu.tbadk.coreExtra.relationship.a) customMessage.getData();
                if (cmd == 2001183) {
                    K = g.Gn().c(aVar);
                } else {
                    K = g.Gn().K(aVar.getUserId());
                }
                if (!K) {
                    com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
                }
            }
        }
        return null;
    }
}
