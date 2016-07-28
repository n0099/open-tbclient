package com.baidu.tieba.homepage.mygod.data;

import com.baidu.tbadk.mvc.b.e;
/* loaded from: classes.dex */
public class b implements e {
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
        return "RecommendGodCache";
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
