package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class g implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    private com.baidu.tieba.im.db.c cbr;
    private int mCmd;

    public g() {
        a(com.baidu.tieba.im.db.c.Yi(), CmdConfigCustom.CMD_LOAD_HISTORY_GROUP);
    }

    private void a(com.baidu.tieba.im.db.c cVar, int i) {
        this.cbr = cVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage)) {
            return jb(this.mCmd);
        }
        if (this.cbr == null) {
            return jb(this.mCmd);
        }
        LoadHistoryMessage.a data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.mCmd);
        LinkedList<ChatMessage> b = this.cbr.b(data.id, data.bYn, data.bYo, data.limit);
        if (b == null) {
            return jb(this.mCmd);
        }
        LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
        if (data.bYn == null) {
            aVar.isFirst = true;
        } else {
            aVar.isFirst = false;
        }
        aVar.msgList = b;
        aVar.id = data.id;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(CmdConfigCustom.CMD_LOAD_HISTORY, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage jb(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
