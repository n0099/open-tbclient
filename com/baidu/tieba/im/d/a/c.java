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
    private com.baidu.tieba.im.db.a a;
    private int b;

    public c(com.baidu.tieba.im.db.a aVar, int i) {
        this.a = aVar;
        this.b = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.c> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage) || this.a == null) {
            return a(this.b);
        }
        com.baidu.tieba.im.message.c data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.b);
        LinkedList<ChatMessage> a = this.a.a(com.baidu.adp.lib.f.b.a(data.d, 0L), data.a, data.b, data.c);
        if (a == null) {
            return a(this.b);
        }
        com.baidu.tieba.im.message.d dVar = new com.baidu.tieba.im.message.d();
        if (data.a == null) {
            dVar.c = true;
        } else {
            dVar.c = false;
        }
        dVar.a = data.d;
        dVar.b = a;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(2001105, dVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage a(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
