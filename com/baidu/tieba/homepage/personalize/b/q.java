package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.play.ax;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, d<com.baidu.tieba.card.t>> {
    private TbPageContext<?> GO;
    private o.a afo;
    public BdUniqueId bbl;
    private com.baidu.tieba.homepage.personalize.c.f cqX;
    private cb cqY;
    private com.baidu.tieba.card.t crd;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, d<com.baidu.tieba.card.t> dVar) {
        return a2(i, view, viewGroup, oVar, (d) dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afo = null;
        this.cqY = new r(this);
        this.GO = tbPageContext;
        ajn();
    }

    private void ajn() {
        com.baidu.tieba.card.data.o.beI = "c10708";
        com.baidu.tieba.card.data.o.beJ = "c10735";
        com.baidu.tieba.card.data.o.beK = "c10756";
        com.baidu.tieba.card.data.o.beL = "c10709";
        com.baidu.tieba.card.data.o.beM = "c10734";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public d a(ViewGroup viewGroup) {
        this.crd = new com.baidu.tieba.card.t(this.GO);
        this.crd.Ov();
        this.crd.j(this.bbl);
        this.crd.setOnSubCardOnClickListenner(this.cqY);
        return new d(this.crd);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, d dVar) {
        if (oVar != null) {
            oVar.gj(i + 1);
            oVar.sourceType = 0;
        }
        dVar.Po().a(b(oVar));
        dVar.Po().onBindDataToView(oVar);
        dVar.Po().a(this.afo);
        if (oVar != null) {
            bz.OH().a(oVar.OZ());
        }
        return dVar.getView();
    }

    private ax b(com.baidu.tieba.card.data.o oVar) {
        ax axVar = null;
        if (oVar != null) {
            axVar = new ax();
            axVar.mLocate = "1";
            axVar.aRf = oVar.Ty;
            if (oVar.IU() != null) {
                axVar.aRe = String.valueOf(oVar.IU().getFid());
            }
            axVar.mSource = oVar.getSource();
            axVar.eKb = oVar.OL();
            axVar.eKc = oVar.getWeight();
        }
        return axVar;
    }

    public void setEventCallback(o.a aVar) {
        this.afo = aVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cqX = fVar;
    }
}
