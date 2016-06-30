package com.baidu.tieba.homepage.mygod.data;

import com.baidu.tbadk.mvc.b.e;
/* loaded from: classes.dex */
public class b implements e {
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
        return "RecommendGodCache";
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
