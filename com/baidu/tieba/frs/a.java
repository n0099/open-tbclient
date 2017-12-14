package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class a implements ah {
    public static final AtomicReference<ah> cGD = new AtomicReference<>(null);
    private static final ah cGE = new a();

    private a() {
    }

    public static ah akP() {
        ah ahVar = cGD.get();
        return ahVar == null ? cGE : ahVar;
    }

    @Override // com.baidu.tieba.frs.ah
    public e<ICardInfo, ? extends j.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ah
    public com.baidu.adp.widget.ListView.a<? extends bd, ? extends j.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ah
    public com.baidu.adp.widget.ListView.a<? extends bd, ? extends j.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
