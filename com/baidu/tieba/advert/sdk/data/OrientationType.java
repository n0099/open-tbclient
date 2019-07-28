package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes5.dex */
public enum OrientationType {
    UNKNOWN(0),
    PORTRAIT(1),
    LANDSCAPE(2);
    
    private int type;

    OrientationType(int i) {
        this.type = i;
    }

    public int getValue() {
        return this.type;
    }
}
