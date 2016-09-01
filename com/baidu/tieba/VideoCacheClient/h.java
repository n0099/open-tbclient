package com.baidu.tieba.VideoCacheClient;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class h implements CustomMessageTask.CustomRunnable<com.baidu.tieba.play.e> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.play.e> run(CustomMessage<com.baidu.tieba.play.e> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, c.JM());
    }
}
