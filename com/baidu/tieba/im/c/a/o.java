package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.im.chat.officialBar.RequestLocalHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseLocalHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.bb;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes.dex */
public class o implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestLocalHistoryMessage)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.a.a.a().a("tb.im_official_history").a(String.valueOf(TbadkApplication.getCurrentAccount()) + "@" + ((RequestLocalHistoryMessage) customMessage).getData());
        if (a == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        try {
            QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(a, QueryHistoryMsgResIdl.class);
            if (queryHistoryMsgResIdl.data.res != null) {
                for (MsgInfo msgInfo : queryHistoryMsgResIdl.data.res) {
                    bb bbVar = new bb();
                    if (msgInfo != null) {
                        Date date = new Date();
                        date.setTime(msgInfo.sendTime.longValue() * 1000);
                        bbVar.a = ba.c(date);
                        bbVar.b = msgInfo.type.intValue();
                        bbVar.c = msgInfo.content;
                        bbVar.d = msgInfo.id.intValue();
                        linkedList.add(bbVar);
                    }
                }
            }
            return new ResponseLocalHistoryMessage(linkedList);
        } catch (Exception e) {
            return null;
        }
    }
}
