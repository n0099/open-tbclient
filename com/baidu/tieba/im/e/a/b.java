package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.r> {
    private com.baidu.tieba.im.settingcache.a bnk;
    private int mCmd;

    public b(com.baidu.tieba.im.settingcache.a aVar, int i) {
        this.bnk = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.r> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.mCmd);
        if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
            return null;
        }
        com.baidu.tieba.im.message.r data = customMessage.getData();
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        com.baidu.tieba.im.pushNotify.a aE = this.bnk.aE(str, data.mId);
        if (aE == null) {
            return null;
        }
        aE.setDraft(data.mDraft);
        this.bnk.a(aE);
        return customResponsedMessage;
    }
}
