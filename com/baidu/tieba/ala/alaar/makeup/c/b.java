package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public abstract class b<T> {
    private T deo;
    private String gpG;
    private Long gpH;
    private String mKey;
    private T mValue;

    protected abstract T bOU();

    protected abstract long x(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.gpG = str2;
        aE(t);
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
            this.mValue = bOU();
            if (!TextUtils.isEmpty(this.gpG)) {
                this.gpH = Long.valueOf(x(this.gpG, 0L));
            }
        }
        return this.mValue;
    }

    public void aE(T t) {
        this.deo = t;
    }

    public T getDefaultValue() {
        return this.deo;
    }
}
