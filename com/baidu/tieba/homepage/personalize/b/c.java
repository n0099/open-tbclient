package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.be;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYW;
    private cd bVT;
    private be cGn;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVT = new d(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public a a(ViewGroup viewGroup) {
        this.cGn = new be(this.GM);
        this.cGn.Og();
        this.cGn.i(this.aYW);
        return new a(this.cGn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, a aVar) {
        if (aVar == null || aVar.cGp == null) {
            return null;
        }
        if (nVar != null) {
            nVar.gj(i + 1);
            nVar.b(b(nVar));
            nVar.c(c(nVar));
            nVar.d(e(nVar));
            nVar.e(d(nVar));
        }
        aVar.cGp.onBindDataToView(nVar);
        if (nVar != null) {
            cb.Oj().a(nVar.OI());
        }
        aVar.cGp.setOnSubCardOnClickListenner(this.bVT);
        return aVar.getView();
    }

    private ax b(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Jv() == null) {
            return null;
        }
        return new ax("c10732").ab("fid", String.valueOf(nVar.Jv().getFid())).ab("tid", String.valueOf(nVar.Jv().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Ok()).s("obj_type", nVar.OG());
    }

    private ax c(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Jv() == null) {
            return null;
        }
        return new ax("c10707").ab("fid", String.valueOf(nVar.Jv().getFid())).ab("tid", String.valueOf(nVar.Jv().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Ok()).s("obj_type", nVar.OG());
    }

    private ax d(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Jv() == null) {
            return null;
        }
        return new ax("c10733").ab("fid", String.valueOf(nVar.Jv().getFid())).ab("tid", String.valueOf(nVar.Jv().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Ok()).s("obj_type", nVar.OG());
    }

    private ax e(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Jv() == null) {
            return null;
        }
        return new ax("c10706").ab("fid", String.valueOf(nVar.Jv().getFid())).ab("tid", String.valueOf(nVar.Jv().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Ok()).s("obj_type", nVar.OG());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public be cGp;

        public a(be beVar) {
            super(beVar.getView());
            this.cGp = beVar;
        }
    }
}
