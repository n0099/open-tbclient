package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
/* loaded from: classes.dex */
public class a implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.a> {
    private com.baidu.tieba.im.pushNotify.o a;
    private int b;

    public a(com.baidu.tieba.im.pushNotify.o oVar, int i) {
        this.a = oVar;
        this.b = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.a> customMessage) {
        String str;
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.b);
        if (customMessage == null || !(customMessage instanceof LoadDraftMessage)) {
            return a(this.b);
        }
        LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
        if (TbadkApplication.getCurrentAccountObj() == null) {
            str = "";
        } else {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        com.baidu.tieba.im.message.a data = loadDraftMessage.getData();
        com.baidu.tieba.im.pushNotify.n b = this.a.b(str, data.a);
        if (b == null) {
            return a(loadDraftMessage.getCmd());
        }
        String draft = b.getDraft();
        com.baidu.tieba.im.message.b bVar = new com.baidu.tieba.im.message.b();
        bVar.a = draft;
        bVar.b = data.a;
        try {
            loadDraftResponsedMessage.decodeInBackGround(this.b, bVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadDraftResponsedMessage;
    }

    private LoadDraftResponsedMessage a(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
        loadDraftResponsedMessage.setError(-18);
        return loadDraftResponsedMessage;
    }
}
