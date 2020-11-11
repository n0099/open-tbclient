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
/* loaded from: classes26.dex */
public class l implements CustomMessageTask.CustomRunnable<OfficialFeedHeadResponsedMessage.a> {
    private int mCmd = 2001154;
    private com.baidu.tieba.im.db.l kpp = com.baidu.tieba.im.db.l.cRl();

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<OfficialFeedHeadResponsedMessage.a> customMessage) {
        if (this.kpp == null) {
            return Dw(this.mCmd);
        }
        List<com.baidu.tieba.im.db.pojo.a> cRn = com.baidu.tieba.im.db.l.cRn();
        if (cRn == null || cRn.size() <= 0) {
            return Dw(this.mCmd);
        }
        HashMap hashMap = new HashMap(cRn.size());
        for (com.baidu.tieba.im.db.pojo.a aVar : cRn) {
            hashMap.put(aVar.getGid(), aVar);
        }
        LinkedList<ChatMessage> b = this.kpp.b(hashMap, 80);
        if (b == null) {
            return Dw(this.mCmd);
        }
        OfficialFeedHeadResponsedMessage.a aVar2 = new OfficialFeedHeadResponsedMessage.a();
        OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = new OfficialFeedHeadResponsedMessage(this.mCmd);
        aVar2.kmd = b;
        aVar2.msgList = cRn;
        try {
            officialFeedHeadResponsedMessage.decodeInBackGround(CmdConfigCustom.CMD_LOAD_HISTORY, aVar2);
            return officialFeedHeadResponsedMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return officialFeedHeadResponsedMessage;
        }
    }

    private LoadHistoryResponsedMessage Dw(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage(i);
        loadHistoryResponsedMessage.setError(-18);
        return loadHistoryResponsedMessage;
    }
}
