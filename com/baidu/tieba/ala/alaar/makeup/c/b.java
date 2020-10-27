package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public abstract class b<T> {
    private T cTc;
    private String fWd;
    private Long fWe;
    private String mKey;
    private T mValue;

    protected abstract T bKH();

    protected abstract long x(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.fWd = str2;
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
            this.mValue = bKH();
            if (!TextUtils.isEmpty(this.fWd)) {
                this.fWe = Long.valueOf(x(this.fWd, 0L));
            }
        }
        return this.mValue;
    }

    public void aC(T t) {
        this.cTc = t;
    }

    public T bKI() {
        return this.cTc;
    }
}
