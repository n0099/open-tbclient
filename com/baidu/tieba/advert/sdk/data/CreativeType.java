package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum CreativeType {
    IMAGE(0),
    FLASH(1),
    HTML(3),
    NATIVE(5);
    
    public int typeId;

    CreativeType(int i) {
        this.typeId = i;
    }

    public int getValue() {
        return this.typeId;
    }
}
