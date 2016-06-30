package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bk;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.n, a> {
    private TbPageContext<?> Ea;
    public BdUniqueId aSq;
    private bx bJf;
    private bk crl;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bJf = new e(this);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a a(ViewGroup viewGroup) {
        this.crl = new bk(this.Ea);
        this.crl.i(this.aSq);
        return new a(this.crl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.n nVar, a aVar) {
        if (aVar == null || aVar.crn == null) {
            return null;
        }
        if (nVar != null) {
            nVar.fI(i + 1);
            nVar.b(b(nVar));
            nVar.c(c(nVar));
            nVar.d(e(nVar));
            nVar.e(d(nVar));
        }
        aVar.crn.a(nVar);
        if (nVar != null) {
            bw.Lg().a(nVar.LD());
        }
        aVar.crn.a(this.bJf);
        return aVar.getView();
    }

    private ay b(com.baidu.tieba.card.a.n nVar) {
        if (nVar == null || nVar.Ix() == null) {
            return null;
        }
        return new ay("c10732").ab("fid", String.valueOf(nVar.Ix().getFid())).ab("tid", String.valueOf(nVar.Ix().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Lh()).s("obj_type", nVar.LB());
    }

    private ay c(com.baidu.tieba.card.a.n nVar) {
        if (nVar == null || nVar.Ix() == null) {
            return null;
        }
        return new ay("c10707").ab("fid", String.valueOf(nVar.Ix().getFid())).ab("tid", String.valueOf(nVar.Ix().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Lh()).s("obj_type", nVar.LB());
    }

    private ay d(com.baidu.tieba.card.a.n nVar) {
        if (nVar == null || nVar.Ix() == null) {
            return null;
        }
        return new ay("c10733").ab("fid", String.valueOf(nVar.Ix().getFid())).ab("tid", String.valueOf(nVar.Ix().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Lh()).s("obj_type", nVar.LB());
    }

    private ay e(com.baidu.tieba.card.a.n nVar) {
        if (nVar == null || nVar.Ix() == null) {
            return null;
        }
        return new ay("c10706").ab("fid", String.valueOf(nVar.Ix().getFid())).ab("tid", String.valueOf(nVar.Ix().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Lh()).s("obj_type", nVar.LB());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bk crn;

        public a(bk bkVar) {
            super(bkVar.getView());
            this.crn = bkVar;
        }
    }
}
