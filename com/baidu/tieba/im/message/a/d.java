package com.baidu.tieba.im.message.a;

import com.google.protobuf.MessageLite;
import protobuf.CommitGroupMsg.CommitGroupMsgReq;
/* loaded from: classes.dex */
public final class d extends b {
    public d() {
        super(202001);
    }

    @Override // com.baidu.tieba.im.message.a.b, com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        try {
            return CommitGroupMsgReq.CommitGroupMsgReqIdl.newBuilder().a(CommitGroupMsgReq.DataReq.newBuilder().a(v()).a(Integer.valueOf(i()).intValue()).b(t()).a(u()).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.e("data convert error");
            return null;
        }
    }
}
