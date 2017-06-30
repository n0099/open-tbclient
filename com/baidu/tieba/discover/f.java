package com.baidu.tieba.discover;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ e bPN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bPN = eVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        ShareFromPBMsgData shareFromPBMsgData;
        if (customMessage != null) {
            shareFromPBMsgData = this.bPN.bPM;
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, shareFromPBMsgData);
        }
        return null;
    }
}
