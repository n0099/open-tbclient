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
public class c implements ae {
    public static final AtomicReference<ae> gnj = new AtomicReference<>(null);
    private static final ae gnk = new c();

    private c() {
    }

    public static ae bDe() {
        ae aeVar = gnj.get();
        return aeVar == null ? gnk : aeVar;
    }

    @Override // com.baidu.tieba.frs.ae
    public h<ICardInfo, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ae
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ae
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ae
    public com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
