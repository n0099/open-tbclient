package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum aw {
    NORMAL,
    LOADING,
    NEXT,
    LAST,
    GONE,
    NO_ITEM;

    /* JADX DEBUG: Replace access to removed values field (g) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static aw[] valuesCustom() {
        aw[] valuesCustom = values();
        int length = valuesCustom.length;
        aw[] awVarArr = new aw[length];
        System.arraycopy(valuesCustom, 0, awVarArr, 0, length);
        return awVarArr;
    }
}
