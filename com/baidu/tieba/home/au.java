package com.baidu.tieba.home;
/* loaded from: classes.dex */
public final class au extends com.baidu.adp.a.d {
    private String a = null;
    private String b = null;
    private aw c = null;
    private av d;

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public final void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.c == null) {
            this.a = str;
            this.b = str2;
            this.c = new aw(this, (byte) 0);
            this.c.setPriority(2);
            this.c.execute(new Object[0]);
        }
    }

    public final void a(av avVar) {
        this.d = avVar;
    }
}
