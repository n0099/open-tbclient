package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.im.chat.officialBar.RequestLocalHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseLocalHistoryMessage;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes26.dex */
public class m implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestLocalHistoryMessage)) {
            return null;
        }
        byte[] bArr = com.baidu.tbadk.core.c.a.brq().Bn("tb.im_official_history").get(TbadkApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + ((RequestLocalHistoryMessage) customMessage).getData());
        if (bArr == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        try {
            QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHistoryMsgResIdl.class);
            if (queryHistoryMsgResIdl.data.res != null) {
                for (MsgInfo msgInfo : queryHistoryMsgResIdl.data.res) {
                    ResponseHistoryMessage.a aVar = new ResponseHistoryMessage.a();
                    if (msgInfo != null) {
                        Date date = new Date();
                        date.setTime(msgInfo.sendTime.longValue() * 1000);
                        aVar.time = au.getDateStringMouth(date);
                        aVar.type = msgInfo.type.intValue();
                        aVar.content = msgInfo.content;
                        aVar.id = msgInfo.id.intValue();
                        linkedList.add(aVar);
                    }
                }
            }
            return new ResponseLocalHistoryMessage(linkedList);
        } catch (Exception e) {
            return null;
        }
    }
}
