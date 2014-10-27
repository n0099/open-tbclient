package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class g implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        boolean m;
        if (customMessage != null) {
            int cmd = customMessage.getCmd();
            if (customMessage.getData() != null && (cmd == 2001183 || cmd == 2001184)) {
                b bVar = (b) customMessage.getData();
                if (cmd == 2001183) {
                    m = i.pC().b(bVar);
                } else {
                    m = i.pC().m(bVar.getUserId());
                }
                if (!m) {
                    com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), true);
                }
            }
        }
        return null;
    }
}
