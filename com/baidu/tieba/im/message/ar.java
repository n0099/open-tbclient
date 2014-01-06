package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ar extends at {
    private int b;
    private String c;
    private String d;

    public int b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public ar(int i, String str, String str2) {
        this.b = 0;
        this.c = "";
        this.d = "";
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.tieba.im.message.at
    protected void a(protobuf.i iVar) {
        iVar.d(c());
        iVar.d(b());
    }
}
