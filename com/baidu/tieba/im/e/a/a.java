package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.a> {
    private com.baidu.tieba.im.settingcache.a bqf;
    private int mCmd;

    public a(com.baidu.tieba.im.settingcache.a aVar, int i) {
        this.bqf = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.a> customMessage) {
        String str;
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.mCmd);
        if (customMessage == null || !(customMessage instanceof LoadDraftMessage)) {
            return gG(this.mCmd);
        }
        LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
        if (TbadkCoreApplication.getCurrentAccountObj() == null) {
            str = "";
        } else {
            str = TbadkCoreApplication.getCurrentAccountObj().getID();
        }
        com.baidu.tieba.im.message.a data = loadDraftMessage.getData();
        com.baidu.tieba.im.pushNotify.a aJ = this.bqf.aJ(str, data.id);
        if (aJ == null) {
            return gG(loadDraftMessage.getCmd());
        }
        String draft = aJ.getDraft();
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

    private LoadDraftResponsedMessage gG(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }
}
