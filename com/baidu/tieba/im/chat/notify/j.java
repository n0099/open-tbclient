package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements CustomMessageTask.CustomRunnable<AccountData> {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.a = dVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<AccountData> customMessage) {
        this.a.i();
        return null;
    }
}
