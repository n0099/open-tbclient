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
        List<b> pD = i.pC().pD();
        if (pD != null) {
            Iterator<b> it = pD.iterator();
            while (it.hasNext()) {
                if (com.baidu.adp.lib.util.l.aA(it.next().getUserName())) {
                    it.remove();
                }
            }
        }
        GetContactListResponsedMessage getContactListResponsedMessage = new GetContactListResponsedMessage();
        getContactListResponsedMessage.setContacts(pD);
        return getContactListResponsedMessage;
    }
}
