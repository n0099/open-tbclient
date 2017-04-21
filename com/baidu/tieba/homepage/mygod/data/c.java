package com.baidu.tieba.homepage.mygod.data;

import com.baidu.tieba.homepage.mygod.RecommendGodCacheModel;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.e {
    private long cvK;

    public c(long j) {
        this.cvK = j;
    }

    public long ajs() {
        return this.cvK;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.cvK)).toString();
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public String Fg() {
        return RecommendGodCacheModel.TABLE_NAME;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean Fh() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.b.e
    public boolean isNeedUid() {
        return false;
    }
}
