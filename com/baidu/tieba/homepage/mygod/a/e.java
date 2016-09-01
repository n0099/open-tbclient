package com.baidu.tieba.homepage.mygod.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.card.data.h;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<h, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYu;
    private cf<g> bVU;
    private com.baidu.tieba.card.d cDT;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVU = new f(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a a(ViewGroup viewGroup) {
        this.cDT = new com.baidu.tieba.card.d(this.GM);
        this.cDT.i(this.aYu);
        return new a(this.cDT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        aVar.cDV.onBindDataToView(hVar);
        if (aVar.cDV.Ns() != null) {
            aVar.cDV.Ns().setOnSubCardOnClickListenner(this.bVU);
        }
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        public com.baidu.tieba.card.d cDV;

        public a(com.baidu.tieba.card.d dVar) {
            super(dVar.getView());
            this.cDV = dVar;
        }
    }
}
