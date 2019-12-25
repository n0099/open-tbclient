package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes7.dex */
public enum AdType {
    BANNER(13),
    INTERS(11),
    SPLASH(12),
    NATIVE(14);
    
    private int typeId;

    AdType(int i) {
        this.typeId = i;
    }

    public int getValue() {
        return this.typeId;
    }
}
