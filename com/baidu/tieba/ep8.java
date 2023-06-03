package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes5.dex */
public interface ep8<T extends ICardInfo> {
    void d();

    void e();

    void f(BdUniqueId bdUniqueId);

    void g();

    void h();

    void setAfterClickSchemeListener(io8 io8Var);

    void setBusinessType(int i);

    void setFromCDN(boolean z);

    void setMulDel(boolean z);

    void setPosition(int i);

    void update(Object obj);
}
