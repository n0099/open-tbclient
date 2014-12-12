package com.baidu.tbadk.game;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ b Zh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.Zh = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2001268, this.Zh.vx());
    }
}
