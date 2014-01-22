package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ay extends ba {
    private int b;
    private String c;
    private String d;

    public int b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public ay(int i, String str, String str2) {
        this.b = 0;
        this.c = "";
        this.d = "";
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.tieba.im.message.ba
    protected void a(protobuf.i iVar) {
        iVar.d(c());
        iVar.d(b());
    }
}
