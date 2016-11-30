package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.be;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, a> {
    private TbPageContext<?> GO;
    private o.a afV;
    private bz bZe;
    public BdUniqueId bcf;
    private be cLy;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afV = null;
        this.bZe = new d(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public a a(ViewGroup viewGroup) {
        this.cLy = new be(this.GO);
        this.cLy.Pi();
        this.cLy.i(this.bcf);
        return new a(this.cLy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, a aVar) {
        if (aVar == null || aVar.cLA == null) {
            return null;
        }
        if (nVar != null) {
            nVar.gk(i + 1);
            nVar.b(b(nVar));
            nVar.c(c(nVar));
            nVar.d(e(nVar));
            nVar.e(d(nVar));
        }
        aVar.cLA.onBindDataToView(nVar);
        aVar.cLA.a(this.afV);
        if (nVar != null) {
            bx.Pl().a(nVar.PL());
        }
        aVar.cLA.setOnSubCardOnClickListenner(this.bZe);
        return aVar.getView();
    }

    private av b(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Jz() == null) {
            return null;
        }
        return new av("c10732").ab("fid", String.valueOf(nVar.Jz().getFid())).ab("tid", String.valueOf(nVar.Jz().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Pn()).s("obj_type", nVar.PJ());
    }

    private av c(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Jz() == null) {
            return null;
        }
        return new av("c10707").ab("fid", String.valueOf(nVar.Jz().getFid())).ab("tid", String.valueOf(nVar.Jz().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Pn()).s("obj_type", nVar.PJ());
    }

    private av d(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Jz() == null) {
            return null;
        }
        return new av("c10733").ab("fid", String.valueOf(nVar.Jz().getFid())).ab("tid", String.valueOf(nVar.Jz().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Pn()).s("obj_type", nVar.PJ());
    }

    private av e(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Jz() == null) {
            return null;
        }
        return new av("c10706").ab("fid", String.valueOf(nVar.Jz().getFid())).ab("tid", String.valueOf(nVar.Jz().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Pn()).s("obj_type", nVar.PJ());
    }

    public void setEventCallback(o.a aVar) {
        this.afV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public be cLA;

        public a(be beVar) {
            super(beVar.getView());
            this.cLA = beVar;
        }
    }
}
