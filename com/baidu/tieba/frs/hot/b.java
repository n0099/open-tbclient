package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class b implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        byte[] gL = new a().gL(customMessage.getData());
        FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = new FrsHotThreadResponseCacheMessage();
        try {
            frsHotThreadResponseCacheMessage.decodeInBackGround(CmdConfigCustom.CMD_FRS_HOT_CACHE, gL);
        } catch (Exception e) {
            BdLog.e(e);
        }
        return frsHotThreadResponseCacheMessage;
    }
}
