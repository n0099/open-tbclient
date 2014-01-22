package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReq;
/* loaded from: classes.dex */
public class u extends b {
    public u() {
        e(205001);
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        try {
            return CommitPersonalMsgReq.CommitPersonalMsgReqIdl.newBuilder().a(CommitPersonalMsgReq.DataReq.newBuilder().a(k()).a(c()).a(com.baidu.tieba.im.chat.q.a).b(i()).b(j()).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.d("data convert error");
            return null;
        }
    }
}
