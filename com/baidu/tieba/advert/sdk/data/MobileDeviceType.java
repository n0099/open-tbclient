package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum MobileDeviceType {
    UNKNOWN_DEVICE(0),
    IPHONE(1),
    IPAD(2),
    IPOD(3),
    ANDROID_PHONE(4),
    ADROID_PAD(5);
    
    public int type;

    MobileDeviceType(int i2) {
        this.type = i2;
    }

    public int getValue() {
        return this.type;
    }
}
