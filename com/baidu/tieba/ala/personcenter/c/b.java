package com.baidu.tieba.ala.personcenter.c;

import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes10.dex */
public abstract class b extends BaseCardInfo {
    private c hZL;

    public void a(c cVar) {
        this.hZL = cVar;
    }

    public c getPersonCenterData() {
        return this.hZL;
    }
}
