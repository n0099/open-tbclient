package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.bk> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.core.atomData.bk> run(CustomMessage<com.baidu.tbadk.core.atomData.bk> customMessage) {
        UserData a;
        if (customMessage != null && customMessage.getData() != null && (a = customMessage.getData().a()) != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(a.getUserId()));
            com.baidu.tieba.im.e.a(new cv(this, linkedList), new cw(this, customMessage));
        }
        return null;
    }
}
