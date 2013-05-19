package com.baidu.tieba.d;
/* loaded from: classes.dex */
public enum y {
    UNAVAIL,
    WIFI,
    MOBILE;

    /* JADX DEBUG: Replace access to removed values field (d) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static y[] valuesCustom() {
        y[] valuesCustom = values();
        int length = valuesCustom.length;
        y[] yVarArr = new y[length];
        System.arraycopy(valuesCustom, 0, yVarArr, 0, length);
        return yVarArr;
    }
}
