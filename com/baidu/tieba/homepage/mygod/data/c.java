package com.baidu.tieba.homepage.mygod.data;

import com.baidu.tieba.homepage.mygod.RecommendGodCacheModel;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.e {
    private long cuT;

    public c(long j) {
        this.cuT = j;
    }

    public long aix() {
        return this.cuT;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.cuT)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String EI() {
        return RecommendGodCacheModel.TABLE_NAME;
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
