package com.baidu.tieba.advert.sdk.data;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
/* loaded from: classes5.dex */
public enum ResourceType {
    ID("id"),
    ARRAY("array"),
    LAYOUT("layout"),
    STYLE(UnitedSchemeConstants.UNITED_SCHEME_STYLE),
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
