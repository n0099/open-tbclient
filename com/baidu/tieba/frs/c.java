package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public class c implements ai {
    public static final AtomicReference<ai> hmf = new AtomicReference<>(null);
    private static final ai hmg = new c();

    private c() {
    }

    public static ai bUh() {
        ai aiVar = hmf.get();
        return aiVar == null ? hmg : aiVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public h<ICardInfo, ? extends aa.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bk, ? extends aa.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bk, ? extends aa.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ai
    public com.baidu.adp.widget.ListView.a<? extends bj, ? extends aa.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
