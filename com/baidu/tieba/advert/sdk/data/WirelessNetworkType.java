package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes7.dex */
public enum WirelessNetworkType {
    UNKNOWN_NETWORK(0),
    WIFI(1),
    MOBILE_2G(2),
    MOBILE_3G(3),
    MOBILE_4G(4),
    NETWORKTYPE_INVALID(5),
    NETWORKTYPE_WAP(6);
    
    private int type;

    WirelessNetworkType(int i) {
        this.type = i;
    }

    public int getValue() {
        return this.type;
    }
}
