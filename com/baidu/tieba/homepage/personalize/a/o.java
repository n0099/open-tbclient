package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYu;
    private com.baidu.tieba.card.o cFO;
    private cf<com.baidu.tieba.card.data.k> cFP;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.k.Ro);
        this.cFP = new p(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ah */
    public a a(ViewGroup viewGroup) {
        this.cFO = new com.baidu.tieba.card.o(this.GM, this.aYu);
        return new a(this.cFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        this.cFO = aVar.cFR;
        aVar.cFR.onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.cFR.a(kVar);
        aVar.cFR.setOnSubCardOnClickListenner(this.cFP);
        cd.NI().b(new ay("c11006"));
        return aVar.getView();
    }

    public void kc(int i) {
        if (this.cFO != null) {
            this.cFO.onChangeSkinType(this.GM, i);
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.o cFR;

        public a(com.baidu.tieba.card.o oVar) {
            super(oVar.getView());
            this.cFR = oVar;
        }
    }
}
