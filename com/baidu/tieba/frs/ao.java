package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum ao {
    NORMAL,
    LOADING,
    NEXT,
    LAST,
    GONE,
    NO_ITEM;

    /* JADX DEBUG: Replace access to removed values field (g) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static ao[] valuesCustom() {
        ao[] valuesCustom = values();
        int length = valuesCustom.length;
        ao[] aoVarArr = new ao[length];
        System.arraycopy(valuesCustom, 0, aoVarArr, 0, length);
        return aoVarArr;
    }
}
