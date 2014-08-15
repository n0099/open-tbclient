package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        boolean a;
        if (customMessage != null) {
            int cmd = customMessage.getCmd();
            if (customMessage.getData() != null && (cmd == 2001183 || cmd == 2001184)) {
                b bVar = (b) customMessage.getData();
                if (cmd == 2001183) {
                    a = h.a().a(bVar);
                } else {
                    a = h.a().a(bVar.c());
                }
                if (!a) {
                    com.baidu.tbadk.core.sharedPref.b.a().b("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), true);
                }
            }
        }
        return null;
    }
}
