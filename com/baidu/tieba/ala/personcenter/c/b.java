package com.baidu.tieba.ala.personcenter.c;

import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public abstract class b extends BaseCardInfo {
    private c hVc;

    public void a(c cVar) {
        this.hVc = cVar;
    }

    public c getPersonCenterData() {
        return this.hVc;
    }
}
