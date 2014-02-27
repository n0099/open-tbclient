package com.baidu.tieba.data.emotions;
/* loaded from: classes.dex */
public abstract class WritableEmotionGroup {
    private com.baidu.adp.widget.ImageView.b a;
    private com.baidu.adp.widget.ImageView.b b;
    private int c;
    private int d;

    /* loaded from: classes.dex */
    public enum EmotionGroupType {
        LOCAL,
        BIG_EMOTION,
        PROMOTION;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static EmotionGroupType[] valuesCustom() {
            EmotionGroupType[] valuesCustom = values();
            int length = valuesCustom.length;
            EmotionGroupType[] emotionGroupTypeArr = new EmotionGroupType[length];
            System.arraycopy(valuesCustom, 0, emotionGroupTypeArr, 0, length);
            return emotionGroupTypeArr;
        }
    }

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
