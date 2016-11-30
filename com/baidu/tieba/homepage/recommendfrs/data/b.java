package com.baidu.tieba.homepage.recommendfrs.data;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.e {
    private long cJT;

    public b(long j) {
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
        return "RecommendFrsCache";
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
