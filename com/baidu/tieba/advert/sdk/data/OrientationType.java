package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum OrientationType {
    UNKNOWN(0),
    PORTRAIT(1),
    LANDSCAPE(2);
    
    public int type;

    OrientationType(int i) {
        this.type = i;
    }

    public int getValue() {
        return this.type;
    }
}
