package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.RequestMarkReadedMessage;
/* loaded from: classes.dex */
public class d implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(MessageTypes.CMD_GROUP_MARK_READED);
        if (customMessage == null || !(customMessage instanceof RequestMarkReadedMessage)) {
            return null;
        }
        com.baidu.tieba.im.db.c.a().b(((RequestMarkReadedMessage) customMessage).getData());
        return customResponsedMessage;
    }
}
