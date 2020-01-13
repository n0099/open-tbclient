package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes8.dex */
public enum LandingPageType {
    UNKNOW(0),
    WEBVIEW(1),
    BROWSER(2),
    DOWNLOAD(3);
    
    private int value;

    LandingPageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
