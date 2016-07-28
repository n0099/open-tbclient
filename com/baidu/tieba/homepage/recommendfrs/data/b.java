package com.baidu.tieba.homepage.recommendfrs.data;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.e {
    private long csO;

    public b(long j) {
        this.csO = j;
    }

    public long ahr() {
        return this.csO;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.csO)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Do() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Dp() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
