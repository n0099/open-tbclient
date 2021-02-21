package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public abstract class b<T> {
    private T dgA;
    private String gsD;
    private Long gsE;
    private String mKey;
    private T mValue;

    protected abstract T bPF();

    protected abstract long w(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.gsD = str2;
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
            this.mValue = bPF();
            if (!TextUtils.isEmpty(this.gsD)) {
                this.gsE = Long.valueOf(w(this.gsD, 0L));
            }
        }
        return this.mValue;
    }

    public void aE(T t) {
        this.dgA = t;
    }

    public T getDefaultValue() {
        return this.dgA;
    }
}
