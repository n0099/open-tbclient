package com.baidu.tbadk.coreExtra.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class e implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof GetContactListRequestMessage)) {
            return null;
        }
        List<b> tk = i.tj().tk();
        if (tk != null) {
            Iterator<b> it = tk.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (com.baidu.adp.lib.util.k.isEmpty(next.getUserName()) || next.getUserType() == 1) {
                    it.remove();
                }
            }
        }
        GetContactListResponsedMessage getContactListResponsedMessage = new GetContactListResponsedMessage();
        getContactListResponsedMessage.setContacts(tk);
        return getContactListResponsedMessage;
    }
}
