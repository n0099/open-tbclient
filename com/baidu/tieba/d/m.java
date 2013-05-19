package com.baidu.tieba.d;
/* loaded from: classes.dex */
public enum m {
    INNER,
    SDCARD;

    /* JADX DEBUG: Replace access to removed values field (c) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static m[] valuesCustom() {
        m[] valuesCustom = values();
        int length = valuesCustom.length;
        m[] mVarArr = new m[length];
        System.arraycopy(valuesCustom, 0, mVarArr, 0, length);
        return mVarArr;
    }
}
