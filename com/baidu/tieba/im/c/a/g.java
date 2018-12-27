package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class g implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    private com.baidu.tieba.im.db.c fcf;
    private int mCmd;

    public g() {
        a(com.baidu.tieba.im.db.c.aRc(), 2001145);
    }

    private void a(com.baidu.tieba.im.db.c cVar, int i) {
        this.fcf = cVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage)) {
            return qG(this.mCmd);
        }
        if (this.fcf == null) {
            return qG(this.mCmd);
        }
        LoadHistoryMessage.a data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.mCmd);
        LinkedList<ChatMessage> b = this.fcf.b(data.id, data.eYY, data.eYZ, data.limit);
        if (b == null) {
            return qG(this.mCmd);
        }
        LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
        if (data.eYY == null) {
            aVar.isFirst = true;
        } else {
            aVar.isFirst = false;
        }
        aVar.msgList = b;
        aVar.id = data.id;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage qG(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
