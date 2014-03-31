package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.im.chat.officialBar.ResponseLocalHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.bd;
import com.baidu.tieba.im.chat.officialBar.bf;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Date;
import java.util.LinkedList;
import protobuf.QueryHistoryMsg.QueryHistoryMsgRes;
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.task.a<String> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<String> aVar) {
        if (aVar == null || !(aVar instanceof bd)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.c.b.a().z().a(String.valueOf(TbadkApplication.E()) + "@" + ((bd) aVar).a());
        if (a == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        try {
            for (QueryHistoryMsgRes.MsgInfo msgInfo : QueryHistoryMsgRes.QueryHistoryMsgResIdl.parseFrom(a).getData().getResList()) {
                bf bfVar = new bf();
                if (msgInfo != null) {
                    Date date = new Date();
                    date.setTime(msgInfo.getSendTime() * 1000);
                    bfVar.a = bc.c(date);
                    bfVar.b = msgInfo.getType();
                    bfVar.c = msgInfo.getContent();
                    bfVar.d = msgInfo.getId();
                    com.baidu.adp.lib.util.f.e("history:item:" + bfVar.d);
                    linkedList.add(bfVar);
                }
            }
            return new ResponseLocalHistoryMessage(linkedList);
        } catch (InvalidProtocolBufferException e) {
            com.baidu.adp.lib.util.f.e(e.getMessage());
            return null;
        }
    }
}
