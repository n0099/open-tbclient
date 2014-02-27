package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReq;
/* loaded from: classes.dex */
public final class bc extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;
    private String c;

    public bc() {
        e(106103);
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.tieba.im.coder.g
    public final MessageLite a() {
        return UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl.newBuilder().a(UpdateChatroomTopicReq.DataReq.newBuilder().a(this.a).a(this.b).b(this.c).build()).build();
    }
}
