package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum WirelessNetworkType {
    UNKNOWN_NETWORK(0),
    WIFI(1),
    MOBILE_2G(2),
    MOBILE_3G(3),
    MOBILE_4G(4),
    NETWORKTYPE_INVALID(5),
    NETWORKTYPE_WAP(6);
    
    public int type;

    WirelessNetworkType(int i2) {
        this.type = i2;
    }

    public int getValue() {
        return this.type;
    }
}
