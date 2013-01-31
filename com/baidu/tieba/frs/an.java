package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum an {
    NORMAL,
    LOADING,
    NEXT,
    LAST,
    GONE,
    NO_ITEM;

    /* JADX DEBUG: Replace access to removed values field (g) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static an[] valuesCustom() {
        an[] valuesCustom = values();
        int length = valuesCustom.length;
        an[] anVarArr = new an[length];
        System.arraycopy(valuesCustom, 0, anVarArr, 0, length);
        return anVarArr;
    }
}
