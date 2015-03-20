package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class k implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        int i = com.baidu.adp.lib.g.c.toInt(customMessage.getData(), 0);
        if (!com.baidu.tieba.im.db.m.PY().gq(String.valueOf(i))) {
            return null;
        }
        return new CustomResponsedMessage<>(2001155, String.valueOf(i));
    }
}
