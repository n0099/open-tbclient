package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.ah;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.play.ax;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, d<ah>> {
    private TbPageContext<?> GO;
    private cb bFl;
    public BdUniqueId bbl;
    private com.baidu.tieba.homepage.personalize.c.f cqS;
    private ah cqU;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, d<ah> dVar) {
        return a2(i, view, viewGroup, oVar, (d) dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bFl = new j(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public d a(ViewGroup viewGroup) {
        this.cqU = new ah(this.GO);
        this.cqU.j(this.bbl);
        return new d(this.cqU);
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
        }
        return axVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, d dVar) {
        if (oVar != null) {
            oVar.gj(i + 1);
        }
        dVar.Po().a(b(oVar));
        dVar.Po().onBindDataToView(oVar);
        dVar.Po().setOnSubCardOnClickListenner(this.bFl);
        if (oVar.beB != null && oVar.beB.getTid() != null) {
            bz.OH().a(new at("c11003").ab("tid", oVar.beB.getTid()));
        }
        return dVar.getView();
    }

    public void a(com.baidu.tieba.homepage.personalize.c.f fVar) {
        this.cqS = fVar;
    }
}
