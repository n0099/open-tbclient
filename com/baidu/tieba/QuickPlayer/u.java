package com.baidu.tieba.QuickPlayer;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class u implements CustomMessageTask.CustomRunnable<com.baidu.tieba.play.w> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.play.w> run(CustomMessage<com.baidu.tieba.play.w> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, new s());
    }
}
