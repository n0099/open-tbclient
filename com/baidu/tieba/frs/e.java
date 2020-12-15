package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes22.dex */
public class e implements ao {
    public static final AtomicReference<ao> iRQ = new AtomicReference<>(null);
    private static final ao iRR = new e();

    private e() {
    }

    public static ao cBn() {
        ao aoVar = iRQ.get();
        return aoVar == null ? iRR : aoVar;
    }

    @Override // com.baidu.tieba.frs.ao
    public k<ICardInfo, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ao
    public com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ao
    public com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ao
    public com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
