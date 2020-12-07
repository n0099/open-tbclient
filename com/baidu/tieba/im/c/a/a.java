package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<LoadDraftMessage.a> {
    private com.baidu.tieba.im.settingcache.a kDs;
    private int mCmd;

    public a(com.baidu.tieba.im.settingcache.a aVar, int i) {
        this.kDs = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadDraftMessage.a> customMessage) {
        String str;
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.mCmd);
        if (customMessage == null || !(customMessage instanceof LoadDraftMessage)) {
            return EI(this.mCmd);
        }
        LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
        if (TbadkCoreApplication.getCurrentAccountObj() == null) {
            str = "";
        } else {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        LoadDraftMessage.a data = loadDraftMessage.getData();
        ChatSetting fx = this.kDs.fx(str, data.id);
        if (fx == null) {
            return EI(loadDraftMessage.getCmd());
        }
        String draft = fx.getDraft();
        LoadDraftResponsedMessage.a aVar = new LoadDraftResponsedMessage.a();
        aVar.mDraft = draft;
        aVar.id = data.id;
        try {
            loadDraftResponsedMessage.decodeInBackGround(this.mCmd, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadDraftResponsedMessage;
    }

    private LoadDraftResponsedMessage EI(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }
}
