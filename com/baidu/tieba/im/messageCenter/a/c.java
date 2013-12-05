package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        if (message == null || !(message instanceof LoadHistoryMessage)) {
            com.baidu.adp.lib.h.e.a("message error");
            return a(-105);
        }
        LoadHistoryMessage loadHistoryMessage = (LoadHistoryMessage) message;
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage();
        LinkedList<GroupMsgPojo> a2 = com.baidu.tieba.im.db.d.a().a(loadHistoryMessage.getGroupId(), loadHistoryMessage.getLastMsgId(), loadHistoryMessage.getLastRid(), loadHistoryMessage.getLimit());
        LinkedList linkedList = new LinkedList();
        if (a2 == null) {
            com.baidu.adp.lib.h.e.a("read DB error");
            return a(loadHistoryMessage.getCmd());
        }
        Iterator<GroupMsgPojo> it = a2.iterator();
        while (it.hasNext()) {
            linkedList.add(0, it.next().toChatMessage());
        }
        if (loadHistoryMessage.getLastMsgId() == null) {
            loadHistoryResponsedMessage.setIsFirst(true);
        } else {
            loadHistoryResponsedMessage.setIsFirst(false);
        }
        loadHistoryResponsedMessage.setGroupId(loadHistoryMessage.getGroupId());
        loadHistoryResponsedMessage.setMsgList(linkedList);
        return loadHistoryResponsedMessage;
    }

    private LoadHistoryResponsedMessage a(int i) {
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = new LoadHistoryResponsedMessage();
        loadHistoryResponsedMessage.setCmd(i);
        loadHistoryResponsedMessage.setErrNo(-18);
        return loadHistoryResponsedMessage;
    }
}
