package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<LoadDraftMessage.a> {
    private com.baidu.tieba.im.settingcache.a cfP;
    private int mCmd;

    public a(com.baidu.tieba.im.settingcache.a aVar, int i) {
        this.cfP = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadDraftMessage.a> customMessage) {
        String str;
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.mCmd);
        if (customMessage == null || !(customMessage instanceof LoadDraftMessage)) {
            return jx(this.mCmd);
        }
        LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
        if (TbadkCoreApplication.getCurrentAccountObj() == null) {
            str = "";
        } else {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        LoadDraftMessage.a data = loadDraftMessage.getData();
        com.baidu.tieba.im.pushNotify.a aO = this.cfP.aO(str, data.id);
        if (aO == null) {
            return jx(loadDraftMessage.getCmd());
        }
        String draft = aO.getDraft();
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

    private LoadDraftResponsedMessage jx(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }
}
