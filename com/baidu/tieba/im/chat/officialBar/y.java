package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements CustomMessageTask.CustomRunnable<OfficalBarChatActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<OfficalBarChatActivityConfig> run(CustomMessage<OfficalBarChatActivityConfig> customMessage) {
        UserData userData;
        if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(userData.getUserId()));
            com.baidu.tieba.im.l.a(new z(this, linkedList), new aa(this, customMessage));
        }
        return null;
    }
}
