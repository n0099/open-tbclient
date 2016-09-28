package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.as;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.ah;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<as, a> implements com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private ah bVS;
    private cd bVT;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new h(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public a a(ViewGroup viewGroup) {
        this.bVS = new ah(this.GM);
        this.bVS.i(this.GM.getUniqueId());
        return new a(this.bVS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, as asVar, a aVar) {
        if (aVar == null || aVar.bVV == null) {
            return null;
        }
        aVar.bVV.onBindDataToView(asVar);
        aVar.bVV.setOnSubCardOnClickListenner(this.bVT);
        com.baidu.tieba.frs.g.b.afl().a(cdl, asVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public ah bVV;

        public a(ah ahVar) {
            super(ahVar.getView());
            this.bVV = ahVar;
        }
    }
}
