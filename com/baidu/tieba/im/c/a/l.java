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
/* loaded from: classes20.dex */
public class l implements CustomMessageTask.CustomRunnable<OfficialFeedHeadResponsedMessage.a> {
    private int mCmd = 2001154;
    private com.baidu.tieba.im.db.l jzo = com.baidu.tieba.im.db.l.cEn();

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<OfficialFeedHeadResponsedMessage.a> customMessage) {
        if (this.jzo == null) {
            return BJ(this.mCmd);
        }
        List<com.baidu.tieba.im.db.pojo.a> cEp = com.baidu.tieba.im.db.l.cEp();
        if (cEp == null || cEp.size() <= 0) {
            return BJ(this.mCmd);
        }
        HashMap hashMap = new HashMap(cEp.size());
        for (com.baidu.tieba.im.db.pojo.a aVar : cEp) {
            hashMap.put(aVar.getGid(), aVar);
        }
        LinkedList<ChatMessage> b = this.jzo.b(hashMap, 80);
        if (b == null) {
            return BJ(this.mCmd);
        }
        OfficialFeedHeadResponsedMessage.a aVar2 = new OfficialFeedHeadResponsedMessage.a();
        OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = new OfficialFeedHeadResponsedMessage(this.mCmd);
        aVar2.jwb = b;
        aVar2.msgList = cEp;
        try {
            officialFeedHeadResponsedMessage.decodeInBackGround(CmdConfigCustom.CMD_LOAD_HISTORY, aVar2);
            return officialFeedHeadResponsedMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return officialFeedHeadResponsedMessage;
        }
    }

    private LoadHistoryResponsedMessage BJ(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
