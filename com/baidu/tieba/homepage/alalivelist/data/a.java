package com.baidu.tieba.homepage.alalivelist.data;

import com.baidu.tbadk.mvc.b.e;
import com.baidu.tieba.homepage.alalivelist.model.RecommendAlaLiveCacheModel;
/* loaded from: classes.dex */
public class a implements e {
    private long ctu;

    public a(long j) {
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
        return RecommendAlaLiveCacheModel.TABLE_NAME;
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
