package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    private com.baidu.tieba.im.db.c kMF;
    private int mCmd;

    public f() {
        a(com.baidu.tieba.im.db.c.cVz(), CmdConfigCustom.CMD_LOAD_HISTORY_GROUP);
    }

    private void a(com.baidu.tieba.im.db.c cVar, int i) {
        this.kMF = cVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage)) {
            return Dn(this.mCmd);
        }
        if (this.kMF == null) {
            return Dn(this.mCmd);
        }
        LoadHistoryMessage.a data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.mCmd);
        LinkedList<ChatMessage> j = this.kMF.j(data.id, data.kJs, data.kJt, data.limit);
        if (j == null) {
            return Dn(this.mCmd);
        }
        LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
        if (data.kJs == null) {
            aVar.isFirst = true;
        } else {
            aVar.isFirst = false;
        }
        aVar.msgList = j;
        aVar.id = data.id;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(CmdConfigCustom.CMD_LOAD_HISTORY, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage Dn(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
