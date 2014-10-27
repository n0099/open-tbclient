package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.c> {
    private com.baidu.tieba.im.db.a biv;
    private int mCmd;

    public c(com.baidu.tieba.im.db.a aVar, int i) {
        this.biv = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.c> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage) || this.biv == null) {
            return gl(this.mCmd);
        }
        com.baidu.tieba.im.message.c data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.mCmd);
        LinkedList<ChatMessage> a = this.biv.a(com.baidu.adp.lib.g.c.a(data.id, 0L), data.beg, data.beh, data.limit);
        if (a == null) {
            return gl(this.mCmd);
        }
        com.baidu.tieba.im.message.d dVar = new com.baidu.tieba.im.message.d();
        if (data.beg == null) {
            dVar.isFirst = true;
        } else {
            dVar.isFirst = false;
        }
        dVar.id = data.id;
        dVar.msgList = a;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(2001105, dVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage gl(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
