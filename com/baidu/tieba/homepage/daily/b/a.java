package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String fYO;
    private String mImgUrl;
    private String mTitle;

    public void mk(String str) {
        this.mImgUrl = str;
    }

    public void xt(String str) {
        this.fYO = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        return this.fYO;
    }
}
