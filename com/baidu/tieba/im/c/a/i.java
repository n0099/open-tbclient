package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes7.dex */
public class i implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        int i = com.baidu.adp.lib.f.b.toInt(customMessage.getData(), 0);
        if (!com.baidu.tieba.im.db.l.cTL().LR(String.valueOf(i))) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_DEL_OFFICIAL_DB, String.valueOf(i));
    }
}
