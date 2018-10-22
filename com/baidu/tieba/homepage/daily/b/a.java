package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String eba;
    private String mImgUrl;
    private String mTitle;

    public void dR(String str) {
        this.mImgUrl = str;
    }

    public void oF(String str) {
        this.eba = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xa() {
        return this.eba;
    }
}
