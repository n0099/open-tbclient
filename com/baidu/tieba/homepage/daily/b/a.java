package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String fHQ;
    private String mImgUrl;
    private String mTitle;

    public void lg(String str) {
        this.mImgUrl = str;
    }

    public void wc(String str) {
        this.fHQ = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xf() {
        return this.fHQ;
    }
}
