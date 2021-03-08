package com.baidu.tieba.ala.personcenter.c;

import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes9.dex */
public abstract class b extends BaseCardInfo {
    private c ibu;

    public void a(c cVar) {
        this.ibu = cVar;
    }

    public c getPersonCenterData() {
        return this.ibu;
    }
}
