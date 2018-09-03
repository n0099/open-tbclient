package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    private com.baidu.tieba.im.db.a eCf;
    private int mCmd;

    public c(com.baidu.tieba.im.db.a aVar, int i) {
        this.eCf = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage) || this.eCf == null) {
            return oE(this.mCmd);
        }
        LoadHistoryMessage.a data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.mCmd);
        LinkedList<ChatMessage> b = this.eCf.b(com.baidu.adp.lib.g.b.c(data.id, 0L), data.eyZ, data.eza, data.limit);
        if (b == null) {
            return oE(this.mCmd);
        }
        LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
        if (data.eyZ == null) {
            aVar.isFirst = true;
        } else {
            aVar.isFirst = false;
        }
        aVar.id = data.id;
        aVar.msgList = b;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(2001105, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage oE(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
