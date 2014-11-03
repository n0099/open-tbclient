package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.a> {
    private com.baidu.tieba.im.pushNotify.b biI;
    private int mCmd;

    public a(com.baidu.tieba.im.pushNotify.b bVar, int i) {
        this.biI = bVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.a> customMessage) {
        String str;
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.mCmd);
        if (customMessage == null || !(customMessage instanceof LoadDraftMessage)) {
            return gk(this.mCmd);
        }
        LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
        if (TbadkApplication.getCurrentAccountObj() == null) {
            str = "";
        } else {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        com.baidu.tieba.im.message.a data = loadDraftMessage.getData();
        com.baidu.tieba.im.pushNotify.a am = this.biI.am(str, data.id);
        if (am == null) {
            return gk(loadDraftMessage.getCmd());
        }
        String draft = am.getDraft();
        com.baidu.tieba.im.message.b bVar = new com.baidu.tieba.im.message.b();
        bVar.mDraft = draft;
        bVar.id = data.id;
        try {
            loadDraftResponsedMessage.decodeInBackGround(this.mCmd, bVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadDraftResponsedMessage;
    }

    private LoadDraftResponsedMessage gk(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }
}
