package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes3.dex */
public class k implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        int h = com.baidu.adp.lib.g.b.h(customMessage.getData(), 0);
        if (!com.baidu.tieba.im.db.l.aIp().nf(String.valueOf(h))) {
            return null;
        }
        return new CustomResponsedMessage<>(2001151, String.valueOf(h));
    }
}
