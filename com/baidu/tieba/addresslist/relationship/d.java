package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes8.dex */
public class d implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        boolean eX;
        if (customMessage != null) {
            int cmd = customMessage.getCmd();
            if (customMessage.getData() != null && (cmd == 2001179 || cmd == 2001180)) {
                com.baidu.tbadk.coreExtra.relationship.a aVar = (com.baidu.tbadk.coreExtra.relationship.a) customMessage.getData();
                if (cmd == 2001179) {
                    eX = f.bMn().c(aVar);
                } else {
                    eX = f.bMn().eX(aVar.getUserId());
                }
                if (!eX) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.GET_ADDRESSLIST_SWITCH + TbadkCoreApplication.getCurrentAccount(), true);
                }
            }
        }
        return null;
    }
}
