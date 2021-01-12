package com.baidu.tieba.hottopicselect;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes7.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        HotSelectCacheResponseMessage hotSelectCacheResponseMessage = null;
        if (customMessage != null && (customMessage instanceof HotSelectCacheReqMessage)) {
            hotSelectCacheResponseMessage = new HotSelectCacheResponseMessage();
            try {
                hotSelectCacheResponseMessage.decodeInBackGround(CmdConfigCustom.CMD_HOT_TOPIC_SELECT_CACHE, (byte[]) null);
            } catch (Exception e) {
            }
        }
        return hotSelectCacheResponseMessage;
    }
}
