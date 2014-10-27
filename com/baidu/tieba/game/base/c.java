package com.baidu.tieba.game.base;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        t<byte[]> bc;
        if (customMessage instanceof CacheReadRequest) {
            String data = ((CacheReadRequest) customMessage).getData();
            if (!StringUtils.isNull(data) && (bc = com.baidu.tbadk.core.a.a.kS().bc("tb.game_center_list")) != null) {
                return new CacheReadResponse(bc.get(data));
            }
            return null;
        }
        return null;
    }
}
