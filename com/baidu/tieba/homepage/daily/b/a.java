package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String dTg;
    private String mImgUrl;
    private String mTitle;

    public void dB(String str) {
        this.mImgUrl = str;
    }

    public void ob(String str) {
        this.dTg = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String uR() {
        return this.dTg;
    }
}
