package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String fYL;
    private String mImgUrl;
    private String mTitle;

    public void ml(String str) {
        this.mImgUrl = str;
    }

    public void xr(String str) {
        this.fYL = str;
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
        return this.fYL;
    }
}
