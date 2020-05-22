package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes13.dex */
public class ResponseHistoryMessage extends TbSocketReponsedMessage {
    private List<a> msg;
    private int msgCount;

    /* loaded from: classes13.dex */
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
        super(CmdConfigSocket.CMD_QUERY_OFFICIAL_BAR_HISTORY);
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
                    aVar.time = aq.getDateStringMouth(date);
                    aVar.type = msgInfo.type.intValue();
                    aVar.content = msgInfo.content;
                    aVar.id = msgInfo.id.intValue();
                    this.msg.add(aVar);
                }
            }
        }
        if (!this.msg.isEmpty()) {
            l<byte[]> vL = com.baidu.tbadk.core.c.a.aSS().vL("tb.im_official_history");
            RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) getOrginalMessage();
            if (requestHistoryMessage != null && requestHistoryMessage.getRequestId() == 0) {
                vL.setForever(TbadkApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + String.valueOf(requestHistoryMessage.getFid()), bArr);
            }
        }
    }
}
