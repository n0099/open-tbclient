package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class c implements ad {
    public static final AtomicReference<ad> eXL = new AtomicReference<>(null);
    private static final ad eXM = new c();

    private c() {
    }

    public static ad bbM() {
        ad adVar = eXL.get();
        return adVar == null ? eXM : adVar;
    }

    @Override // com.baidu.tieba.frs.ad
    public h<ICardInfo, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ad
    public com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ad
    public com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // com.baidu.tieba.frs.ad
    public com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
