package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.bc> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.core.atomData.bc> run(CustomMessage<com.baidu.tbadk.core.atomData.bc> customMessage) {
        UserData a;
        if (customMessage != null && customMessage.getData() != null && (a = customMessage.getData().a()) != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(a.getUserId()));
            com.baidu.tieba.im.i.a(new ct(this, linkedList), new cu(this, customMessage));
        }
        return null;
    }
}
