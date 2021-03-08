package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public abstract class b<T> {
    private T dib;
    private String gum;
    private Long gun;
    private String mKey;
    private T mValue;

    protected abstract T bPL();

    protected abstract long w(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.gum = str2;
        aG(t);
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
            this.mValue = bPL();
            if (!TextUtils.isEmpty(this.gum)) {
                this.gun = Long.valueOf(w(this.gum, 0L));
            }
        }
        return this.mValue;
    }

    public void aG(T t) {
        this.dib = t;
    }

    public T getDefaultValue() {
        return this.dib;
    }
}
