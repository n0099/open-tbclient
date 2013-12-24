package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ar extends aq {
    private String b;

    public ar(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.message.aq
    protected void a(protobuf.i iVar) {
        iVar.a(b());
    }
}
