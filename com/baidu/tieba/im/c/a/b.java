package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes2.dex */
public abstract class b implements CustomMessageTask.CustomRunnable<SaveDraftMessage.a> {
    private com.baidu.tieba.im.settingcache.a jzl;
    private int mCmd;

    public b(com.baidu.tieba.im.settingcache.a aVar, int i) {
        this.jzl = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<SaveDraftMessage.a> customMessage) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.mCmd);
        if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
            return null;
        }
        SaveDraftMessage.a data = customMessage.getData();
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        ChatSetting eS = this.jzl.eS(str, data.mId);
        if (eS == null) {
            return null;
        }
        eS.setDraft(data.mDraft);
        this.jzl.a(eS);
        return customResponsedMessage;
    }
}
