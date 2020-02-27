package com.baidu.tieba.advert.sdk.data;
/* loaded from: classes10.dex */
public enum ResourceType {
    ID("id"),
    ARRAY("array"),
    LAYOUT("layout"),
    STYLE("style"),
    STRING("string"),
    DRAWABLE("drawable");
    
    private String value;

    ResourceType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
