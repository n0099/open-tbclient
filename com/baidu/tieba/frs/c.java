package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.a;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements bw {
    public static final AtomicReference<bw> cbC = new AtomicReference<>(null);
    private static final bw cbD = new c();

    private c() {
    }

    public static bw ady() {
        bw bwVar = cbC.get();
        return bwVar == null ? cbD : bwVar;
    }

    @Override // com.baidu.tieba.frs.bw
    public p<ICardInfo, ? extends z.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.bw
    public a<? extends com.baidu.tbadk.core.data.bm, ? extends z.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.bw
    public a<? extends com.baidu.tbadk.core.data.bm, ? extends z.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
