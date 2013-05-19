package com.baidu.tieba.d;
/* loaded from: classes.dex */
public enum z {
    UNAVAIL,
    WIFI,
    TwoG,
    ThreeG;

    /* JADX DEBUG: Replace access to removed values field (e) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static z[] valuesCustom() {
        z[] valuesCustom = values();
        int length = valuesCustom.length;
        z[] zVarArr = new z[length];
        System.arraycopy(valuesCustom, 0, zVarArr, 0, length);
        return zVarArr;
    }
}
