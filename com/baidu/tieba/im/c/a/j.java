package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.OfficialFeedHeadResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class j implements CustomMessageTask.CustomRunnable<OfficialFeedHeadResponsedMessage.a> {
    private int mCmd = 2001154;
    private com.baidu.tieba.im.db.l kMG = com.baidu.tieba.im.db.l.cVQ();

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<OfficialFeedHeadResponsedMessage.a> customMessage) {
        if (this.kMG == null) {
            return Dn(this.mCmd);
        }
        List<com.baidu.tieba.im.db.pojo.a> cVS = com.baidu.tieba.im.db.l.cVS();
        if (cVS == null || cVS.size() <= 0) {
            return Dn(this.mCmd);
        }
        HashMap hashMap = new HashMap(cVS.size());
        for (com.baidu.tieba.im.db.pojo.a aVar : cVS) {
            hashMap.put(aVar.getGid(), aVar);
        }
        LinkedList<ChatMessage> c = this.kMG.c(hashMap, 80);
        if (c == null) {
            return Dn(this.mCmd);
        }
        OfficialFeedHeadResponsedMessage.a aVar2 = new OfficialFeedHeadResponsedMessage.a();
        OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = new OfficialFeedHeadResponsedMessage(this.mCmd);
        aVar2.kJv = c;
        aVar2.msgList = cVS;
        try {
            officialFeedHeadResponsedMessage.decodeInBackGround(CmdConfigCustom.CMD_LOAD_HISTORY, aVar2);
            return officialFeedHeadResponsedMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return officialFeedHeadResponsedMessage;
        }
    }

    private LoadHistoryResponsedMessage Dn(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
