package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes4.dex */
public enum LandingPageType {
    UNKNOW(0),
    WEBVIEW(1),
    BROWSER(2),
    DOWNLOAD(3);
    
    public int value;

    LandingPageType(int i2) {
        this.value = i2;
    }

    public int getValue() {
        return this.value;
    }
}
