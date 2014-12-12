package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.p> {
    private com.baidu.tieba.im.settingcache.a bnY;
    private int mCmd;

    public b(com.baidu.tieba.im.settingcache.a aVar, int i) {
        this.bnY = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.p> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.mCmd);
        if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
            return null;
        }
        com.baidu.tieba.im.message.p data = customMessage.getData();
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        com.baidu.tieba.im.pushNotify.a aD = this.bnY.aD(str, data.mId);
        if (aD == null) {
            return null;
        }
        aD.setDraft(data.mDraft);
        this.bnY.a(aD);
        return customResponsedMessage;
    }
}
