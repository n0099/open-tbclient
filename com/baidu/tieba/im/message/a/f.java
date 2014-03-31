package com.baidu.tieba.im.message.a;

import com.baidu.tieba.im.chat.x;
import com.google.protobuf.MessageLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReq;
/* loaded from: classes.dex */
public class f extends a {
    public f() {
        super(205001);
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        try {
            return CommitPersonalMsgReq.CommitPersonalMsgReqIdl.newBuilder().a(CommitPersonalMsgReq.DataReq.newBuilder().a(v()).a(l()).a(x.a).b(t()).b(u()).c(0).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.e("data convert error");
            return null;
        }
    }
}
