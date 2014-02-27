package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.av;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public final class am extends com.baidu.adp.a.d {
    private av a = null;
    private cr b = null;
    private int c;
    private String d;
    private String e;

    public final void a(int i) {
        this.c = 0;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void a() {
        av avVar = new av();
        avVar.a(this.d);
        avVar.b(this.e);
        avVar.a(this.c);
        this.a = avVar;
        com.baidu.tieba.im.messageCenter.d.a().a(this.a);
    }

    public final void b() {
        if (this.a != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.a);
            this.a = null;
        }
        if (this.b != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.b);
            this.b = null;
        }
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }
}
