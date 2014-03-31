package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class bo extends com.baidu.adp.a.e {
    private com.baidu.tieba.im.message.as a = null;
    private int b;
    private String c;
    private String d;

    public final void a(int i) {
        this.b = 0;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final void a() {
        com.baidu.tieba.im.message.as asVar = new com.baidu.tieba.im.message.as();
        asVar.a(this.c);
        asVar.b(this.d);
        asVar.d(this.b);
        this.a = asVar;
        super.sendMessage(this.a);
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
        this.a = null;
        super.cancelMessage();
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
