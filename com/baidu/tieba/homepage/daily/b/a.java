package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String emt;
    private String mImgUrl;
    private String mTitle;

    public void es(String str) {
        this.mImgUrl = str;
    }

    public void pB(String str) {
        this.emt = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String yA() {
        return this.emt;
    }
}
