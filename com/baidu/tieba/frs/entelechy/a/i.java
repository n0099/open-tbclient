package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<ao, a> implements com.baidu.tieba.frs.h.e {
    private TbPageContext<?> EA;
    private com.baidu.tieba.frs.entelechy.view.ae bKJ;
    private bx bKK;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKK = new j(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public a a(ViewGroup viewGroup) {
        this.bKJ = new com.baidu.tieba.frs.entelechy.view.ae(this.EA);
        this.bKJ.i(this.EA.getUniqueId());
        return new a(this.bKJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ao aoVar, a aVar) {
        if (aVar == null || aVar.bKM == null) {
            return null;
        }
        aVar.bKM.a(aoVar);
        aVar.bKM.a(this.bKK);
        com.baidu.tieba.frs.h.b.aam().a(bSh, aoVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.view.ae bKM;

        public a(com.baidu.tieba.frs.entelechy.view.ae aeVar) {
            super(aeVar.getView());
            this.bKM = aeVar;
        }
    }
}
