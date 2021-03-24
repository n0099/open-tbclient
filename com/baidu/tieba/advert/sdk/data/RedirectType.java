package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum RedirectType {
    SDKBROWSER(0),
    SDKWEBVIEW(1),
    APPMANAGE(2);
    
    public int value;

    RedirectType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
