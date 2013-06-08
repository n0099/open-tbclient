package com.baidu.tieba.c;
/* loaded from: classes.dex */
public enum aq {
    DO_CLEAR;

    /* JADX DEBUG: Replace access to removed values field (b) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static aq[] valuesCustom() {
        aq[] valuesCustom = values();
        int length = valuesCustom.length;
        aq[] aqVarArr = new aq[length];
        System.arraycopy(valuesCustom, 0, aqVarArr, 0, length);
        return aqVarArr;
    }
}
