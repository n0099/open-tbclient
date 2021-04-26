package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum OrientationType {
    UNKNOWN(0),
    PORTRAIT(1),
    LANDSCAPE(2);
    
    public int type;

    OrientationType(int i2) {
        this.type = i2;
    }

    public int getValue() {
        return this.type;
    }
}
