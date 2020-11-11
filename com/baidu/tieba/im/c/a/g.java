package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class g implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    private com.baidu.tieba.im.db.c kpo;
    private int mCmd;

    public g() {
        a(com.baidu.tieba.im.db.c.cQU(), CmdConfigCustom.CMD_LOAD_HISTORY_GROUP);
    }

    private void a(com.baidu.tieba.im.db.c cVar, int i) {
        this.kpo = cVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage)) {
            return Dw(this.mCmd);
        }
        if (this.kpo == null) {
            return Dw(this.mCmd);
        }
        LoadHistoryMessage.a data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.mCmd);
        LinkedList<ChatMessage> e = this.kpo.e(data.id, data.kma, data.kmb, data.limit);
        if (e == null) {
            return Dw(this.mCmd);
        }
        LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
        if (data.kma == null) {
            aVar.isFirst = true;
        } else {
            aVar.isFirst = false;
        }
        aVar.msgList = e;
        aVar.id = data.id;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(CmdConfigCustom.CMD_LOAD_HISTORY, aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage Dw(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
