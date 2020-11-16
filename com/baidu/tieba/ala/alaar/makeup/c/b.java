package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public abstract class b<T> {
    private T cXl;
    private String gbB;
    private Long gbC;
    private String mKey;
    private T mValue;

    protected abstract T bMz();

    protected abstract long x(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.gbB = str2;
        aC(t);
        setKey(str);
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public String getKey() {
        return this.mKey;
    }

    public T getValue() {
        if (this.mValue == null && !TextUtils.isEmpty(this.mKey)) {
            this.mValue = bMz();
            if (!TextUtils.isEmpty(this.gbB)) {
                this.gbC = Long.valueOf(x(this.gbB, 0L));
            }
        }
        return this.mValue;
    }

    public void aC(T t) {
        this.cXl = t;
    }

    public T bMA() {
        return this.cXl;
    }
}
