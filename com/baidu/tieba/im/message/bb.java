package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReq;
/* loaded from: classes.dex */
public final class bb extends com.baidu.tbadk.message.websockt.d {
    private int a;
    private String b;
    private String c;

    public bb() {
        super(106103);
    }

    public final void d(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        return UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl.newBuilder().a(UpdateChatroomTopicReq.DataReq.newBuilder().a(this.a).a(this.b).b(this.c).build()).build();
    }
}
