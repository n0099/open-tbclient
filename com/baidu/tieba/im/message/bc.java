package com.baidu.tieba.im.message;

import com.google.protobuf.MessageLite;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReq;
/* loaded from: classes.dex */
public class bc extends s implements com.baidu.tieba.im.coder.g {
    private int a;
    private String b;
    private String c;

    public bc() {
        e(106103);
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return UpdateChatroomTopicReq.UpdateChatroomTopicReqIdl.newBuilder().a(UpdateChatroomTopicReq.DataReq.newBuilder().a(b()).a(c()).b(d()).build()).build();
    }
}
