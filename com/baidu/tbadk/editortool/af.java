package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class af {
    private com.baidu.adp.widget.ImageView.b a;
    private com.baidu.adp.widget.ImageView.b b;
    private int c;
    private int d;

    public abstract String a(int i);

    public abstract boolean a(String str);

    public abstract com.baidu.adp.widget.ImageView.b b(String str);

    public abstract com.baidu.adp.widget.ImageView.b c(String str);

    public abstract EmotionGroupType c();

    public abstract int d();

    public abstract String e();

    public abstract String f();

    public abstract int g();

    public abstract int h();

    public final com.baidu.adp.widget.ImageView.b i() {
        return this.a;
    }

    public final void a(com.baidu.adp.widget.ImageView.b bVar) {
        if (bVar != null) {
            bVar.h();
        }
        this.a = bVar;
    }

    public com.baidu.adp.widget.ImageView.b a() {
        return this.b;
    }

    public final void b(com.baidu.adp.widget.ImageView.b bVar) {
        if (bVar != null) {
            bVar.h();
        }
        this.b = bVar;
    }

    public final int j() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i) {
        this.d = i;
    }

    public final int k() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i) {
        this.c = i;
    }
}
