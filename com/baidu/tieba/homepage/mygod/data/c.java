package com.baidu.tieba.homepage.mygod.data;

import com.baidu.tieba.homepage.mygod.RecommendGodCacheModel;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.mvc.b.e {
    private long ctt;

    public c(long j) {
        this.ctt = j;
    }

    public long air() {
        return this.ctt;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return new StringBuilder(String.valueOf(this.ctt)).toString();
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
