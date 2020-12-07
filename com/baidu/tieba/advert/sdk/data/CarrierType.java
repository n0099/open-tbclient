package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes23.dex */
public enum CarrierType {
    YIDONG(46000),
    LIANTONG(46001),
    DIANXIN(46003),
    TIETONG(46020);
    
    private int type;

    CarrierType(int i) {
        this.type = i;
    }

    public int getValue() {
        return this.type;
    }
}
