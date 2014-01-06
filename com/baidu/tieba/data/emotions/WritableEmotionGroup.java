package com.baidu.tieba.data.emotions;
/* loaded from: classes.dex */
public abstract class WritableEmotionGroup {
    private com.baidu.adp.widget.ImageView.d a;
    private com.baidu.adp.widget.ImageView.d b;
    private int c;
    private int d;

    /* loaded from: classes.dex */
    public enum EmotionGroupType {
        LOCAL,
        BIG_EMOTION,
        PROMOTION
    }

    public abstract String a(int i);

    public abstract boolean a(String str);

    public abstract com.baidu.adp.widget.ImageView.d b(String str);

    public abstract com.baidu.adp.widget.ImageView.d c(String str);

    public abstract EmotionGroupType c();

    public abstract int d();

    public abstract String e();

    public abstract String f();

    public com.baidu.adp.widget.ImageView.d g() {
        return this.a;
    }

    public void a(com.baidu.adp.widget.ImageView.d dVar) {
        if (dVar != null) {
            dVar.h();
        }
        this.a = dVar;
    }

    public com.baidu.adp.widget.ImageView.d a() {
        return this.b;
    }

    public void b(com.baidu.adp.widget.ImageView.d dVar) {
        if (dVar != null) {
            dVar.h();
        }
        this.b = dVar;
    }

    public int h() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        this.d = i;
    }

    public int i() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.c = i;
    }
}
