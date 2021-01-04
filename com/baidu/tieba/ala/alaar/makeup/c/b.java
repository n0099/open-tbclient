package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class b<T> {
    private T dje;
    private String gun;
    private Long guo;
    private String mKey;
    private T mValue;

    protected abstract T bSL();

    protected abstract long x(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.gun = str2;
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
            this.mValue = bSL();
            if (!TextUtils.isEmpty(this.gun)) {
                this.guo = Long.valueOf(x(this.gun, 0L));
            }
        }
        return this.mValue;
    }

    public void aE(T t) {
        this.dje = t;
    }

    public T getDefaultValue() {
        return this.dje;
    }
}
