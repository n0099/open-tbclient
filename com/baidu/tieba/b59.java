package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes5.dex */
public interface b59<T extends ICardInfo> {
    void c();

    void d();

    void f();

    void g(BdUniqueId bdUniqueId);

    void h();

    void setAfterClickSchemeListener(g49 g49Var);

    void setBusinessType(int i);

    void setFromCDN(boolean z);

    void setMulDel(boolean z);

    void setPosition(int i);

    void update(Object obj);
}
