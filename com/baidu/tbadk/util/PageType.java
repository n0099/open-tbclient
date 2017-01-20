package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public enum PageType {
    PERSON_INFO,
    FRS,
    PB,
    IMAGE_PB,
    FLOOR_IN_FLOOR,
    WRITE;

    /* JADX DEBUG: Replace access to removed values field (aDv) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static PageType[] valuesCustom() {
        PageType[] valuesCustom = values();
        int length = valuesCustom.length;
        PageType[] pageTypeArr = new PageType[length];
        System.arraycopy(valuesCustom, 0, pageTypeArr, 0, length);
        return pageTypeArr;
    }
}
