package com.baidu.tieba.c;
/* loaded from: classes.dex */
public enum an {
    DO_CLEAR;

    /* JADX DEBUG: Replace access to removed values field (b) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static an[] valuesCustom() {
        an[] valuesCustom = values();
        int length = valuesCustom.length;
        an[] anVarArr = new an[length];
        System.arraycopy(valuesCustom, 0, anVarArr, 0, length);
        return anVarArr;
    }
}
