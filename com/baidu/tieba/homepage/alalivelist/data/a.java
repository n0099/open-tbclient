package com.baidu.tieba.homepage.alalivelist.data;

import com.baidu.tbadk.mvc.b.e;
import com.baidu.tieba.homepage.alalivelist.model.RecommendAlaLiveCacheModel;
/* loaded from: classes.dex */
public class a implements e {
    private long cuT;

    public a(long j) {
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
        return RecommendAlaLiveCacheModel.TABLE_NAME;
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
