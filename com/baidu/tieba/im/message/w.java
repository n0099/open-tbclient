package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReq;
/* loaded from: classes.dex */
public final class w extends b {
    public w() {
        e(205001);
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        try {
            return CommitPersonalMsgReq.CommitPersonalMsgReqIdl.newBuilder().a(CommitPersonalMsgReq.DataReq.newBuilder().a(k()).a(c()).a(com.baidu.tieba.im.chat.q.a).b(i()).b(j()).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.e("data convert error");
            return null;
        }
    }
}
