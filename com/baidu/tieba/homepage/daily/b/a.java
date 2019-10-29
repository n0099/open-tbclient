package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String arY;
    private String gfQ;
    private String mTitle;

    public void mU(String str) {
        this.arY = str;
    }

    public void wR(String str) {
        this.gfQ = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.arY;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aha() {
        return this.gfQ;
    }
}
