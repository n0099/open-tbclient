package com.baidu.tieba.homepage.mygod.data;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.e {
    private long cJT;

    public c(long j) {
        this.cJT = j;
    }

    public long aoo() {
        return this.cJT;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.cJT)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String EN() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean EO() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
