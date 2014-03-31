package com.baidu.tieba.im.message.a;

import com.google.protobuf.MessageLite;
import protobuf.CommitGroupMsg.CommitGroupMsgReq;
/* loaded from: classes.dex */
public class b extends a {
    public b() {
        super(202001);
    }

    public b(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public MessageLite h() {
        try {
            return CommitGroupMsgReq.CommitGroupMsgReqIdl.newBuilder().a(CommitGroupMsgReq.DataReq.newBuilder().a(v()).a(Integer.valueOf(i()).intValue()).b(t()).a(u()).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.e("data convert error");
            return null;
        }
    }
}
