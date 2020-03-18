package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public class c implements af {
    public static final AtomicReference<af> goi = new AtomicReference<>(null);
    private static final af goj = new c();

    private c() {
    }

    public static af bDp() {
        af afVar = goi.get();
        return afVar == null ? goj : afVar;
    }

    @Override // com.baidu.tieba.frs.af
    public h<ICardInfo, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.af
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.af
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.af
    public com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
