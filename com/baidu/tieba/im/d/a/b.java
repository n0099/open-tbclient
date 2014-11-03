package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.p> {
    private com.baidu.tieba.im.pushNotify.b biI;
    private int mCmd;

    public b(com.baidu.tieba.im.pushNotify.b bVar, int i) {
        this.biI = bVar;
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
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        com.baidu.tieba.im.pushNotify.a am = this.biI.am(str, data.mId);
        if (am == null) {
            return null;
        }
        am.setDraft(data.mDraft);
        this.biI.a(am);
        return customResponsedMessage;
    }
}
