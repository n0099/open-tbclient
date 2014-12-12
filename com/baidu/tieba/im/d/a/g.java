package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class g implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.c> {
    private com.baidu.tieba.im.db.c boa;
    private int mCmd;

    public g() {
        a(com.baidu.tieba.im.db.c.Mu(), 2001149);
    }

    private void a(com.baidu.tieba.im.db.c cVar, int i) {
        this.boa = cVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.c> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage)) {
            return gy(this.mCmd);
        }
        if (this.boa == null) {
            return gy(this.mCmd);
        }
        com.baidu.tieba.im.message.c data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.mCmd);
        LinkedList<ChatMessage> a = this.boa.a(data.id, data.bhN, data.bhO, data.limit);
        if (a == null) {
            return gy(this.mCmd);
        }
        d dVar = new d();
        if (data.bhN == null) {
            dVar.isFirst = true;
        } else {
            dVar.isFirst = false;
        }
        dVar.msgList = a;
        dVar.id = data.id;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(2001105, dVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage gy(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
