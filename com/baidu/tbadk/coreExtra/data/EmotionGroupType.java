package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public enum EmotionGroupType {
    LOCAL,
    BIG_EMOTION,
    PROMOTION;

    /* JADX DEBUG: Replace access to removed values field (agj) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static EmotionGroupType[] valuesCustom() {
        EmotionGroupType[] valuesCustom = values();
        int length = valuesCustom.length;
        EmotionGroupType[] emotionGroupTypeArr = new EmotionGroupType[length];
        System.arraycopy(valuesCustom, 0, emotionGroupTypeArr, 0, length);
        return emotionGroupTypeArr;
    }
}
