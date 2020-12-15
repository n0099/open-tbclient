package com.baidu.tieba.ala.alaar.makeup.c;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public abstract class b<T> {
    private T dej;
    private String gjO;
    private Long gjP;
    private String mKey;
    private T zJ;

    protected abstract T bQl();

    protected abstract long x(String str, long j);

    public b() {
    }

    public b(String str, T t, String str2) {
        this.gjO = str2;
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
            this.zJ = bQl();
            if (!TextUtils.isEmpty(this.gjO)) {
                this.gjP = Long.valueOf(x(this.gjO, 0L));
            }
        }
        return this.zJ;
    }

    public void aC(T t) {
        this.dej = t;
    }

    public T bQm() {
        return this.dej;
    }
}
