package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h implements CustomMessageTask.CustomRunnable<com.baidu.tieba.im.message.c> {
    private com.baidu.tieba.im.db.c a;
    private int b;

    public h() {
        a(com.baidu.tieba.im.db.c.a(), MessageTypes.CMD_LOAD_HISTORY_GROUP);
    }

    private void a(com.baidu.tieba.im.db.c cVar, int i) {
        this.a = cVar;
        this.b = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tieba.im.message.c> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage)) {
            BdLog.e("message error");
            return a(this.b);
        } else if (this.a == null) {
            return a(this.b);
        } else {
            com.baidu.tieba.im.message.c data = customMessage.getData();
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.b);
            LinkedList<ChatMessage> a = this.a.a(data.d, data.a, data.b, data.c);
            if (a == null) {
                BdLog.e("read DB error");
                return a(this.b);
            }
            com.baidu.tieba.im.message.d dVar = new com.baidu.tieba.im.message.d();
            if (data.a == null) {
                dVar.c = true;
            } else {
                dVar.c = false;
            }
            dVar.b = a;
            dVar.a = data.d;
            try {
                loadHistoryResponsedMessage.decodeInBackGround(MessageTypes.CMD_LOAD_HISTORY, dVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return loadHistoryResponsedMessage;
        }
    }

    private LoadHistoryResponsedMessage a(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
