package com.baidu.tieba.homepage.mygod.data;

import com.baidu.tieba.homepage.mygod.RecommendGodCacheModel;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.e {
    private long ctu;

    public c(long j) {
        this.ctu = j;
    }

    public long ajk() {
        return this.ctu;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.ctu)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Ep() {
        return RecommendGodCacheModel.TABLE_NAME;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Eq() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
