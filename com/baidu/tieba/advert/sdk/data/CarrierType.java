package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum CarrierType {
    YIDONG(46000),
    LIANTONG(46001),
    DIANXIN(46003),
    TIETONG(46020);
    
    public int type;

    CarrierType(int i2) {
        this.type = i2;
    }

    public int getValue() {
        return this.type;
    }
}
