package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes3.dex */
public class ResponseHistoryMessage extends TbSocketReponsedMessage {
    private List<a> msg;
    private int msgCount;

    /* loaded from: classes3.dex */
    public static class a {
        public String content;
        public int id;
        public String time;
        public int type;
    }

    public int getMsgCount() {
        return this.msgCount;
    }

    public List<a> getMsg() {
        return this.msg;
    }

    public ResponseHistoryMessage() {
        super(208002);
        this.msgCount = 0;
        this.msg = new LinkedList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHistoryMsgResIdl.class);
        setError(queryHistoryMsgResIdl.error.errorno.intValue());
        setErrorString(queryHistoryMsgResIdl.error.usermsg);
        this.msgCount = queryHistoryMsgResIdl.data.total.intValue();
        if (queryHistoryMsgResIdl.data.res != null) {
            for (MsgInfo msgInfo : queryHistoryMsgResIdl.data.res) {
                a aVar = new a();
                if (msgInfo != null) {
                    Date date = new Date();
                    date.setTime(msgInfo.sendTime.longValue() * 1000);
                    aVar.time = an.d(date);
                    aVar.type = msgInfo.type.intValue();
                    aVar.content = msgInfo.content;
                    aVar.id = msgInfo.id.intValue();
                    this.msg.add(aVar);
                }
            }
        }
        if (!this.msg.isEmpty()) {
            l<byte[]> cY = com.baidu.tbadk.core.c.a.ty().cY("tb.im_official_history");
            RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) getOrginalMessage();
            if (requestHistoryMessage != null && requestHistoryMessage.getRequestId() == 0) {
                cY.e(TbadkApplication.getCurrentAccount() + "@" + String.valueOf(requestHistoryMessage.getFid()), bArr);
            }
        }
    }
}
