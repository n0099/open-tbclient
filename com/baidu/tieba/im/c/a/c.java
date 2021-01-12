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
public abstract class c implements CustomMessageTask.CustomRunnable<LoadHistoryMessage.a> {
    private com.baidu.tieba.im.db.a kEl;
    private int mCmd;

    public c(com.baidu.tieba.im.db.a aVar, int i) {
        this.kEl = aVar;
        this.mCmd = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadHistoryMessage.a> customMessage) {
        if (customMessage == null || !(customMessage instanceof LoadHistoryMessage) || this.kEl == null) {
            return CW(this.mCmd);
        }
        LoadHistoryMessage.a data = customMessage.getData();
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(this.mCmd);
        LinkedList<ChatMessage> b2 = this.kEl.b(com.baidu.adp.lib.f.b.toLong(data.id, 0L), data.kAZ, data.kBa, data.limit);
        if (b2 == null) {
            return CW(this.mCmd);
        }
        LoadHistoryResponsedMessage.a aVar = new LoadHistoryResponsedMessage.a();
        if (data.kAZ == null) {
            aVar.isFirst = true;
        } else {
            aVar.isFirst = false;
        }
        aVar.id = data.id;
        aVar.msgList = b2;
        try {
            loadHistoryResponsedMessage.decodeInBackGround(CmdConfigCustom.CMD_LOAD_HISTORY, aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage CW(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
