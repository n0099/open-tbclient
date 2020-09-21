package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes20.dex */
public class c implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof GetContactListRequestMessage)) {
            return null;
        }
        List<com.baidu.tbadk.coreExtra.relationship.a> bDg = f.bDf().bDg();
        if (bDg != null) {
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = bDg.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if ((k.isEmpty(next.getUserName()) && k.isEmpty(next.bqp())) || next.getUserType() == 1) {
                    it.remove();
                }
            }
        }
        GetContactListResponsedMessage getContactListResponsedMessage = new GetContactListResponsedMessage();
        getContactListResponsedMessage.setContacts(bDg);
        return getContactListResponsedMessage;
    }
}
