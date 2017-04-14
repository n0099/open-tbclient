package com.baidu.tieba.homepage.recommendfrs.data;

import com.baidu.tieba.homepage.recommendfrs.model.RecommendFrsCacheModel;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.e {
    private long ctt;

    public b(long j) {
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
