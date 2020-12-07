package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public abstract class b<T> {
    private T dej;
    private String gjM;
    private Long gjN;
    private String mKey;
    private T zJ;

    protected abstract T bQk();

    protected abstract long x(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.gjM = str2;
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
        if (this.zJ == null && !TextUtils.isEmpty(this.mKey)) {
            this.zJ = bQk();
            if (!TextUtils.isEmpty(this.gjM)) {
                this.gjN = Long.valueOf(x(this.gjM, 0L));
            }
        }
        return this.zJ;
    }

    public void aC(T t) {
        this.dej = t;
    }

    public T bQl() {
        return this.dej;
    }
}
