package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class a implements af {
    public static final AtomicReference<af> cpp = new AtomicReference<>(null);
    private static final af cpq = new a();

    private a() {
    }

    public static af agA() {
        af afVar = cpp.get();
        return afVar == null ? cpq : afVar;
    }

    @Override // com.baidu.tieba.frs.af
    public d<ICardInfo, ? extends j.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.af
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends j.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.af
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends j.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
