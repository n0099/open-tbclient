package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.c.e.p.k;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryHistoryMsg.MsgInfo;
import protobuf.QueryHistoryMsg.QueryHistoryMsgResIdl;
/* loaded from: classes4.dex */
public class ResponseHistoryMessage extends TbSocketReponsedMessage {
    public List<a> msg;
    public int msgCount;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17110a;

        /* renamed from: b  reason: collision with root package name */
        public int f17111b;

        /* renamed from: c  reason: collision with root package name */
        public String f17112c;

        /* renamed from: d  reason: collision with root package name */
        public int f17113d;
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
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
                    aVar.f17110a = k.getDateStringMouth(date);
                    aVar.f17111b = msgInfo.type.intValue();
                    aVar.f17112c = msgInfo.content;
                    aVar.f17113d = msgInfo.id.intValue();
                    this.msg.add(aVar);
                }
            }
        }
        if (this.msg.isEmpty()) {
            return;
        }
        l<byte[]> d2 = d.a.m0.r.r.a.f().d("tb.im_official_history");
        RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) getOrginalMessage();
        if (requestHistoryMessage == null || requestHistoryMessage.getRequestId() != 0) {
            return;
        }
        d2.g(TbadkCoreApplication.getCurrentAccount() + "@" + String.valueOf(requestHistoryMessage.getFid()), bArr);
    }
}
