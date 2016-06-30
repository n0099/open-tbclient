package com.baidu.tieba.homepage.recommendfrs.data;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.e {
    private long cqj;

    public b(long j) {
        this.cqj = j;
    }

    public long agL() {
        return this.cqj;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.cqj)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Dp() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Dq() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
