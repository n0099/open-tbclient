package com.baidu.tieba.homepage.recommendfrs.data;

import com.baidu.tieba.homepage.recommendfrs.model.RecommendFrsCacheModel;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.e {
    private long ctu;

    public b(long j) {
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
        return RecommendFrsCacheModel.TABLE_NAME;
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
