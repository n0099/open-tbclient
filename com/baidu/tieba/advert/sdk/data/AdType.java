package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum AdType {
    BANNER(13),
    INTERS(11),
    SPLASH(12),
    NATIVE(14);
    
    public int typeId;

    AdType(int i2) {
        this.typeId = i2;
    }

    public int getValue() {
        return this.typeId;
    }
}
