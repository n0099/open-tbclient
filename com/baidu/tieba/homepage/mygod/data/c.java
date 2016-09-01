package com.baidu.tieba.homepage.mygod.data;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.e {
    private long cEc;

    public c(long j) {
        this.cEc = j;
    }

    public long amf() {
        return this.cEc;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.cEc)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String EI() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean EJ() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
