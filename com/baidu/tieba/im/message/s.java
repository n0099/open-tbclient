package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.CommitPersonalMsg.CommitPersonalMsgReq;
/* loaded from: classes.dex */
public class s extends b {
    public s() {
        e(205001);
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        try {
            return CommitPersonalMsgReq.CommitPersonalMsgReqIdl.newBuilder().a(CommitPersonalMsgReq.DataReq.newBuilder().a(j()).a(b()).a(com.baidu.tieba.im.chat.a.a).b(h()).b(i()).build()).build();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.d("data convert error");
            return null;
        }
    }
}
