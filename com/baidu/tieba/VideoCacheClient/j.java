package com.baidu.tieba.VideoCacheClient;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.play.x;
/* loaded from: classes.dex */
class j implements CustomMessageTask.CustomRunnable<x> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<x> run(CustomMessage<x> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, c.KK());
    }
}
