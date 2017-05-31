package com.baidu.tieba.discover;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements CustomMessageTask.CustomRunnable<String> {
    final /* synthetic */ d bJp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bJp = dVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        ShareFromPBMsgData shareFromPBMsgData;
        if (customMessage != null) {
            shareFromPBMsgData = this.bJp.bJo;
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, shareFromPBMsgData);
        }
        return null;
    }
}
