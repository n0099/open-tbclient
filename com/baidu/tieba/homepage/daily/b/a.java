package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String dLS;
    private String mImgUrl;
    private String mTitle;

    public void dj(String str) {
        this.mImgUrl = str;
    }

    public void nu(String str) {
        this.dLS = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String tP() {
        return this.dLS;
    }
}
