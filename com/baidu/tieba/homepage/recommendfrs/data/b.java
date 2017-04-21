package com.baidu.tieba.homepage.recommendfrs.data;

import com.baidu.tieba.homepage.recommendfrs.model.RecommendFrsCacheModel;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.e {
    private long cvK;

    public b(long j) {
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
        return RecommendFrsCacheModel.TABLE_NAME;
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
