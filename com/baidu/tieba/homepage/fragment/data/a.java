package com.baidu.tieba.homepage.fragment.data;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.mvc.b.e {
    private String cacheKey;

    public a(String str) {
        this.cacheKey = str;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Dr() {
        return "HomePageCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Ds() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
