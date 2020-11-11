package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public abstract class b<T> {
    private T cYV;
    private String gbU;
    private Long gbV;
    private String mKey;
    private T mValue;

    protected abstract T bNg();

    protected abstract long x(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.gbU = str2;
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
            this.mValue = bNg();
            if (!TextUtils.isEmpty(this.gbU)) {
                this.gbV = Long.valueOf(x(this.gbU, 0L));
            }
        }
        return this.mValue;
    }

    public void aC(T t) {
        this.cYV = t;
    }

    public T bNh() {
        return this.cYV;
    }
}
