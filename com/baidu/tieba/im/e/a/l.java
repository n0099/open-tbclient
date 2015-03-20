package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.im.chat.officialBar.RequestLocalHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseLocalHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.au;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes.dex */
public class l implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestLocalHistoryMessage)) {
            return null;
        }
        byte[] bArr = com.baidu.tbadk.core.b.a.rc().bW("tb.im_official_history").get(String.valueOf(TbadkApplication.getCurrentAccount()) + "@" + ((RequestLocalHistoryMessage) customMessage).getData());
        if (bArr == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        try {
            QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHistoryMsgResIdl.class);
            if (queryHistoryMsgResIdl.data.res != null) {
                for (MsgInfo msgInfo : queryHistoryMsgResIdl.data.res) {
                    au auVar = new au();
                    if (msgInfo != null) {
                        Date date = new Date();
                        date.setTime(msgInfo.sendTime.longValue() * 1000);
                        auVar.time = bd.c(date);
                        auVar.type = msgInfo.type.intValue();
                        auVar.content = msgInfo.content;
                        auVar.id = msgInfo.id.intValue();
                        linkedList.add(auVar);
                    }
                }
            }
            return new ResponseLocalHistoryMessage(linkedList);
        } catch (Exception e) {
            return null;
        }
    }
}
