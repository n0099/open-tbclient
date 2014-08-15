package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
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
        super(208002);
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
                    baVar.a = com.baidu.tbadk.core.util.ba.c(date);
                    baVar.b = msgInfo.type.intValue();
                    baVar.c = msgInfo.content;
                    baVar.d = msgInfo.id.intValue();
                    this.msg.add(baVar);
                }
            }
        }
        if (!this.msg.isEmpty()) {
            com.baidu.adp.lib.cache.t<byte[]> a = com.baidu.tbadk.core.a.a.a().a("tb.im_official_history");
            RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) getOrginalMessage();
            if (requestHistoryMessage != null && requestHistoryMessage.getRequestId() == 0) {
                a.a(String.valueOf(TbadkApplication.getCurrentAccount()) + "@" + String.valueOf(requestHistoryMessage.getFid()), (String) bArr);
            }
        }
    }
}
