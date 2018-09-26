package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof GetContactListRequestMessage)) {
            return null;
        }
        List<com.baidu.tbadk.coreExtra.relationship.a> TC = f.TB().TC();
        if (TC != null) {
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = TC.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if ((k.isEmpty(next.getUserName()) && k.isEmpty(next.GM())) || next.getUserType() == 1) {
                    it.remove();
                }
            }
        }
        GetContactListResponsedMessage getContactListResponsedMessage = new GetContactListResponsedMessage();
        getContactListResponsedMessage.setContacts(TC);
        return getContactListResponsedMessage;
    }
}
