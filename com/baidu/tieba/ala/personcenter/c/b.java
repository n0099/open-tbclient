package com.baidu.tieba.ala.personcenter.c;

import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes6.dex */
public abstract class b extends BaseCardInfo {
    private c hNl;

    public void a(c cVar) {
        this.hNl = cVar;
    }

    public c getPersonCenterData() {
        return this.hNl;
    }
}
