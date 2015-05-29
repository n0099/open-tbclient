package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.r;
/* loaded from: classes.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<r> {
    private com.baidu.tieba.im.settingcache.a bqf;
    private int mCmd;

    public b(com.baidu.tieba.im.settingcache.a aVar, int i) {
        this.bqf = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<r> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.mCmd);
        if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
            return null;
        }
        r data = customMessage.getData();
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        com.baidu.tieba.im.pushNotify.a aJ = this.bqf.aJ(str, data.mId);
        if (aJ == null) {
            return null;
        }
        aJ.setDraft(data.mDraft);
        this.bqf.a(aJ);
        return customResponsedMessage;
    }
}
