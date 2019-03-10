package com.baidu.tieba.homepage.daily.b;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String fId;
    private String mImgUrl;
    private String mTitle;

    public void lf(String str) {
        this.mImgUrl = str;
    }

    public void wf(String str) {
        this.fId = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xi() {
        return this.fId;
    }
}
