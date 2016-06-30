package com.baidu.tbadk.game;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ b atI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.atI = bVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, this.atI.CF());
    }
}
