package com.baidu.tieba.c;
/* loaded from: classes.dex */
public abstract class c<T> {
    final String mPropertyName;

    public abstract float aI(T t);

    public abstract void setValue(T t, float f);

    public c(String str) {
        this.mPropertyName = str;
    }
}
