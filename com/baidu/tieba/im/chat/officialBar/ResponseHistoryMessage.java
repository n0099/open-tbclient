package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes.dex */
public class ResponseHistoryMessage extends TbSocketReponsedMessage {
    private List<ba> msg;
    private int msgCount;

    public int getMsgCount() {
        return this.msgCount;
    }

    public List<ba> getMsg() {
        return this.msg;
    }

    public ResponseHistoryMessage() {
        super(MessageTypes.CMD_QUERY_OFFICIAL_BAR_HISTORY);
        this.msgCount = 0;
        this.msg = new LinkedList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHistoryMsgResIdl.class);
        setError(queryHistoryMsgResIdl.error.errorno.intValue());
        setErrorString(queryHistoryMsgResIdl.error.usermsg);
        this.msgCount = queryHistoryMsgResIdl.data.total.intValue();
        if (queryHistoryMsgResIdl.data.res != null) {
            for (MsgInfo msgInfo : queryHistoryMsgResIdl.data.res) {
                ba baVar = new ba();
                if (msgInfo != null) {
                    Date date = new Date();
                    date.setTime(msgInfo.sendTime.longValue() * 1000);
                    baVar.a = bg.c(date);
                    baVar.b = msgInfo.type.intValue();
                    baVar.c = msgInfo.content;
                    baVar.d = msgInfo.id.intValue();
                    BdLog.d("history:item:" + baVar.d);
                    this.msg.add(baVar);
                }
            }
        }
        if (!this.msg.isEmpty()) {
            com.baidu.adp.lib.cache.s<byte[]> C = com.baidu.tbadk.core.a.b.a().C();
            RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) getOrginalMessage();
            if (requestHistoryMessage != null && requestHistoryMessage.getRequestId() == 0) {
                C.a(String.valueOf(TbadkApplication.getCurrentAccount()) + "@" + String.valueOf(requestHistoryMessage.getFid()), bArr);
            }
        }
    }
}
