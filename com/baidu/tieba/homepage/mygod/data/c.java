package com.baidu.tieba.homepage.mygod.data;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.e {
    private long cpo;

    public c(long j) {
        this.cpo = j;
    }

    public long aiO() {
        return this.cpo;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.cpo)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Ev() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Ew() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
