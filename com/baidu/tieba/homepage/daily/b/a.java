package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String geC;
    private String mImgUrl;
    private String mTitle;

    public void mv(String str) {
        this.mImgUrl = str;
    }

    public void xZ(String str) {
        this.geC = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acQ() {
        return this.geC;
    }
}
