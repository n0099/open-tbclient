package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class l implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        int i = com.baidu.adp.lib.g.c.toInt(customMessage.getData(), 0);
        if (!com.baidu.tieba.im.db.n.Nj().gq(String.valueOf(i))) {
            return null;
        }
        return new CustomResponsedMessage<>(2001155, String.valueOf(i));
    }
}
