package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum RedirectType {
    SDKBROWSER(0),
    SDKWEBVIEW(1),
    APPMANAGE(2);
    
    public int value;

    RedirectType(int i2) {
        this.value = i2;
    }

    public int getValue() {
        return this.value;
    }
}
