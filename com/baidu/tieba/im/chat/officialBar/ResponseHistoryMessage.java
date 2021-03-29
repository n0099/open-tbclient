package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import d.b.b.e.p.k;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes3.dex */
public class ResponseHistoryMessage extends TbSocketReponsedMessage {
    public List<a> msg;
    public int msgCount;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17882a;

        /* renamed from: b  reason: collision with root package name */
        public int f17883b;

        /* renamed from: c  reason: collision with root package name */
        public String f17884c;

        /* renamed from: d  reason: collision with root package name */
        public int f17885d;
    }

    public ResponseHistoryMessage() {
        super(208002);
        this.msgCount = 0;
        this.msg = new LinkedList();
    }

    public List<a> getMsg() {
        return this.msg;
    }

    public int getMsgCount() {
        return this.msgCount;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        QueryHistoryMsgResIdl queryHistoryMsgResIdl = (QueryHistoryMsgResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryHistoryMsgResIdl.class);
        setError(queryHistoryMsgResIdl.error.errorno.intValue());
        setErrorString(queryHistoryMsgResIdl.error.usermsg);
        this.msgCount = queryHistoryMsgResIdl.data.total.intValue();
        List<MsgInfo> list = queryHistoryMsgResIdl.data.res;
        if (list != null) {
            for (MsgInfo msgInfo : list) {
                a aVar = new a();
                if (msgInfo != null) {
                    Date date = new Date();
                    date.setTime(msgInfo.sendTime.longValue() * 1000);
                    aVar.f17882a = k.getDateStringMouth(date);
                    aVar.f17883b = msgInfo.type.intValue();
                    aVar.f17884c = msgInfo.content;
                    aVar.f17885d = msgInfo.id.intValue();
                    this.msg.add(aVar);
                }
            }
        }
        if (this.msg.isEmpty()) {
            return;
        }
        l<byte[]> d2 = d.b.h0.r.r.a.f().d("tb.im_official_history");
        RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) getOrginalMessage();
        if (requestHistoryMessage == null || requestHistoryMessage.getRequestId() != 0) {
            return;
        }
        d2.g(TbadkCoreApplication.getCurrentAccount() + "@" + String.valueOf(requestHistoryMessage.getFid()), bArr);
    }
}
