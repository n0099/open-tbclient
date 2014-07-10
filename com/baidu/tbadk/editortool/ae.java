package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ae {
    private com.baidu.adp.widget.a.a a;
    private com.baidu.adp.widget.a.a b;
    private int c;
    private int d;

    public abstract String a(int i);

    public abstract boolean a(String str);

    public abstract com.baidu.adp.widget.a.a b(String str);

    public abstract com.baidu.adp.widget.a.a c(String str);

    public abstract EmotionGroupType c();

    public abstract int d();

    public abstract String e();

    public abstract String f();

    public abstract int g();

    public abstract int h();

    public abstract boolean i();

    public com.baidu.adp.widget.a.a j() {
        return this.a;
    }

    public void a(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.h();
        }
        this.a = aVar;
    }

    public com.baidu.adp.widget.a.a a() {
        return this.b;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.h();
        }
        this.b = aVar;
    }

    public int k() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        this.d = i;
    }

    public int l() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.c = i;
    }
}
