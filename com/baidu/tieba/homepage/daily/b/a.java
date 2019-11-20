package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String arG;
    private String geZ;
    private String mTitle;

    public void mU(String str) {
        this.arG = str;
    }

    public void wR(String str) {
        this.geZ = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.arG;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String agY() {
        return this.geZ;
    }
}
