package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.entelechy.view.ah;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<aq, a> implements com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GM;
    private ah bVT;
    private cf bVU;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVU = new h(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public a a(ViewGroup viewGroup) {
        this.bVT = new ah(this.GM);
        this.bVT.i(this.GM.getUniqueId());
        return new a(this.bVT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, aq aqVar, a aVar) {
        if (aVar == null || aVar.bVW == null) {
            return null;
        }
        aVar.bVW.onBindDataToView(aqVar);
        aVar.bVW.setOnSubCardOnClickListenner(this.bVU);
        com.baidu.tieba.frs.g.b.aeX().a(cdn, aqVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public ah bVW;

        public a(ah ahVar) {
            super(ahVar.getView());
            this.bVW = ahVar;
        }
    }
}
