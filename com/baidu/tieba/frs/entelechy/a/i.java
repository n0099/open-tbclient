package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<aj, a> {
    private TbPageContext<?> Ea;
    private com.baidu.tieba.frs.entelechy.view.ad bJe;
    private bx bJf;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJf = new j(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public a a(ViewGroup viewGroup) {
        this.bJe = new com.baidu.tieba.frs.entelechy.view.ad(this.Ea);
        this.bJe.i(this.Ea.getUniqueId());
        return new a(this.bJe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, aj ajVar, a aVar) {
        if (aVar == null || aVar.bJh == null) {
            return null;
        }
        aVar.bJh.a(ajVar);
        aVar.bJh.a(this.bJf);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.view.ad bJh;

        public a(com.baidu.tieba.frs.entelechy.view.ad adVar) {
            super(adVar.getView());
            this.bJh = adVar;
        }
    }
}
