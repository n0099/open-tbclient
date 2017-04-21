package com.baidu.tieba.homepage.alalivelist.data;

import com.baidu.tbadk.mvc.b.e;
import com.baidu.tieba.homepage.alalivelist.model.RecommendAlaLiveCacheModel;
/* loaded from: classes.dex */
public class a implements e {
    private long cvK;

    public a(long j) {
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
        return RecommendAlaLiveCacheModel.TABLE_NAME;
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
