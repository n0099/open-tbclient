package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.au;
import com.baidu.tieba.card.bz;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<au, a> implements com.baidu.tieba.frs.h.e {
    private TbPageContext<?> GO;
    private com.baidu.tieba.frs.entelechy.view.ag bZd;
    private bz bZe;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bZe = new i(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public a a(ViewGroup viewGroup) {
        this.bZd = new com.baidu.tieba.frs.entelechy.view.ag(this.GO);
        this.bZd.i(this.GO.getUniqueId());
        return new a(this.bZd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, au auVar, a aVar) {
        if (aVar == null || aVar.bZg == null) {
            return null;
        }
        aVar.bZg.onBindDataToView(auVar);
        aVar.bZg.setOnSubCardOnClickListenner(this.bZe);
        com.baidu.tieba.frs.h.b.agV().a(chm, auVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.frs.entelechy.view.ag bZg;

        public a(com.baidu.tieba.frs.entelechy.view.ag agVar) {
            super(agVar.getView());
            this.bZg = agVar;
        }
    }
}
