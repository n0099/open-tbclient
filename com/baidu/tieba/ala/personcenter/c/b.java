package com.baidu.tieba.ala.personcenter.c;

import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public abstract class b extends BaseCardInfo {
    private c hDE;

    public void a(c cVar) {
        this.hDE = cVar;
    }

    public c getPersonCenterData() {
        return this.hDE;
    }
}
