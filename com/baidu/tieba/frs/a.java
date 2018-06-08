package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class a implements ad {
    public static final AtomicReference<ad> dgP = new AtomicReference<>(null);
    private static final ad dgQ = new a();

    private a() {
    }

    public static ad asO() {
        ad adVar = dgP.get();
        return adVar == null ? dgQ : adVar;
    }

    @Override // com.baidu.tieba.frs.ad
    public f<ICardInfo, ? extends q.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ad
    public com.baidu.adp.widget.ListView.a<? extends bd, ? extends q.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ad
    public com.baidu.adp.widget.ListView.a<? extends bd, ? extends q.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
