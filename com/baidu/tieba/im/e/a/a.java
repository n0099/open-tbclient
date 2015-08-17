package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<LoadDraftMessage.a> {
    private com.baidu.tieba.im.settingcache.a bDT;
    private int mCmd;

    public a(com.baidu.tieba.im.settingcache.a aVar, int i) {
        this.bDT = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadDraftMessage.a> customMessage) {
        String str;
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.mCmd);
        if (customMessage == null || !(customMessage instanceof LoadDraftMessage)) {
            return hk(this.mCmd);
        }
        LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
        if (TbadkCoreApplication.getCurrentAccountObj() == null) {
            str = "";
        } else {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        LoadDraftMessage.a data = loadDraftMessage.getData();
        com.baidu.tieba.im.pushNotify.a aJ = this.bDT.aJ(str, data.id);
        if (aJ == null) {
            return hk(loadDraftMessage.getCmd());
        }
        String draft = aJ.getDraft();
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

    private LoadDraftResponsedMessage hk(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }
}
